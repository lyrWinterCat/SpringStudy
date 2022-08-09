package com.korea.bbs;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDAO;
import util.Common;
import util.Paging;
import vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	BoardDAO board_dao;
	
	public void setBoard_dao(BoardDAO board_dao) {
		this.board_dao = board_dao;
	}
	
	@RequestMapping(value= {"/","board_list.do"})
	public String list(Model model) {
		int nowPage=1;
		String page=request.getParameter("page"); // 처음에는 값이 없기 때문에 null로 들어옴
		
		if(page!=null && !page.isEmpty()) { //값이 들어옴
			nowPage = Integer.parseInt(page);
		}
		int start = (nowPage-1)*Common.Board.BLOCKLIST + 1;		
		int end = nowPage*Common.Board.BLOCKLIST;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("start",start);
		map.put("end",end);		
		
		//전체 목록 가져오기 
		//List<BoardVO> list = BoardDAO.getInstance().selectList();	

		List<BoardVO> list = board_dao.selectList(map);	

		int rowTotal = board_dao.getRowTotal();
		
		//									사용할 페이지 주소 , 현재 페이지 번호, 전체 게시물 수 , 한 페이지에 표기할 게시물 수 , 보여지는 페이지 메뉴 수
		String pageMenu = Paging.getPaging("board_list.do", nowPage, rowTotal, Common.Board.BLOCKLIST, Common.Board.BLOCKPAGE);
		

		request.getSession().removeAttribute("show");		

		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return Common.VIEW_PATH+"board_list.jsp?page="+nowPage;
	}
	
	// 글쓰기 화면으로 이동
	@RequestMapping("insert_form.do")
	public String insert_form() {		
		
		return Common.VIEW_PATH+"insert_form.jsp";
	}
	
	//글 추가하기
	@RequestMapping("insert.do")
	public String insert(BoardVO vo) {
		String ip = request.getRemoteAddr();//ip		
		
		String myIp;
		try {
			myIp = InetAddress.getLocalHost().getHostAddress();
			if(ip.equals("0:0:0:0:0:0:0:1")) {
				ip=myIp;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vo.setIp(ip);
		
		int res=board_dao.insert(vo);
		
		return "redirect:board_list.do";
	}
	
	// 글 보기
	@RequestMapping("view.do")
	public String view(Model model) {
		
		int idx=Integer.parseInt(request.getParameter("idx"));
				
		//idx에 해당하는 게시글 한 건을 조회하기 위해 selectOne메서드 사용
		BoardVO vo = board_dao.selectOne(idx);
		
		//조회수 증가
		// session 사용하기 (새로고침시 조회수 증가 방지)
		session = request.getSession();
		String show=(String)session.getAttribute("show"); //object로 받아오기때문에 형변환 해주기
		
		if(show==null) {
			//show가 null일때만 조회수 증가
			int res=board_dao.update_readhit(idx);
			session.setAttribute("show","0");
		}

		model.addAttribute("vo", vo);
		
		return Common.VIEW_PATH+"board_view.jsp";
	}
	
	//리플달기로 보내기
	@RequestMapping("reply_form.do")
	public String goReply() {
		return Common.VIEW_PATH+"reply_form.jsp";
	}
	
	
	//리플달기
	@RequestMapping("reply.do")
	public String reply(BoardVO vo) {
		
		int idx=Integer.parseInt(request.getParameter("idx"));
		String ip=request.getRemoteAddr();
		
		String myIp;
		try {
			myIp = InetAddress.getLocalHost().getHostAddress();
			if(ip.equals("0:0:0:0:0:0:0:1")) {
				ip=myIp;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vo.setIp(ip);
				
		//기준글의 idx를 이용해서 댓글을 달고 싶은 게시글의 정보를 가져온다.
		BoardVO base_vo = board_dao.selectOne(idx);
		
		//기준글에 step 이상 값은 step=step+1 처리
		board_dao.update_step(base_vo);
		
		
		// 댓글이 들어갈 위치를 선정
		vo.setRef(base_vo.getRef());
		vo.setStep(base_vo.getStep()+1);
		vo.setDepth(base_vo.getDepth()+1);
		
		//댓글 등록
		int res=board_dao.reply(vo);
		
		if(res>0) {
			int page=Integer.parseInt(request.getParameter("page"));
			
			return "redirect:board_list.do?page"+page;
			//response.sendRedirect("board_list.do?page="+page);
		}
		
		return Common.VIEW_PATH+"board_list.jsp";
	}
	
	

}

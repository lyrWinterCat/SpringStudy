package com.korea.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileUploadController {
	
	@Autowired 
	ServletContext application;
	//자동 주입 어노테이션
	// servletContext, session, request등 spring지원 객체 자동 생성 어노테이션
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	static final String VIEW_PATH="/WEB-INF/views/";
	
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insert_form() {
		
		return VIEW_PATH+"insert_form.jsp";
	}
	
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo) {
		
		/* 전에 했던 접근 경로
		String webPath="/resources/upload/";//상대경로
		String savePath="";
		System.out.println(savePath);
		
		//절대경로
		 * ServletContext application;
		 * application.getRealPath(path);
		 */
		
		String webPath="/resources/upload/";//상대경로
		String savePath = application.getRealPath(webPath);//절대경로
		System.out.println(savePath);
		
		//업로드된 파일 정보
		MultipartFile photo = vo.getPhoto();
		String filename="no_file";
		
		if(!photo.isEmpty()) {
			//upload된 실제 파일명
			filename=photo.getOriginalFilename();
			//vo.setFilename(filename);
			
			//파일을 저장할 경로
			File saveFile = new File(savePath,filename);
			// ㄴsavePath 경로까지 가서 filename이라고 하는 것이 있는지 확인해줄래??
			if(!saveFile.exists()) { //만약 saveFile이 존재하지 않다면
				saveFile.mkdirs();//경로 만들어줘				
			}else {
				// 같은 이름의 파일 올라올 때 중복 막기 (중복폴더로 생성이 안되는 경우 막아주기)
				long time = System.currentTimeMillis(); //자바가 만들어진 1970년부터 2022년 현재까지의 시간을 1000분의 1초로 저장
				filename=String.format("%d_%s", time,filename);
				saveFile = new File(savePath,filename);
			}
			
			try { //실제로 파일을 업로드하는 코드
				photo.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		vo.setFilename(filename);
		request.setAttribute("vo", vo);
		
		return VIEW_PATH+"input_result.jsp";
	}
	
	
}

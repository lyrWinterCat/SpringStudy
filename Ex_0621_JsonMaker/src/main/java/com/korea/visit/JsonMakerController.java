package com.korea.visit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVO;

@Controller
public class JsonMakerController {
	
	@RequestMapping("/vo_to_json.do")
	@ResponseBody
	// return 되는 데이터를 .jsp등의 view로 인식하지 말고, 객체로써 바로 응답하도록 처리 
	// 주로 ajax의 콜백함수로 보낼 때 사용
	public PersonVO vo_to_json() {
		PersonVO p1 = new PersonVO();
		p1.setName("홍길동");
		p1.setAge(30);
		p1.setAddr("서울");
		
		return p1;
	}
	
	@RequestMapping("/map_to_json.do")
	@ResponseBody
	public HashMap<String,Object> map_to_json() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name", "독고길동");
		map.put("age","20");
		
		HashMap<String,String> telMap = new HashMap<String, String>();
		telMap.put("home_tel", "032-111-1111");
		telMap.put("office_tel","032-222-2222");
		telMap.put("cell_tel", "010-333-3333");
		
		map.put("tel", telMap);
		
		return map;
	}
	
	@RequestMapping("list_to_json.do")
	@ResponseBody
	public List list_to_json(){
		List<PersonVO> list = new ArrayList<PersonVO>();
		list.add(new PersonVO("삼길동",30,"서울시 강남구"));
		list.add(new PersonVO("사길동",40,"서울시 구로구"));
		list.add(new PersonVO("오길동",50,"서울시 강서구"));
		return list;		
	}
}

package com.example.ex02.controller;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Case;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ex02.domain.vo.Product;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExampleController{
	/*
	 * 이름 입력, 출근 또는 퇴근 버튼 클릭
	 * 출근시간은 09:00 퇴근시간은 18:00
	 * 출근 버튼 클릭시 9시가 넘으면 지각처리
	 * 퇴근 버튼 클릭시 18시 전이라면 퇴근이 아닌 업무시간으로 처리
	 * 
	 * 모든 jsp는 work경로 안에 생성하며, 아래와 같이 분기별로 jsp문서를 한개씩 작성
	 * getToWork.jsp
	 * leaveWork.jsp
	 * late.jsp
	 * work.jsp
	 * 
	 */	
	@GetMapping("/checkIn")
	public String checkIn() {
		log.info("출퇴근관리 시작");
		return "work/checkIn";
	}
	
	@GetMapping("/getToWork")
	public String getToWork(@ModelAttribute("name") String name) {
		log.info("출근 들어옴");
		Calendar c = Calendar.getInstance();
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		
		boolean lateCondition= hour>=9 && min >0;
		if(lateCondition) {
			return "work/late";
		}
		return "work/work";
	}
	@GetMapping("/leaveWork")
	public String leaveWork(@ModelAttribute("name") String name) {
		log.info("퇴근 들어옴");
		Calendar c = Calendar.getInstance();
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		
		boolean leaveWorkCondition= hour>=18 && min >=0;
		if(leaveWorkCondition) {
			return "work/leaveWork";
		}
		return "work/getToWork";		
	}	
	
	/*
	 * 	
	@GetMapping("checkWork")
	public String checkWork() {
		return "/work/checkWork";
	}
	
	@GetMapping("is_late")
	public String is_late(@ModelAttribute("name") String name){
		LocalTime time=LocalTime.now();
		log.info(name + " "+time);
		if(time.isAfter(LocalTime.of(9, 0))) {
			log.info("지각");
			return "/work/late";
		}
		return "/work/work";
	}
	
	@GetMapping("is_ok")
	public String is_ok(@ModelAttribute("name") String name) {
		LocalTime time=LocalTime.now();
		log.info(name + " "+time);
		if(time.isBefore(LocalTime.of(18, 0))) {
			return "/work/getToWork";
		}
		return "/work/leaveWork";
	}
	 */
	
	/*
	 * 상품의 바코드를 입력받고 해당 상품명을 출력
	 * 오징어 땅콩 : 4383927
	 * 초코 우유 : 0832147
	 * 피자과자 : 9841631
	 * 샌드위치 : 5587578
	 */
	
	/*
	@GetMapping("shop")
	public String counter() {
		return "shop/counter";
	}
	
	@GetMapping("productView")
	public String products(String number, Model model) {
		String name="";
		switch(number) {
		case "4383927" :
			name="오징어땅콩";
			break;
		case "0832147" :
			name="초코우유";
			break;
		case "9841631" :
			name="벌집피자";
			break;
		case "5587578" :
			name="샌드위치";
			break;			
		}
		model.addAttribute("name", name);
		return "shop/productView";			
	}
	 * 
	 */
	
	@GetMapping("/market")
	public String goMarket() {
		return "market/market";
	}
	
	@PostMapping("/cashier")
	public String getProduct(String barcode, Model model) {
		String productName=null;
		switch(barcode) {
		case "4383927" :
			productName="오징어땅콩";
			break;
		case "0832147" :
			productName="초코우유";
			break;
		case "9841631" :
			productName="벌집피자";
			break;
		case "5587578" :
			productName="샌드위치";
			break;
		default:
			productName="없는 상품";
			break;
		}
		model.addAttribute("productName", productName);		
		
		return "/market/cashier";
	}
	/*선택한 할인률을 해당 상품에 적용
	 * 버튼을 여러개 만들어서 클릭된 할인율 만큼 상품의 가격 적용
	 * 
	 * @GetMapping("/sale")
	 * goChangeSale
	 * salechange.jsp
	 * 선택 / 상품명 / 가격 총 3개의 항목으로 구성
	 * 각 상품의 선택 부분은 radio버튼으로 작성
	 * 할인율버튼은 총 4개의 버튼으로 제작하고
	 * 각각 10% 30% 60% 90%
	 * 마지막에 적용버튼을 제작하여 form태그를 전송
	 * 
	 * @PostMapping("/change")
	 * 상품 모델객체(product)로 전체 내용을 전달받음
	 * 전달받은 상품 가격에 할인율을 적용한 가격을
	 * showChange.jsp로 전달
	 */
	
	/*
	@GetMapping("/sale")
	public String goChangeSale() {
		return "/market/saleChange";
	}
	
	@PostMapping("/change")
	public String change(String check,int sale,Product product) {
		String[] products=check.split(" ");
		product.setName(products[0]);
		product.setPrice(Integer.parseInt(products[1])*sale/100);
		return "/market/showChange";
	}
	 * 
	 */
	@GetMapping("/sale")
	public String goChangeSale() {
		return "product/saleChange";
	}
	
	@PostMapping("/change")
	public String change(HttpServletRequest request,Product product,Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		log.info(product);
		double rating=(100-product.getDiscountRate())*0.01;
		model.addAttribute("originPrice", product.getProductPrice());
		product.setProductPrice((int)((product.getProductPrice())*rating));
		return "product/showChange";
	}
	
	@PostMapping("/usePoint")
	public String usePoint(@ModelAttribute("product") Product product) {
		
		return "product/usePoint";
	}
	
	@PostMapping("/use")
	public String use(Product product, Integer point, Model model) {
		int cash=product.getProductPrice() - point;
		//if(cash<1){}
		
		if(point>=product.getProductPrice()) {
			point=product.getProductPrice();
			cash=0;
		}
		
		model.addAttribute("product", product);
		model.addAttribute("point", point);
		model.addAttribute("cash", cash);
		
		return "product/payment";
	}

	
	
	

}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤 계층을 의미하는 어노테이션 추가 -> request와 response를 누림
/*단순히 bean을 관리받는다는점 이외도 요청객체와 응답객체를 주입받을수 있음
 * WebServlet => Controller + RequestMapping*/
@Controller
//Web.xml대신 자바코드에 직접추가 가능함 - 전체적인 빈 목록을 볼수 없음
@RequestMapping ("/home/*")// url-pattern에 등록했던 URL주소값으로 추가함.

public class HomeController {
	
	@GetMapping ("index")
	public String home () {
		return "home/index";
		
	}
}

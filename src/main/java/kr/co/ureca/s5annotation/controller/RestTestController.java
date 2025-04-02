package kr.co.ureca.s5annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.s5annotation.service.RestTestService;

// @Controller : client의 request를 받고, client에게 response를 전송하는 역할을 하는 객체.
// @ResponseBody : @Controller는 일반적으로 view name을 return하나, @ResponseBody일 경우는 html body를 return 함.
// @RestController : @Controller + @ResponseBody, 일반적으로 html body를 return 함.
@RestController
@RequestMapping("/rest-test")
public class RestTestController {

	@Autowired
	private RestTestService service;

	//class의 @RequestMapping과 method의 @RequestMapping을 결합한 uri에 대응됨.
	// http://localhost:8080/rest-test/no1
	// 메소드의 @RequestMapping은 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping으로 대체될 수 있다.
	@RequestMapping(value = "/no1", method = RequestMethod.GET)
	public String no1() {
		return "hello world"; // @RestController에서는 html body로 return 됨.
	} // no1

	// @PathVariable : client가 uri에 포함시켜 보낸 data를 받는 annotation.
	// http://localhost:8080/rest-test/no2/data
	@GetMapping("/no2/{id}")
	public EmpDTO no2(@PathVariable Long id) { // 변수명을 @GetMapping의 {id}와 같게 선언!!!
		EmpDTO dto = service.findById(id);
		return dto;
	} // no2

	// http://localhost:8080/rest-test/no3/data
	@GetMapping("/no3/{data}")
	public EmpDTO no3(@PathVariable("data") Long id) { // 변수명을 @GetMapping의 {id}와 다를 경우!!!
		EmpDTO dto = service.findById(id);
		return dto;
	} // no2


} // class





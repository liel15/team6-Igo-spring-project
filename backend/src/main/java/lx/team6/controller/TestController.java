package lx.team6.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import lx.team6.dao.TestDAO;
import lx.team6.service.TestService;
import lx.team6.vo.TestVO;

@RestController()
@CrossOrigin(origins = "*")
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TestService service;
	
	@GetMapping("/")
	public void startServer() {
		logger.info("서버가 시작되었습니다!");
	}
	
	@GetMapping("/test")
	public List<TestVO> list(HttpServletRequest req) {
		logger.info("test 호출 완료");
		List<TestVO> memberlist = service.getListTest();
		System.out.println(memberlist);
		return memberlist;
	}
	
	
}

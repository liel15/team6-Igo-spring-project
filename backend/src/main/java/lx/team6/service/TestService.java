package lx.team6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.dao.TestDAO;
import lx.team6.vo.TestVO;

@Component
public class TestService {

	@Autowired
	TestDAO dao; 
	
	public List<TestVO> getListTest() {
		
		// 리턴하기전에 데이터 가공 또는 검증이 필요할때 service에서 작업
		return dao.getListTest();
	}
	
}
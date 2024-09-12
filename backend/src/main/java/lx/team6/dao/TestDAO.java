package lx.team6.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.vo.TestVO;

@Component
public class TestDAO {
	
	@Autowired
	SqlSession session;
	
	public List<TestVO> getListTest() {
		return session.selectList("getListTest");
	}
	
	public void createTest(TestVO vo) {
		session.insert("createTest", vo);
	}

	public TestVO getTestById(int abId) {
		return session.selectOne("getTestById", abId);
	}

	public int deleteTest(int abId) {
		return session.delete("deleteTest", abId);
	}
}

package lx.team6.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.vo.*;

@Component
public class AddrbookDAO {
	
	@Autowired
	SqlSession session;
	
	//방명록정보를 전달받아서 DB에 저장함
	public void createAddrbook(AddrbookVo vo) {
		session.insert("createAddrbook", vo);
	}
	
	//저장된 정보를 보여줌
	public List<AddrbookVo> showAddrbookList() throws Exception {
		return session.selectList("showAddrbookList");
	}

	public AddrbookVo getAddrbookById(int abId) {

		return session.selectOne("getAddrbookById", abId);
	}
	
	public void deleteAddrbookList(int abId) {
		session.delete("deleteAddrbookList",abId);
	}
	
	public void updateAddrbookList(AddrbookVo vo) {
		session.update("updateAddrbookList", vo);
	}
	
	//아이디 찾기
	public AddrbookVo findById(String abId) {
		return session.selectOne("findById", abId);
	}
	
	//회원가입
	public void createUser(AddrbookVo vo) {
		session.insert("createUser", vo);
		}
}

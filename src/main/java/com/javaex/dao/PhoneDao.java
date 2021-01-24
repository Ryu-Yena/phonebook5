package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//전체 리스트 가져오기
	public List<PersonVo> getPersonList(){
		System.out.println("dao:getPersonList()");
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList2");
		
		System.out.println(personList);
		return personList;
	}
	
	//전화번호 저장
	public void personInsert(PersonVo personVo) {
		System.out.println(personVo.toString());
		sqlSession.insert("phonebook.insert", personVo);
		
	}
	
	//전화번호 삭제
	public int personDelete(int personId) {
		System.out.println("dao: personDelete()" + personId);
		
		int count = sqlSession.delete("phonebook.delete", personId);
		System.out.println(count);
		
		return count;
	}
	
	//1명 데이터 가져오기
	public PersonVo getPerson(int personId) {
		System.out.println("dao: getperson()" + personId);
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", personId);
		System.out.println(personVo.toString());
		
		return personVo;
		
	}
	
	//수정
	
	
	
}

package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {

	Member loginMember(Member m);

	void insertMember(Member m) throws Exception;

	void updateMember(Member m) throws Exception;

	void deleteMember(String userId) throws Exception;
	

}

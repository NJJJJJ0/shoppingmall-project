package com.example.project.model.member;

import java.util.List;

public interface MemberDAO {
	String login(MemberDTO dto);
	List<MemberDTO> list();
	void insert(MemberDTO dto);
	MemberDTO detail(String userid);
	void delete(String userid);
	void update(MemberDTO dto);
	boolean check_passwd(String userid, String passwd);

	
}
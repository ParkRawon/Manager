package co.micol.manager;

import co.micol.manager.menu.LoginMenu;

//import java.util.ArrayList;
//import java.util.List;
//
//import co.micol.manager.member.service.MemberService;
//import co.micol.manager.member.serviceImpl.MemberServiceImpl;
//import co.micol.manager.member.vo.MemberVO;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MemberService memberDao = new MemberServiceImpl();
//		List<MemberVO> members = new ArrayList<MemberVO>();
//		
//		members = memberDao.memberSelectList();
//		for(MemberVO vo : members) {
//			vo.toString();
//		}
	
		LoginMenu menu = new LoginMenu();
		menu.login();

	}

}

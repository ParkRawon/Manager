package co.micol.manager.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.manager.board.service.BoardService;
import co.micol.manager.board.serviceImpl.BoardServiceImpl;
import co.micol.manager.board.vo.BoardVO;
import co.micol.manager.member.service.MemberService;
import co.micol.manager.member.serviceImpl.MemberServiceImpl;
import co.micol.manager.member.vo.MemberVO;


public class UserMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService memDao = new MemberServiceImpl(); // 멤버 정보 수정
	private BoardService boDao = new BoardServiceImpl(); // 게시글

	private void title() {
		System.out.println("================");
		System.out.println("------사용자 메뉴------");
		System.out.println("----1.나의 정보 수정----");
		System.out.println("-----2.게시글 보기-----");
		System.out.println("-----3.게시글 작성-----");
		System.out.println("-----4.게시글 수정-----");
		System.out.println("-----5.종 료 하 기-----");
		System.out.println("---원하는 작업을 선택하세요>>>");
	}

	private void userMenu(MemberVO vo) {
		System.out.println(vo.getName() + "님 환영합니다.");
		// 메뉴가 동작될 수 있도록 구현해보기.
		boolean b = false;
		do {
			title();
			int choice;
			switch (choice = sc.nextInt()) {
			case 1:
				myInfoUpdate();
				break;
			case 2:
				boardList();
				break;
			case 3:
				boardInsert();
				break;
			case 4:
				boardUpdate(vo.getId());
				break;
			case 5:
				b = true;
				System.out.println("작업을 종료합니다.");
				break;
			}
		} while (!b);

	}

	private void boardUpdate(String id) {
		// TODO 게시글 수정
		BoardVO vo = new BoardVO();
		System.out.println("게시글 아이디를 입력하세요");
		String boardId = sc.next();
		sc.nextLine();
		vo.setBoardId(boardId);
		vo = boDao.boardSelect(vo);
		if(vo.getWriter().equals(id)) {
			vo = new BoardVO();
			System.out.println("내용을 입력하세요");
			vo.setSubject(sc.nextLine());
			vo.setWriter(id);
			vo.setBoardId(boardId);
			int n = boDao.boardUpdate(vo);
			if(n != 0 ) {
				System.out.println("정상적으로 수정되었습니다.");
			}else {
				System.out.println("수정실패!!!");
			}
		} else {
			System.out.println("본인의 글만 수정가능합니다.");
			vo.toString();
		}
	
	}

	private void boardInsert() {
		// TODO 게시글 작성
		BoardVO vo = new BoardVO();
		System.out.println("게시판 id를 입력하세요>>");
		vo.setBoardId(sc.next());
		sc.nextLine();
		System.out.println("게시판 제목을 입력하세요>>");
		vo.setTitle(sc.nextLine());
		System.out.println("게시판 내용을 입력하세요>>");
		vo.setSubject(sc.nextLine());
		System.out.println("게시판 작성자를 입력하세요>>");
		vo.setWriter(sc.nextLine());
		int n = boDao.boardInsert(vo);
		if(n != 0) {
			System.out.println("정상적으로 입력되었습니다.");
		}else {
			System.out.println("입력실패!!!");
		}
		
	}

	private void boardList() {
		// TODO 게시글 보기
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boDao.boardSelectList();
		for(BoardVO vo : list) {
			vo.toString();
		}
		
	}

	private void myInfoUpdate() {
		// TODO 나의 정보 수정(주소와 전화번호만 수정한다.)
		MemberVO vo = new MemberVO();
		System.out.println("수정할 주소를 입력하세요>>>>");
		vo.setAddress(sc.next());
		sc.nextLine();
		System.out.println("수정할 전화번호를 입력하세요>>>");
		vo.setTel(sc.next());
		sc.nextLine();
		System.out.println("본인의 id를 입력하세요>>>");
		vo.setId(sc.next());
		int n = memDao.memberUpdate(vo);
		if(n != 0) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("수정실패!!!");
		}
	}

	public void run(MemberVO vo) {
		userMenu(vo);

	}

}

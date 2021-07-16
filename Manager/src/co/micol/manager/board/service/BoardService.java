package co.micol.manager.board.service;

import java.util.List;

import co.micol.manager.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList();   //게시글 목록
	BoardVO boardSelect(BoardVO vo);     //게시글 조회
	int boardInsert(BoardVO vo);          //게시글 추가
	int boardDelete(BoardVO vo);         //게시글 삭제
	int boardUpdate(BoardVO vo);         //게시글 수정
	
	

}

package co.micol.manager.board.vo;

import java.sql.Date;

public class BoardVO {
	private String boardId;
	private String writer;
	private String title;
	private String subject;
	private Date enterDate;
	private int hit;
	
	public BoardVO() { //생성자
		// TODO Auto-generated constructor stub
	}

	
	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String toString() {
		System.out.print(" "+ boardId+ " : ");
		System.out.print(writer+ " : ");
		System.out.print(title+ " : ");
		System.out.print(enterDate+ " : ");
		System.out.println(hit);
		return null;
	}
	
	

}

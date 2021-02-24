package kr.green.testportfolio.vo;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class BoardVo {
	private int num, views;
	private String content, writer, isDel;
	private Date registerDate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public BoardVo() {
	}
	
	public BoardVo(int num, int views, String content, String writer, String isDel, Date registerDate) {
		super();
		this.num = num;
		this.views = views;
		this.content = content;
		this.writer = writer;
		this.isDel = isDel;
		this.registerDate = registerDate;
	}
	
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", views=" + views + ", content=" + content + ", writer=" + writer + ", isDel="
				+ isDel + ", registerDate=" + registerDate + "]";
	}
	
	
}

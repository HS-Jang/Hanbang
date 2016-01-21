package hanbang_TeamA.com.vo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="review")
public class ReviewVO extends AbstractVO  {
	
	private String id;	//id
	private String userId;	//등록사용자id
	private String insertTime;	//입력시간
	private String title;	//제목
	private String contents;	//내용
	private String subAddr;	//동주소
	private int recommend;	//추천수
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getSubAddr() {
		return subAddr;
	}
	public void setSubAddr(String subAddr) {
		this.subAddr = subAddr;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [id=" + id + ", userId=" + userId + ", insertTime="
				+ insertTime + ", title=" + title + ", contents=" + contents
				+ ", subAddr=" + subAddr + ", recommend=" + recommend + "]";
	}
	
	
	
	
	
	

}

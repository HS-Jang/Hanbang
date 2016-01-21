package hanbang_TeamA.com.vo;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class UserVO extends AbstractVO {
	
	@Id
	private String id;
	
	@NotEmpty(message = "User Id is required.")
	private String userId;
	
	@NotEmpty(message = "Pessowrd is required.")
	private String pwd;
	
	private String name;
	
	private String authNo;
	
	private String cell;
	
	private String rigth;
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userId=" + userId + ", pwd=" + pwd
				+ ", name=" + name + ", authNo=" + authNo + ", cell=" + cell
				+ ", rigth=" + rigth + "]";
	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthNo() {
		return authNo;
	}

	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getRigth() {
		return rigth;
	}

	public void setRigth(String rigth) {
		this.rigth = rigth;
	}
	

}

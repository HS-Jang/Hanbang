package hanbang_TeamA.com.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class SessionVO implements Serializable  {
	
	private static final long serialVersionUID = 2506026650186940160L;
	
	private String userId;
	
	private String name;
	
	private String rigth;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRigth() {
		return rigth;
	}

	public void setRigth(String rigth) {
		this.rigth = rigth;
	}

	@Override
	public String toString() {
		return "SessionVO [userId=" + userId + ", name=" + name + ", rigth="
				+ rigth + "]";
	}
	
	

}

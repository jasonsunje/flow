package vo.users;

public class UsersVO {

	private int userid;
	private String username;
	private String password;
	private String role;
	private String salt;

	public UsersVO() {
		super();
	}

	public UsersVO(int userid, String username, String password, String role, String salt) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}

package vo.admin;

public class AdminVO {

	private int adminId;
	private String name;
	private String password;

	public AdminVO() {
		super();
	}

	public AdminVO(int admindId, String name, String password) {
		super();
		this.adminId = admindId;
		this.name = name;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

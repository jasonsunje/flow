package vo.extensionsetting;

public class ExtensionsettingVO {

	private int extensionid;
	private String extensionname;
	private int isblocked;
	private int userid;

	public ExtensionsettingVO() {
		super();
	}

	public ExtensionsettingVO(int extensionid, String extensionname, int isblocked, int userid) {
		super();
		this.extensionid = extensionid;
		this.extensionname = extensionname;
		this.isblocked = isblocked;
		this.userid = userid;
	}

	public int getExtensionid() {
		return extensionid;
	}

	public void setExtensionid(int extensionid) {
		this.extensionid = extensionid;
	}

	public String getExtensionname() {
		return extensionname;
	}

	public void setExtensionname(String extensionname) {
		this.extensionname = extensionname;
	}

	public int getIsblocked() {
		return isblocked;
	}

	public void setIsblocked(int isblocked) {
		this.isblocked = isblocked;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}

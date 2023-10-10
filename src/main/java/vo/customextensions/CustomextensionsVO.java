package vo.customextensions;

public class CustomextensionsVO {

	private int customextensionid;
	private String extensionname;
	private int userid;

	public CustomextensionsVO() {
		super();
	}

	public CustomextensionsVO(int customextensionid, String extensionname, int userid) {
		super();
		this.customextensionid = customextensionid;
		this.extensionname = extensionname;
		this.userid = userid;
	}

	public int getCustomextensionid() {
		return customextensionid;
	}

	public void setCustomextensionid(int customextensionid) {
		this.customextensionid = customextensionid;
	}

	public String getExtensionname() {
		return extensionname;
	}

	public void setExtensionname(String extensionname) {
		this.extensionname = extensionname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}

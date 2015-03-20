package bean;

public class Country {
	
	private int flag;
	private String name;
	private int tag;
	
	public Country(int flag, String name, int tag) {
		this.flag = flag;
		this.name = name;
		this.tag = tag;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setTag(int tag) {
		this.tag = tag;
	}
	
	public int getTag() {
		return tag;
	}
}

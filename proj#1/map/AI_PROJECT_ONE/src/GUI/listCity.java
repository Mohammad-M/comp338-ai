package GUI;

public class listCity {
	private int vid;
	private String name;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public listCity(int vid, String name) {
		super();
		this.vid = vid;
		this.name = name;
	}
}

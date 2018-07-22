package GUI;
import java.util.LinkedList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Vertices extends Circle {
	public static int vNum=1;
	private int vid;
	//double allCost = 0;
	double costEdge = 0;
	
	public Vertices parent;
	public boolean isUsed = false;
	private String name = new String();
	private LinkedList<edge> cost = new LinkedList<>();
	public Vertices(double centerX, double centerY, double radius , int vid, String vname) {
		super(centerX, centerY, radius);
		this.vid=vNum++;
		this.name = new String(vname);
		this.setFill(Color.BLUE);
		
	}
	
	
	public Vertices(double centerX, double centerY, double radius) {
		super(centerX, centerY, radius);
		this.vid=vNum++;
		this.setFill(Color.BLUE);
		// TODO Auto-generated constructor stub
	}


	public static int getvNum() {
		return vNum;
	}
	public static void setvNum(int vNum) {
		Vertices.vNum = vNum;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<edge> getCost() {
		return cost;
	}


	public void setCost(LinkedList<edge> cost) {
		this.cost = cost;
	}

	public String toString() {
		return this.vid + " -> " + this.name;
	}
}

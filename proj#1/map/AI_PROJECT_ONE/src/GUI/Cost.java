package GUI;

import javafx.scene.shape.Line;

public class Cost extends Line{
	private int vid1;
	private int vid2;
	private double cost;
	
	public Cost(int vid1,int vid2, double cost, double startX, double startY, double endX, double endY) {
		super(startX, startY, endX, endY);
		this.vid1 = vid1;
		this.vid2 = vid2;
		this.cost = cost;
	}
	public int getVid1() {
		return vid1;
	}
	public void setVid1(int vid1) {
		this.vid1 = vid1;
	}
	public int getVid2() {
		return vid2;
	}
	public void setVid2(int vid2) {
		this.vid2 = vid2;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Cost [vid1=" + vid1 + ", vid2=" + vid2 + ", cost=" + cost + "]";
	}
	

}

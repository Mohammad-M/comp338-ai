package GUI;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Font;

public class edge extends Group {
	
	Line line;
	Label label;
	private int vid1;
	private int vid2;
	
	double cost;
	

	public edge(int vid1,int vid2,  double cost, double startX, double startY, double endX, double endY) {
		this(vid1, vid2,cost, new Line(startX, startY, endX, endY), new Label(""), startX,
				startY, endX, endY);
	}

	

	private edge(int vid1,int vid2, double cost, Line line, Label l, double xx1,
			double yy1, double xx2, double yy2) {
		super(line, l);
		this.vid1 = vid1;
		this.vid2 = vid2;
		this.line= line;
		this.label = l;
		this.cost = cost;
		
		
			l.setText(cost+"");
			if ((yy2 - yy1) / (xx2 - xx1) < 0) {
				l.setLayoutX((xx1 + xx2) / 2 - 3);
				l.setLayoutY((yy1 + yy2) / 2 - 16);
			} else {
				l.setLayoutX((xx1 + xx2) / 2 - 3);
				l.setLayoutY((yy1 + yy2) / 2 - 10);
			}
			l.setAlignment(Pos.TOP_LEFT);
			l.setStyle("-fx-background-color:deepskyblue ;");
			l.setFont(new Font(13));

		
		l.setVisible(false);
		this.line.setStrokeWidth(2);
		this.line = line;
		this.line.setStroke(Color.DARKGREEN);

	

		

		
		

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

	

	
}

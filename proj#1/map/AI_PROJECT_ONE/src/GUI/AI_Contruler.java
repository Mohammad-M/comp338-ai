package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class AI_Contruler implements Initializable {
	@FXML
	Pane root = new Pane();
	@FXML
	Button ver = new Button();
	@FXML
	Button edge = new Button();
	@FXML
	Button clear = new Button();
	@FXML
	boolean verF = false;
	@FXML
	boolean edgeF = false;
	@FXML
	boolean clearF = false;
	@FXML
	public static Vertices data[] = new Vertices[200];

	@FXML
	Label costl;
	@FXML
	Label spacel;
	private PrintWriter savetxt;
	private Scanner scan;
	@FXML
	Labeled startVertex;
	boolean BFsboolean;
	private boolean Vstart = false;
	private Vertices Vbegin;
	private boolean UCSboolean;
	private boolean DFSboolean;
	private boolean DLSboolean;
	private boolean IDDFSboolean;
	private boolean Astarboolean;

	public void BFS() {
		System.out.println("bfs");
		BFsboolean = true;
		Vstart = true;
		startVertex.setText("Pleas select start vertex ...");
		startVertex.setVisible(true);
		costl.setVisible(false);
	}

	public void UCS() {
		System.out.println("ucs");
		UCSboolean = true;
		Vstart = true;
		startVertex.setText("Pleas select start vertex ...");
		startVertex.setVisible(true);
		costl.setVisible(false);
	}

	@FXML
	public void DFS() {
		System.out.println("dfs");
		DFSboolean = true;
		Vstart = true;
		startVertex.setText("Pleas select start vertex ...");
		startVertex.setVisible(true);
		costl.setVisible(false);
	}

	public void IDDFS() {
		System.out.println("IDDFS");
		IDDFSboolean = true;
		Vstart = true;
		startVertex.setText("Pleas select start vertex ...");
		startVertex.setVisible(true);
		costl.setVisible(false);
	}
	public void Astar() {
		System.out.println("A*");
		Astarboolean = true;
		Vstart = true;
		startVertex.setText("Pleas select start vertex ...");
		startVertex.setVisible(true);
		costl.setVisible(false);
	}
	public void DLS() {
		System.out.println("dls");
		DLSboolean = true;
		Vstart = true;
		startVertex.setText("Pleas select start vertex ...");
		startVertex.setVisible(true);
		costl.setVisible(false);
	}

	public void clear() {
		System.out.println(data[31].getName());
		for (int i = 0; i < data[31].getCost().size(); i++) {

			System.out.print("  edge =   " + data[data[31].getCost().get(i).getVid1()].getName() + "-"
					+ data[data[31].getCost().get(i).getVid2()].getName());

		}
		System.out.println();
		costl.setVisible(false);
		spacel.setVisible(false);
		BFsboolean = false;
		DFSboolean = false;
		Vstart = false;
		IDDFSboolean = false;
		DLSboolean = false;
		UCSboolean = false;
		Astarboolean = false;
		startVertex.setText("Pleas select start vertex ...");
		startVertex.setVisible(false);
		lNode n = alledgeDrow.getFirstNode();
		for (int i = 0; i < alledgeDrow.getlength(); i++) {
			((edge) n.element).line.setStroke(Color.DARKGREEN);
			n = n.Next;
		}
		alledgeDrow = new List();
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null) {

				data[i].isUsed = false;
				data[i].parent = null;
				data[i].costEdge = 0;
			}
		}
		System.out.println("clear");

	}

	@FXML
	private void save() throws FileNotFoundException {
		File savedata = new File("files/data.txt");
		savetxt = new PrintWriter(savedata);
		for (int i = 1; i < data.length; i++) {
			if (data[i] != null) {
				String data1 = data[i].getVid() + "," + data[i].getName() + "," + data[i].getCenterX() + ","
						+ data[i].getCenterY();
				String data2 = new String();
				String tmp = new String();
				for (int j = 0; j < data[i].getCost().size(); j++) {
					edge tmpCost = data[i].getCost().get(j);
					tmp = tmpCost.getVid2() + ":" + tmpCost.getCost() + ",";
					data2 += tmp;
				}
				savetxt.println(data1 + "#" + data2);
			}

		}
		savetxt.close();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TODO Auto-generated method stub
		root.setOnMousePressed(e -> {
			if (verF) {
				TextInputDialog dialog = new TextInputDialog("Name Of city ");
				dialog.setTitle("Name Of city");
				dialog.setHeaderText("");
				dialog.setContentText("Please enter the name of City ");
				Optional<String> result = dialog.showAndWait();
				try {
					String name = result.get();
					int i = Vertices.vNum;
					data[i] = new Vertices(e.getX(), e.getY(), 5);
					data[i].setName(name);
					root.getChildren().add(data[i]);
				} catch (Exception ew) {

				}
			}
		});

		ver.setOnAction(e -> {
			verF = true;
			edgeF = false;
			clearF = false;
		});
		clear.setOnAction(e -> {
			verF = false;
			edgeF = false;
			clearF = true;
		});

	}

	@FXML
	private void addEdgeFun() {
		verF = false;
		edgeF = true;
		clearF = false;
		Stage edgeStage = new Stage();
		GridPane Pane = new GridPane();
		Scene edgeScene = new Scene(Pane);
		ListView<listCity> cityOne = new ListView<listCity>();
		ListView<listCity> cityTwo = new ListView<listCity>();
		Button addEdge = new Button("Add Edge");
		TextField costValue = new TextField();
		Label c1 = new Label("City One");
		Label c2 = new Label("City Two");
		c1.setPrefWidth(340);
		c2.setPrefWidth(340);
		c1.setPrefHeight(30);
		c2.setPrefHeight(30);
		c1.setAlignment(Pos.CENTER);
		c2.setAlignment(Pos.CENTER);
		addEdge.setPrefWidth(340);
		costValue.setPromptText("Cost in Km");

		Pane.add(c1, 0, 0);
		Pane.add(c2, 1, 0);
		Pane.add(cityOne, 0, 1);
		Pane.add(cityTwo, 1, 1);
		Pane.add(addEdge, 1, 2);
		Pane.add(costValue, 0, 2);

		ObservableList<listCity> options = FXCollections.observableArrayList();
		ObservableList<listCity> options2 = FXCollections.observableArrayList();
		for (int i = 1; i < AI_Contruler.data.length; i++) {
			if (data[i] != null) {
				options.add(new listCity(data[i].getVid(), data[i].getName()));
			} else
				break;
		}

		for (int i = 1; i < AI_Contruler.data.length; i++) {
			if (data[i] != null) {
				options2.add(new listCity(data[i].getVid(), data[i].getName()));
			} else
				break;
		}
		cityOne.setItems(options);
		cityTwo.setItems(options2);
		addEdge.setOnAction(e -> {
			int v1 = cityOne.getSelectionModel().getSelectedItem().getVid();
			int v2 = cityTwo.getSelectionModel().getSelectedItem().getVid();
			double cost = Double.parseDouble(costValue.getText());
			// data[v1].getCost().add(new Cost(v2, cost));
			Line lineTmp = new Line(data[v1].getCenterX(), data[v1].getCenterY(), data[v2].getCenterX(),
					data[v2].getCenterY());
			root.getChildren().add(lineTmp);
		});
		edgeStage.setScene(edgeScene);
		File BZU_IMG_ICON = new File("files/img/icon.png");
		edgeStage.getIcons().add(new Image(BZU_IMG_ICON.toURI().toString()));
		edgeStage.setTitle("Add edge");
		edgeStage.setResizable(false);
		edgeStage.show();

	}

	@FXML
	public void readFile() {
		File info = new File("files/data.txt");
		try {
			int max = 0;
			scan = new Scanner(info);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String sp[] = line.split("#");
				String sp2[] = sp[0].split(",");
				int i = Integer.parseInt(sp2[0]);
				data[i] = new Vertices(Double.parseDouble(sp2[2]), Double.parseDouble(sp2[3]) + 15, 5, i, sp2[1]);
				data[i].setOnMouseMoved(e -> {
					data[i].setFill(Color.CYAN);
				});
				data[i].setOnMouseExited(e -> {
					data[i].setFill(Color.BLUE);
				});
				data[i].setOnMouseClicked(e -> {

					if (BFsboolean) {
						startVertex.setText("Pleas select end vertex ...");
						if (Vstart) {
							Vbegin = (Vertices) e.getSource();
							Vstart = false;
						} else {
							clear();
							if (Vbegin.getVid() != ((Vertices) e.getSource()).getVid()) {
								BFSAlgorethim(Vbegin, (Vertices) e.getSource());
								if (((Vertices) e.getSource()).parent != null) {
									DrowingPath((Vertices) e.getSource());
									startVertex.setText("Pleas select start vertex ...");
									startVertex.setVisible(false);
								} else {
									startVertex.setText("This vertex can not be reached");
									startVertex.setVisible(true);
								}
							} else {
								costl.setText("Cost = " + 0);
								costl.setVisible(true);
								spacel.setText("Space = " + 0);
								spacel.setVisible(true);
							}

						}
					}
					if (UCSboolean) {
						startVertex.setText("Pleas select end vertex ...");
						if (Vstart) {
							Vbegin = (Vertices) e.getSource();
							Vstart = false;
						} else {
							clear();
							if (Vbegin.getVid() != ((Vertices) e.getSource()).getVid()) {
								UCSAlgorethim(Vbegin, (Vertices) e.getSource());
								if (((Vertices) e.getSource()).parent != null) {
									DrowingPath((Vertices) e.getSource());
									startVertex.setText("Pleas select start vertex ...");
									startVertex.setVisible(false);
								} else {
									startVertex.setText("This vertex can not be reached");
									startVertex.setVisible(true);
								}
							} else {
								costl.setText("Cost = " + 0);
								costl.setVisible(true);
								spacel.setText("Space = " + 0);
								spacel.setVisible(true);
							}
						}
					}
					if (DFSboolean) {

						startVertex.setText("Pleas select end vertex ...");
						if (Vstart) {
							Vbegin = (Vertices) e.getSource();
							Vstart = false;
						} else {
							clear();
							if (Vbegin.getVid() != ((Vertices) e.getSource()).getVid()) {
								DFSAlgorethim(Vbegin, (Vertices) e.getSource());
								if (((Vertices) e.getSource()).parent != null) {
									DrowingPath((Vertices) e.getSource());
									startVertex.setText("Pleas select start vertex ...");
									startVertex.setVisible(false);
								} else {
									startVertex.setText("This vertex can not be reached");
									startVertex.setVisible(true);
								}
							} else {
								costl.setText("Cost = " + 0);
								costl.setVisible(true);
								spacel.setText("Space = " + 0);
								spacel.setVisible(true);
							}
						}
					}
					if (DLSboolean) {
						startVertex.setText("Pleas select end vertex ...");
						if (Vstart) {
							Vbegin = (Vertices) e.getSource();
							Vstart = false;
						} else {
							clear();
							if (Vbegin.getVid() != ((Vertices) e.getSource()).getVid()) {
								TextInputDialog dialog = new TextInputDialog("20");
								dialog.setTitle("Depth Limited Search");
								dialog.setHeaderText("Look, Depth Limited Search");
								dialog.setContentText("Please enter max #of vertixes:");

								// Traditional way to get the response value.
								Optional<String> result = dialog.showAndWait();
								if (result.isPresent()) {
									try {
										int a = Integer.parseInt(result.get());
										DLSAlgorethim(Vbegin, (Vertices) e.getSource(), a);
										if (((Vertices) e.getSource()).parent != null) {
											DrowingPath((Vertices) e.getSource());
											startVertex.setText("Pleas select start vertex ...");
											startVertex.setVisible(false);
										} else {
											startVertex.setText("This vertex can not be reached");
											startVertex.setVisible(true);
										}
									} catch (Exception e2) {
										Alert alert = new Alert(AlertType.ERROR);
										alert.setTitle("Error Dialog");
										alert.setHeaderText("Look, an Error Dialog");
										alert.setContentText("Ooops, error input!");

										alert.showAndWait();
										clear();
									}

								}
							} else {
								costl.setText("Cost = " + 0);
								costl.setVisible(true);
								spacel.setText("Space = " + 0);
								spacel.setVisible(true);
							}

						}
					}
					if (IDDFSboolean) {
						startVertex.setText("Pleas select end vertex ...");
						if (Vstart) {
							Vbegin = (Vertices) e.getSource();
							Vstart = false;
						} else {
							clear();
							if (Vbegin.getVid() != ((Vertices) e.getSource()).getVid()) {
								IDDFSboolean = true;
								IDDFSAlgorethim(Vbegin, (Vertices) e.getSource());
								if (((Vertices) e.getSource()).parent != null) {
									DrowingPath((Vertices) e.getSource());
									startVertex.setText("Pleas select start vertex ...");
									startVertex.setVisible(false);
								} else {
									startVertex.setText("This vertex can not be reached");
									startVertex.setVisible(true);
								}
							} else {
								costl.setText("Cost = " + 0);
								costl.setVisible(true);
								spacel.setText("Space = " + 0);
								spacel.setVisible(true);
							}
						}
					}
					if (Astarboolean) {
						startVertex.setText("Pleas select end vertex ...");
						if (Vstart) {
							Vbegin = (Vertices) e.getSource();
							Vstart = false;
						} else {
							clear();
							if (Vbegin.getVid() != ((Vertices) e.getSource()).getVid()) {
								Astarboolean = true;
								IDDFSAlgorethim(Vbegin, (Vertices) e.getSource());
								if (((Vertices) e.getSource()).parent != null) {
									DrowingPath((Vertices) e.getSource());
									startVertex.setText("Pleas select start vertex ...");
									startVertex.setVisible(false);
								} else {
									startVertex.setText("This vertex can not be reached");
									startVertex.setVisible(true);
								}
							} else {
								costl.setText("Cost = " + 0);
								costl.setVisible(true);
								spacel.setText("Space = " + 0);
								spacel.setVisible(true);
							}
						}
					}
				});

			}
			scan = new Scanner(info);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String sp[] = line.split("#");
				String sp2[] = sp[0].split(",");
				int i = Integer.parseInt(sp2[0]);

				if (i > max)
					max = i;

				if (sp.length > 1) {
					String sp3[] = sp[1].split(",");
					for (int j = 0; j < sp3.length; j++) {
						String sp4[] = sp3[j].split(":");

						double startX = data[i].getCenterX();
						double startY = data[i].getCenterY();
						double endX;
						double endY;
						double m = (data[Integer.parseInt(sp4[0])].getCenterY() - startY)
								/ (data[Integer.parseInt(sp4[0])].getCenterX() - startX);
						double angle = Math.atan(m);
						if (startX <= data[Integer.parseInt(sp4[0])].getCenterX()) {
							endX = data[Integer.parseInt(sp4[0])].getRadius() * Math.cos(angle + Math.PI)
									+ data[Integer.parseInt(sp4[0])].getCenterX();
							startX += data[Integer.parseInt(sp4[0])].getRadius() * Math.cos(angle);
							endY = data[Integer.parseInt(sp4[0])].getRadius() * Math.sin(angle + Math.PI)
									+ data[Integer.parseInt(sp4[0])].getCenterY();
							startY += data[Integer.parseInt(sp4[0])].getRadius() * Math.sin(angle);
						} else {
							endX = data[Integer.parseInt(sp4[0])].getRadius() * Math.cos(angle)
									+ data[Integer.parseInt(sp4[0])].getCenterX();
							startX += data[Integer.parseInt(sp4[0])].getRadius() * Math.cos(angle + Math.PI);
							startY += data[Integer.parseInt(sp4[0])].getRadius() * Math.sin(angle + Math.PI);
							endY = data[Integer.parseInt(sp4[0])].getRadius() * Math.sin(angle)
									+ data[Integer.parseInt(sp4[0])].getCenterY();
						}

						edge c = new edge(i, Integer.parseInt(sp4[0]), Double.parseDouble(sp4[1]), startX, startY, endX,
								endY);
						c.setOnMouseMoved(e -> {
							((edge) e.getSource()).label.setLayoutX(e.getX() - 26);
							((edge) e.getSource()).label.setLayoutY(e.getY() - 10);

							((edge) e.getSource()).label.setVisible(true);
						});
						c.setOnMouseExited(e -> {
							((edge) e.getSource()).label.setVisible(false);
						});
						if (!data[i].getCost().contains(c))
							data[i].getCost().add(c);
						if (!data[Integer.parseInt(sp4[0])].getCost().contains(c))
							data[Integer.parseInt(sp4[0])].getCost().add(c);
						root.getChildren().add(c);
					}
				}
			}
			Vertices.vNum = max + 1;

			for (int i = 1; i < data.length; i++) {
				if (data[i] != null) {
					root.getChildren().add(data[i]);
				} else
					break;
			}



		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void IDDFSAlgorethim(Vertices vbegin2, Vertices source) {
		int cost = 0;
		int space = 0;
		for (int i = 1; i < 200; i++) {
			DLSAlgorethim(vbegin2, source, i);
			cost += Icost;
			if (Ispace > space)
				space = Ispace;
			if (source.parent != null)
				break;
			else {
				clear();
				IDDFSboolean = true;
			}
		}
		costl.setText("Cost = " + cost);

		costl.setVisible(true);
		spacel.setText("Space = " + space);
		spacel.setVisible(true);
		IDDFSboolean = false;
	}

	private void DLSAlgorethim(Vertices begin, Vertices end, int a) {
		int cost = 0;
		int space = 0;
		Stack<Vertices> s = new Stack<>();
		s.push(begin);
		if (a < 1)
			return;
		while (!s.empty()) {
			if (s.size() > space)
				space = s.size();
			if (space > a) {
				if (!IDDFSboolean) {
					costl.setText("Cost = " + cost);
					costl.setVisible(true);
					spacel.setText("Space = " + --space);
					spacel.setVisible(true);
				} else {
					Icost = cost;
					Ispace = space;
				}

				return;
			}
			cost++;

			cost++;
			Vertices v = s.pop();
			v.isUsed = true;
			for (int i = 0; i < v.getCost().size(); i++) {
				cost++;
				Vertices d = data[v.getCost().get(i).getVid1()];
				if (d.getVid() != v.getVid()) {
					if (d.getVid() == end.getVid()) {
						d.parent = v;
						cost++;
						costl.setText("Cost = " + cost);
						costl.setVisible(true);
						spacel.setText("Space = " + space);
						spacel.setVisible(true);
						System.out.println("find");
						return;
					} else {
						if (!d.isUsed) {
							s.push(d);
							if (d.parent == null)
								d.parent = v;
						}
						cost++;
					}
					cost++;
				} else {
					d = data[v.getCost().get(i).getVid2()];
					if (d == end) {
						d.parent = v;
						costl.setText("Cost = " + cost);
						costl.setVisible(true);
						spacel.setText("Space = " + space);
						spacel.setVisible(true);
						System.out.println("find");
						return;
					} else {
						if (!d.isUsed) {
							s.push(d);
							if (d.parent == null)
								d.parent = v;
						}
						cost++;
					}
					cost++;
				}
				cost++;
			}
		}
		cost++;
		if (!IDDFSboolean) {
			costl.setText("Cost = " + cost);
			costl.setVisible(true);
			spacel.setText("Space = " + space);
			spacel.setVisible(true);
		} else {
			Icost = cost;
			Ispace = space;
		}
	}

	int Icost = 0;
	int Ispace = 0;

	private void DFSAlgorethim(Vertices begin, Vertices end) {
		int cost = 0;
		int space = 0;
		Stack<Vertices> s = new Stack<>();
		begin.isUsed = true;
		s.push(begin);

		while (!s.empty()) {
			if (s.size() > space)
				space = s.size();
			cost++;
			Vertices v = s.pop();
			System.out.println(v.getName());
			if (v == end) {
				costl.setText("Cost = " + cost);
				costl.setVisible(true);
				spacel.setText("Space = " + space);
				spacel.setVisible(true);
				System.out.println("find");
				return;
			}
			cost++;
			v.isUsed = true;
			for (int i = 0; i < v.getCost().size(); i++) {
				cost++;
				Vertices d = data[v.getCost().get(i).getVid1()];
				if (d.getVid() != v.getVid()) {
					System.out.println(d.getName());
					if (!d.isUsed) {
						s.push(d);

						d.parent = v;
					}
					cost++;

				} else {
					d = data[v.getCost().get(i).getVid2()];
					System.out.println(d.getName());
					if (!d.isUsed) {
						s.push(d);

						d.parent = v;
					}
					cost++;

				}
				cost++;
			}
		}
		cost++;

		costl.setText("Cost = " + cost);

		costl.setVisible(true);
		spacel.setText("Space = " + space);
		spacel.setVisible(true);

	}

	private void DrowingPath(Vertices source) {
		if (source.parent != null) {
			for (int i = 0; i < source.getCost().size(); i++) {
				edge e = source.getCost().get(i);
				if (e.getVid1() == source.parent.getVid()) {
					e.line.setStroke(Color.RED);
					alledgeDrow.addLast(e);
				} else if (e.getVid2() == source.parent.getVid()) {
					e.line.setStroke(Color.RED);
					alledgeDrow.addLast(e);
				}
			}
			System.out.println(source.getName());
			DrowingPath(source.parent);
		}

	}

	private void UCSAlgorethim(Vertices vbegin2, Vertices end) {
		minHeap heap = new minHeap(200);
		vbegin2.costEdge = 0;
		Vertices temp = vbegin2;
		temp.isUsed = true;
		int cost = 0;
		int space = 0;
		while (true) {
			if (heap.size > space)
				space = heap.size;
			if (temp.getVid() == end.getVid()) {
				System.out.println("done 2");
				cost++;
				break;
			} else {
				for (int i = 0; i < temp.getCost().size(); i++) {
					cost++;
					edge c = temp.getCost().get(i);
					Vertices v = data[c.getVid1()];

					if (temp.getVid() != v.getVid()) {
						if (!v.isUsed) {
							if (v.parent == null) {
								v.parent = temp;

								v.costEdge = c.cost + v.parent.costEdge;

							} else {
								double a, b;
								a = c.cost + temp.costEdge;

								if (v.costEdge > a) {
									v.parent = temp;

									v.costEdge = c.cost + v.parent.costEdge;
								}

							}

							heap.insert(new Node(v));
							System.out.print(
									v.getName() + "--" + v.costEdge + "  parent = " + v.parent.getName() + " %% ");

						}
						cost++;
					} else {

						v = data[c.getVid2()];
						if (!v.isUsed) {

							if (v.parent == null) {

								v.parent = temp;

								v.costEdge = c.cost + v.parent.costEdge;

							} else {

								double a, b;
								a = c.cost + temp.costEdge;

								if (v.costEdge > a) {
									v.parent = temp;
									v.costEdge = c.cost + v.parent.costEdge;
								}

							}

							heap.insert(new Node(v));
							System.out.print(
									v.getName() + "--" + v.costEdge + "  parent = " + v.parent.getName() + " %% ");
						}
						cost++;

					}
					cost++;

				}

				if (heap.size == 0)
					break;
				cost++;
				System.out.println();

				temp = heap.deleteMin().element;
				temp.isUsed = true;
				System.out.println("temp = " + temp.getName());
			}

		}
		costl.setText("Cost = " + cost);
		costl.setVisible(true);
		spacel.setText("Space = " + space);
		spacel.setVisible(true);
	}

	List alledgeDrow = new List();

	public void BFSAlgorethim(Vertices begin, Vertices end) {

		int cost = 0;
		int space = 0;
		queue q = new queue();
		q.inq(begin);

		while (!q.empty()) {
			if (q.size() > space)
				space = q.size();
			cost++;
			Vertices v = (Vertices) q.deq();
			System.out.println(v.getName());
			v.isUsed = true;
			if (v == end) {
				costl.setText("Cost = " + cost);
				costl.setVisible(true);
				spacel.setText("Space = " + space);
				spacel.setVisible(true);
				System.out.println("find");
				return;
			}
			cost++;
			for (int i = 0; i < v.getCost().size(); i++) {
				cost++;
				Vertices d = data[v.getCost().get(i).getVid1()];
				if (d.getVid() != v.getVid()) {
					System.out.println(d.getName());
					if (!d.isUsed) {
						q.inq(d);

							d.parent = v;
					}
					cost++;

				} else {
					d = data[v.getCost().get(i).getVid2()];
					System.out.println(d.getName());
					if (!d.isUsed) {
						q.inq(d);

							d.parent = v;
					}
					cost++;

				}
				cost++;
			}
		}
		cost++;

		costl.setText("Cost = " + cost);

		costl.setVisible(true);
		spacel.setText("Space = " + space);
		spacel.setVisible(true);

	}

	public void about() {
		Alert infoMsg = new Alert(AlertType.INFORMATION);
		infoMsg.setContentText(
				"This Is The Artificial intelligence  project \nDone by  Waseem Awashra \nCourse Instructor Dr. Mustafa Jarrar");
		infoMsg.show();
	}
}

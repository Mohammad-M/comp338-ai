package GUI;

/*
 *
 * @ MMM << 1141648 >>
 *
 */

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Driver extends Application {
	static Stage primaryStage = new Stage();
	@Override
	public void start(Stage primaryStageh) throws Exception {
		/*
		 * To defined FXML file to used by Scene Builder tools
		 */
		Parent root = FXMLLoader.load(getClass().getResource("FXGUI.fxml"));

		/*
		 * To run GUI by javaFx , and set dimensions for the interface
		 */
		Scene mySceen = new Scene(root);
		primaryStage.setScene(mySceen);
		primaryStage.setTitle("AI PROJECT ONE"); // Title interface
		/*
		 * To add BZU icons to interface
		 */
		File BZU_IMG_ICON = new File("files/img/icon.png");
		primaryStage.getIcons().add(new Image(BZU_IMG_ICON.toURI().toString()));
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	/*
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		launch(args);
	}

}

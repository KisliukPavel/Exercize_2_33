/*(Body Mass Index Calculator) Create a BMI calculator that reads the user’s weight in pounds and height in inches
(or, if you prefer, the user’s weight in kilograms and height in meters), then calculates and displays the user’s
body mass index.*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercize_2_33 extends Application {
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception
	{
		String title = "Body Mass Index Calculator";
		Parent root = FXMLLoader.load(getClass().getResource("Exercize_2_33.fxml"));
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.setTitle(title);
		primaryStage.centerOnScreen();
		//-----------------------------------------------
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.show();
	}
}
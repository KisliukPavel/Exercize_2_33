import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class Exercize_2_33Controller {

	@FXML
	private Label Result_Label;

	@FXML
	private TextField Weight_Text_Field;

	@FXML
	private TextField Height_Text_Field;

	@FXML
	private Button Compute_Button;

	@FXML
	void compute_Button_Pressed(ActionEvent event) {
		if((0 == Height_Text_Field.getText().length()) || (0 == Weight_Text_Field.getText().length())) {
			Result_Label.setVisible(false);
		}
		else if(!check_Height(Height_Text_Field.getText()) || !check_Weight(Weight_Text_Field.getText())) {
			Result_Label.setVisible(true);
			Result_Label.setTextFill(Color.RED);
			Result_Label.setText("Incorrect input!!!");
		}
		else {
			Result_Label.setVisible(true);
			Result_Label.setTextFill(Color.BLACK);
			Double BMI = compute_BMI(Height_Text_Field.getText(), Weight_Text_Field.getText());
			if (BMI.compareTo(18.5) < 0) {
				Result_Label.setText(String.format("Your BMI is %.2f. Underweight!", BMI));
			}
			else if (BMI.compareTo(25.0) < 0) {
				Result_Label.setText(String.format("Your BMI is %.2f. Normal!", BMI));
			}
			else if(BMI.compareTo(30.0) < 0) {
				Result_Label.setText(String.format("Your BMI is %.2f. Overweight!", BMI));
			}
			else {
				Result_Label.setText(String.format("Your BMI is %.2f. Obese!", BMI));
			}
		}

	}

	boolean check_Height(String S)
	{
		for(int i = 0; i < S.length(); i++) {
			if(!(Character.isDigit(S.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	boolean check_Weight(String S)
	{
		if(!(Character.isDigit(S.charAt(0))) || !(Character.isDigit(S.charAt(S.length() - 1)))) return false;
		int dot_Counter = 0;
		for(int i = 0; i < S.length(); i++) {
			if(!(Character.isDigit(S.charAt(i)))) {
				if('.' != S.charAt(i)) {
					return false;
				}
				else dot_Counter++;
			}
		}
		if(dot_Counter > 1) return false;
		return true;
	}

	Double compute_BMI(String Height, String Weight)
	{
		Double height = Double.valueOf(Height) / 100;
		Double weight = Double.valueOf(Weight);
		return weight / (Math.pow(height, 2.0));
	}

}

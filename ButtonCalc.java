package application;

import javafx.scene.control.Button;
//main class
public class ButtonCalc {
	private static Double operand1=0.0;
	private String operator="";
	Main main = new Main();
	Double num = 0.0;
	String numbersOnly ="";
	//for all the number buttons
	public Button getNumButton(String prompt) {
		Button button = new Button(prompt);
		button.setId("numButton");
		button.setPrefSize(70, 100);
		button.setOnAction(e->{
			numbersOnly += prompt;
			Main.setToTextField += prompt;
			Main.numAndSign.setText(Main.setToTextField);
			if (prompt.equals(".")) {
				return;
		     }
			num = Double.parseDouble(numbersOnly);
			if (!operator.equals("")) {
				Double ans = 0.0;
				if (operator.equals("+")) {
					ans = operand1 + num;
				}else if(operator.equals("x")) {
					ans = operand1 * num;
				}else if (operator.equals("÷")) {
					ans = operand1 / num;
				}else if(operator.equals("-")) {
					ans = operand1 - num;
				}
				Main.ansDisplay.setText(""+ans);
			}

		});

		return button;
	}
	//for operator buttons
	public Button getOperatorButton(String prompt) {
		Button button = new Button(prompt);
		button.setId("rightButton");
		button.setPrefSize(60, 75);
		button.setOnAction(e->{
			operator = prompt;
			if (operand1 == 0.0) {
				operand1 = num;
			}
			num = 0.0 ;
			Main.numAndSign.setText(Main.setToTextField+prompt);
			Main.setToTextField += prompt;
			numbersOnly = "";
			if (!Main.ansDisplay.getText().equals(""))operand1 =Double.parseDouble(Main.ansDisplay.getText());

		});

		return button;
	}
	//for clear buttons
	public Button getClearButton(String prompt) {
		Button button = new Button(prompt);
		button.setId("clearbtn");
		button.setPrefSize(60, 100);
		button.setOnAction(e-> {
			Main.ansDisplay.setText("");
			Main.numAndSign.setText("");
			operand1 = 0.0;
			operator = "";
			num = 0.0;
			numbersOnly ="";
			Main.setToTextField = "";

		});
		return button;
	}
	//for equalToButton
	public Button getEqualButton(String string) {
		Button button = new Button(string);
		button.setId("numButton");
		button.setPrefSize(70, 100);
		button.setOnAction(e-> {
			String ans_1 =Main.ansDisplay.getText();
			Main.numAndSign.setText(ans_1);
			Main.ansDisplay.setText("");
			operand1 = Double.parseDouble(ans_1);
			operator = "";
			num = 0.0;
			numbersOnly =ans_1;
			Main.setToTextField = ans_1;
		});

		return button;
	}

}

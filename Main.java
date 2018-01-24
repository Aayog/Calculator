package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	static TextField ansDisplay,numAndSign;
	static String setToTextField = "";
	int ansText;
	@Override
	public void start(Stage window) {
		try {
			numAndSign = new TextField();

			numAndSign.setPrefSize(300, 40);
			ansDisplay = new TextField();
			ansDisplay.setPrefSize(300, 40);

			numAndSign.setEditable(false);
			ansDisplay.setEditable(false);
						
			ButtonCalc calc = new ButtonCalc();
			
			Button button0 = calc.getNumButton("0");
			Button button1 = calc.getNumButton("1");
			Button button2 = calc.getNumButton("2");
			Button button3 = calc.getNumButton("3");
			Button button4 = calc.getNumButton("4");
			Button button5 = calc.getNumButton("5");
			Button button6 = calc.getNumButton("6");
			Button button7 = calc.getNumButton("7");
			Button button8 = calc.getNumButton("8");
			Button button9 = calc.getNumButton("9");
			Button buttonPoint = calc.getNumButton(".");
			Button buttonEqual = calc.getEqualButton("=");
			
			Label moreLabel = new Label("");
			moreLabel.setId("more");
			moreLabel.prefHeight(400);
			moreLabel.prefWidth(10);
			
			GridPane numButtons = new GridPane();
			
			numButtons.setAlignment(Pos.CENTER);
			numButtons.add(button7, 0, 0);
			numButtons.add(button8, 1, 0);
			numButtons.add(button9, 2, 0);
			
			numButtons.add(button4, 0, 1);
			numButtons.add(button5, 1, 1);
			numButtons.add(button6, 2, 1);
			
			numButtons.add(button1, 0, 2);
			numButtons.add(button2, 1, 2);
			numButtons.add(button3, 2, 2);
			
			numButtons.add(buttonPoint, 0, 3);
			numButtons.add(button0    , 1, 3);
			numButtons.add(buttonEqual, 2, 3);
			
			Button buttonMulti = calc.getOperatorButton("x");
			Button buttonDiv = calc.getOperatorButton("÷");
			Button buttonSub = calc.getOperatorButton("-");
			Button buttonAdd = calc.getOperatorButton("+");
			Button buttonClear = calc.getClearButton("AC");
			
			GridPane operatorButtons = new GridPane();
			operatorButtons.setAlignment(Pos.CENTER);
			operatorButtons.add(buttonClear, 0, 0);
			operatorButtons.add(buttonDiv, 0, 1);
			operatorButtons.add(buttonMulti, 0, 2);
			operatorButtons.add(buttonSub, 0, 3);
			operatorButtons.add(buttonAdd, 0, 4);
			operatorButtons.add(moreLabel, 1, 0,1,4);
			operatorButtons.setId("more");
			
			GridPane bottomLayer = new GridPane();
			bottomLayer.setAlignment(Pos.TOP_LEFT);
			bottomLayer.add(numButtons, 0, 0);
			bottomLayer.add(operatorButtons, 1, 0);
			bottomLayer.setId("bottom");
			GridPane topLayer = new GridPane();
			topLayer.setAlignment(Pos.CENTER);
			topLayer.setVgap(0.0);
			topLayer.add(numAndSign, 0, 0);
			topLayer.add(ansDisplay, 0, 1);
			topLayer.setId("top");
			
			
			GridPane mainLayout = new GridPane();
			mainLayout.setAlignment(Pos.CENTER);
			mainLayout.setVgap(0.0);
			mainLayout.add(topLayer,0,0);
			mainLayout.add(bottomLayer, 0, 1);
			
			Scene scene = new Scene(mainLayout,300,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setTitle("Calculator");
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

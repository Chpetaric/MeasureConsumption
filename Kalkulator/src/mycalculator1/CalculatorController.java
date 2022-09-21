package mycalculator1;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;




public class CalculatorController {
	
	float data = 0f;
	
	int operation = -1;
	
	@FXML
	private TextField displayField;

	@FXML
	private Button one;
	
	@FXML
	private Button two;

	@FXML
	private Button three;

	@FXML
	private Button four;

	@FXML
	private Button five;

	@FXML
	private Button six;

	@FXML
	private Button seven;

	@FXML
	private Button eight;

	@FXML
	private Button nine;

	@FXML
	private Button plus;

	@FXML
	private Button minus;

	@FXML
	private Button Mminus;

	@FXML
	private Button Mplus;

	@FXML
	private Button plusminus;

	@FXML
	private Button C;

	@FXML
	private Button div;

	@FXML
	private Button mult;

	@FXML
	private Button equals;
	
	@FXML
	private Button zero;
	
	@FXML
	private Button MC;
	
	
public void buttonClickHandler(ActionEvent evt) {
		
		Button clickedButton = (Button) evt.getTarget();
		String buttonLabel = clickedButton.getText();
		
		switch(buttonLabel){
		
			case "0": 
			case "1": 
			case "2": 
			case "3": 
			case "4": 
			case "5": 
			case "6": 
			case "7":
			case "8":
			case "9":
			case ".":
				processDigit(buttonLabel);
			break;
			default:
			processOperation(evt);
			
		}
	}

private void processDigit(String buttonLabel) {
	displayField.setText(displayField.getText()+buttonLabel);
	
}

private void processOperation(ActionEvent event) {
	
	
	//System.out.println("You select operation "+buttonLabel);
	
	if (event.getSource() == plus) {
        data = Float.parseFloat(displayField.getText());
        operation = 1; //Addition
        displayField.setText("");
    } else if (event.getSource() == minus) {
        data = Float.parseFloat(displayField.getText());
        operation = 2; //Substraction
        displayField.setText("");
    } else if (event.getSource() == mult) {
        data = Float.parseFloat(displayField.getText());
        operation = 3; //Mul
        displayField.setText("");
    } else if (event.getSource() == div) {
        data = Float.parseFloat(displayField.getText());
        operation = 4; //Division
        displayField.setText("");
    } else if (event.getSource() == C) {
    	displayField.setText("");
    } else if (event.getSource() == equals) {
        Float secondOperand = Float.parseFloat(displayField.getText());
        switch (operation) {
            case 1: //Addition
                Float ans = data + secondOperand;
                displayField.setText(String.valueOf(ans));break;
            case 2: //Subtraction
                ans = data - secondOperand;
                displayField.setText(String.valueOf(ans));break;
            case 3: //Mul
                ans = data * secondOperand;
                displayField.setText(String.valueOf(ans));break;
            case 4: //Div
                ans = 0f;
                try {
                    ans = data / secondOperand;
                }catch(Exception e){displayField.setText("Error");}
                displayField.setText(String.valueOf(ans));break;
        }
    }
	
}
	
	
}

module Kalkulator {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens mycalculator1 to javafx.graphics, javafx.fxml;
}

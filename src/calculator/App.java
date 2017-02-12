package calculator;


import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
	Button button;
	TextArea ta;
	ComboBox<String> cb;
	
public static void main(){
	launch();
}
	@Override
	public void start(Stage stage) throws Exception {
		
		cb= new ComboBox<>();
		cb.setAccessibleText("77");
		cb.setValue("poi");
		ta=new TextArea();
		stage.setTitle("One di");
		button = new Button();
		button.setText("clickMe");
		ta.setText("12");
		ta.setMaxSize(100, 50);
		button.setMaxSize(30,10);
		button.setOnAction(e -> System.out.println("one "+ta.getText()));
		VBox layout= new VBox(10);
		layout.alignmentProperty().set(Pos.CENTER);
		layout.getChildren().addAll(button,ta,cb);
		
		
		Scene scene= new Scene(layout,480,320);	
		stage.setScene(scene);
		stage.show();

	}

}

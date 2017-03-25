package calculator.ui;

import java.awt.event.ActionListener;

import calculator.ui.fxUI.FXMLDocumentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class DesktopFXUserInterface extends Application implements UserInterface {
//private FXMLDocumentController fx=new FXMLDocumentController();
	@Override
	public void run() {
		
		 launch();

	}
	public void setUIListener(Listener a){
		//fx.setActionListener(a);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try{
        Parent root = FXMLLoader.load(getClass().getResource("fxUI/FXMLDocument.fxml"));
		
		
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){e.printStackTrace();}
    }

}

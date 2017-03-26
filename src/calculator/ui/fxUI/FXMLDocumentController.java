package calculator.ui.fxUI;

	import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import calculator.control.CalculatorController;
import calculator.ui.Listener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FXMLDocumentController implements Initializable,Listener {
	
   
		private static List<Listener> listeners =new ArrayList<Listener>();

		
		@FXML  private TextArea textArea;
		@FXML	private Button bExponent;
		@FXML	private Button bPercent;
		@FXML	private Button bLeftBracket;
		@FXML	private Button bRightBracket;
		@FXML	private Button bLoad;
		@FXML	private Button bSave;
		@FXML	private Button bSqrt;
		@FXML	private Button bShowHistory;
		@FXML	private Button bCalculations;
		@FXML	private Button bLoadFromFile;
		@FXML	private Button bClear;
		@FXML	private Button bClearHistory;
	    private Listener a;
	    private boolean _newExampleFlag = true;
	    public FXMLDocumentController(){
	    	CalculatorController.addActionListener(this);
	    }
	    @FXML
	    private void handlePlusButtonAction(ActionEvent event) {
	    	a.fireEvent(event.getSource().toString());
	    }
	    @FXML
	    private void clearHistory(ActionEvent event) {
	    	a.fireEvent(event.getSource().toString());
	    }

	    
	    @FXML
	    private void clearTextArea(ActionEvent e){
	    	setTextArea("");
	    }
	    public void setTextArea(String s){
	    	
	    	
	    	 textArea.setText(s);
	    }
	    public void set_newExampleFlag(boolean _newExampleFlag) {
			this._newExampleFlag = _newExampleFlag;
		}
		public String getTextAreaContent(){
	    	return textArea.getText();
	    }
	    
	    
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	a=CalculatorController.getInstance();
	    	
	    	bExponent.setVisible(false);
	    	bLoad.setVisible(false);
	    	bExponent.setVisible(false);
	    	bPercent.setVisible(false);
	    	bSave.setVisible(false);
	    	bSqrt.setVisible(false);
	    	bShowHistory.setVisible(false);
	    	bLoadFromFile.setVisible(false);
	    	bClearHistory.setVisible(false);
	    	
	    	
	    	
	    }
	    
		public void fireEvent(String eventtoString) {
			
			
			if (eventtoString.contains("del")){
				String textAreaContent = getTextAreaContent();
				if (textAreaContent.length()>0)setTextArea(textAreaContent.substring(0,textAreaContent.length()-1));
			}
			else{
			if (eventtoString.contains("get")){
				String textAreaContent = getTextAreaContent();
				setTextArea(textAreaContent+"=");
				a.fireEvent("$"+textAreaContent);
				
			}else{if (eventtoString.contains("$")){
				setTextArea(eventtoString);
			}else{
				boolean flag = eventtoString.contains("f");
				if (_newExampleFlag){
		    		textArea.setText("");
		    	set_newExampleFlag(false);}
				if (flag){eventtoString=eventtoString.substring(1);
				}
				String s=getTextAreaContent()+eventtoString;
			
				setTextArea(s);
				set_newExampleFlag(flag);
				
			}
			
			
			
			}}
			
		 }
		public static void addActionListener(Listener l){
			for(int i=0;i<listeners.size();i++){
				if (listeners.get(i).equals(l)){
					return;
				}
			}
			listeners.add(l);
		}
		public static void removeActionListener(Listener l){
			for(int i=0;i<listeners.size();i++){
				if (listeners.get(i).equals(l)){
					listeners.remove(i);
					return;
				}
			}
		}
		
		
	   
}


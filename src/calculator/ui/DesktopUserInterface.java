package calculator.ui;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DesktopUserInterface extends JFrame implements UserInterface{
 private final int WIDTH=400;
 private final int HEIGHT=300;
 private JTextField field =new JTextField(1);
 private JButton _b1= new JButton("1");
 private JButton _b2= new JButton("2");
 private JButton _b3= new JButton("3");
 private JButton b4= new JButton("4");
 private JButton b5= new JButton("5");
 private JButton b6= new JButton("6");
 private JButton b7= new JButton("7");
 private JButton b8= new JButton("8");
 private JButton b9= new JButton("9");
 private JButton b0= new JButton("0");
 private JButton bComma= new JButton(".");
 private JButton bBackspace= new JButton("backspace");
 private JButton bPercent= new JButton("%");
 private JButton bLeftBrecket= new JButton("(");
 private JButton bRightBrecket= new JButton(")");
 private JButton bMinus= new JButton("-");
 private JButton _bPlus= new JButton("+");
 private JButton bCalculation= new JButton("Calculation");
 private JButton bMultiply= new JButton("*");
 private JButton bDivide= new JButton("/");
 private JButton bSave= new JButton("save");
 private JButton bLoad= new JButton("load");
 private JButton bShow= new JButton("show history");
 
 private JPanel panel =new JPanel();
  public DesktopUserInterface(){
	  _b1.setSize(10,10);
  }
	public void run() {
		this.setSize(WIDTH, HEIGHT);
		field.setSize(300,10);
		Container container = getContentPane();
		//panel.setLayout(layout);
		GroupLayout layout = new GroupLayout(container);
		container.add(panel);
		container.setLayout(layout);
		panel.add(field);
		container.add(_b1);
		container.add(_b2);
		container.add(_b3);
//		container.add(b4);
//		container.add(b5);
//		container.add(b6);
//		container.add(b7);
//		container.add(b8);
//		container.add(b9);
//		container.add(b0);
//		container.add(bComma);
//		container.add(_bPlus);

		
		this.setContentPane(container);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	@Override
	public void setUIListener(Listener a) {
		// TODO Auto-generated method stub
		
	}
	

}

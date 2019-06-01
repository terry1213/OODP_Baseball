package baseball;

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

public abstract class Menu extends JPanel{
	
	private ImageIcon bgImg = new ImageIcon("/Users/seosang-won/eclipse-workspace/oodp_baseball/src/img/baseball_background.jpg");
	protected JLabel bg = new JLabel(bgImg);

	
	public void setBackground() {
		bg.setBounds(0, 0, 500, 578);
		bg.setLayout(null);
	}
	
	
	//Hook Method
	abstract void decoratePanel();
	
	
		
}

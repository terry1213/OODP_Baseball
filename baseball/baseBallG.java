package baseball;

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;


public class baseBallG extends JFrame{
		
	   ScoreTable sTable;
	   
	   public baseBallG() {
		   super("ContentPane Example");
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		   
		   JFrame f=new JFrame();//creating instance of JFrame  
	          
		   f.setContentPane(new Container());
		   f.setSize(500,600);//400 width and 500 height  
		   f.setLayout(null);//using no layout managers  

		   f.setVisible(true);
		  }
	   
	 
	   
	  @Override
	  public void paint( Graphics g ) {  
		  
		  super.paint(g);
		  
		  //필드 전체 그리기 
		      Graphics2D outField = (Graphics2D)g.create();
		      Color groundColor = new Color(180, 104, 1);
				outField.fillArc(0,200,500,500,45,90);
			
			//내야 필드
			
			  Graphics2D inField = (Graphics2D)g.create();
			  Rectangle base = new Rectangle();
			  base.setBounds(200,320,100,100);
			  inField.setColor(Color.green);
			  inField.rotate(Math.toRadians(45), base.x + base.width/2, base.y + base.height/2);
			  inField.draw(base);
			  inField.fill(base);
			  
			//Draw FirstBase
				
			  Graphics2D fB = (Graphics2D)g.create();
			  Rectangle rec = new Rectangle();
			  rec.setBounds(245,305,10,10);
			  fB.setColor(Color.white);
			  fB.rotate(Math.toRadians(45), rec.x + rec.width/2, rec.y + rec.height/2);
			  fB.draw(rec);
			  fB.fill(rec);
			  
			//Draw SecondBase
				
			  Graphics2D sB = (Graphics2D)g.create();
			  Rectangle rec2 = new Rectangle();
			  rec2.setBounds(305,365,10,10);
			  sB.setColor(Color.white);
			  sB.rotate(Math.toRadians(45), rec2.x + rec2.width/2, rec2.y + rec2.height/2);
			  sB.draw(rec2);
			  sB.fill(rec2);
			  
			  
			//Draw ThirdBase
				
			  Graphics2D tB = (Graphics2D)g.create();
			  Rectangle rec3 = new Rectangle();
			  rec3.setBounds(185,365,10,10);
			  tB.setColor(Color.white);
			  tB.rotate(Math.toRadians(45), rec3.x + rec3.width/2, rec3.y + rec3.height/2);
			  tB.draw(rec3);
			  tB.fill(rec3);
			  
	   }
	  
	  class ScoreTable extends JPanel {
		    public ScoreTable() {
		        Object[][] cellData = {
		            {"row1-col1", "row1-col2"},
		            {"row2-col1", "row2-col2"}};
		        String[] columnNames = {"col1", "col2"};
		        add(  new JTable(cellData, columnNames) ) ;
		    }
		}
	  
	
}



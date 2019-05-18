package baseball;

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;

public class field extends JPanel{
	
	MsgPanel msg = new MsgPanel();
	SBOPanel sbo = new SBOPanel();
	fieldPanel fld = new fieldPanel();
	ScoreBoardPanel score;
	baseballGame game;
	
	public field() {
		initGame();
	}
	
	private void initField() {
		
		 msg = new MsgPanel();
		 sbo = new SBOPanel();
		 fld = new fieldPanel();
		 score = new ScoreBoardPanel(game);

		add(msg);
		add(sbo);
		add(score);
		add(fld);
		
	}
	
	private void initGame() {
		game = new baseballGame();
		game.gameStart();
		initField();
	}
	
	public class fieldPanel extends JPanel {
		@Override
		  public void paintComponent( Graphics g ) {  
			  
			  super.paintComponent(g);
			  drawField(g);
		   }
		
		public void drawField(Graphics g) {
			//필드 전체 그리기
				drawOutField(g);
			
			//내야 필드
				drawInField(g);
			 
			  
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
		
		public void drawOutField(Graphics g) {
			Color groundColor = new Color(180, 104, 1);
		      g.setColor(groundColor);
		      g.fillArc(0,200,500,500,45,90);
		}
		
		public void drawInField(Graphics g) {
			 	Graphics2D inField = (Graphics2D)g.create();
			  Rectangle base = new Rectangle();
			  base.setBounds(200,320,100,100);
			  inField.setColor(Color.green);
			  inField.rotate(Math.toRadians(45), base.x + base.width/2, base.y + base.height/2);
			  inField.draw(base);
			  inField.fill(base);
		}
	}
	 
	 
	 public class MsgPanel extends JPanel{
		 
		 String msg1;
		 
		 public MsgPanel() {
			 setBackground(Color.black);
			 setPreferredSize(new Dimension(250 ,30));
			  
			  JLabel label1=new JLabel(msg1);
			  label1.setSize(100,100);
			  label1.setLocation(0,0);
			  label1.setForeground(Color.yellow);
			  
			label1.setText("Welcome to Baseball Manager 2019!");
			System.out.println("msg:"+msg1);
			add(label1);
		 }
		 
		 public void getmsg(String m) {
			  msg1=m;
			  System.out.println("get:"+msg1);
		  }
	 }
	 
	 public class SBOPanel extends JPanel{
		 CirclePanel strike1;
		   CirclePanel strike2;
		   CirclePanel ball1;
		   CirclePanel ball2;
		   CirclePanel ball3;
		   CirclePanel out1;
		   CirclePanel out2;
		   JPanel sbo=new JPanel();    
		   Object[] sboList=new Object[11];
		   public SBOPanel() {
			   this(Color.white);
		   }
		   
		   public SBOPanel(Color c) {
			   

			   
			   strike1=new CirclePanel(5,80,10,c);
			   strike2=new CirclePanel(5,80,10,c);
			   ball1=new CirclePanel(5,80,10,c);
			   ball2=new CirclePanel(5,80,10,c);
			   ball3=new CirclePanel(5,80,10,c);
			   out1=new CirclePanel(5,80,10,c);
			   out2=new CirclePanel(5,80,10,c);
			   
			   sbo.setLayout(new GridLayout(3,4));
			   sboList[0]=new JLabel("S");
			   sboList[1]=strike1;
			   sboList[2]=strike2;
			   sboList[3]=new JLabel(" ");
			   sboList[4]=new JLabel("B");
			   sboList[5]=ball1;
			   sboList[6]=ball2;
			   sboList[7]=ball3;
			   sboList[8]=new JLabel("O");
			   sboList[9]=out1;
			   sboList[10]=out2;		   
			   
			   for(int i=0;i<11;i++) {
				   if(i==0||i==3||i==4||i==8)
					   sbo.add((JLabel)sboList[i]);
				   else
					   sbo.add((CirclePanel)sboList[i]);
			   }
			   add(sbo,BorderLayout.CENTER);
			  
			   //Todo initialize Jpanel as gridpanel(3,2) and fills it with CirclePanel 
		  
			  setVisible(true);		  
			  }
		   
		   public CirclePanel getStrike1() {
			return strike1;
		}

		public void setStrike1(CirclePanel strike1) {
			this.strike1 = strike1;
		}

		public CirclePanel getStrike2() {
			return strike2;
		}

		public void setStrike2(CirclePanel strike2) {
			this.strike2 = strike2;
		}

		public CirclePanel getBall1() {
			return ball1;
		}

		public void setBall1(CirclePanel ball1) {
			this.ball1 = ball1;
		}

		public CirclePanel getBall2() {
			return ball2;
		}

		public void setBall2(CirclePanel ball2) {
			this.ball2 = ball2;
		}

		public CirclePanel getBall3() {
			return ball3;
		}

		public void setBall3(CirclePanel ball3) {
			this.ball3 = ball3;
		}

		public CirclePanel getOut1() {
			return out1;
		}

		public void setOut1(CirclePanel out1) {
			this.out1 = out1;
		}

		public CirclePanel getOut2() {
			return out2;
		}

		public void setOut2(CirclePanel out2) {
			this.out2 = out2;
		}

		public void redraw () {

			CStrike(Color.red);
			repaint();
			revalidate();
		    
		   }
		   public void CStrike(Color c) {
			   setStrike1(new CirclePanel(5,80,10,c));
			   revalidate();
		       repaint();
		   }
		   
		   class CirclePanel extends JPanel {
			    int centerX, centerY, radius;
			    Color circle_color=Color.red;
			    public CirclePanel(int centerX, int centerY, int radius, Color c) {
			    	this.centerX = centerX;
			        this.centerY = centerY;
			        this.radius = radius;
			        this.circle_color = c;
			        revalidate();
			        repaint();
			    }
			    public void setCircle(int centerX, int centerY, int radius, Color c) {
			        this.centerX = centerX;
			        this.centerY = centerY;
			        this.radius = radius;
			        this.circle_color = c;
			        revalidate();
			        repaint();
			    }


			    protected void paintComponent(Graphics g) {
			        //System.out.println("Trying to draw circle");
			        super.paintComponent(g);
			        g.setColor(this.circle_color);
			        g.fillOval(centerX, centerY, radius*2, radius*2);
			    }
			}
	 }
	 
	 public class ScoreBoardPanel extends JPanel{
		 	private Label baseLabel;
		    private Label teamLabel1;
		    private Label teamLabel2;
		    private Label scoreLabel1;
		    private Label scoreLabel2;
//		    private Label label1;
//		    private Label label2;
		    private JPanel contentPane;
		    baseballGame game;
		    
		    public ScoreBoardPanel() {
		    	contentPane = new JPanel();
		        contentPane.setLayout(null);
		        contentPane.setBackground(Color.black);
		        contentPane.setPreferredSize(new Dimension(500, 130));

		        
		        baseLabel = new Label();
		        baseLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		        baseLabel.setText("1    2    3    4    5    6    7    8    9    R    H  ");
		        baseLabel.setForeground(Color.white);
		        
		        teamLabel1 = new Label();
		        teamLabel1.setFont(new Font("Dialog", Font.PLAIN, 18));
		        teamLabel1.setText("HGU");
		        teamLabel1.setForeground(Color.yellow);
		        
		        teamLabel2 = new Label();
		        teamLabel2.setFont(new Font("Dialog", Font.PLAIN, 18));
		        teamLabel2.setText("COM");
		        teamLabel2.setForeground(Color.yellow);

		        scoreLabel1 = new Label();
		        //label2.setBounds(200, 100, 300, 300);
		        int bufferI = 0 + 0 + 0;
		        String bufferS = 0 + "    " + 0 + "    " + 0 + "                                       " + bufferI + "    " +0;
		        scoreLabel1.setFont(new Font("Dialog", Font.PLAIN, 18));
		        scoreLabel1.setText(bufferS);
		        scoreLabel1.setForeground(Color.green);
		        
		        scoreLabel2 = new Label();
		        //label2.setBounds(200, 100, 300, 300);
		        bufferI = 0 + 0 + 0;
		        bufferS = 0 + "    " + 0 + "    " + 0 + "                                       " + bufferI + "    " +0;
		        scoreLabel2.setFont(new Font("Dialog", Font.PLAIN, 18));
		        scoreLabel2.setText(bufferS);
		        scoreLabel2.setForeground(Color.green);

		        baseLabel.setLocation(100, 25);
		        teamLabel1.setLocation(20, 50);
		        teamLabel2.setLocation(20, 75);
		        scoreLabel1.setLocation(100, 50);
		        scoreLabel2.setLocation(100, 75);
		        
		        baseLabel.setSize(400, 25);
		        teamLabel1.setSize(80, 25);
		        teamLabel2.setSize(80, 25);
		        scoreLabel1.setSize(400, 25);
		        scoreLabel2.setSize(400, 25);
		        
		        contentPane.add(baseLabel);
		        contentPane.add(teamLabel1);
		        contentPane.add(teamLabel2);
		        contentPane.add(scoreLabel1);
		        contentPane.add(scoreLabel2);
		        
		        add(contentPane);
				
				
			}
		    
		    public ScoreBoardPanel(baseballGame game) {
				//MainMenu mainPanel = new MainMenu();
				
				this.game = game;
				setBoard();
			}
		    
		    public void setBoard() {
		    	contentPane = new JPanel();
		        contentPane.setLayout(null);
		        contentPane.setBackground(Color.black);
		        contentPane.setPreferredSize(new Dimension(500, 130));

		        
		        baseLabel = new Label();
		        baseLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		        baseLabel.setText("1    2    3    4    5    6    7    8    9    R    H  ");
		        baseLabel.setForeground(Color.white);
		        
		        teamLabel1 = new Label();
		        teamLabel1.setFont(new Font("Dialog", Font.PLAIN, 18));
		        teamLabel1.setText("HGU");
		        teamLabel1.setForeground(Color.yellow);
		        
		        teamLabel2 = new Label();
		        teamLabel2.setFont(new Font("Dialog", Font.PLAIN, 18));
		        teamLabel2.setText("COM");
		        teamLabel2.setForeground(Color.yellow);

		        scoreLabel1 = new Label();
		        //label2.setBounds(200, 100, 300, 300);
		        int bufferI = game.getScoreBoard(0, 0) + game.getScoreBoard(0, 1) + game.getScoreBoard(0, 2) + game.getScoreBoard(0, 3) + game.getScoreBoard(0, 4) + game.getScoreBoard(0, 5) + game.getScoreBoard(0, 6) + game.getScoreBoard(0, 7) + game.getScoreBoard(0, 8);
		        String bufferS = game.getScoreBoard(0, 0) + "    " + game.getScoreBoard(0, 1) + "    " + game.getScoreBoard(0, 2) + "    " + game.getScoreBoard(0, 3) + "    " + game.getScoreBoard(0, 4) + "    " + game.getScoreBoard(0, 5) + "    " + game.getScoreBoard(0, 6) + "    " + game.getScoreBoard(0, 7) + "    " + game.getScoreBoard(0, 8) + "    " +  bufferI + "    " +game.getTeam1().getHits();
		        scoreLabel1.setFont(new Font("Dialog", Font.PLAIN, 18));
		        scoreLabel1.setText(bufferS);
		        scoreLabel1.setForeground(Color.green);
		        
		        scoreLabel2 = new Label();
		        //label2.setBounds(200, 100, 300, 300);
		        bufferI = game.getScoreBoard(1, 0) + game.getScoreBoard(1, 1) + game.getScoreBoard(1, 2) + game.getScoreBoard(1, 3) + game.getScoreBoard(1, 4) + game.getScoreBoard(1, 5) + game.getScoreBoard(1, 6) + game.getScoreBoard(1, 7) + game.getScoreBoard(1, 8);
		        bufferS = game.getScoreBoard(1, 0) + "    " + game.getScoreBoard(1, 1) + "    " + game.getScoreBoard(1, 2) + "    " + game.getScoreBoard(1, 3) + "    " + game.getScoreBoard(1, 4) + "    " + game.getScoreBoard(1, 5) + "    " + game.getScoreBoard(1, 6) + "    " + game.getScoreBoard(1, 7) + "    " + game.getScoreBoard(1, 8) + "    "+ bufferI + "    " +game.getTeam2().getHits();
		        scoreLabel2.setFont(new Font("Dialog", Font.PLAIN, 18));
		        scoreLabel2.setText(bufferS);
		        scoreLabel2.setForeground(Color.green);

		        baseLabel.setLocation(100, 25);
		        teamLabel1.setLocation(20, 50);
		        teamLabel2.setLocation(20, 75);
		        scoreLabel1.setLocation(100, 50);
		        scoreLabel2.setLocation(100, 75);
		        
		        baseLabel.setSize(400, 25);
		        teamLabel1.setSize(80, 25);
		        teamLabel2.setSize(80, 25);
		        scoreLabel1.setSize(400, 25);
		        scoreLabel2.setSize(400, 25);
		        
		        contentPane.add(baseLabel);
		        contentPane.add(teamLabel1);
		        contentPane.add(teamLabel2);
		        contentPane.add(scoreLabel1);
		        contentPane.add(scoreLabel2);
		        
		        add(contentPane);
				
		    }

	 }
	 
	 private class ScheduleTask extends TimerTask {

		    @Override
		    public void run() {
		        
		        repaint();
		    }
		}
}

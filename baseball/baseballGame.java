

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class baseballGame {
	
	private JPanel contentPane;
	
	
	protected team t1;   //팀 1번 
	protected team t2;   //팀 2번 
	
	private team currentTeam = new team();    //현재 팀에 새로운 팀 할당.
	private ArrayList<String> resultList;     //공을 던진 후의 결과를 모아놓은 리스트.
	
	protected int inning;  //현재 이닝.

	protected boolean isGameOver;  //게임 종료 여부.
	protected int strike;  //스트라이크
	protected int ball; // 볼.
	protected int out; // 아웃
	
	protected String msg1; //메시지를 담는 변수. 
	protected int gameFlag; //0이 되면 체인지, 1이 되면 
	private int[][] scoreBoard = new int[2][11];	//스코어보드
	private int[] scoreSum = new int[2];
	
	JFrame frame = new JFrame();
    

    JTextArea ta = new JTextArea();
    TextAreaOutputStream taos = new TextAreaOutputStream( ta, 1000 );
    PrintStream ps = new PrintStream( taos );
	

	field fieldPanel;
	
	
//	-----------constructor for normal game--------------
	public baseballGame(JPanel panel){
		
		contentPane = panel;
		
		fieldPanel = new field(contentPane);
		contentPane.add(fieldPanel, "Field");
		
		this.isGameOver = false;
		this.strike = 0;
		this.ball = 0;
		this.out = 0;
		
		frame.add( new JLabel(" Outout" ), BorderLayout.NORTH );
		System.setOut( ps );
	    System.setErr( ps );
	    frame.add( new JScrollPane( ta )  );
	    frame.pack();
	    frame.setVisible( true );
	    frame.setSize(800,600);
	    
	    
		this.t1 = new team("HGU");
		t1.setEntry();
		this.t2 = new team("COM");
		t2.setEntry();
		gameStart();
		

	}
	
	
//	-----------constructor for League--------------
	public baseballGame(JPanel panel, team t1, team t2){
		
		contentPane = panel;
		
		fieldPanel = new field(contentPane);
		contentPane.add(fieldPanel, "Field");

		this.isGameOver = false;
		this.strike = 0;
		this.ball = 0;
		this.out = 0;
		this.t1 = t1;
		this.t1.resetHit();
		this.t2 = t2;
		this.t2.resetHit();
		t2.setEntry();
		gameStart();
		
	}
	
	
//	-----------------function of game start---------------------
	public void gameStart() {
		
		resultList = new ArrayList<String>(36);
		setList();

		this.currentTeam = t1;

		while(true) {
			if(gameFlag == 0) {
				this.plusInning();	//Inning 증

				if(this.isGameOver()) {
					
					fieldPanel.initField(this);
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.show(contentPane, "Field");
					break;
				}
					

				print_attackORbatter(0);
				}
		
		 
		if(gameFlag == 0 || gameFlag == 1) { //gameFlag가 1이라면, 공수교대.

			print_attackORbatter(1);
			}
		
		
		print_attackORbatter(2);

					
		//경우의 수 리스트를 불러온다.
		String result = this.getResultList();
		
		msg1 = result;
		printGameScreen();

			if(result.equals("스트라이크")){
				func_strike();
			}

			else if(result.equals("볼")) {//볼 
				func_ball();
			}
			
			else if(result.equals("1루타"))	{//1루타
				func_single();
			}
			else if(result.equals("2루타"))	{//2루타
	
				func_double();
			}
			else if(result.equals("3루타"))	{//3루타
			
				func_triple();
			}						

			else if(result.equals("홈런"))	{//홈런
				func_homerun();
			}
			else if(result.equals("파울")){
				func_foul();	
			}
			else if(result.equals("아웃")) {
				func_out();
			}
			
			scoreNchangeteam();
			
			
		}
	}
	
	public boolean isGameOver()
	{
		boolean result = false;
		if(this.getInning().equals("9회말"))
		{
			if(t1.getRun() < t2.getRun()) {
				result = true;
				printGameOverScreen();
				t1.result("lose");
				t2.result("win");
			}
		}
		else if(this.getInning().equals("게임끝")){
				result = true;
				printGameOverScreen();
				if(scoreSum[0] < scoreSum[1]) {
					t2.result("win");
					t1.result("lose");
				}else if(scoreSum[0] > scoreSum[1]) {
					t1.result("win");
					t2.result("lose");
				}else {
					t1.result("draw");
					t2.result("draw");
				}
		}
		
		return result;
	}	
	public void exitProgram() {

		printExitScreen();

	}//end exitProgram()
	//Game Print
	
	public void printMenuScreen() {
		System.out.println("==============================");
		System.out.println("|     1. 친선 경기              |");
		System.out.println("|     2. 종료                  |");
		System.out.println("==============================");
	}

	
	public void clearCount(){
		if(out == 3) //
			out = 0;

		ball = 0;
		strike = 0;
	}
	
	public void printGameScreen() { 
		scoreSum[0] = scoreBoard[0][0]+scoreBoard[0][1]+scoreBoard[0][2]+scoreBoard[0][3]+scoreBoard[0][4]+scoreBoard[0][5]+scoreBoard[0][6]+scoreBoard[0][7]+scoreBoard[0][8];
		scoreSum[1] = scoreBoard[1][0]+scoreBoard[1][1]+scoreBoard[1][2]+scoreBoard[1][3]+scoreBoard[1][4]+scoreBoard[1][5]+scoreBoard[1][6]+scoreBoard[1][7]+scoreBoard[1][8];
		System.out.printf("==============================================================\n");
		System.out.printf(" 이닝  |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 |  R |  H |\n");
		System.out.printf("==============================================================\n");
		System.out.printf(" %3s  |%3d |%3d |%3d |%3d |%3d |%3d |%3d |%3d |%3d |%3d |%3d |\n", t1.getTeam(), scoreBoard[0][0],scoreBoard[0][1],scoreBoard[0][2],scoreBoard[0][3],scoreBoard[0][4],scoreBoard[0][5],scoreBoard[0][6],scoreBoard[0][7],scoreBoard[0][8],scoreSum[0],t1.getHits());
		System.out.printf("==============================================================\n");
		System.out.printf(" %3s  |%3d |%3d |%3d |%3d |%3d |%3d |%3d |%3d |%3d |%3d |%3d |\n", t2.getTeam(),scoreBoard[1][0],scoreBoard[1][1],scoreBoard[1][2],scoreBoard[1][3],scoreBoard[1][4],scoreBoard[1][5],scoreBoard[1][6],scoreBoard[1][7],scoreBoard[1][8],scoreSum[1],t2.getHits());
		System.out.printf("   => %s         \r",msg1);
	}//end printGameScreen()
	
	
	//------------------------------------functions about playing---------------------------------------------
	
		public void func_strike() {
			strike++;	

			//2 스트라이크 였으면, 
			if(strike == 3)
			{						
				currentTeam.entryList.get(currentTeam.getBatter()-1).setLocation(-1); //타자를 베이스 밖으로.
				currentTeam.entryList.get(currentTeam.getBatter()-1).so++;//삼진아웃.;
				currentTeam.nextBatter();//타자는 다음 타자로 교체.
				out++; //아웃카운트 증가.
				gameFlag = 1;
				msg1 = "삼진 아웃!";
				if(out == 3)
				{
					gameFlag = 0;
					msg1 = "삼진 아웃! 공수가 교체됩니다.";
				}
				clearCount();//아웃카운트를 초기화.					
			}
			else	//계속 진행.
			{						
				gameFlag = 2;
				
			}
		}
		
		public void func_ball() {
			ball++;
			if(ball == 4) {//볼이 3개 였다면.				
					currentTeam.entryList.get(currentTeam.getBatter()-1).bb++;//4볼
					clearCount();//카운트 초기화.
					int run = this.runBase(currentTeam.entryList, 1); //���� ����
					currentTeam.entryList.get(currentTeam.getBatter()-1).rbi += run;	//득점 증가.
					currentTeam.nextBatter();
					gameFlag = 1;
					msg1 = "볼넷!";
			}
			else {				
				gameFlag = 2;
			}
		}
		
		public void func_single() {
			currentTeam.entryList.get(currentTeam.getBatter()-1).singleH++;
			clearCount();
			int run = this.runBase(currentTeam.entryList, 1); //전체 베이스 개씩 진루.
			currentTeam.entryList.get(currentTeam.getBatter()-1).rbi += run;	//현재 타자의 타점 누적.
			currentTeam.nextBatter();//다음 타자
			gameFlag = 1;
		}
		public void func_double() {
			currentTeam.entryList.get(currentTeam.getBatter()-1).doubleH++;
			clearCount();
			int run = this.runBase(currentTeam.entryList, 2); //전체 베이스 한개씩 진루.
			currentTeam.entryList.get(currentTeam.getBatter()-1).rbi += run;	//현재 타자의 타점 누적.
			currentTeam.nextBatter();//다음 타자
			gameFlag = 1;
		}
		public void func_triple() {
			currentTeam.entryList.get(currentTeam.getBatter()-1).tripleH++;
			clearCount();
			int run = this.runBase(currentTeam.entryList, 3); //전체 베이스 개씩 진루.
			currentTeam.entryList.get(currentTeam.getBatter()-1).rbi += run;	//현재 타자의 타점 누적.
			currentTeam.nextBatter();//다음 타자	
			gameFlag = 1;
		}
		public void func_homerun() {
			currentTeam.entryList.get(currentTeam.getBatter()-1).homerun++;
			clearCount();
			int run = this.runBase(currentTeam.entryList, 4); //전체 베이스 개씩 진루.
			currentTeam.entryList.get(currentTeam.getBatter()-1).rbi += run;	//현재 타자의 타점 누적.
			currentTeam.nextBatter();//다음 타자	
			gameFlag = 1;
		}
		public void func_foul() {
			gameFlag = 2;
			
			//만약 2스트라이크 전이라면.
			if(strike != 2)
				strike++;	
		}
		public void func_out() {
			out++;
			if(out == 3)
			{
				currentTeam.entryList.get(currentTeam.getBatter()-1).setLocation(-1); //아웃.
				currentTeam.nextBatter();
				clearCount();
				gameFlag = 0;
			}
			else
			{
				currentTeam.entryList.get(currentTeam.getBatter()-1).setLocation(-1); 
				currentTeam.nextBatter();
				clearCount();
				gameFlag = 1;
			}
		}
	
	public void plusInning() {
		this.inning++;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	
	
	public void printGameOverScreen() {
		System.out.println("게임이 종료되었습니다.");
		System.out.println("점수는 다음과 같습니다.");
		System.out.printf("%3s : %d\n" , t1.getTeam(), scoreSum[0]);
		System.out.printf("%3s : %d\n" , t2.getTeam(), scoreSum[1]);
	}
	
	public void printExitScreen() {
		System.out.println("게임을 종료니다.");
	}
	
	/*
	 * 구성 : 총 36개의 경우의 수로 이루어져 있다.
	 * 
	 * 각 경우의 수의 확률은  다음과 같다.
	 * 
	 *  x/36으로 계산 하면된다. 
	 * 홈런 : 1 
	 * 3루타 : 1
	 * 2루타 : 3
	 * 안타 : 4
	 * 스트라이트 : 5
	 * 파울 : 5
	 * 볼 : 7
	 * 아웃 : 10
	 * */
	
	public void setList() {

		this.resultList.add("3루타");			
		this.resultList.add("홈런");				

		for(int i=0; i< 2; i++) { this.resultList.add("2루타"); } 

		for(int i=0; i< 5; i++) {			
			this.resultList.add("스트라이크");
			this.resultList.add("파울");		
		}

		for(int i=0; i< 3; i++) { this.resultList.add("1루타"); } 

		for(int i=0; i< 7; i++) { this.resultList.add("볼"); } 

		for(int i=0; i< 30; i++) { this.resultList.add("아웃"); } 
	}//end setList


	// ��� ���ڿ� ��ȯ
	public String getResultList() {
		Random rnd = new Random();
		return this.resultList.get(rnd.nextInt(34));
	}//end getResultList()
	
	
	public int runBase(ArrayList<player> currentList, int baseCount){
		int count=0;	
		for(int i = 0; i < baseCount; i++)
		{
			for(int j = 0; j < currentList.size(); j++)
			{
				if(currentList.get(j).getLocation() != -1)
				{
					currentList.get(j).plusLocation();
				}
				if(currentList.get(j).getLocation() == 4)  //타자가 한 바퀴를 돌았다면.
				{
					currentList.get(j).run++;		
					currentList.get(j).inningRun++;	
					count++;
					currentList.get(j).setLocation(-1);	
				}
			}
		}
		return count;
	}
	
	public String getInning() {
		String result="";
		switch(this.inning) {
			case 1:
				result = "1회초";
				break;
			case 2:
				result = "1회말";
				break;
			case 3:
				result = "2회초";
				break;
			case 4:
				result = "2회말";
				break;
			case 5:
				result = "3회초";
				break;			
			case 6:
				result = "3회말";
				break;
			case 7:
				result = "4회초";
				break;
			case 8:
				result = "4회말";
				break;
			case 9:
				result = "5회초";
				break;
			case 10:
				result = "5회말";
				break;
			case 11:
				result = "6회초";
				break;
			case 12:
				result = "6회말";
				break;
			case 13:
				result = "7회초";
				break;
			case 14:
				result = "7회말";
				break;
			case 15:
				result = "8회초";
				break;
			case 16:
				result = "8회말";
				break;
			case 17:
				result = "9회초";
				break;
			case 18:
				result = "9회말";
				break;
			case 19:
				result = "게임끝";
				break;
				default:
		}//end switch

		return result;
		
	}//end getInning()
	
	public int getScoreBoard(int a, int b) {
		return scoreBoard[a][b];
	}
	
	public team getTeam1() {
		return t1;
	}

	public team getTeam2() {
		return t2;
	}
	
//	---------------------functions about score, changing team, changing attack, batter------------------------------------------------
	
	public void scoreNchangeteam() {
		int	i = currentTeam.team.equals(t1.getTeam()) ? 0 : 1;
		int j = Integer.parseInt(this.getInning().substring(0,1))-1;
		scoreBoard[i][j] = currentTeam.getInningRun();
			
		if(gameFlag == 0) {
			currentTeam.resetInningData();
			currentTeam = (currentTeam.team.equals(t1.getTeam()) ? t2 : t1);
		}
	}
	
	
	public void print_attackORbatter(int a) {
		if (a==0){
			msg1 = currentTeam.entryList.get(0).getTeam()+"팀의 " + this.getInning() + "공격입니다.";
			//FileIO.getInputString();
			printGameScreen();
		}
		else if(a==1) {
			this.msg1 = currentTeam.getBatter() + "번 타자 "+currentTeam.entryList.get(currentTeam.getBatter()-1).getName()+" 타석에 들어섭니다.";
			currentTeam.entryList.get(currentTeam.getBatter()-1).setLocation(0);	
			currentTeam.inningRun=0;		
			printGameScreen();
		}
		else {
			msg1 = "????"+currentTeam.entryList.get(currentTeam.getBatter()-1).getCount() + "????!";
			currentTeam.entryList.get(currentTeam.getBatter()-1).count++;//count++;
		}
			
	}
	//------------------------------------------------------------------------------

}

package baseball;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class arcadeBaseballGame extends baseballGame{
	
//	private team currentTeam = new team();    //현재 팀에 새로운 팀 할당.
//	private int strike;  //스트라이크
//	private int ball; // 볼.
//	private int out; // 아웃
//	
//	private String msg1; //메시지를 담는 변수. 
//	private int gameFlag; //0이 되면 체인지, 1이 되면 

	
	//	-----------constructor for normal game--------------
	public arcadeBaseballGame(JPanel panel){	
		super(panel);
	}

	//---------------------------------Template Hook Method---------------------------------------------
	public void clearCount(){
		if(out == 2) //
			out = 0;
			ball = 0;
			strike = 0;
	}
	public void func_strike() {
		strike++;	

		//2 스트라이크 였으면, 
		if(strike == 5)
		{						
			currentTeam.entryList.get(currentTeam.getBatter()-1).setLocation(-1); //타자를 베이스 밖으로.
			currentTeam.entryList.get(currentTeam.getBatter()-1).so++;//삼진아웃.;
			currentTeam.nextBatter();//타자는 다음 타자로 교체.
			out++; //아웃카운트 증가.
			gameFlag = 1;
			msg1 = "삼진 아웃!";
			if(out == 2)
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
	public void func_foul() {
		gameFlag = 2;
		
		//만약 2스트라이크 전이라면.
		if(strike != 5)
			strike++;	
	}
	public void func_out() {
		out++;
		if(out == 2)
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
	public void func_ball() {
		ball++;
		if(ball == 6) {//볼이 3개 였다면.				
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

}

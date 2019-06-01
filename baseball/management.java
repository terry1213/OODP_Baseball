package baseball;

public class management {
	private Long time;		//시간
	protected String team;		//팀
	private int win;			//승리
	private int draw;			//무승부
	private int lose;			//패배

	protected int count;		//
	private double avg;		//타율 
	protected int singleH;		//1루타
	protected int doubleH;		//2루타
	protected int tripleH;		//3루타
	protected int homerun;		//홈런
	protected int run;			//점수
	protected int inningRun;	//이닝 점수
	protected int rbi;			//타점
	protected int bb;			//볼넷
	int so;			//삼진

	public void setTime(Long time) { this.time = time;	}
	public Long getTime() {	return this.time; }


	public void setTeam(String team) {	this.team = team; }
	public String getTeam() {	return this.team;	}
		
	public void resetH() {
		this.singleH = 0;
		this.doubleH = 0;
		this.tripleH = 0;
		this.homerun = 0;
	}

	public int getCount(){	return this.count+1;	}

	public int getSingleH(){ return this.singleH; }

	public int getDoubleH(){ return this.doubleH; }

	public int getTripleH(){ return this.tripleH; }

	public int getTotalH(){ return this.singleH + this.doubleH + this.tripleH + this.homerun; }

	public int getRun(){ return this.run; }

	public int getRbi(){ return this.rbi; }

	public int getBb(){ return this.bb; }

	public int getSo() { return this.so; }



}

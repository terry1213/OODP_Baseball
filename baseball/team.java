
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class team extends management{
	
	protected boolean isHome;
	
	protected int score;
	protected ArrayList<player> allPlayerList;//모든 선수 명단
	protected ArrayList<player> entryList;//선발 명단
	private int batter = 1;
	private int win = 0;
	private int draw = 0;
	private int lose = 0;
	
	public team() {
		
	}
	
	public team(String team) {
		super.team = team;
		addPlayer();
		this.entryList=new ArrayList<player>();
	}

	public ArrayList<player> getAllEntryList(){
		return this.allPlayerList;
	}
	
	public ArrayList<player> getEntryList(){
		return this.entryList;
	}
	
	public void setFinalEntry(ArrayList<player> entry) {
		this.entryList = entry;
	}
	
	public void setFinalPlayerList(ArrayList<player> playerList) {
		this.allPlayerList = playerList;
	}
	
	
	public void setBatter(int batter)
	{
		this.batter = batter;
	}

	public int getBatter()
	{
		return this.batter;
	}

	public void nextBatter()
	{
		this.entryList.get(batter - 1).count = 0;	//
		batter++;
		if(batter==10)
			batter = 1;
		
		this.entryList.get(batter-1).setLocation(0);
	}
	
	
	public void addPlayer()
	{
		this.allPlayerList = new ArrayList<player>();
		try{
			String teamName = "/Users/seosang-won/eclipse-workspace/oodp_baseball/src/text/" + team + ".txt";
            //파일 객체 생성
            File file = new File(teamName);
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
            	allPlayerList.add(new player(line, team));
            }         
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }

	}
	
	public void setEntry() 
	{
		this.entryList = new ArrayList<player>();
		for(int i = 0; i < 9; i++) {
			entryList.add(this.allPlayerList.get(i));
		}
	}
	
	public String getTeam()
	{
		return super.team;
	}
	
	public int getRun()  //점수 산
	{
		for(int i = 0; i < this.entryList.size(); i++){
			this.run += this.entryList.get(i).run;
		}
		return this.run;
	}

	public int getInningRun() //한 이닝에 난 점수 계
	{
		int total = 0;
		for(int i = 0; i < this.entryList.size(); i++){
			total += this.entryList.get(i).inningRun;
		}
		return total;
	}

	public int getHits() // 타자들의 타수 계산 
	{
		int total=0;
		for(int i = 0; i < this.entryList.size(); i++){
			total += this.entryList.get(i).getTotalH();
		}
		return total;
	}


	public boolean isOnBase(int baseNum)  // 누군가 n번째 베이스에 있는지 없는지. 
	{
		boolean result = false;
		for(player player : this.entryList){
			if(player.getLocation() == baseNum)
				result = true;
		}
		return result;
	}

	public void resetInningData() { // 이닝 데이터를 초기화 함.
		for(player p : this.entryList) {
			p.setLocation(-1);
			p.inningRun=0;
		}
	}
	
	public void result(String str) {
		if(str == "win") {
			win++;
		}else if(str == "lose") {
			lose++;
		}else {
			draw++;
		}
	}
	
	public void resetHit() {
		for(int i = 0; i < this.entryList.size(); i++){
			this.entryList.get(i).resetH();
		}
	}
	
	public int getWin() {
		return win;
	}
	
	public int getDraw() {
		return draw;
	}
	
	public int getLose() {
		return lose;
	}
}

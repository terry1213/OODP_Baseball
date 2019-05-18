
package baseball;
import java.util.*;


public class team extends management{
	protected boolean isHome;
	protected int score;
	protected ArrayList<player> playerList;
	private int batter = 1;
	
	public team() {
		
	}
	
	public team(String team) {
		super.team = team;
		addPlayer();
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
		this.playerList.get(batter - 1).count = 0;	//
		batter++;
		if(batter==10)
			batter = 1;
		
		this.playerList.get(batter-1).setLocation(0);
	}
	
	
	public void addPlayer()
	{
		this.playerList = new ArrayList<player>();
		if(super.team.equals("HGU"))
		{
			playerList.add(new player("Alice", "HGU"));
			playerList.add(new player("Beil", "HGU"));
			playerList.add(new player("Chris", "HGU"));
			playerList.add(new player("Danny", "HGU"));
			playerList.add(new player("Ellen", "HGU"));
			playerList.add(new player("Francis", "HGU"));
			playerList.add(new player("Grace", "HGU"));
			playerList.add(new player("Helen", "HGU"));
			playerList.add(new player("Isabell", "HGU"));
//			playerList.add(new player("�谭��", "3 ��"));
		}
		else
		{
			playerList.add(new player("com1", "COM"));
			playerList.add(new player("com2", "COM"));
			playerList.add(new player("com3", "COM"));
			playerList.add(new player("com4", "COM"));
			playerList.add(new player("com5", "COM"));
			playerList.add(new player("com6", "COM"));
			playerList.add(new player("com7", "COM"));
			playerList.add(new player("com8", "COM"));
			playerList.add(new player("com9", "COM"));
//			playerList.add(new Player("����ȿ", "COM"));
		}
	}
	
	public int getRun()  //점수 산
	{
		for(int i = 0; i < this.playerList.size(); i++){
			this.run += this.playerList.get(i).run;
		}
		return this.run;
	}

	public int getInningRun() //한 이닝에 난 점수 계
	{
		int total = 0;
		for(int i = 0; i < this.playerList.size(); i++){
			total += this.playerList.get(i).inningRun;
		}
		return total;
	}

	public int getHits() // 타자들의 타수 계산 
	{
		int total=0;
		for(int i = 0; i < this.playerList.size(); i++){
			total += this.playerList.get(i).getTotalH();
		}
		return total;
	}


	public boolean isOnBase(int baseNum)  // 누군가 n번째 베이스에 있는지 없는지. 
	{
		boolean result = false;
		for(player player : this.playerList){
			if(player.getLocation() == baseNum)
				result = true;
		}
		return result;
	}

	public void resetInningData() { // 이닝 데이터를 초기화 함.
		for(player p : this.playerList) {
			p.setLocation(-1);
			p.inningRun=0;
		}
	}
}

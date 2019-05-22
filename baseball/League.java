
import java.util.ArrayList;
import java.util.Random;

public class League {
	
	protected int year;
	protected ArrayList<team> teams;
	protected int maxGames;
	protected int curGames;
	private team[] teamArray = new team[10];
	private int round = 0;
	private int[][][] matching = {
			{
				{0, 9}, {1, 8}, {2, 7}, {3, 6}, {4, 5}
			},
			{
				{0, 1}, {9, 5}, {6, 4}, {7, 3}, {8, 2}
			},
			{
				{0, 2}, {1, 9}, {3, 8}, {4, 7}, {5, 6}
			},
			{
				{0, 3}, {9, 6}, {7, 5}, {8, 4}, {1, 2}
			},
			{
				{0, 4}, {2, 9}, {3, 1}, {5, 8}, {6, 7}
			},
			{
				{0, 5}, {9, 7}, {8, 6}, {1, 4}, {2, 3}
			},
			{
				{0, 6}, {3, 9}, {4, 2}, {5, 1}, {7, 8}
			},
			{
				{0, 7}, {9, 8}, {1, 6}, {2, 5}, {3, 4}
			},
			{
				{0, 8}, {4, 9}, {5, 3}, {6, 2}, {7, 1}
			}
	};


	public League() { 
		round = 0;
		teamArray[0] = new team("HGU");
		teamArray[1] = new team("SL");
		teamArray[2] = new team("BD");
		teamArray[3] = new team("KT");
		teamArray[4] = new team("NC");
		teamArray[5] = new team("LG");
		teamArray[6] = new team("SK");
		teamArray[7] = new team("KIA");
		teamArray[8] = new team("HW");
		teamArray[9] = new team("EG");
		
	}
	public team getTeam(int i) {
		return teamArray[matching[round][0][i]];
	}
	
	public team[] getTeamArray() {
		return teamArray;
	}
	
	public void increaseRound() {
		round++;
	}
	
	public void fakeComGame() {
		Random generator = new Random();        
		int ranNum;
		
		for(int i = 1; i < 5; i++) {
			ranNum = generator.nextInt(52);
			if(ranNum < 25) {
				teamArray[matching[round][i][0]].result("win");
				teamArray[matching[round][i][1]].result("lose");
			}else if(ranNum < 50) {
				teamArray[matching[round][i][0]].result("lose");
				teamArray[matching[round][i][1]].result("win");
			}else {
				teamArray[matching[round][i][0]].result("draw");
				teamArray[matching[round][i][1]].result("draw");
			}
		}
	}
	
	public void initLeague() {
		setYear(2019);
		
	}
	
	public void setTeams() {
		
	}
	
	public void setYear(int init_year) {
		year = init_year;
	}

	public String toString() {
		return String.valueOf(year);
	}
}
package baseball;
import java.util.*;

//Batter, pitcher, catcher
public class player extends management{
	
	public static final int HOMEPLATE = 0;
	public static final int FIRSTBASE = 1;
	public static final int SECONDBASE = 2;
	public static final int THIRDBASE = 3;
	public static final int BENCH = -1;
	

	protected String name;
	protected int location;
	
	public player() {
		
	}
	
	public player(String name, String team) {
		this.name = name;
		super.team = team;
		this.location = -1; //처음 플레이어가 생성되면 위치는 -1.
	}

	
	public String getName() {
		return this.name;
	}
	
	
	public int getLocation() {
		return this.location;
	}
	
	public void plusLocation() {
		this.location++;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	
	public void setLocation(int location) {
		this.location = location;
	}
	
}



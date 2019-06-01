package baseball;

public class realPlayer extends player {
	private String name;
	private int location;
	private boolean isNull;
	
	public realPlayer(String name, String team) {
		this.name = name;
		super.team = team;
		this.location = -1; //처음 플레이어가 생성되면 위치는 -1.
		this.isNull = true;
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
	
	public boolean isNil() {
		return isNull;
	}
}

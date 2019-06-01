package baseball;

public class nullPlayer extends player{
	
	private String name;
	private int location;
	private boolean isNull;
	
	public nullPlayer(String name) {
		this.name = name;
		super.team = team;
		this.location = -1; //처음 플레이어가 생성되면 위치는 -1.
		this.isNull = true;
	}

	
	public String getName() {
		return this.name + "는 존재하지 않습니다.";
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
		return this.isNull;
	}

}

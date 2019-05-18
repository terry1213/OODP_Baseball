package baseball;

public class League {
	
	int year;


	public League() { }

	
	public void setYear(int init_year) {
		year = init_year;
	}

	public String toString() {
		return String.valueOf(year);
	}
}

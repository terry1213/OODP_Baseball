package baseball;

import javax.swing.JPanel;

public class realBaseballFactory extends baseballFactory {
	team t1;
	team t2;
	@Override
	public baseballGame createBaseballGame(String name,JPanel panel) {
		switch(name) {
		case "normal" : return new normalBaseballGame(panel);
		case "league" : return new normalBaseballGame(panel,t1,t2);
		case "arcade" : return new arcadeBaseballGame(panel);
		}
		return null;
	}

}

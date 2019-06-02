package baseball;

import javax.swing.JPanel;

public abstract class baseballFactory {
	abstract baseballGame createBaseballGame(String name,JPanel panel);
}

package baseball;

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
	
	private JPanel contentPane = new JPanel();
	
	private MainMenu mainPanel;
	private MainMenu2 mainPanel2 ;
	private LeagueMenu leaguePanel;

	private static GameWindow gamewindowObject;
	
	public static GameWindow getInstance() {

		// 아직 인스턴스가 생성된적이 없음 = 존재하지 않음
        if(gamewindowObject== null) {
             
            // 인스턴스 생성. 생성자가 private이니까 클래스 내부에서는 가능.
            gamewindowObject = new GameWindow();
        }
        return gamewindowObject;

	}
	
	
	private GameWindow() {
		
		mainPanel= new MainMenu(contentPane);
		mainPanel2 = new MainMenu2(contentPane);
		leaguePanel = new LeagueMenu(contentPane);
		
		contentPane.setLayout(new CardLayout());
		contentPane.add(mainPanel, "Main1");
		contentPane.add(mainPanel2, "Main2");
		contentPane.add(leaguePanel, "League");
		
		
	
		setTitle("Baseball game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 600); // 프레임 크기 500X600 설정
		setPreferredSize(new Dimension(500,600));
		getContentPane().add(contentPane);
		
		pack();
		
		setVisible(true); // 화면에 프레임 출력
	}
	


}

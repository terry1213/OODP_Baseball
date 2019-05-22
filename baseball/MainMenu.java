
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MainMenu extends Menu implements ActionListener{
	
	
	
	private JPanel contentPane;
	
	JButton startBt = new JButton("게임 시작");
	JButton	exitBt = new JButton("종료");
	JLabel lblBaseballManager_1 = new JLabel("Baseball Manager 2019");
	
	
	public MainMenu(JPanel panel) {
		
		
		super.setBackground();
		this.decoratePanel();
		
		contentPane=panel;
		
		
}
	
	@Override
	public void decoratePanel() {
		
		//게임 시작 버튼 생성
		
		startBt.setSize(100, 40);
		startBt.setLocation(200, 300);
		startBt.addActionListener(this);
		//게임 종료 버튼 생성
		
		exitBt.setSize(100, 40);
		exitBt.setLocation(200, 400);
		
		// 게임 이름 Label 
	
		lblBaseballManager_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaseballManager_1.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		bg.add(lblBaseballManager_1);
		lblBaseballManager_1.setBounds(129, 115, 248, 85);
		
		bg.add(startBt); // 게임시작  버튼 달기
		bg.add(exitBt);
		
		add(bg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//액션 리스너 재정의
				if (e.getSource().equals(this.startBt))
				{
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Main2");
				}
				else if(e.getSource().equals(this.exitBt))
				{
					JOptionPane.showMessageDialog(this, "종료");
				}
	}
	


	
	
	
}

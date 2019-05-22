

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


public class MainMenu2 extends Menu implements ActionListener{
	
	private JPanel contentPane;
	
	JButton	normalGBt = new JButton("친선전");
	JButton	leagueGBt = new JButton("리그");
	JButton arcadeGBt = new JButton("아케이드");
	JButton	backBt = new JButton("뒤로");
	baseballGame game;
	
	public MainMenu2(JPanel panel) {
		
		
		
		setBackground();
		decoratePanel();
		contentPane=panel;
	}
	
	@Override
	public void decoratePanel() {
		
		//移쒖꽑 寃쎄린 踰꾪듉 �깮�꽦
		normalGBt.setSize(100, 40);
		normalGBt.setLocation(200, 200);
		normalGBt.addActionListener(this);
		bg.add(normalGBt); 
		
		
		//移쒖꽑 寃쎄린 踰꾪듉 �깮�꽦
		leagueGBt.setSize(100, 40);
		leagueGBt.setLocation(200, 250);
		leagueGBt.addActionListener(this);
		bg.add(leagueGBt); 
		
		//移쒖꽑 寃쎄린 踰꾪듉 �깮�꽦
		arcadeGBt.setSize(100, 40);
		arcadeGBt.setLocation(200, 300);
		arcadeGBt.addActionListener(this);
		bg.add(arcadeGBt); 
		
		//移쒖꽑 寃쎄린 踰꾪듉 �깮�꽦
		backBt.setSize(100, 40);
		backBt.setLocation(200, 350);
		backBt.addActionListener(this);
		bg.add(backBt); 
		// 寃뚯엫�떆�옉  踰꾪듉 �떖湲�
		add(bg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�븸�뀡 由ъ뒪�꼫 �옱�젙�쓽
				if (e.getSource().equals(this.normalGBt))
				{	
					baseballGame game = new baseballGame(contentPane);
	                
				}
				else if(e.getSource().equals(this.leagueGBt))
				{
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "League");	
				}
				else if(e.getSource().equals(this.arcadeGBt))
				{
					JOptionPane.showMessageDialog(this, "아케이드 모드");
				}
				else if(e.getSource().equals(this.backBt))
				{
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Main1");
				}
	}

	
	
	
	
}

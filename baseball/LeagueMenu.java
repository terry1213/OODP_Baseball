
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LeagueMenu extends Menu implements ActionListener{

	private JPanel contentPane;
	
	JButton	proceedGBt = new JButton("경기 진행");
	JButton	entryBt = new JButton("엔트리");
	JButton	backBt = new JButton("뒤로");
	JButton	rankingBt = new JButton("순위표");
	
	League nLeague;
	
	public LeagueMenu(JPanel panel) {
		nLeague = new League();
		setBackground();
		decoratePanel();
		contentPane=panel;
	}
	
	@Override
	public void decoratePanel() {
		
		//add proceed button
		proceedGBt.setSize(100, 40);
		proceedGBt.setLocation(200, 200);
		proceedGBt.addActionListener(this);
		bg.add(proceedGBt); 
		
		
		//add entry button
		entryBt.setSize(100, 40);
		entryBt.setLocation(200, 300);
		entryBt.addActionListener(this);
		bg.add(entryBt); 
		
		//add ranking button
		rankingBt.setSize(100, 40);
		rankingBt.setLocation(200, 400);
		rankingBt.addActionListener(this);
		bg.add(rankingBt); 
		
		//add back button
		backBt.setSize(100, 40);
		backBt.setLocation(200, 500);
		backBt.addActionListener(this);
		bg.add(backBt); 

		
		// Add all buttons to background
		add(bg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

				if (e.getSource().equals(this.proceedGBt))
				{	
					baseballGame game = new baseballGame(contentPane, nLeague.getTeam(0), nLeague.getTeam(1));
					nLeague.fakeComGame();
					nLeague.increaseRound();
				}
				else if(e.getSource().equals(this.entryBt))
				{
					EntryPanel entry = new EntryPanel(contentPane, nLeague.getTeam(0));
					contentPane.add(entry, "Entry");
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Entry");
				}

				else if(e.getSource().equals(this.backBt))
				{
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Main2");
				}
				else if(e.getSource().equals(this.rankingBt))
				{
					RankingList ranking = new RankingList(contentPane, nLeague.getTeamArray());
					
					contentPane.add(ranking, "Ranking");
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Ranking");
				}
}
}

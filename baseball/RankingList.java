
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class RankingList extends JPanel implements ActionListener{


	
	private JPanel contentPane;
	private JPanel contentPane2;
	private JPanel contentPane3;
 	private Label baseLabel;
 	private Label stateLabel;
    private Label rankLabel1;
    private Label rankLabel2;
    private Label rankLabel3;
    private Label rankLabel4;
    private Label rankLabel5;
    private Label rankLabel6;
    private Label rankLabel7;
    private Label rankLabel8;
    private Label rankLabel9;
    private Label rankLabel10;
	JButton btnBack = new JButton("뒤로가기");
	private team[] sortedTeam = new team[10];;
	
	public RankingList(JPanel panel, League nLeague) {
		
		contentPane3 = panel;
		String buffer;
		
		contentPane = new JPanel();
		btnBack.setSize(100, 40);
		btnBack.setLocation(200, 500);
		btnBack.addActionListener(this);
		contentPane.add(btnBack);
		add(contentPane);
		
    	contentPane2 = new JPanel();
        contentPane2.setLayout(null);
        contentPane2.setBackground(Color.black);
        contentPane2.setPreferredSize(new Dimension(500, 300));
        
        stateLabel = new Label();
        stateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        stateLabel.setText(nLeague.getLeagueState().printMessage());
        stateLabel.setForeground(Color.white);
        stateLabel.setLocation(210, 5);
        stateLabel.setSize(400, 25);
        contentPane2.add(stateLabel);
        
        sortingTeam(nLeague.getTeamArray());
        
        baseLabel = new Label();
        baseLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
        baseLabel.setText("Lank  Team    win    draw  lose");
        baseLabel.setForeground(Color.white);
        
        rankLabel1 = new Label();
        rankLabel1.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "1       " + sortedTeam[0].team + "      " + sortedTeam[0].getWin() +"       " + sortedTeam[0].getDraw() + "       " + sortedTeam[0].getLose();
        rankLabel1.setText(buffer);
        rankLabel1.setForeground(Color.white);
        
        rankLabel2 = new Label();
        rankLabel2.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "2       " + sortedTeam[1].team + "      " + sortedTeam[1].getWin() +"       " + sortedTeam[1].getDraw() + "       " + sortedTeam[1].getLose();
        rankLabel2.setText(buffer);
        rankLabel2.setForeground(Color.white);
        
        rankLabel3 = new Label();
        rankLabel3.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "3       " + sortedTeam[2].team + "      " + sortedTeam[2].getWin() +"       " + sortedTeam[2].getDraw() + "       " + sortedTeam[2].getLose();
        rankLabel3.setText(buffer);
        rankLabel3.setForeground(Color.white);
        
        rankLabel4 = new Label();
        rankLabel4.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "4       " + sortedTeam[3].team + "      " + sortedTeam[3].getWin() +"       " + sortedTeam[3].getDraw() + "       " + sortedTeam[3].getLose();
        rankLabel4.setText(buffer);
        rankLabel4.setForeground(Color.white);
        
        rankLabel5 = new Label();
        rankLabel5.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "5       " + sortedTeam[4].team + "      " + sortedTeam[4].getWin() +"       " + sortedTeam[4].getDraw() + "       " + sortedTeam[4].getLose();
        rankLabel5.setText(buffer);
        rankLabel5.setForeground(Color.white);
        
        rankLabel6 = new Label();
        rankLabel6.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "6       " + sortedTeam[5].team + "      " + sortedTeam[5].getWin() +"       " + sortedTeam[5].getDraw() + "       " + sortedTeam[5].getLose();
        rankLabel6.setText(buffer);
        rankLabel6.setForeground(Color.white);
        
        rankLabel7 = new Label();
        rankLabel7.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "7       " + sortedTeam[6].team + "      " + sortedTeam[6].getWin() +"       " + sortedTeam[6].getDraw() + "       " + sortedTeam[6].getLose();
        rankLabel7.setText(buffer);
        rankLabel7.setForeground(Color.white);
        
        rankLabel8 = new Label();
        rankLabel8.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "8       " + sortedTeam[7].team + "      " + sortedTeam[7].getWin() +"       " + sortedTeam[7].getDraw() + "       " + sortedTeam[7].getLose();
        rankLabel8.setText(buffer);
        rankLabel8.setForeground(Color.white);
        
        rankLabel9 = new Label();
        rankLabel9.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "9       " + sortedTeam[8].team + "      " + sortedTeam[8].getWin() +"       " + sortedTeam[8].getDraw() + "       " + sortedTeam[8].getLose();
        rankLabel9.setText(buffer);
        rankLabel9.setForeground(Color.white);
        
        rankLabel10 = new Label();
        rankLabel10.setFont(new Font("Dialog", Font.PLAIN, 18));
        buffer = "10     " + sortedTeam[9].team + "      " + sortedTeam[9].getWin() +"       " + sortedTeam[9].getDraw() + "       " + sortedTeam[9].getLose();
        rankLabel10.setText(buffer);
        rankLabel10.setForeground(Color.white);
        
        baseLabel.setLocation(130, 25);
        rankLabel1.setLocation(130, 50);
        rankLabel2.setLocation(130, 75);
        rankLabel3.setLocation(130, 100);
        rankLabel4.setLocation(130, 125);
        rankLabel5.setLocation(130, 150);
        rankLabel6.setLocation(130, 175);
        rankLabel7.setLocation(130, 200);
        rankLabel8.setLocation(130, 225);
        rankLabel9.setLocation(130, 250);
        rankLabel10.setLocation(130, 275);
        
        baseLabel.setSize(400, 25);
        rankLabel1.setSize(400, 25);
        rankLabel2.setSize(400, 25);
        rankLabel3.setSize(400, 25);
        rankLabel4.setSize(400, 25);
        rankLabel5.setSize(400, 25);
        rankLabel6.setSize(400, 25);
        rankLabel7.setSize(400, 25);
        rankLabel8.setSize(400, 25);
        rankLabel9.setSize(400, 25);
        rankLabel10.setSize(400, 25);
        
        contentPane2.add(baseLabel);
        contentPane2.add(rankLabel1);
        contentPane2.add(rankLabel2);
        contentPane2.add(rankLabel3);
        contentPane2.add(rankLabel4);
        contentPane2.add(rankLabel5);
        contentPane2.add(rankLabel6);
        contentPane2.add(rankLabel7);
        contentPane2.add(rankLabel8);
        contentPane2.add(rankLabel9);
        contentPane2.add(rankLabel10);
        
		add(contentPane2);
        
        
        
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.btnBack))
		{
			
			CardLayout cardLayout = (CardLayout) contentPane3.getLayout();
            cardLayout.show(contentPane3, "League");	
			
			
		}
	}
	
	public void sortingTeam(team[] bfSorting) {
		sortedTeam = Arrays.copyOf(bfSorting, 10);
		team temTeam;
		for(int i = 1; i < 10; i++) {
			temTeam = sortedTeam[i];
			for(int j = i - 1;  j > -1; j--) {
				if(sortedTeam[j].getWin() >= temTeam.getWin()) {
					sortedTeam[j + 1] = temTeam;
					break;
				}else {
					sortedTeam[j + 1] = sortedTeam[j];
					if(j == 0) {
						sortedTeam[j] = temTeam; 
					}
				}
			}
		}
	}
	
	
	
	
	
	
}

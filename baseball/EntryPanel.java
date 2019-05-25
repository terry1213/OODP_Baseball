

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EntryPanel extends JPanel implements ActionListener{
	
	JButton goR = new JButton("->");
	JButton goL = new JButton("<-");
	JButton btnCompelete = new JButton("Compelete");
	
	ArrayList<player> fnWholeEntry;
	
	ArrayList<String> wholePlayers;
	ArrayList<String> entry;
	
	JList playerList;
	JList entryList;
	
	team t;
	
	private JPanel contentPane;
	
public EntryPanel(JPanel panel, team team1) {
		
		//Size of this panel
		setBounds(0, 0, 306, 248);
        setLayout(null);
        t= team1;
        
         initPanel();
		contentPane=panel;
}

public void initPanel() {
	
    
  
	
    btnCompelete.setBounds(100, 186, 117, 29);
    btnCompelete.addActionListener(this);
    goR.setLocation(117, 52);
    goR.setSize(75, 29);
	goR.addActionListener(this);
	
	//add go Left button
	goL.setSize(75, 29);
	goL.setLocation(117, 93);
	goL.addActionListener(this);
	
	this.add(btnCompelete);
    this.add(goR);
    this.add(goL);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(20, 20, 75, 144);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(205, 20, 75, 144);
    entryList= new JList();
    entryList.setModel(new DefaultListModel());
    
     playerList= new JList();
     playerList.setModel(new DefaultListModel());
	
    
	//Assign new Arraylist.
	wholePlayers = new ArrayList<String>();
	entry = new ArrayList<String>();
	
	
	//Assign player names into Arraylist.
	
	for(player p1 : t.getAllEntryList()) {
		wholePlayers.add(p1.getName());
	}
	
	Iterator it = t.iterator();
	while(it.hasNext()) {
		player p = (player)it.next();
		entry.add(p.getName());
	}
//	for(player p2 : t.getEntryList()) {
//		entry.add(p2.getName());
//	}
	
	for (String element : wholePlayers) {
	   ((DefaultListModel) playerList.getModel()).addElement(element);
	}

	for (String element : entry) {
	   ((DefaultListModel) entryList.getModel()).addElement(element);
	}
	    
	    scrollPane_1.setViewportView(playerList);
	    scrollPane.setViewportView(entryList);
	    this.add(scrollPane);
	    this.add(scrollPane_1);
	    
	    
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//액션 리스너 재정의
			if (e.getSource().equals(this.goR))
			{
				 int index = playerList.getSelectedIndex();
				 String s = (String) playerList.getSelectedValue();
				 removeActionPerformed(playerList, index, e);
				 addActionPerformed(entryList, s, e);
				 
			}
			else if(e.getSource().equals(this.goL))
			{
				int index = entryList.getSelectedIndex();
				 String s = (String) entryList.getSelectedValue();
				 removeActionPerformed(entryList, index, e);
				 addActionPerformed(playerList, s, e);
			}
			else if(e.getSource().equals(this.btnCompelete))
			{
				
				wholePlayers = setJListToArrayList(playerList, wholePlayers);
				entry = setJListToArrayList(entryList, entry);
				
				t.setFinalEntry(this.setFinalEntry());
				t.setFinalPlayerList(this.setFinalPlayerList());
				
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "League");	
				
				
			}
			
		
}

private void removeActionPerformed(JList list, int index, ActionEvent e) {

    DefaultListModel model = (DefaultListModel) list.getModel();
    if (model.size() > 0) {
      model.remove(index);
    }
  }

private void addActionPerformed(JList list,String player, ActionEvent e) {

    DefaultListModel model = (DefaultListModel) list.getModel();
    if (model.size() < 12) {
      model.addElement(player);
    }
  }

public ArrayList<String> setJListToArrayList(JList list, ArrayList<String> arrList) {
	arrList = new ArrayList(list.getModel().getSize());
	for (int i = 0; i < list.getModel().getSize(); i++) {
	    arrList.add((String) list.getModel().getElementAt(i));
	}
	
	return arrList;
	
}

public ArrayList<player> setFinalEntry(){
	
	ArrayList<player> finalEntry = new ArrayList<player>();
	
	for(String playerName : this.entry) {
		finalEntry.add(new player(playerName,t.getTeam()));
	}
	return finalEntry;
}

public ArrayList<player> setFinalPlayerList(){
	
	ArrayList<player> playerList = new ArrayList<player>();
	
	for(String playerName : this.wholePlayers) {
		playerList.add(new player(playerName,t.getTeam()));
	}
	return playerList;
}
}




	



import javax.media.*;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class audioplay extends JFrame implements ActionListener
{
	public JPanel mainpanel, bottompanel;
	public JButton playb;
	public JButton pauseb;
	public JButton frwdb;
	public JButton backb;
	public File f;
	public int a=1,z=0;
	
	
	public Player p;
	
	public audioplay()
	{
				setBounds(700,150,250,300);
				setTitle("BCZplayer");
				getContentPane().setBackground(Color.YELLOW);
				
				mainpanel		= 	new JPanel();
				bottompanel	=	new JPanel();
				playb				=	new JButton("I>");
				frwdb				=	new JButton(">>");
				backb				=	new JButton("<<");

				// playb.setBounds(0,0,10,20);
				mainpanel.setLayout(new BorderLayout());
			//	bottompanel.setLayout(new BorderLayout());
				
				bottompanel.add(backb);
				bottompanel.add(playb);
			//	bottompanel.add(pauseb);
				bottompanel.add(frwdb);
			
			//***************************************EPIC CSS STARTS HERE*****************************
				
				playb.setBackground(Color.BLUE);
				playb.setContentAreaFilled(true);
                playb.setOpaque(true);
				
				//frwdb.setBackground(Color.BLUE);	
				//frwd.setContentAreaFilled(true);				
				//backb.setBackground(Color.BLUE);
			
			//***********************************************ENDS HERE*************************************		
			

				backb.addActionListener(this);
				playb.addActionListener(this);
			//	pauseb.addActionListener(this);
				frwdb.addActionListener(this);
				
				mainpanel.add(bottompanel,BorderLayout.SOUTH);
				
				
				getContentPane().setLayout(new BorderLayout());
				getContentPane().add(mainpanel,BorderLayout.CENTER);
				 f=new File("bang.mp3");
	}
	
		  public void actionPerformed(ActionEvent e){
					
					try{
					if(a==1){
					
					 p=Manager.createRealizedPlayer(f.toURI().toURL());
					 a=0;
					 }
					}		
					catch(Exception ex){System.out.println(ex);}
					if(z==0)
					{
							if(e.getSource()==playb){
									p.start();
									playb.setText("||");
									z=1;
								}
					}
					else if(z==1){
						p.stop();
						playb.setText("I>");
						z=0;
					}
						
		  }


	public static void main(String args[] ){
		audioplay a=new audioplay();
		a.setVisible(true);
	}
} 







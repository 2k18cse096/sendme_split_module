package com.sendme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Main extends Thread
{
//Authors selvaraji and snega.
	static String filename,path,ip,iptemp,ipa;
	static boolean conected=false;
	static long length,sending;
	static JFrame frame;
	static JMenu help;
	static JMenuBar menu;
	static JMenuItem how, mainmenu;
	static JButton b1, b2, b3,background;
	static JLabel la1,la2,pic;
	static JTextField tx;
	static DefaultBoundedRangeModel model = new DefaultBoundedRangeModel();
	static JProgressBar pro;
	static URL url = Main.class.getResource("/assest/help.jpg");
	static Icon icon = new ImageIcon(url);
	
	public static void main (String[] args)throws IOException {
		

		
		frame = new JFrame("SENDME");
		tx =new JTextField();
		la1 = new JLabel("label");
		la2 = new JLabel("info");
		menu = new JMenuBar();
		help = new JMenu("HELP");
		how = new JMenuItem("HOW TO USE");
		b1 = new JButton("SEND");
		b2 = new JButton("RECEIVE");
		background = new JButton(icon);
		background.setRolloverIcon(icon);
		background.setVisible(false);
		mainmenu = new JMenuItem("MAIN MENU");
		mainmenu.setVisible(false);
		b3 = new JButton("EXIT");
		pro = new JProgressBar(model);
		
		
		
		help.add(how);
		help.add(mainmenu);
		menu.add(help);
		
		b1.setBounds(175, 50, 150, 30);
		b1.setFocusable(false);
		b2.setBounds(175, 90, 150, 30);
		b2.setFocusable(false);
		b3.setBounds(175, 130, 150, 30);
		b3.setFocusable(false);
		background.setBounds(0, 0, 480, 220);
		tx.setBounds(175, 170, 150, 30);
		la1.setBounds(175,200, 300,30);
		la2.setBounds(175,200, 300,30);
		pro.setValue(0);
		pro.setStringPainted(true);
		pro.setBounds(175, 90, 150, 30);
		
		
		
		b1.addActionListener(e ->
		{	
			Send send = new Send();
			ip= tx.getText();
			send.connect(ip);
			
		});
		
		
		
		b2.addActionListener(e ->
		{      
			Receive rec = new Receive();
			b2.setVisible(false);
			rec.receive();
		});
		
		
		
		b3.addActionListener(e ->
		{
			frame.dispose();
		});
		
		
		
		how.addActionListener(e -> 
		{
				how.setVisible(false);
				mainmenu.setVisible(true);
				background.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
				la1.setVisible(false);
				la2.setVisible(false);
				tx.setVisible(false);
				pro.setVisible(false);
			
		});
		mainmenu.addActionListener(e ->
		{
			mainmenu.setVisible(false);
			background.setVisible(false);
			how.setVisible(true);
			b1.setVisible(true);
			b2.setVisible(true);
			b3.setVisible(true);
			la1.setVisible(true);
			la2.setVisible(true);
			tx.setVisible(true);
			pro.setVisible(true);
			
		});
		
		ip = ipad();
		int i= 0;
		while(ip.length()!=i)
		{
			if(ip.charAt(i)=='/')
			{
				iptemp = ip.substring(i+1,ip.length());
				break;
			}
			i++;
			
		}
		
		la1.setText(iptemp);
		System.out.println(ip);
		la2.setText("");

		
		
		frame.add(menu);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(tx);
		frame.add(la2);
		frame.add(la1);
		frame.add(pro);
		frame.add(background);
		frame.setJMenuBar(menu);
		frame.setSize(500, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static String ipad()throws IOException
		{
			InetAddress ipaddress;
			ipaddress = InetAddress.getLocalHost();
			ip=ipaddress.toString();
			return ip;
		}
}
		
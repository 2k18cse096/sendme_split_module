package com.sendme;

public class Send extends Main{
	
	
	public  void connect(String ipa)
	{

		Send_Thread t = new Send_Thread();
		Thread t1 = new Thread(t);
		la2.setText("");
		t1.start();
	
	}
}

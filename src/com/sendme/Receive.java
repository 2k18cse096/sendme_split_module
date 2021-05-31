package com.sendme;

public class Receive extends Main {
	
	public  void receive()
	{
		
		Receive_Thread t = new Receive_Thread();
		Thread t2 = new Thread(t);
		t2.start();
		
	}
}

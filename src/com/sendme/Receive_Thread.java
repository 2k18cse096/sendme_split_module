package com.sendme;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive_Thread extends Receive{
	
	public void run()
	{
		try {
			ServerSocket serversocket= new ServerSocket(4445);
			Socket socket = serversocket.accept();


			InputStream in = socket.getInputStream();
			String output;
			
			DataInputStream din = new DataInputStream(in);
			output = din.readUTF();
			
			DataInputStream din2 = new DataInputStream(in);
			String len =din2.readUTF();
			
			String  outp ="C:\\Sendme\\received\\"+output;
			File file = new File("C:\\Sendme\\received\\");
			if(!file.exists())
			{
				file.mkdirs();
			}

			OutputStream out = new FileOutputStream(outp);
			byte[] bytes = new byte[32*1024];//32768
			int count;
			long temp=0;
			long length =Long.parseLong(len);
			
			while((count = in.read(bytes)) > 0)
			{
				out.write(bytes , 0, count);
				sending +=32768;
				temp =(sending *100)/length;
				pro.setValue(((int)temp));
			}
			pro.setValue(0);
			out.close();
			in.close();
			socket.close();
			serversocket.close();
			din.close();
			din2.close();
			b2.setVisible(true);
			}
			catch(IOException e)
			{
			e.printStackTrace();
			}

}
}

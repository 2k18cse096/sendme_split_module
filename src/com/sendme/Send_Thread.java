package com.sendme;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Send_Thread extends Send {
	
	public void run() 
	{
		pro.setBounds(175, 50, 150, 30);
		try {
			path =File_chooser.fileCho();

			File file = new File(path); 
			length = file.length();

			filename=file.getName();
			
			Socket socket = new Socket(InetAddress.getByName(ip), 4445);
			byte[] bytes = new byte[32*1024];	
			InputStream in = new FileInputStream(file);
			OutputStream out = socket.getOutputStream();
			int count ;
			DataOutputStream stream = new DataOutputStream(out);
			stream.writeUTF(filename);
			
			DataOutputStream stream1 = new DataOutputStream(out);
			String len =Long.toString(length);
			stream1.writeUTF(len);
			
			sending =0;
			long temp;
			while((count =in.read(bytes)) >0)
			{
				sending +=32768;
				temp =(sending *100)/length;
				pro.setValue((int)temp);
				out.write(bytes, 0, count);
			}
			System.out.println("completed");
			out.close();
			b1.setVisible(true);
			in.close();
			socket.close();
			stream.close();
			}
			catch(Exception e)
			{
				la1.setVisible(false);
				la2.setText("Receiver not found!!!");
				e.printStackTrace();
			} 
		
			}

}

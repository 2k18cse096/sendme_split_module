package com.sendme;

import java.io.IOException;

import javax.swing.JFileChooser;

public class File_chooser extends Main {
	public static String fileCho()throws IOException
	{
	JFileChooser file = new JFileChooser();
    file.setMultiSelectionEnabled(true);
    file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    file.setFileHidingEnabled(false);
    if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
      java.io.File fi = file.getSelectedFile();
      path = fi.getPath();
     }
    System.out.print(path+"\n");	
    if(path==null)
    {
    	path=fileCho();
    }
	return path;

}
}

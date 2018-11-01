
package ass1;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.PrintWriter;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
public class Terminal{
public Terminal(){};

public void cp(String sourcePath, String destinationPath )throws Exception
{
		InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(sourcePath);
	        os = new FileOutputStream(destinationPath);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
}
/*public void mv(String sourcePath, String destinationPath)
{
	File file = new File(sourcePath);
    File newFile = new File(destinationPath);
    if(file.renameTo(newFile)){
        System.out.println("File move success");;
    }else{
        System.out.println("File move failed");
    }
}*/
public void rm(String sourcePath)
{
	File dir = new File(sourcePath);
	dir.delete();
}
public void mv(String sourcePath, String destinationPath) throws IOException
{
	InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(sourcePath);
        os = new FileOutputStream(destinationPath);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        Terminal obj = new Terminal();
        obj.rm(sourcePath);
        os.close();
    }
}
public void mkdir(String folder)
{
	 File file = new File(folder);
     if (!file.exists()) {
         if (file.mkdir()) {
             System.out.println("Directory is created!");
         } else {
             System.out.println("Failed to create directory!");
         }
}
}
public void rmdir(String folder)
{
	File file = new File(folder);
    if (file.exists()) 
    {
    	file.delete();
    }
    else
    	System.out.println("Not Found!");
}
public void date()
{
	java.util.Date date=new java.util.Date();  
	System.out.println(date);
}
public void pwd()
{
	 String pwd = System.getProperty("user.dir");
     System.out.println(pwd);
	
}
public void clear()
{
	for(int i=0;i<=50;i++)
		System.out.println("\n");
}
public void ls()
{
	 File dir = new File(System.getProperty("user.dir"));
     String childs[] = dir.list();
     for(String child: childs){
         System.out.println(child);
        }
}
public void cd(String folder)
{
            File dir = new File(folder);
            if(dir.isDirectory()==true) {
                System.setProperty("user.dir", dir.getAbsolutePath());
            } else {
                System.out.println( "is not a directory.");
            }
 }
public void cd()
{
            File dir = new File("c:\\");
            if(dir.isDirectory()==true) {
                System.setProperty("user.dir", dir.getAbsolutePath());
            } else {
                System.out.println( "is not a directory.");
            }
 }
public void cat(String file1,String file2) throws IOException
{
	//file1  file2
			StringBuilder sb=new StringBuilder();
			
			// PrintWriter object for file3.txt 
	        PrintWriter pw = new PrintWriter("file3.txt"); 
	          
	        // BufferedReader object for file1.txt 
	        BufferedReader br = new BufferedReader(new FileReader(file1)); 
	          
	        String line = br.readLine(); 
	          
	        // loop to copy each line of  
	        // file1.txt to  file3.txt 
	        while (line != null) 
	        { 
	        	sb.append(line);
	        	pw.println(line); 
	            line = br.readLine();
	            //sb.append(line);
	        } 
	        
	          
	        br = new BufferedReader(new FileReader(file2)); 
	          
	        line = br.readLine(); 
	          
	        // loop to copy each line of  
	        // file2.txt to  file3.txt 
	        while(line != null) 
	        { 
	        	sb.append(line);
	        	pw.println(line); 
	            line = br.readLine(); 
	            //sb.append(line);
	        } 
	          
	        String TheResult=sb.toString();
	        
	        System.out.println(TheResult);
	        pw.flush();      
	        // closing resources 
	        br.close(); 
	        pw.close(); 
	                    
	        //file1.txt
	        //file2.txt
}
void cat(String file1) throws IOException
{
	StringBuilder sb=new StringBuilder();
	
	// PrintWriter object for file3.txt 
    PrintWriter pw = new PrintWriter("file3.txt"); 
      
    // BufferedReader object for file1.txt 
    BufferedReader br = new BufferedReader(new FileReader(file1)); 
      
    String line = br.readLine(); 
      
    // loop to copy each line of  
    // file1.txt to  file3.txt 
    while (line != null) 
    { 
    	sb.append(line);
    	pw.println(line); 
        line = br.readLine();
        //sb.append(line);
    } 
    
    String TheResult=sb.toString();
   
    	System.out.println(TheResult);
    	br.close(); 
        pw.close();
    
}
public void exit()
{
	System.exit(0);
}
public void args(String cmd)
{
	String[] with1args={"","cat","rm","cd","mkdir","rmdir","more","args"};
	String[] with2args={"cp","mv","cat"};
	String[] noargs={"ls","clear","date","help","cd","pwd","exit"};
	for(int i=0;i<noargs.length+1;++i)
		if(cmd.equals(with1args[i]))
			System.out.println("1");
	for(int i=0;i<with2args.length;++i)
		if(cmd.equals(with2args[i]))
			System.out.println("2");
	for(int i=0;i<noargs.length;++i)
		if(cmd.equals(noargs[i]))
			System.out.println("0");
}
public void help()
{
	ArrayList<String>cmds=new ArrayList<String>();
	cmds.add("args : List all command arguments");
	cmds.add("date : Current date/time");
	cmds.add("clear : clear the screen");
	cmds.add("cd : This command changes the current directory to another one");
	cmds.add("ls : These programs list each given file or directory name. "
			+ "\n     Directory contents are sorted alphabetically. For ls, files are by default listed in columns, sorted vertically, if the standard output is a terminal; "
			+ "\n     otherwise, they are listed one per line.");
	cmds.add("cp : If the last argument names an existing directory, cp copies each other given file into a file with the same name in that directory. "
			+ "\n     Otherwise, if only two files are given, it copies the first onto the second. "
			+ "\n     It is an error if the last argument is not a directory and more than two files are given. "
			+ "\n     By default, it does not copy directories.");
	cmds.add("mv : If the last argument names an existing directory, mv moves each other given file into a file with the same name in that directory. "
			+ "\n     Otherwise, if only two files are given, it moves the first onto the second. "
			+ "\n     It is an error if the last argument is not a directory and more than two files are given. "
			+ "\n     It can move only regular files across file systems. If a destination file is unwritable, the standard input is a tty, and the f or"
			+ "\n     --force option is not given, mv prompts the user for whether to overwrite the file. If the response does not begin with y or Y, the file is skipped.");
	cmds.add("rm : rm removes each specified file. By default, it does not remove directories. "
			+ "\n     If a file is unwritable, the standard input is a tty, and the -f or --force option is not given, rm prompts the user for whether to remove the file. "
			+ "\n     If the response does not begin with y or Y, the file is skipped.");
	cmds.add("mkdir : mkdir creates a directory with each given name. By default, the mode of created directories is 0777 minus the bits set in the umask.");
	cmds.add("rmdir : rmdir removes each given empty directory. If any nonoption argument does not refer to an existing empty directory, it is an error.");
	cmds.add("cat : Concatenate files and print on the standard output.");
	cmds.add("more : Let us display and scroll down the output in one direction only. You can scroll page by page or line by line.");
	cmds.add("pwd : Display current user directory.");
	cmds.add("help : list all user commands and the syntax of their arguments.");
	for(int i=0;i<cmds.size();i++)
		System.out.println(cmds.get(i));
	
}
public void more(String file1) throws IOException
{
	BufferedReader br = new BufferedReader(new FileReader(file1)); 
    
    String line = br.readLine(); 
    String[] words;
     words=line.split(" ");
    // loop to print each line of  
    // file1.txt to  console 
    while (line != null) 
    {  
    	words=line.split(" ");
        for(int i=0;i<words.length;i++)
       	 System.out.println(words[i]);
    	line = br.readLine();
    }    
    br.close();
}
public void choice(String check) throws IOException
{
	Parser obj=new Parser();
	Terminal ob=new Terminal();
	if(obj.parse(check)==true)
	{
		switch(obj.cmd)
		{
		case "cp":
			{try{ob.cp(obj.args[0], obj.args[1]);}
			catch(Exception e){System.out.println(e);}
			}break;
		case "ls":
			ob.ls();break;
		case "rm":
			ob.rm(obj.args[0]);break;
		case "mv":
			ob.mv(obj.args[0], obj.args[1]);break;
		case"date":
			ob.date();break;
		case "clear":
			ob.clear();break;
		case"pwd":
			ob.pwd();break;
		case "args":
			ob.args(obj.args[0]);break;
		case"mkdir":
			ob.mkdir(obj.args[0]);break;
		case"rmdir":
			ob.rmdir(obj.args[0]);break;
		case"cd":
		{
			//By Default C
			if(check.indexOf("d")!=(check.length()-1))
				ob.cd(obj.args[0]);
			else
				ob.cd();
				
		}break;
		case "cat":
			{
				check=check.substring(check.indexOf("$")+2);
				String[]buffer=check.split(" ");
				if(buffer.length==2)	
					ob.cat(obj.args[0]);
				else
					ob.cat(obj.args[0],obj.args[1]);
			}break;
		case "help":
			ob.help();break;
		case "exit":
			System.exit(1);break;
		case "more":
			ob.more(obj.args[0]);break;
		}
	}
	else
		System.out.println("Invalid Syntax");
}	
}
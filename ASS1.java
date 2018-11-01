package ass1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class ASS1 {

    
public static void main(String args[]) throws IOException
{
	while(true)
	{
	Terminal object=new Terminal();
	Scanner input=new Scanner(System.in);
	String in="kemo@kemo~$ ";
	System.out.print(in);
	String out="";
	out=input.nextLine();
	String check=in+out;
	
        
        if(out.indexOf(">")!=-1&&out.indexOf(">>")==-1)
	{
		String file = out;
		file=file.substring(file.indexOf(">")+2);
        PrintStream o = new PrintStream(new File(file)); 
       PrintStream console = System.out; 
       System.setOut(o);
       object.choice(check);
   		System.setOut(console);
	}
	if(out.indexOf(">>")!=-1)
	{
		String file=out;
		file=file.substring(file.indexOf(">")+2);
		 FileOutputStream fos = new FileOutputStream(file,true);
		  PrintStream ps = new PrintStream(fos);
		  PrintStream console = System.out;
		System.setOut(ps);
	     object.choice(check);
	   	System.setOut(console);
	}
	if(out.indexOf("|")==-1)
			object.choice(check);
	else
	{
		String buffer="";
		out.toCharArray();
		for(int i=0;i<out.length();++i)
			{if(out.charAt(i)!='|')
				{buffer+=out.charAt(i);}
			if(out.charAt(i)=='|'||i==out.length()-1)
				{System.out.println(buffer);object.choice(in+buffer);buffer="";}}
	} 	
}
	}
}


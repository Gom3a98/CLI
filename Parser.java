package ass1;
import java.util.*;
public class Parser{
public String[] args=new String[2]; // Will be filled by arguments extracted by parse method
public String cmd; // Will be filled by the command extracted by parse method
// Returns true if it was able to parse user input correctly. Otherwise false
// Incase of success, it should save the extracted command and arguments
// at args and cmd paramters
public Parser(){};
public boolean parse(String input)
{
	String[] with1args={"","mkdir","rmdir","more","args","rm","cd","cat"};
	String[] with2args={"","mv","cp","cat"};
	String[] noargs={"ls","clear","date","help","cd","pwd","exit"};
	input=input.substring(input.indexOf("$")+2);
	String[]buffer=input.split(" ");
	cmd=buffer[0];
	if(buffer.length==1)
	{
		for(int i=0;i<=noargs.length;++i)
			if(cmd.equals(noargs[i]))
				return true;
		return false;
	}
	if(buffer.length==2)
	{
		args[0]=String.valueOf(buffer[1]);
		for(int i=0;i<=with1args.length;i++)
		{
		if(!cmd.equals(with1args[i]))
				return true;
		return false;
		}
	}
	if(buffer.length==3)
	{
			args[0]=String.valueOf(buffer[1]);
		    args[1]=String.valueOf(buffer[2]);
		for(int i=0;i<=with2args.length;++i)
			{
			if(!cmd.equals(with2args[i]))
					return true;
			return false;
			}
	}
	return false;
}
}

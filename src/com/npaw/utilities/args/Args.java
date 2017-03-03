package com.npaw.utilities.args;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Args {

	String multiThreading;
	String filenamePath;

	public Args(String[] args) throws ArgsException {

		parseParameters(Arrays.asList(args));
	}

	private void parseParameters(List<String> argsList) throws ArgsException{
		ListIterator<String> currentArgument;
		
		try{

			for (currentArgument = argsList.listIterator();currentArgument.hasNext();){
				String argString = currentArgument.next();
				if (argString.startsWith("-")){					
					multiThreading = currentArgument.next();
					currentArgument.previous();
					
				}
				else{
					filenamePath = currentArgument.next();
					currentArgument.previous();
					break;
				}
			}
							
		}
		catch (Exception e){
			throw new ArgsException(e.getMessage());
		}
		
		
	}
	
	public String isMultiThreading(){
		return multiThreading;
	}
	
	public String getFilePath(){
		return filenamePath;
	}
}

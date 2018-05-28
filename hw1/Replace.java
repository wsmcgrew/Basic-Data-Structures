import java.lang.*;
import java.io.*;
import java.util.*;

public class Replace {
	
	private BufferedReader in;
	private BufferedReader hf;
	private static DataOutputStream fileOut;
	private static int counter = 0;
	private String[] tempArr;
	
	public static void main(String[] args) throws IOException {
		fileOut = new DataOutputStream(new FileOutputStream("fileFix.i"));
		
		System.out.println("Please type full path to files: \n");
		Scanner input = new Scanner(System.in);
		String user = input.nextLine();
		
		//in = new BufferedReader(new FileReader(user));//<<need to check for .c files and .hfiles			
		//justWriteStuff(user);
		
	}//end method
        
        /**
         * This method reads in the filepath and reads the file
         * as an Array of String to return to the caller
         * 
         * @param user -- file path to the file
         * @return -- Array of strings that contains the file that is passed to it
         * @throws IOException 
         */
	public String[] readFile(String user) throws IOException {
		in = new BufferedReader(new FileReader(user));
		String[] theThingIWant = null;
		
		while(in.readLine() != null) {
			theThingIWant[counter] = in.readLine();
			counter++;
		}
		in.close();
		return theThingIWant;
	}// end method readFile
		/**
		* Writes a String of arrays to the DataOutputStream
		* if it has an INCLUDE statement, I want to call another method to create 
		* a different Array of string for the .h file
		* 
		* @parm String, String -- uses the User input to find the file
		*               String[] -- The File being read in as a String of Arrays
		**/
	public void justWriteStuff(String user, String[] thingImPassing) throws IOException {
		
	//DataOutputStream fileOut = new DataOutputStream(new FileOutputStream("fileFix.i"));
	
		for(int i = 0; i < thingImPassing.length -1; i++) {
			if(thingImPassing[i].contains("#include")) {
				String[] whoopsie = whoopSsie(user, thingImPassing, i);
				justWriteStuff(user, whoopsie);
			} else {
				fileOut.writeChars(thingImPassing[i]);
			}
		}//end for loop
		fileOut.flush();
	}// end class justWriteStuff
	
        /**
         * This method reads a file that has an "include" statement and returns a 
         * Array of Strings that has the file saved in it.
         * 
         * @param user -- String that finds the file being searched for
         * @param theThing -- Array of strings that is the file
         * @param i -- index in which the "include Statement was discovered
         * @return -- an Array of Strings that has the contents of the new file
         * @throws IOException --Exception that the file did not include an include statement
         */
	public String[] whoopSsie(String user, String[] theThing, int i) throws IOException {
		//hf = new BufferedReader(new FileReader(user));
                String fileName;
                fileName = null;
                //the following should return the '.h'file and then is passed into the ReadFile method
                if(theThing[i].contains("#include")) {
                    fileName = theThing[i];
                    fileName = fileName.substring(theThing[i].indexOf("<") + 1);
                    fileName = fileName.substring(0, theThing[i].indexOf(">"));
                }
                //THIS IS WHERE TO FIND THE NEW FILENAME
		String[] itsToLateAtNight = readFile(fileName);
		return itsToLateAtNight;
	}//end method woopsie
        
//**
}// end class 

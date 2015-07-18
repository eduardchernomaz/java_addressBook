/**
 * Author: Eduard Chernomaz
 * An address book Application - MVC pattern
 * create a controller class
 * controller class starts a view and a model
 */

package hw3;

import java.io.*;
import java.util.*;

public class AddressBookModel {

	private String addressBookLocation = "/Users/echerno/Documents/workspace/hw3/src/hw3/AddressBook";
	
	public AddressBookModel(){
	}
	
	public void addEntryToFile(String entry){
		
		try{
            File addressBookFile= new File(addressBookLocation);
            
            FileWriter fw = new FileWriter(addressBookFile, true);
            fw.write(entry + "\n");
            fw.close();    
        }
		catch(IOException e){
			e.printStackTrace(System.out);
		}
	}
	
	public ArrayList<String> searchEntryInFile(String searchItem){
		ArrayList<String> entriesFound = new ArrayList<String>();

		try{
            File addressBookFile= new File(addressBookLocation);
            
            FileReader fr = new FileReader(addressBookFile); 
            BufferedReader br = new BufferedReader(fr); 
            String s; 
            while((s = br.readLine()) != null) {
        		String[] line = s.split(",");
            	if (line[1].contains(searchItem)){
            		entriesFound.add(s);
        		}
            } 
            fr.close(); 
        }
		catch(IOException e){
			e.printStackTrace(System.out);
		}
		
		return entriesFound;
	}
}

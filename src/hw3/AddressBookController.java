/**
 * Author: Eduard Chernomaz
 * An address book Application - MVC pattern
 * create a controller class
 * controller class starts a view and a model
 */

package hw3;

import hw3.AddressBookModel;

import java.util.*;

class AddressBookController {
	
	private String entry;

    public AddressBookController(){
        AddressBookView v = new AddressBookView(this);
    }
    
    public void addEntry(String entry){
        AddressBookModel abm = new AddressBookModel();
        abm.addEntryToFile(entry);
    }
    
    public ArrayList<String> searchEntry(String searchItem){
    	
    	AddressBookModel abm = new AddressBookModel();
    	ArrayList<String> entriesFound = abm.searchEntryInFile(searchItem);
    	
    	return entriesFound;
    }
}


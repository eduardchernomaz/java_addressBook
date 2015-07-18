/**
 * Author: Eduard Chernomaz
 * An address book Application - MVC pattern
 * create a controller class
 * controller class starts a view and a model
 */

package hw3;

import java.util.*;
import hw3.AddressBookController;

class AddressBookView{

    public AddressBookView(AddressBookController abc){
        Scanner input = new Scanner(System.in);

		loop: while(true) {
			try {
				System.out.println("############### Address Book ###############");
				System.out.println("Enter one of the options below:");
				System.out.println("1: Search the address book by lastname");
				System.out.println("2: Add an entry to the address book");
				System.out.println("3: Exit Address Book");
				System.out.print("Option: ");

				int choice = input.nextInt();

				switch(choice) {
					case 1:
						// Search the address book
						System.out.print("Search Last Name: ");
						String searchItem = input.next();
						ArrayList<String> entriesFound = abc.searchEntry(searchItem.toLowerCase());

						if (entriesFound.size() == 0) {
							System.out.println("No Address entries were found.");
						} else {
							for (String entry : entriesFound) {
								String[] line = entry.split(",");
								System.out.println("First Name: " + line[0]);
								System.out.println("Last Name: " + line[1]);
								System.out.println("Address: " + line[2]);
								System.out.println("City: " + line[3]);
								System.out.println("State: " + line[4]);
								System.out.println("Zip: " + line[5] + "\n");
							}
						}
						break;
					case 2:
						// Add an entry to the address book
						System.out.println("Enter first name: ");
						String firstName = input.next();
						System.out.println("Enter last name: ");
						String lastName = input.next();
						System.out.println("Enter address: ");
						String address = input.next();
						System.out.println("Enter city: ");
						String city = input.next();
						System.out.println("Enter state: ");
						String state = input.next();
						System.out.println("Enter zip: ");
						String zip = input.next();
						String entry = firstName + "," + lastName + "," + address + "," + city + "," + state + "," + zip;
						System.out.println("String is:" + entry);
						abc.addEntry(entry);
						break;
					case 3:
						break loop;
					default:
						throw new Exception("The choice you made is not one of the options. Please choose again.");
				}

			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
    }
}

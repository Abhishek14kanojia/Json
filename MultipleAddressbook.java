package io.javabrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.Iterator;

public class MultipleAddressbook {

	Map<String, AddressbookService> addressmap = new HashMap<>();
	private Scanner scannerObject;
	private Map<String, AddressbookService> addressBookMap;
	public class MultipleAddressBook {
	    public AddressbookService addressBook;
	    Scanner scannerObject = new Scanner(System.in);

	    public void addressBookMain() {

	        boolean moreChanges = true;
	        do {

	            System.out.println("\nChoose the operation on the Directory you want to perform");
	            System.out.println(
	                    "1.Add an Address Book\n2.Edit Existing Address Book\n3.Search Person By Region\n4.View People By Region\n5.Count People By Region\n6.Display Address book Directory\n7.Exit Address book System");

	            switch (scannerObject.nextInt()) {
	                case 1:
	                    addAddressbook();
	                    break;
	                case 2:
	                    editAddressBook();
	                    break;
	                case 3:
	                    System.out.println("Enter \n1.Search By City\n2.Search By State");
	                    int searChoice = scannerObject.nextInt();
	                    if (searChoice == 1)
	                        searchByCity();
	                    else
	                        searchByState();
	                    break;
	                case 4:
	                    System.out.println("Enter \n1.Display By City\n2.Display By State");
	                    int displayChoice = scannerObject.nextInt();
	                    if (displayChoice == 1)
	                        displayPeopleByRegion(AddressbookService.personByCity);
	                    else
	                        displayPeopleByRegion(AddressbookService.personByState);
	                    break;
	                case 5:
	                    System.out.println("Enter \n1.Display By City\n2.Display By State");
	                    int countChoice = scannerObject.nextInt();
	                    if (countChoice == 1)
	                        countPeopleByRegion(AddressbookService.personByCity);
	                    else
	                        countPeopleByRegion(AddressbookService.personByState);
	                    break;
	                case 6:
	                    displayDirectoryContents();
	                    break;
	                case 7:
	                    moreChanges = false;
	                    System.out.println("Exiting Address Book Directory !");
	            }

	        } while (moreChanges);
	    }
	    private void editAddressBook() {
	    	String addressBookToEdit = scannerObject.next();

	        Map<String, AddressbookService> addressBookMap = null;
			if (addressBookMap.containsKey(addressBookToEdit)) {
	            addressBook = addressBookMap.get(addressBookToEdit);
	            addressBook.operation();
	        } else {
	            System.out.println("Book Does Not Exist");
	        }

	    }			
		}
		void addAddressbook() {
			Scanner scannerObject = null;
			String bookName = scannerObject.next();

	        Map<String, AddressbookService> addressBookMap = null;
			if (addressBookMap.containsKey(bookName)) {
	            System.out.println("Book Name Already Exists");
	            return;
	        }
	        AddressbookService addressBook = new AddressbookService();
	        addressBook.setAddressBookName(bookName);
	        Map<String, AddressbookService> addressBookMap1 = null;
			addressBookMap1.put(bookName, addressBook);
			
			
		}
		  
		private void displayDirectoryContents() {
			for (String eachBookName : addressBookMap.keySet()) {

	            System.out.println(eachBookName);
	        	    }
	}			
		

		private void countPeopleByRegion(HashMap<String, ArrayList<PersonContact>> personbycity) {
			String regionName = scannerObject.next();

	        long countPeople = listToDisplay.values().stream()
	                .map(region -> region.stream().filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName))).count();

	        System.out.println("Number of People residing in " + regionName + " are: " + countPeople + "\n");
			
		}

		private void displayPeopleByRegion(HashMap<String, ArrayList<PersonContact>> personbycity) {
			 String regionName = scannerObject.next();

		        listToDisplay.values().stream()
		                .map(region -> region.stream().filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName))).forEach(person -> person.forEach(personDetails -> System.out.println(personDetails)));
		    }
			
		

		private void searchByState() {
			 String stateName = scannerObject.next();
		        System.out.println("Enter the name of the Person : ");
		        String personName = scannerObject.next();

		        for (AddressbookService addressBook : addressBookMap.values()) {
		            ArrayList<PersonContact> contactList = ((AddressbookService) addressBook).getContact();
		            contactList.stream().filter(person -> person.getFirstName().equals(personName) && person.getState().equals(stateName)).forEach(person -> System.out.println(person));

		        }			
		}
	

	public void searchByCity() {
		 Scanner scannerObject;
		String cityName = scannerObject.next();
	        System.out.println("Enter the name of the Person : ");
	        String personName = scannerObject.next();

	        Map<String, AddressbookService> addressBookMap;
			for (AddressbookService addressBook : addressBookMap.values()) {
	            ArrayList<PersonContact> contactList = addressBook.getContact();
	            contactList.stream()
	                    .filter(person -> person.getFirstName().equals(personName) && person.getCity().equals(cityName))
	                    .forEach(person -> System.out.println(person));

	        }
	    
		
	}

}




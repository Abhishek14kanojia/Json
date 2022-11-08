package io.javabrain;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.google.gson.Gson; 

public class AddressbookService {

	public static final HashMap<String, ArrayList<PersonContact>> personByCity = null;
	public static HashMap<String, ArrayList<PersonContact>> personByState;
	Scanner sc = new Scanner(System.in);
	String name;
	public boolean isPresent = false;
    public String addressBookName;
 
    public String getAddressBookName() {
        return addressBookName;
    }

    public enum IOService {
        CONSOLE_IO, FILE_IO
    }
    public void setAddressBookName1(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public ArrayList<PersonContact> getContact() {
        return new ArrayList<PersonContact>(contact.values());
    }
	List<PersonContact> contacts = new ArrayList<>();
	Map<String, AddressbookService> addressbookmap = new HashMap<>();
	PersonContact person = new PersonContact(); 
	public void operation1() {

        boolean moreChanges = true;
        do {

            System.out.println("\nChoose the operation you want to perform");
            System.out.println(
                    "1.Add Contact to Address Book\n2.Edit Existing contact\n3.Display contact book\n4.Delete Contact\n5.Display Sorted Address Book \n6.Write To File\n7.Read From File \n8.Write Data To CSV File \n9.Read Data From CSV File \n10.Exit Address book System");

            Scanner scannerObject;
			switch (scannerObject.nextInt()) {
                case 1:
                    addcontact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    displayContact();
                    break;
                case 4:
                    addPerson();
                    break;
                case 5:
                    System.out.println("What Criteria Do You Want Address Book To Be Sorted In ?");
                    System.out.println("1.FirstName\n2.City\n3.State\n4.Zip Code");
                    int sortingChoice = scannerObject.nextInt();
                    sortAddressBook(sortingChoice);
                    break;
                case 6:
                    writeToAddressBookFile(IOService.FILE_IO);
                    break;
                case 7:
                    readDataFromFile(IOService.FILE_IO);
                    break;
                case 8:
                    try {
                        writeDataToCSV();
                    } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
                        ((Throwable) e).printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        readDataFromCSV();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    moreChanges = false;
                    System.out.println("Exiting Address Book: " + this.getAddressBookName() + " !");

            }

        } while (moreChanges);
    }
	
	private void readDataFromCSV() {
		// TODO Auto-generated method stub
		
	}

	private void writeDataToCSV() {
		// TODO Auto-generated method stub
		
	}

	private void readDataFromFile(IOService fileIo) {
		// TODO Auto-generated method stub
		
	}

	private void sortAddressBook(int sortingChoice) {
		// TODO Auto-generated method stub
		
	}

	private void writeToAddressBookFile(IOService fileIo) {
		// TODO Auto-generated method stub
		
	}

	void checkduplicate() {
		System.out.println("Enter first Name :");
		name = sc.next();
		for(PersonContact i : contacts) {
			if(i.getFirstName().equals(name)) {
			System.out.println("Exists");	
			}return;
		}
	}
	void addcontact() {
		System.out.println("Enter the Name : ");
		int number = sc.nextInt();
		for(int i = 0; i < number; i++) {
			System.out.println("Enter Details: ");
			checkduplicate();
		}
	}


	private void addPerson() {
		PersonContact person = new PersonContact();
		Scanner scan = new Scanner(System.in);
        String firstName = name;

        System.out.print("enter last name: ");
        String lastName = scan.next();

        System.out.print("enter address: ");
        String address = scan.next();

        System.out.print("enter city: ");
        String city = scan.next();

        System.out.print("enter state: ");
        String state = scan.next();

        System.out.print(" Please enter the zip: ");
        int zip = scan.nextInt();

        System.out.print("enter phone number: ");
        Long phoneNumber = scan.nextLong();

        System.out.print(" enter email: ");
        String email = scan.next();

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(phoneNumber);
        person.setEmail(email);
        person.setCity(city);
        person.setState(state);
        person.setZip(zip);
        addPersonToCity(person);
        addPersonToState(person);
        HashMap<String, ArrayList<PersonContact>> contact;
		contact.put(firstName, person);

        contact.put(firstName, person);
	}
	
	 public PersonContact findContact() {
	        System.out.println("\n Enter the first name of the contact to edit: ");
	        String name = sc.next();
	        int duplicate = 0;
	        PersonContact temp = null;
	        for (PersonContact contact : contacts) {
	            if (contact.getFirstName().equals(name)) {
	                duplicate++;
	                temp = contact;
	            }
	        }
	        if (duplicate == 1) {
	            return temp;

	        } else if (duplicate > 1) {
	            System.out.print(" There are multiple contacts with given name.\n Please enter their email id: ");
	            String email = sc.next();
	            for (PersonContact contact : contacts) {
	                if (contact.getFirstName().equals(name) && contact.getEmail().equals(email)) {
	                    return contact;
	                }
	            }
	        } else {
	            System.out.println("No contact with the given first name. Please enter the correct first name");
	            findContact();
	        }
	        return temp;
	    }
	
	 public void editContact() {

	        PersonContact contact = findContact();

	        System.out.println("Enter your choice to edit: " + "\n 1.Edit first name" + "\n 2.Edit last name"
	                + "\n 3.Edit address" + "\n 4.Edit city" + "\n 5.Edit state" + "\n 6.Edit zipcode"
	                + "\n 7.Edit phone number" + "\n 8.Edit email");
	 
	        int choice = sc.nextInt(); 
	        switch (choice) {
            case 1:
                System.out.println("Enter new first name");
                String newFirstName = sc.next();
                contact.setFirstName(newFirstName);
                System.out.println("new first name updated");

                break;
            case 2:
                System.out.println("Enter new last name");
                String newLastName = sc.next();
                contact.setLastName(newLastName);
                System.out.println("new last name updated");

                break;
            case 3:
                System.out.println("Enter new address");
                String newAddress = sc.next();
                contact.setAddress(newAddress);
                System.out.println("new new address updated");

                break;
            case 4:
                System.out.println("Enter new city");
                String newCity = sc.next();
                contact.setCity(newCity);
                System.out.println("new city updated");

                break;
            case 5:
                System.out.println("Enter new state");
                String newState = sc.next();
                contact.setState(newState);
                System.out.println("new state updated");

                break;
            case 6:
                System.out.println("Enter new zip code");
                int newZipCode = sc.nextInt();
                contact.setZip(newZipCode);
                System.out.println("new zip code updated");
                break;

            case 7:
                System.out.println("Enter new phone number");
                long newPhoneNumber = sc.nextLong();
                contact.setPhoneNumber(newPhoneNumber);
                System.out.println("new phone number updated");

                break;

            case 8:
                System.out.println("Enter new email");
                String newEmail = sc.next();
                contact.setEmail(newEmail);
                System.out.println("new email updated");

                break;

            default:
                System.out.println("Please enter a number between 1 to 8 only...");
                break;
        }
        System.out.println("The contact after editing is : " + contact);
  
	 }
	 public void displayContact() {
		 HashMap<String, ArrayList<PersonContact>> contact = null;
		for (String eachContact : contact.keySet()) {
	            ArrayList<PersonContact> person = contact.get(eachContact);
	            System.out.println(person);
	        }	        
	    }public void deleteContact() {
	       PersonContact contact = findContact();
	        if (contact == null) {
	            System.out.println("No contact found with the given name");
	            return;
	        }
	        contacts.remove(contact);
	        System.out.println("The contact has been deleted from the Address Book");
	    }
	    public void addPersonToCity(PersonContact contact) {
	        Map<String, AddressbookService> personByCity;
			if (personByCity.containsKey(contact.getCity())) {
	            personByCity.get(contact.getCity()).add(contact);
	        } else {
	            ArrayList<PersonContact> cityList = new ArrayList<>();
	            cityList.add(contact);
	            personByCity.put(contact.getCity(), cityList);
	        }
	    }
	    public void addPersonToState(PersonContact contact) {
	        List<PersonContact> personByState;
			if (personByState.containsKey(contact.getState())) {
	            personByState.get(contact.getState()).add(contact);
	        } else {
	            ArrayList<PersonContact> stateList = new ArrayList<>();
	            stateList.add(contact);
	            personByState.put(contact.getState(), stateList);
	        }   
	    }
		public void setAddressBookName(String bookName) {
			 List<ArrayList<PersonContact>> sortedContactList;

		        HashMap<String, ArrayList<PersonContact>> contact;
				int sortingChoice;
				switch (sortingChoice) {

		            case 1:
		                sortedContactList = contact.values().stream().sorted(
		                                (firstperson, secondperson) -> firstperson.getFirstName().compareTo(secondperson.getFirstName()))
		                        .collect(Collectors.toList());
		                printSortedList(sortedContactList);
		                break;

		            case 2:
		                sortedContactList = contact.values().stream()
		                        .sorted((firstperson, secondperson) -> firstperson.getCity().compareTo(secondperson.getCity()))
		                        .collect(Collectors.toList());
		                printSortedList(sortedContactList);
		                break;

		            case 3:
		                sortedContactList = contact.values().stream()
		                        .sorted((firstperson, secondperson) -> firstperson.getState().compareTo(secondperson.getState()))
		                        .collect(Collectors.toList());
		                printSortedList(sortedContactList);
		                break;

		            case 4:
		                sortedContactList = contact.values().stream().sorted((firstperson, secondperson) -> Long
		                                .valueOf(firstperson.getZip()).compareTo(Long.valueOf(secondperson.getZip())))
		                        .collect(Collectors.toList());
		                printSortedList(sortedContactList);
		                break;
		        }
			
		}
		private void printSortedList(List<ArrayList<PersonContact>> sortedContactList) {
			Iterator iterator = (Iterator) sortedContactList.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	            System.out.println();
	        }			
		}
		public void writeToAddressBookFile1(IOService ioService) {
	        if (ioService.equals(IOService.CONSOLE_IO))
	            displayContents();

	        else if (ioService.equals(IOService.FILE_IO)) {
	            String bookName = this.getAddressBookName();
	            String fileName = bookName + ".txt";
	            Object contact;
				new AddressBookIO().writeToAddressBookFile(fileName, contact);
	        }
		}
		
		 public List<String> readDataFromFile1(IOService fileIo) {

		        List<String> employeePayrollFromFile = new ArrayList<String>();
		        if (fileIo.equals(IOService.FILE_IO)) {
		            System.out.println("Employee Details from payroll-file.txt");
		            String bookName = this.getAddressBookName();
		            String fileName = bookName + ".txt";
		            employeePayrollFromFile = new AddressBookIO().readDataFromFile(fileName);

		        }
		        return employeePayrollFromFile;
		    }
		 public void printData(IOService fileIo) {
		        String bookName = this.getAddressBookName();
		        String fileName = bookName + ".txt";
		        if (fileIo.equals(IOService.FILE_IO)) new AddressBookIO().printData(fileName);
		    }
		 public long countEntries(IOService fileIo) {

		        String bookName = this.getAddressBookName();
		        String fileName = bookName + ".txt";
		        if (fileIo.equals(IOService.FILE_IO))
		            return new AddressBookIO().countEntries(fileName);

		        return 0;
		    }
		 public void writeDataToCSV1() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

		        String fileName = "./" + this.getAddressBookName() + ".csv";
		        try (Writer writer = Files.newBufferedWriter(Paths.get(fileName));) {

		            StatefulBeanToCsvBuilder<PersonContact> builder = new StatefulBeanToCsvBuilder<>(writer);
		            StatefulBeanToCsv<PersonContact> beanWriter = builder.build();
		            HashMap<String, ArrayList<PersonContact>> contact;
					Collection<ArrayList<PersonContact>> listOfContacts = contact.values().stream()
		                    .collect(Collectors.toCollection(ArrayList::new));
		            beanWriter.write(listOfContacts);
		            writer.close();
		            System.out.println("Written To CSV Successfully !");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}
		 public <CsvValidationException extends Throwable> void readDataFromCSV1() throws IOException, CsvValidationException {

		        String fileName = "./" + this.getAddressBookName() + ".csv";
		        try (Reader reader = Files.newBufferedReader(Paths.get(fileName));
		             CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {

		            String[] nextRecord;
		            try {
		                while ((nextRecord = csvReader.readNext()) != null) {
		                    System.out.println("First Name = " + nextRecord[2]);
		                    System.out.println("Last Name = " + nextRecord[3]);
		                    System.out.println("City = " + nextRecord[0]);
		                    System.out.println("State = " + nextRecord[5]);
		                    System.out.println("Email = " + nextRecord[1]);
		                    System.out.println("Phone Number = " + nextRecord[4]);
		                    System.out.println("Zip Code = " + nextRecord[6]);
		                    System.out.println("\n");
		                }
		            } catch (com.opencsv.exceptions.CsvValidationException e) {
		                e.printStackTrace();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    } public void writeDataToJson() throws IOException {

		        String fileName = "./" + this.getAddressBookName() + ".json";
		        Path filePath = Paths.get(fileName);
		        Gson gson = new Gson();
		        HashMap<String, ArrayList<PersonContact>> contact;
				String json = gson.toJson(contact.values());
		        FileWriter writer = new FileWriter(String.valueOf(filePath));
		        writer.write(json);
		        writer.close(); 

		    } public void readDataFromJson() throws IOException {

		        ArrayList<PersonContact> contactList;
		        String fileName = "./" + this.getAddressBookName() + ".json";
		        Path filePath = Paths.get(fileName);

		        try (Reader reader = Files.newBufferedReader(filePath)) {
		            Gson gson = new Gson();
		            contactList = new ArrayList<>(Arrays.asList(gson.fromJson(reader, PersonContact[].class)));
		            for (PersonContact contact : contactList) {
		                System.out.println("{");
		                System.out.println("Firstname : " + contact.getFirstName());
		                System.out.println("Lastname : " + contact.getLastName());
		                System.out.println("City : " + contact.getCity());
		                System.out.println("State : " + contact.getState());
		                System.out.println("Zip Code : " + contact.getZip());
		                System.out.println("Phone number : " + contact.getPhoneNumber());
		                System.out.println("Email : " + contact.getEmail());
		                System.out.println("}\n");
		            }
		        }
		    }

}

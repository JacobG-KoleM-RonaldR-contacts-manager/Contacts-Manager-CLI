import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.*;

public class App {
    private static Boolean running;
    private static Input inputHandler;
    private static IO ioHandler;
    public static void main(String[] args) throws Exception {

        inputHandler = new Input();
        ioHandler = new IO("data","contacts.txt");
        running = true;

        while(running){

            mainMenu();

        }

        inputHandler.close();
        
    }

    public static void mainMenu(){

        System.out.println("---------------------------------");
        System.out.println("1. View Contacts");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("---------------------------------");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");

        int answer = inputHandler.getInt(1, 5);

        switch(answer){
            case 1: viewContacts(); //View Contacts;
                break;
            case 2: addContact(); // Add Contact
                break;
            case 3: searchContact(); //Search Contacts;
                break;
            case 4: deleteContact(); //Delete Contacts;
                break;
            case 5: running = false; //Exit;
                break;
        }

    }

    public static void viewContacts(){

        List<String> data = ioHandler.getList();
        Collections.sort(data);
        
        System.out.println("");
        System.out.println("---------------------------------");
        for(String line : data){
            System.out.println(line);
        }
        System.out.println("---------------------------------");
        System.out.println("");

    }

    public static void addContact(){
        StringBuilder contact = new StringBuilder();
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("What is the contacts name?: ");
        System.out.println("");

        inputHandler.getString();
        contact.append(inputHandler.getString());

        System.out.println("");
        System.out.println("What is the contacts number?: ");
        String phone = inputHandler.getPhoneNumber();
        System.out.println("");
        contact.append(" | ");
        contact.append(phone);

        ArrayList<String> output = new ArrayList<String>();
        output.add(contact.toString());

        ioHandler.appendLine(output);

    }

    public static void searchContact(){

        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("Who are you looking for? :");
        System.out.println("");

        inputHandler.getString();
        String search = inputHandler.getString();
        Boolean found = false;

        System.out.println("");
        System.out.println("---------------------------------");

        List<String> data = ioHandler.getList();
        for(String line : data){
            if(line.toLowerCase().indexOf(search.toLowerCase()) != -1){ //if indexOf doesnt say it doesnt exist
                System.out.println(line);
                found = true;
            }
        }

        if(found){
            System.out.println("---------------------------------");
            System.out.println("");
        }else{
            System.out.println("No Contact found");
            System.out.println("---------------------------------");
            System.out.println("");
        }
        
    }

    public static void deleteContact(){

        viewContacts();
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("Who do you want to delete? :");
        System.out.println("");

        inputHandler.getString();
        String search = inputHandler.getString();
        Boolean found = false;
        int count = 0;
        int index = 0;

        System.out.println("");
        System.out.println("---------------------------------");

        List<String> data = ioHandler.getList();
        for(String line : data){
            if(line.toLowerCase().indexOf(search.toLowerCase()) != -1 && !found){ //if indexOf doesnt say it doesnt exist
                System.out.println(line);
                index = count;
                found = true;
            }
            count++;
        }

        if(found){
            System.out.println("---------------------------------");
            System.out.println("");
            System.out.println("Would you like to delete this contact? (Y/N)");
            boolean ans = inputHandler.yesNo();
            if(ans){
                data.remove(index); //removes the contact
                ioHandler.writeLines(data); //completely rewrites the file with new list
                System.out.println("Contact Deleted");
            }
            System.out.println("---------------------------------");
        }else{
            System.out.println("No Contact found");
            System.out.println("---------------------------------");
            System.out.println("");
        }
        
    }



}

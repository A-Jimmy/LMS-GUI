/*
Andres Jimmy
Software Development I - CEN 3024
August 9, 2023
LMSController class main method for a user to add, remove, and list
books from a text file
 */

package org.example;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class LMSController {


    public static void main(String[] args) throws IOException {

        ArrayList<LMS> collectionList = new ArrayList<LMS>();

        //Ask user for file name
        String getUserFile = JOptionPane.showInputDialog("Start by entering file name");

        File fileToEdit = new File(getUserFile);

        while (!fileToEdit.exists()) {
            String getUserFileError = JOptionPane.showInputDialog("File not found, try again");
            ;

            fileToEdit = new File(getUserFileError);
        }

        readFile(fileToEdit);

//The scanner fileScan and while loop is used to parse through the file
// and add to the arrayList of LMS objects "collection" for editing
        Scanner fileScan = new Scanner(fileToEdit);
        while (fileScan.hasNext()) {
            String[] split = fileScan.nextLine().split(",");
            collectionList.add(new LMS(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4]));
        }
        fileScan.close();

        String menu = "Please pick an option\n" +
                "1. Add a book to collection\n" +
                "2. Remove a book from collection by title or barcode number\n" +
                "3.List all books in collection\n" +
                "4.Check out a book\n" +
                "5.Check in a book\n" +
                "6.Exit";

        int exit = 0;

        while (exit != 6) {
            String userChoice = JOptionPane.showInputDialog(menu);
            int choice = Integer.parseInt(userChoice);

            switch (choice) {
                case 1:
/*Method name:addBookToList(ArrayList<LMS> arrayList);
Uses LMS class to add an object of type LMS to collection ArrayList
*/
                    addBookToList(collectionList);


                    writeToFile(fileToEdit, collectionList);
                    break;
                case 2:
                    readFile(fileToEdit);
/*Method name: removeBookByID(ArrayList<LMS> arrayList)
Asks user for barcode number to remove book from list
 */
                    removeBook(collectionList);

                    writeToFile(fileToEdit, collectionList);
                    readFile(fileToEdit);
                    break;
                case 3:
                    // listBooks(collection);
                    readFile(fileToEdit);
                    break;
                case 4:
 /*  Method name: checkOut(ArrayList<LMS> arrayList);
 Ask user for book title to check out and sets status to "checked out"
  */
                    checkOut(collectionList);

                    writeToFile(fileToEdit, collectionList);
                    readFile(fileToEdit);
                    break;
                case 5:
 /*  Method name: checkIn(ArrayList<LMS> arrayList);
 Ask user for book title to check in and sets status to "checked in"
  */
                    checkIn(collectionList);

                    writeToFile(fileToEdit, collectionList);
                    readFile(fileToEdit);
                    break;
                case 6:
                    exit = 6;
                    JOptionPane.showMessageDialog(null, "Exiting");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please enter 1 - 6");
                    break;


            }
        }
    }

    /*
    Method name: addBookToList(ArrayList<LMS> arrayList)
    Adds a user entry to an array list of class LMS and sets an id number
     */
    public static void addBookToList(ArrayList<LMS> arrayList) {
        arrayList.add(new LMS());


    }

    /*
    Method name: removeBook(ArrayList<LMS> arrayList)
    Asks user for barcode or title to remove book from list

     */
    public static void removeBook(ArrayList<LMS> arrayList) {



        String removeOption = "Press 1 to remove with barcode or press 2 to remove with title";
        int option = Integer.parseInt(JOptionPane.showInputDialog(removeOption));
        boolean bookFound = false;

        if (option == 1) {

            int barcode = Integer.parseInt(JOptionPane.showInputDialog("Enter barcode"));
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getBarcode() == barcode) {
                    arrayList.remove(i);
                    bookFound = true;
                }
            }
            if (bookFound == false) {
                JOptionPane.showInputDialog("No book found with entered barcode");
            }
        }
        if (option == 2) {
            String removeTitle = JOptionPane.showInputDialog("Enter title");
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getTitle().equals(removeTitle)) {
                    arrayList.remove(i);
                    bookFound = true;
                }
            }
            if (bookFound == false) {
                JOptionPane.showInputDialog("No book found with entered title");
            }
        }

    }



    /*Method name: readFile(File fileP)
    Prints out contents from text file
    */
    public static void readFile(File fileP) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileP));
        String read;
        String displayFile = "Book List\n";

        while ((read = br.readLine()) != null) {
            displayFile += read;
            displayFile += "\n";

        }
        JOptionPane.showMessageDialog(null, displayFile);


    }

    /*Method name:checkOut(ArrayList<LMS> arrayList)
        Lists the books in file, asks user for title of book,
        check for availability, set book status to checked out, and updates due date
         */
    public static void checkOut(ArrayList<LMS> arrayList) {
        LocalDate date = LocalDate.now();
        LocalDate due = date.plusDays(30);
         String list = "";
        for (int i = 0; i < arrayList.size(); i++) {
            list += arrayList.get(i) + "\n";
        }

        String checkOut = JOptionPane.showInputDialog("Enter title of book to check out\n" + list);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getTitle().equals(checkOut) && !arrayList.get(i).getStatus().equals("Checked Out")) {
                arrayList.get(i).setStatus("Checked Out");
                arrayList.get(i).setDueDate(String.valueOf(due));
                JOptionPane.showMessageDialog(null,arrayList.get(i).getTitle() + "is now checked out");
                                break;
            } else if (arrayList.get(i).getTitle().equals(checkOut) && arrayList.get(i).getStatus().equals("Checked Out")) {
                JOptionPane.showMessageDialog(null,arrayList.get(i).getTitle() + "is noavailable for checkout");
                      }
        }
    }


    /*Method name:checkIn(ArrayList<LMS> arrayList)
    Lists the books in file, asks user for title of book,
    set book status to checked in, and updates due date
     */
    public static void checkIn(ArrayList<LMS> arrayList) {


        String list = "";
        for (int i = 0; i < arrayList.size(); i++) {
            list += arrayList.get(i) + "\n";
        }
        String checkIn = JOptionPane.showInputDialog("Enter title of book to check in\n" + list);

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getTitle().equals(checkIn) && arrayList.get(i).getStatus().equals("Checked Out")) {
                arrayList.get(i).setStatus("Checked In");
                arrayList.get(i).setDueDate("null");
                JOptionPane.showMessageDialog(null,arrayList.get(i).getTitle() + "is now checked in");
                break;
            }


        }
    }

    /*Method name:writeToFile(File file,ArrayList<LMS> arrayList) throws IOException
    Method to write current arraylist to file
     */
    public static void writeToFile(File file, ArrayList<LMS> arrayList) throws IOException {
        FileWriter fw = new FileWriter(file);
        for (LMS string : arrayList) {
            fw.write(string + System.lineSeparator());
        }
        fw.close();
    }

}





/*unused method
    public static void listBooks(ArrayList<LMS> arrayList) {
        String list = "";
        for (int i = 0; i < arrayList.size(); i++) {
            list += arrayList.get(i) + "\n";
           }
        JOptionPane.showMessageDialog(null,list);


    }
*/

/*
Andres Jimmy
Software Development I - CEN 3024
August 9, 2023
LMS Class that asks for user input for book information
 */

package org.example;

import java.util.Scanner;

public class LMS {

    private int barcode;

    private String title;
    private String author;
    private String status;

    private String dueDate;

    public LMS() {
        addBook();
    }

    public LMS(int barcode, String title, String author, String status, String dueDate) {

        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.status = status;
        this.dueDate = dueDate;

    }

    public int getBarcode(){return barcode;}

    public void setBarcode(int barcode){this.barcode = barcode;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus(){return status;}

    public void setStatus(String status){this.status = status;}

    public String getDueDate(){return dueDate;}

    public void setDueDate(String dueDate){this.dueDate = dueDate;}



    @Override
    public String toString() {
        return barcode + ","  + title + "," + author + "," + status + "," + dueDate;
    }

    /*
    Method name:addBook()
    Takes in user input to set the title and author of class book
    */
    public void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter barcode");
        setBarcode(Integer.parseInt(input.nextLine()));
        System.out.println("Enter title of book");
        setTitle(input.nextLine());
        System.out.println("Enter author");
        setAuthor(input.nextLine());
        setStatus("Checked In");
        setDueDate("null");
    }


}

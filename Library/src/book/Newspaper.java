package book;

import java.util.Scanner;

public class Newspaper extends Book {
    protected String date;
    
    public Newspaper(){
        date = "";
    }
    
    public Newspaper(String t, String d, int q){
        title = t;
        date = d;
        quantity = q;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setBook(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        title = sc1.nextLine();
        date = sc1.nextLine();
        quantity = sc2.nextInt();
    }
    
    public void setBook(String t, String d, int q){
        title = t;
        date = d;
        quantity = q;
    }
    
    public void displayBook(){
        System.out.println("-----------------------------------");
        System.out.println("Book Title:: " + title);
        System.out.println("Date:: " + date);
        System.out.println("Quantity:: " + quantity);
        System.out.println("");
        //System.out.println("-----------------------------------");
    }     
    
    public void displayBookUser(){
        System.out.println("-----------------------------------");
        System.out.println("Book Title:: " + title);
        System.out.println("Date:: " + date);
        //System.out.println("Quantity:: " + quantity);
        System.out.println("");
        //System.out.println("-----------------------------------");
    }
}   
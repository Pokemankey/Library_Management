package book;

import java.util.Scanner;

public class Scholarly extends Book {
    protected String stream;
    
    public Scholarly(){
        stream = "";
    }
    
    public Scholarly(String t, String s, int q){
        title = t;
        stream = s;
        quantity = q;
    }
    
    public String getStream(){
        return stream;
    }
    
    public void setBook(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        title = sc1.nextLine();
        stream = sc1.nextLine();
        quantity = sc2.nextInt();
    }
    
    public void setBook(String t, String s, int q){
        title = t;
        stream = s;
        quantity = q;
    }
    
    public void displayBook(){
        System.out.println("-----------------------------------");
        System.out.println("Book Title:: " + title);
        System.out.println("Stream:: " + stream);
        System.out.println("Quantity:: " + quantity);
        System.out.println("");
        //System.out.println("-----------------------------------");
    }
    public void displayBookUser(){
        System.out.println("-----------------------------------");
        System.out.println("Book Title:: " + title);
        System.out.println("Stream:: " + stream);
        //System.out.println("Quantity:: " + quantity);
        System.out.println("");
        //System.out.println("-----------------------------------");
    }
}
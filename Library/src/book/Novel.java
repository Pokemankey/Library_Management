package book;

import java.util.Scanner;

public class Novel extends Book {
    protected String genre;
    
    public Novel(){
        genre = "";
    }
    
    public Novel(String t, String g, int q){
        title = t;
        genre = g;
        quantity = q;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public void setBook(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        title = sc1.nextLine();
        genre = sc1.nextLine();
        quantity = sc2.nextInt();
    }
    
    public void setBook(String t, String g, int q){
        title = t;
        genre = g;
        quantity = q;
    }
    
    public void displayBook(){
        System.out.println("-----------------------------------");
        System.out.println("Book Title:: " + title);
        System.out.println("Genre:: " + genre);
        System.out.println("Quantity:: " + quantity);
        System.out.println("");
        //System.out.println("-----------------------------------");
    }    
    public void displayBookUser(){
        System.out.println("-----------------------------------");
        System.out.println("Book Title:: " + title);
        System.out.println("Genre:: " + genre);
        //System.out.println("Quantity:: " + quantity);
        System.out.println("");
        //System.out.println("-----------------------------------");
    }
}
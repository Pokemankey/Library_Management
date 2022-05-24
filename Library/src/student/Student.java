package student;

import java.util.Scanner;
import book.*;

public class Student {
    protected String name;
    protected Scholarly borrowedScholarly[] = new Scholarly[5];
    protected Novel borrowedNovel[] = new Novel[5];
    protected Newspaper borrowedNewspaper[] = new Newspaper[5];
    protected int AUD;
    protected int scholarlyCounter;
    protected int novelCounter;
    protected int newspaperCounter;
    protected int pin;
    
    public Student(){
        name = "";
        AUD = 0;
        scholarlyCounter = 0;
        novelCounter = 0;
        newspaperCounter = 0;
        pin = 0;
        
        for(int i=0; i<5; i++){
            borrowedScholarly[i] = new Scholarly();
            borrowedNovel[i] = new Novel();
            borrowedNewspaper[i] = new Newspaper();
        }
    }
    
    public Student(String n, int a, int p){
        name = n;
        AUD = a;
        scholarlyCounter = 0;
        novelCounter = 0;
        newspaperCounter = 0;
        pin = p;
        
        for(int i=0; i<5; i++){
            borrowedScholarly[i] = new Scholarly();
            borrowedNovel[i] = new Novel();
            borrowedNewspaper[i] = new Newspaper();
        }
    }
    
    public String getName(){
        return name;
    }
    
    public void register(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        
        name = sc1.nextLine();
        AUD = sc2.nextInt();
        pin = sc2.nextInt();
    }
    
    public void register(String n, int a, int p){
        name = n;
        AUD = a;
        pin = p;
    }
    
    public boolean verify(int a, int p){
        if((AUD == a) && (pin == p)){
            return true;
        }
        return false;
    }
    
    public void displayBorrowedBooks(){
        for(int i = 0; i<scholarlyCounter; i++){
            borrowedScholarly[i].displayBookUser();
        }
        for(int i = 0; i<novelCounter; i++){
            borrowedNovel[i].displayBookUser();
        }
        for(int i = 0; i<newspaperCounter; i++){
            borrowedNewspaper[i].displayBookUser();
        }
    }
    
    public void borrowBook(Scholarly sc){
        if(sc.getQuantity() <= 0){
            System.out.println("Not enough books available!");
            return;
        }
        if((scholarlyCounter + novelCounter + newspaperCounter) == 3){
            System.out.println("You have exceeded the maximum borrowed books of 5!");
            return;
        }
        borrowedScholarly[scholarlyCounter].setBook(sc.getTitle(), sc.getStream(), sc.getQuantity());
        scholarlyCounter++;
        sc.decrementQuantity();
    }
      
    public void borrowBook(Novel n){
        if(n.getQuantity() <= 0){
            System.out.println("Not enough books available!");
            return;
        }
        if((scholarlyCounter + novelCounter + newspaperCounter) == 3){
            System.out.println("You have exceeded the maximum borrowed books of 5!");
            return;
        }
        borrowedNovel[novelCounter].setBook(n.getTitle(), n.getGenre(), n.getQuantity());
        novelCounter++;
        n.decrementQuantity();
    }
    
    public void borrowBook(Newspaper n){
        if(n.getQuantity() <= 0){
            System.out.println("Not enough books available!");
            return;
        }
        if((scholarlyCounter + novelCounter + newspaperCounter) == 3){
            System.out.println("You have exceeded the maximum borrowed books of 5!");
            return;
        }
        borrowedNewspaper[newspaperCounter].setBook(n.getTitle(), n.getDate(), n.getQuantity());
        newspaperCounter++; 
        n.decrementQuantity();
    }
    
    public void returnBook(Scholarly scholarlyBooks[], Novel novels[], Newspaper newspapers[], int size){
        Scanner sc = new Scanner(System.in);
        int option2;
        int option;
        System.out.println("What type of book would you like to return");
        System.out.println("1)Scholarly book");
        System.out.println("2)Novel book");
        System.out.println("3)Newspaper book");
        option = sc.nextInt();
        switch(option){
            case 1:
                if(scholarlyCounter <= 0){
                    System.out.println("No scholarly books available");
                    break;
                }
                for(int i=0; i<scholarlyCounter; i++){
                    System.out.println("-----------------------------------");
                    System.out.println("------------------" + (i+1) + "-----------------");
                    borrowedScholarly[i].displayBook();
                }
                System.out.println("Pick Book to be returned::");
                option2 = sc.nextInt();
                option2--;
                for(int i=0; i<size;i++){
                    if(scholarlyBooks[i].getTitle().equals(borrowedScholarly[option2].getTitle())){
                        scholarlyBooks[i].incrementQuantity();
                    }
                }
                for(int i = option2; i<4; i++){
                    borrowedScholarly[i] = borrowedScholarly[i+1];
                }
                scholarlyCounter--;
                
                break;
            case 2:
                if(novelCounter <= 0){
                    System.out.println("No novel available");
                    break;
                }
                for(int i=0; i<novelCounter; i++){
                    System.out.println("-----------------------------------");
                    System.out.println("------------------" + (i+1) + "-----------------");
                    borrowedNovel[i].displayBook();
                }
                System.out.println("Pick Book to be returned::");
                option2 = sc.nextInt();
                option2--;
                for(int i=0; i<size;i++){
                    if(novels[i].getTitle().equals(borrowedNovel[option2].getTitle())){
                        novels[i].incrementQuantity();
                    }
                }
                for(int i = option2; i<4; i++){
                    borrowedNovel[i] = borrowedNovel[i+1];
                }
                novelCounter--;
                break;
            case 3:
                if(newspaperCounter <= 0){
                    System.out.println("No newspaper available");
                    break;
                }
                for(int i=0; i<newspaperCounter; i++){
                    System.out.println("-----------------------------------");
                    System.out.println("------------------" + (i+1) + "-----------------");
                    borrowedNewspaper[i].displayBook();
                }
                System.out.println("Pick Book to be returned::");
                option2 = sc.nextInt();
                option2--;
                for(int i=0; i<size;i++){
                    if(newspapers[i].getTitle().equals(borrowedNewspaper[option2].getTitle())){
                        newspapers[i].incrementQuantity();
                    }
                }
                for(int i = option2; i<4; i++){
                    borrowedNewspaper[i] = borrowedNewspaper[i+1];
                }
                newspaperCounter--;
                break;
        }
    }
}
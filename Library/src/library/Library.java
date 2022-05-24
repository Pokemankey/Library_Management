package library;

import book.*;
import student.*;
import java.util.Scanner;

public class Library {
    
    public static void main(String[] args) {
        //INITIALIZING STUDENT AND BOOK DATA BASE
        Student students[] = new Student[3];
        
        Scholarly scholarlyBooks[] = new Scholarly[3];
        Novel novels[] = new Novel[3];
        Newspaper newspapers[] = new Newspaper[3];
        
        students[0] = new Student("John", 10000, 1234); 
        students[1] = new Student("Doe", 10001, 4321); 
        students[2] = new Student("Tom", 10002, 0000); 
        
        scholarlyBooks[0] = new Scholarly("Introduction to Java" , "CSE", 10);
        scholarlyBooks[1] = new Scholarly("Accounting 101" , "MBA", 10);
        scholarlyBooks[2] = new Scholarly("Applied Math IV" , "Sci", 10);

        novels[0] = new Novel("The beginning after the end Vol.1", "Fantasy", 10);
        novels[1] =  new Novel("The house on needless street", "psychological horror", 10);
        novels[2] =  new Novel("Tell me your dreams", "Thriller", 10);
        
        newspapers[0] = new Newspaper("Khaleej Times", "29/3", 1);
        newspapers[1] = new Newspaper("The forbes", "7/4", 1);
        newspapers[2] = new Newspaper("Timeout Dubai", "26/8", 1);
        
        boolean loggedIn = false;
        int studentIndex = 0;
        int choice = 0;
        
        Scanner scanInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        
        do{
            System.out.println("----------LIBRARY MANAGEMENT----------");
            System.out.println("1)Login");
            System.out.println("2)Exit");
            choice = scanInt.nextInt();
            switch(choice){
                case 1:
                    while(!loggedIn){
                        int tempAUD, tempPin;
                        System.out.println("Enter AUD::");
                        tempAUD = scanInt.nextInt();
                        System.out.println("Enter Pin::");
                        tempPin = scanInt.nextInt();
                        for(int i=0; i<3; i++){
                            if(students[i].verify(tempAUD, tempPin)){
                                studentIndex = i;
                                loggedIn = true;
                                break;
                            }
                        }
                        if(!loggedIn){
                            System.out.println("Cannot Find User!");
                        }
                    }
                    libraryMenu(students[studentIndex], scholarlyBooks, novels, newspapers);
                    loggedIn = false;
            }
        }while(choice!=2);
    }
    
    public static void libraryMenu(Student student, Scholarly scholarlyBooks[], Novel novels[], Newspaper newspapers[]){
        Scanner scanInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        
        int choice = 0;
        
        System.out.println("Welcome " + student.getName());
        
        do{
            System.out.println("1)Display Books in Library");
            System.out.println("2)Borrow Book");
            System.out.println("3)Return Book");
            System.out.println("4)Check Borrowed Books");
            System.out.println("5)Log Out");
            choice = scanInt.nextInt();
            switch(choice){
                case 1:
                    System.out.println("----------Scholarly Books----------");
                    for(int i=0; i<3; i++){
                        scholarlyBooks[i].displayBook();
                    }
                    System.out.println("---------------Novels--------------");
                    for(int i=0; i<3; i++){
                        novels[i].displayBook();
                    }
                    System.out.println("------------Newspapers-------------");
                    for(int i=0; i<3; i++){
                        newspapers[i].displayBook();
                    }
                    break;
                case 2:
                    int typeChoice=0, bookChoice=0;
                    System.out.println("1)Scholarly");
                    System.out.println("2)Novels");
                    System.out.println("3)Newspaper");
                    typeChoice = scanInt.nextInt();
                        if(typeChoice == 1){
                            for(int i=0; i<3; i++){
                                System.out.println("------------------" + (i+1) + "-----------------");
                                scholarlyBooks[i].displayBook();
                            }
                            System.out.println("Enter the book you want to borrow::");
                            bookChoice = scanInt.nextInt();
                            bookChoice--;
                            if(bookChoice>2){
                                System.out.println("Invalid Choice!");
                            }
                            else{
                                student.borrowBook(scholarlyBooks[bookChoice]);
                            }
                        }
                        else if(typeChoice == 2){
                            for(int i=0; i<3; i++){
                                System.out.println("------------------" + (i+1) + "-----------------");
                                novels[i].displayBook();
                            }
                            System.out.println("Enter the novel you want to borrow::");
                            bookChoice = scanInt.nextInt();
                            bookChoice--;
                            if(bookChoice>2){
                                System.out.println("Invalid Choice!");
                            }
                            else{
                                student.borrowBook(novels[bookChoice]);
                            }
                        }
                        else if(typeChoice == 3){
                            for(int i=0; i<3; i++){
                                System.out.println("------------------" + (i+1) + "-----------------");
                                newspapers[i].displayBook();
                            }
                            System.out.println("Enter the newspaper you want to borrow::");
                            bookChoice = scanInt.nextInt();
                            bookChoice--;
                            if(bookChoice>2){
                                System.out.println("Invalid Choice!");
                            }
                            else{
                                student.borrowBook(newspapers[bookChoice]);
                            }
                        }
                        else{
                            System.out.println("Invalid Choice!");
                        }
                        break;
                case 3:
                    student.returnBook(scholarlyBooks, novels, newspapers, 3);
                    break;
                case 4:
                    student.displayBorrowedBooks();
                    break;
            }
        }while(choice!=5);
    }
}
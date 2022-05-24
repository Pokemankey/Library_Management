package book;

import java.util.Scanner;

public class Book {
    protected String title;
    protected int quantity;
    
    public Book(){
        title = "";
        quantity = 0;
    }
    
    public String getTitle(){
        return title;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setBook(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        title = sc1.nextLine();
        quantity = sc2.nextInt();
    }
    
    public void displayBook(){
        System.out.println("-----------------------------------");
        
        
        System.out.println("-----------------------------------");
    }
    
    public void decrementQuantity(){
        quantity--;
    }
    
    public void incrementQuantity(){
        quantity++;
    }
}
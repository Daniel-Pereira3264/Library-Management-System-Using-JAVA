
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cse107.project;
import java.util.*;

/**
 *
 * @author student
 */

class library{
    private ArrayList<Admin> admins= new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>(); 
    private ArrayList<Book> books = new ArrayList<>();
    
    void addadmin(Admin admin){
        admins.add(admin);
    }
    void addstudent(Student student){
        students.add(student);
    }
    void addbooks(Book book){
        books.add(book);
    }
    
    

    
}

class Admin{
    private String name;
    private int id;
    private String post;
    
    
    
    
}

class Student{
    
}

class Author{
    
    private int authorId;
    private String authorName;
    private String authorCountry;
    
    Author(){};
    Author(int authorId,String authorName, String authorCountry){
        
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorCountry = authorCountry;
    }
    
    public int getAuthorId(){
        
        return this.authorId;
    }
    
    
    public String getAuthorName(){
        
        return this.authorName;
    }
    
    public String getAuthorCountry(){
        
        return this.authorCountry;
    }
    
    
     public void setAuthorId(int id){
        
         this.authorId = id;
    }
    
    
    public  void setAuthorName(String name){
        
       this.authorName = name;
    }
    
    public  void setAuthorCountry(String country){
        
       this.authorCountry = country;
    }
    
    public String toString(){
        
        return this.authorId + " " +this.authorName + " "+ this.authorCountry;
    }
}


class Book{
    
    private int ISBN;
    private String bookTitle;
    private double bookPrice;
    private ArrayList<Author> author = new ArrayList<>();
    private Publisher publisher = new Publisher();
    private int numberOfAuthors = 0;
    
    Book(){};
    Book(int bookId,String bookTitle,double bookPrice){
        
        this.ISBN = bookId;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
       

    }
    
    
    public void setNumberOfAuthors(int num){
        
        this.numberOfAuthors = num;
    }
    public int getNumberOfAuhtors(){
        
        return this.numberOfAuthors;
    }
    public int getBookId(){
        
        return this.ISBN;
    }
    
    
    public String getBookTitle(){
        
        return this.bookTitle;
    }
    public double getBookPrice(){
        
        return this.bookPrice;
    }
    
    public void setBookId(int id){
        
       this.ISBN = id;
    }
    
    
    public void setBookTitle(String title){
        
        this.bookTitle = title;
    }
    public void setBookPrice(double price){
        
      this.bookPrice = price;
    }
   
    

    public String toString(){
        
        return this.ISBN + " " +this.bookTitle + " "+ this.bookPrice;
    }
    
    public void getAuthor(){
        
        for(int i=0; i<this.numberOfAuthors; i++){
            
            System.out.println("Author No. "+(i+1));
            System.out.println(author.get(i).toString());
            
        }
    }
    
    public void getPublisher(){
        
        System.out.println(publisher.toString());
    }
    
    public void addAuthor(Author author){
        
        this.author.add(author);
        
    }
    
    public void addPublsiher(Publisher publisher){
        
        this.publisher = publisher;
       
    }
    
    public void dropAuthor(int authorId){
        
       for(int i=0; i<this.numberOfAuthors; i++){
           
           if(author.get(i).getAuthorId()==authorId){
                  //System.out.println(author.get(i).toString());
                   //System.out.println("Ok");
                   author.remove(i);
                   break;
           }
          
       } 
       
       this.numberOfAuthors--;
        
        
        
    }
    
   
    
}

class Publisher{
    
    private int publisherId;
    private String publisherName;
    private String publisherCountry;
    
    Publisher(){};
    
    Publisher(int publisherId,String publisherName,String publisherCountry){
           
        
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publisherCountry = publisherCountry;
        
                
    }
    
    
    public String toString(){
        
        return this.publisherId + " " +this.publisherName + " "+ this.publisherCountry;
        
    }
    
  
}
public class Project {

    /**
     * @param args the command line arguments
     */
    
    
        static ArrayList<Author> authors = new ArrayList<>();
        static ArrayList<Book> books = new ArrayList<>();
        static ArrayList<Publisher> publishers = new ArrayList<>();
    public static void main(String[] args) {
        
        
       
        
        Author a = new Author();
        Book b = new Book();
        Publisher p = new Publisher();


        Scanner inp = new Scanner(System.in);
   
            
         //   int input = inp.nextInt();
            
               System.out.println("Enter ISBN: ");
               int isbn = inp.nextInt();
               inp.nextLine();
               System.out.println("Enter title: ");
               String title = inp.nextLine();
               System.out.println("Enter Price: ");
               double price = inp.nextDouble();
               System.out.println("Number of Authors: ");
               int numberOfAuthors = inp.nextInt();
               
               
               b = new Book(isbn,title,price);
               books.add(b);
               b.setNumberOfAuthors(numberOfAuthors);
               
               for(int i=0; i<b.getNumberOfAuhtors(); i++){
                   
                    System.out.println("Enter Author ID: ");
                    int authorId = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Enter Author Name: ");
                    String authorName = inp.nextLine();
                    System.out.println("Enter Author Country: ");
                    String authorCountry = inp.nextLine();

                    a = new Author(authorId,authorName,authorCountry);

                    authors.add(a);
                    b.addAuthor(a);
               }
              
               System.out.println("Enter Pushlisher ID: ");
               int publisherId = inp.nextInt();
               System.out.println("Enter Pushlisher Name: ");
               inp.nextLine();
               String publisherName = inp.nextLine();
               System.out.println("Enter Publisher Country: ");
               String publisherCountry = inp.nextLine();
            
               
               p = new Publisher(publisherId,publisherName,publisherCountry);
               
               publishers.add(p);
               b.addPublsiher(p);
               
               System.out.println("Book Info: " + b.toString());
               System.out.println("Author Info:");
               b.getAuthor();
               System.out.println("Publisher Info:");
               b.getPublisher();
               
               System.out.println("Enter auhtor ID to delete: ");
               
               int auhtorId = inp.nextInt();
               
               b.dropAuthor(auhtorId);
               System.out.println("After deletion author: ");
               b.getAuthor();
               
               
               System.out.println("Search books by ISBN");
               int bookId = inp.nextInt();
               
               for(int i=0; i<books.size(); i++){
                   
                   if(books.get(i).getBookId()==bookId){
                       
                       System.out.println(books.get(i).toString());
                   }
               }
              

        
        }
        


        
    }
    
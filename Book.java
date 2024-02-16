import java.io.Serializable;

public class Book implements Serializable{
    // Defining attributes:
    private int isbn;
    private String title, author;
    private double price;


    // Default constructor:
    public Book(){
        isbn = 0;
        title = null;
        author = null;
        price = 0;
    }

    // Constructor that we will use:
    public Book(int isbn, String title, String author, double price){
            this.isbn = isbn;           // "this.isbn" refers to the created variable at the beginning! "isbn;" is parameter.
            this.author = author;
            this.title = title;
            this.price = price;
            // these 4 lines above are like - "self.isbn = isbn" in Python.
    }

    // String representation of the object in string:
    @Override
    public String toString(){
        return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn +
                "\nPrice: " + price + "\n";
    }
}

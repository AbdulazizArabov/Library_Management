import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Library extends Object implements Serializable{
    private List<Book> collection;

    // Default constructor:
    public Library(){
       collection = new ArrayList<Book>();  // This is the same things as :
//        ArrayList<Book> collection = new ArrayList<>(Book);
        // This has fewer bugs.
    }

    public void addBook(Book book){
        collection.add(book);
    }

    @Override
    public String toString(){
        String total = "\n";
//        for(int i = 0; i < collection.size(); i++){
//            Book b = collection.get(i);
//            total = total + b.toString();    // This "toString" method is from our Book class file.
//        }

        // Using iterators:
        Iterator<Book> i = collection.iterator();    // Iterator<Book> is a pointer. Pointing to books.
        while(i.hasNext()){       // True if iteration has more objects.
            Book b = (Book) i.next();    // Required type: Book.  Casting is required here.
            total = total + b.toString();
        }

        return total;
    }

}

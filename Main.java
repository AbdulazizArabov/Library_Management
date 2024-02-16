import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
// Deserialization converts the serialized byte stream back into an object, preserving its state, fields, and results.

// IMPROVE USER INTERFACE:
//1. SAVING PROCESS: SAY "DO YOU WANT TO SAVE THE BOOK?" IF yes filename and save else: no
//2. add Cloud database
// This class is a center.
public class Main {
    static String fileName = null;
    static Library lib = new Library();   // Object of Library class;
    static Scanner scanner = new Scanner(System.in); // Scanner for inputs.
    static Boolean running = true;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Abdulaziz's Book Library!");

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your library ID: ");
        int userId = scanner.nextInt();

       if(userName.equals("Abdulaziz Arabov") && userId == 2000){
           System.out.print("Accessed successfully. Have a good reading " + userName + "\n");
           // We will run the program unless the user uses it.
           while(running){
               System.out.println("\nEnter 0 for loading a library" +
                       "\nEnter 1 to save and quit" +
                       "\nEnter 2 to list all books in Library" +
                       "\nEnter 3 to add a book to library");

               int answer = scanner.nextInt();

               // Switch case for actions:
               switch(answer){
                   case 0:
                       System.out.print("Enter name of the file to load:");
//                     fileName = scanner.next();
                       loadScript(scanner.next()); // A separate method to make our code readable. Scanner.next() - replaces the line before.
                       break;

                   case 1:
                       // This case saves and quits the program.
                       saveAndQuit();
                       break;
                   case 2:
                       System.out.println(lib.toString());
                       break;
                   case 3:
                       addBook();
                       break;
               }
           }
           System.exit(0);
       } else{
           System.out.println("You do not have access to the Library.");
       }
       scanner.close();
    }


    // Method for case 3: To add a book to a library
    private static void addBook(){
        int isbn;
        String title, author;
        double price;

        System.out.print("Enter the Title: ");
        scanner.nextLine();
        title = scanner.nextLine();

        System.out.print("Enter the Author: ");
        author = scanner.nextLine();

        System.out.print("Enter the ISBN: ");
        isbn = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the Price: ");
        price = scanner.nextDouble();
        scanner.nextLine();


        Book b = new Book(isbn, title, author, price);
        lib.addBook(b);
    }


    // Method for case 1: To save the data and quit the program.
    private static void saveAndQuit() throws IOException {
        System.out.print("Enter a file name: ");
        fileName = scanner.next() + ".ser";
        // breaking program execution:
        running = false;
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(lib);
            fos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    // Creating method for my case 0: To load a library.
    private static void loadScript(String name){
        FileInputStream fis = null;
        ObjectInputStream in = null;

        File file = new File(name + ".ser");    // File or Directory pathname. With .ser because it's serialized.
        if(file.exists()){
            try{
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                lib = (Library) in.readObject();
                fis.close();
                in.close();

            } catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else{
            System.out.println("\nThe file does not exist.");
        }
    }

}

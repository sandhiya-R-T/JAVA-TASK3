package oopsprogramming;

import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

        public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;     }

        public int getBookID() {
        return bookID;
    }

    	public String getTitle() {
        return title;
    }

    	public String getAuthor() {
        return author;
    }

    	public boolean isAvailable() {
        return isAvailable;
    }

    	public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private Book[] books;
    private int maxSize;
    private int currentSize;

       public Library(int maxSize) {
        this.maxSize = maxSize;
        this.books = new Book[maxSize];
        this.currentSize = 0;
    }


    public void addBook(Book book) {
        if (currentSize < maxSize) {
            books[currentSize++] = book;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

        public void removeBook(int bookID) {
        for (int i = 0; i < currentSize; i++) {
            if (books[i].getBookID() == bookID) {
                books[i] = null;
                currentSize--;
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found with ID: " + bookID);
    }

        public void searchBook(int bookID) {
        for (int i = 0; i < currentSize; i++) {
            if (books[i].getBookID() == bookID) {
                System.out.println("Book found:");
                System.out.println("Title: " + books[i].getTitle());
                System.out.println("Author: " + books[i].getAuthor());
                System.out.println("Available: " + (books[i].isAvailable() ? "Yes" : "No"));
                return;
            }
        }
        System.out.println("Book not found with ID: " + bookID);
    }

        public void displayBooks() {
        if (currentSize == 0) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in the library:");
        for (int i = 0; i < currentSize; i++) {
            System.out.println("Book ID: " + books[i].getBookID() + ", Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor() + ", Available: " + (books[i].isAvailable() ? "Yes" : "No"));
        }
    }
}

public class Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

               System.out.print("Enter maximum capacity of the library: ");
        int maxSize = scanner.nextInt();
        Library library = new Library(maxSize);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book by ID");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter book ID to remove: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;
                case 3:
                    System.out.print("Enter book ID to search: ");
                    int searchID = scanner.nextInt();
                    library.searchBook(searchID);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

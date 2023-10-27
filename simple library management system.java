import java.util.ArrayList;
import java.util.List;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
        }
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}

class LibraryUser {
    private int userId;
    private String name;
    private List<Book> borrowedBooks;

    public LibraryUser(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.borrowBook();
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
        }
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee");
        Book book2 = new Book(2, "1984", "George Orwell");
        Book book3 = new Book(3, "Pride and Prejudice", "Jane Austen");

        LibraryUser user1 = new LibraryUser(101, "Alice");
        LibraryUser user2 = new LibraryUser(102, "Bob");

        user1.borrowBook(book1);
        user1.borrowBook(book2);
        user2.borrowBook(book3);

        displayUserStatus(user1);
        displayUserStatus(user2);
    }

    public static void displayUserStatus(LibraryUser user) {
        System.out.println("\nUser Information:");
        System.out.println(user);

        List<Book> borrowedBooks = user.getBorrowedBooks();
        if (!borrowedBooks.isEmpty()) {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books borrowed by this user.");
        }
    }
}

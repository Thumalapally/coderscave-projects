import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int isbn;
    private boolean isAvailable;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class User {
    private String name;
    private String id;
    private List<Book> borrowedBooks;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
}

public class LibraryManagementSystem {
    private List<Book> books;
    private List<User> users;

    public LibraryManagementSystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getIsbn());
            }
        }
    }

    public void borrowBook(String userId, int isbn) {
        User user = getUserById(userId);
        Book book = getBookByIsbn(isbn);

        if (user!= null && book!= null && book.isAvailable()) {
            user.borrowBook(book);
            book.setAvailable(false);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is not available or user not found!");
        }
    }

    public void returnBook(String userId, int isbn) {
        User user = getUserById(userId);
        Book book = getBookByIsbn(isbn);

        if (user!= null && book!= null &&!book.isAvailable()) {
            user.getBorrowedBooks().remove(book);
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book is not borrowed by the user or not found!");
        }
    }

    private User getUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    private Book getBookByIsbn(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter book author: ");
                    String author = scanner.next();
                    System.out.print("Enter book ISBN: ");
                    int isbn = scanner.nextInt();
                    lms.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.next();
                    System.out.print("Enter user ID: ");
                    String userId = scanner.next();
                    lms.addUser(new User(userName, userId));
                    break;
                case 3:
                    lms.displayBooks();
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    String borrowUserId = scanner.next();
                    System.out.print("Enter book ISBN: ");
                    int borrowIsbn = scanner.nextInt();
                    lms.borrowBook(borrowUserId




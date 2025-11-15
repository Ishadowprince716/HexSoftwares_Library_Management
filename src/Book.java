/**
 * Book.java
 * Represents a book in the library system
 */

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private String issuedTo; // Name of member who issued the book
    private String issueDate;
    
    /**
     * Constructor to create a new book
     * @param bookId Unique book identifier
     * @param title Title of the book
     * @param author Author of the book
     * @param isbn ISBN number
     */
    public Book(String bookId, String title, String author, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.issuedTo = null;
        this.issueDate = null;
    }
    
    /**
     * Issue the book to a member
     * @param memberName Name of the member
     * @param issueDate Date of issue
     * @throws IllegalStateException if book is already issued
     */
    public void issueBook(String memberName, String issueDate) {
        if (!this.isAvailable) {
            throw new IllegalStateException("Book is already issued to " + this.issuedTo);
        }
        this.isAvailable = false;
        this.issuedTo = memberName;
        this.issueDate = issueDate;
        System.out.println("✓ Book '" + this.title + "' issued to " + memberName);
    }
    
    /**
     * Return the book to the library
     * @return Name of member who returned the book
     * @throws IllegalStateException if book is not issued
     */
    public String returnBook() {
        if (this.isAvailable) {
            throw new IllegalStateException("Book is not issued. Cannot return.");
        }
        String previousMember = this.issuedTo;
        this.isAvailable = true;
        this.issuedTo = null;
        this.issueDate = null;
        System.out.println("✓ Book '" + this.title + "' returned by " + previousMember);
        return previousMember;
    }
    
    /**
     * Check if book is available
     * @return true if available, false otherwise
     */
    public boolean isAvailable() {
        return this.isAvailable;
    }
    
    /**
     * Display book details
     */
    public void displayBookDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Book ID: " + this.bookId);
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Status: " + (this.isAvailable ? "Available" : "Issued"));
        if (!this.isAvailable) {
            System.out.println("Issued To: " + this.issuedTo);
            System.out.println("Issue Date: " + this.issueDate);
        }
        System.out.println("--------------------");
    }
    
    // Getters
    public String getBookId() {
        return bookId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getIssuedTo() {
        return issuedTo;
    }
    
    public String getIssueDate() {
        return issueDate;
    }
}

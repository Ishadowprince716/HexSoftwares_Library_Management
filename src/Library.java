/**
 * Library.java
 * Main library management class
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Library {
    private String libraryName;
    private List<Book> books;
    private List<Member> members;
    
    /**
     * Constructor to initialize library
     * @param libraryName Name of the library
     */
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    
    /**
     * Add a new book to the library
     * @param book The book to add
     * @throws IllegalArgumentException if book with same ID already exists
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        
        // Check if book already exists
        for (Book b : this.books) {
            if (b.getBookId().equals(book.getBookId())) {
                throw new IllegalArgumentException("Book with ID " + book.getBookId() + " already exists");
            }
        }
        
        this.books.add(book);
        System.out.println("✓ Book '" + book.getTitle() + "' added to library");
    }
    
    /**
     * Register a new member in the library
     * @param member The member to register
     * @throws IllegalArgumentException if member ID already exists
     */
    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        
        // Check if member already exists
        for (Member m : this.members) {
            if (m.getMemberId().equals(member.getMemberId())) {
                throw new IllegalArgumentException("Member with ID " + member.getMemberId() + " already exists");
            }
        }
        
        this.members.add(member);
        System.out.println("✓ Member '" + member.getName() + "' registered successfully");
    }
    
    /**
     * Issue a book to a member
     * @param memberId ID of the member
     * @param bookId ID of the book
     * @throws IllegalArgumentException if member or book not found
     * @throws IllegalStateException if book is already issued or member has reached limit
     */
    public void issueBook(String memberId, String bookId) {
        Member member = findMember(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member with ID " + memberId + " not found");
        }
        
        Book book = findBook(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book with ID " + bookId + " not found");
        }
        
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already issued");
        }
        
        if (member.hasReachedLimit()) {
            throw new IllegalStateException("Member has reached maximum book limit (5 books)");
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String issueDate = dateFormat.format(new Date());
        
        book.issueBook(member.getName(), issueDate);
        member.addIssuedBook(book);
    }
    
    /**
     * Return a book from a member
     * @param memberId ID of the member
     * @param bookId ID of the book
     * @throws IllegalArgumentException if member or book not found
     * @throws IllegalStateException if book is not issued to member
     */
    public void returnBook(String memberId, String bookId) {
        Member member = findMember(memberId);
        if (member == null) {
            throw new IllegalArgumentException("Member with ID " + memberId + " not found");
        }
        
        Book book = findBook(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book with ID " + bookId + " not found");
        }
        
        if (book.isAvailable()) {
            throw new IllegalStateException("Book is not issued");
        }
        
        if (!book.getIssuedTo().equals(member.getName())) {
            throw new IllegalStateException("Book is not issued to this member");
        }
        
        book.returnBook();
        member.removeIssuedBook(book);
    }
    
    /**
     * Find a book by ID
     * @param bookId The book ID to search for
     * @return Book if found, null otherwise
     */
    private Book findBook(String bookId) {
        for (Book book : this.books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Find a member by ID
     * @param memberId The member ID to search for
     * @return Member if found, null otherwise
     */
    private Member findMember(String memberId) {
        for (Member member : this.members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
    
    /**
     * Display all available books
     */
    public void displayAvailableBooks() {
        System.out.println("\n=== Available Books ===");
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        
        if (availableBooks.isEmpty()) {
            System.out.println("No available books.");
        } else {
            for (int i = 0; i < availableBooks.size(); i++) {
                Book book = availableBooks.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + 
                                 " (ISBN: " + book.getIsbn() + ")");
            }
        }
        System.out.println("========================");
    }
    
    /**
     * Display all issued books
     */
    public void displayIssuedBooks() {
        System.out.println("\n=== Issued Books ===");
        List<Book> issuedBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (!book.isAvailable()) {
                issuedBooks.add(book);
            }
        }
        
        if (issuedBooks.isEmpty()) {
            System.out.println("No issued books.");
        } else {
            for (int i = 0; i < issuedBooks.size(); i++) {
                Book book = issuedBooks.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " - Issued to: " + book.getIssuedTo() + 
                                 " (Date: " + book.getIssueDate() + ")");
            }
        }
        System.out.println("======================");
    }
    
    /**
     * Display all library books
     */
    public void displayAllBooks() {
        System.out.println("\n=== All Books in " + this.libraryName + " ===");
        if (this.books.isEmpty()) {
            System.out.println("Library has no books.");
        } else {
            for (int i = 0; i < this.books.size(); i++) {
                Book book = this.books.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + 
                                 " - Status: " + (book.isAvailable() ? "Available" : "Issued"));
            }
        }
        System.out.println("==============================");
    }
    
    /**
     * Display all members
     */
    public void displayAllMembers() {
        System.out.println("\n=== All Members ===");
        if (this.members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (int i = 0; i < this.members.size(); i++) {
                Member member = this.members.get(i);
                System.out.println((i + 1) + ". " + member.getName() + " (ID: " + member.getMemberId() + 
                                 ") - Books Issued: " + member.getIssuedBooksCount());
            }
        }
        System.out.println("===================");
    }
    
    /**
     * Display library statistics
     */
    public void displayStatistics() {
        int totalBooks = this.books.size();
        int availableBooks = 0;
        int issuedBooks = 0;
        
        for (Book book : this.books) {
            if (book.isAvailable()) {
                availableBooks++;
            } else {
                issuedBooks++;
            }
        }
        
        System.out.println("\n=== Library Statistics ===");
        System.out.println("Library Name: " + this.libraryName);
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Available Books: " + availableBooks);
        System.out.println("Issued Books: " + issuedBooks);
        System.out.println("Total Members: " + this.members.size());
        System.out.println("==========================");
    }
    
    // Getters
    public String getLibraryName() {
        return libraryName;
    }
    
    public int getTotalBooks() {
        return this.books.size();
    }
    
    public int getTotalMembers() {
        return this.members.size();
    }
}

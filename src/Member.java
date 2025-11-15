/**
 * Member.java
 * Represents a member/user of the library
 */

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Book> issuedBooks;
    private String membershipDate;
    
    /**
     * Constructor to create a new member
     * @param memberId Unique member ID
     * @param name Name of the member
     * @param email Email address
     * @param phoneNumber Phone number
     * @param membershipDate Date of membership
     */
    public Member(String memberId, String name, String email, String phoneNumber, String membershipDate) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipDate = membershipDate;
        this.issuedBooks = new ArrayList<>();
    }
    
    /**
     * Add issued book to member's list
     * @param book The book to add
     * @throws IllegalArgumentException if book is null
     */
    public void addIssuedBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        this.issuedBooks.add(book);
    }
    
    /**
     * Remove returned book from member's list
     * @param book The book to remove
     * @return true if book was removed, false otherwise
     */
    public boolean removeIssuedBook(Book book) {
        return this.issuedBooks.remove(book);
    }
    
    /**
     * Get number of books currently issued to member
     * @return Count of issued books
     */
    public int getIssuedBooksCount() {
        return this.issuedBooks.size();
    }
    
    /**
     * Check if member has reached maximum book limit (usually 5 books)
     * @return true if at limit, false otherwise
     */
    public boolean hasReachedLimit() {
        return this.issuedBooks.size() >= 5;
    }
    
    /**
     * Display all books issued to this member
     */
    public void displayIssuedBooks() {
        System.out.println("\n=== Books Issued to " + this.name + " ===");
        if (this.issuedBooks.isEmpty()) {
            System.out.println("No books issued.");
        } else {
            for (int i = 0; i < this.issuedBooks.size(); i++) {
                Book book = this.issuedBooks.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + 
                                 " (ISBN: " + book.getIsbn() + ")");
            }
        }
        System.out.println("================================");
    }
    
    /**
     * Display member details
     */
    public void displayMemberDetails() {
        System.out.println("\n--- Member Information ---");
        System.out.println("Member ID: " + this.memberId);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Membership Date: " + this.membershipDate);
        System.out.println("Books Issued: " + this.issuedBooks.size() + "/5");
        System.out.println("---------------------------");
    }
    
    // Getters
    public String getMemberId() {
        return memberId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getMembershipDate() {
        return membershipDate;
    }
    
    public List<Book> getIssuedBooks() {
        return new ArrayList<>(this.issuedBooks);
    }
}

/**
 * LibraryManagementSystem.java
 * Main class for library management system
 */

import java.util.Scanner;

public class LibraryManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library("Central Library");
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   Welcome to Library Management System      ║");
        System.out.println("║   HexSoftwares Internship Project           ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        // Initialize library with sample books
        initializeLibrary();
        
        // Display main menu
        try {
            displayMainMenu();
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Initialize library with sample books and members
     */
    private static void initializeLibrary() {
        System.out.println("Initializing library with sample data...\n");
        
        // Add books
        library.addBook(new Book("B001", "The Java Programming Language", "James Gosling", "978-0134685991"));
        library.addBook(new Book("B002", "Effective Java", "Joshua Bloch", "978-0134685402"));
        library.addBook(new Book("B003", "Clean Code", "Robert C. Martin", "978-0132350884"));
        library.addBook(new Book("B004", "Design Patterns", "Gang of Four", "978-0201633610"));
        library.addBook(new Book("B005", "The Pragmatic Programmer", "David Thomas", "978-0201616224"));
        
        System.out.println();
    }
    
    /**
     * Display main menu
     */
    private static void displayMainMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\n╔════════════════════════════════════════════════╗");
            System.out.println("║             Main Menu                        ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Book Management                         ║");
            System.out.println("║ 2. Member Management                      ║");
            System.out.println("║ 3. Issue/Return Books                      ║");
            System.out.println("║ 4. View Library Information                ║");
            System.out.println("║ 5. Demo: Sample Operations                 ║");
            System.out.println("║ 6. Exit                                    ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        handleBookManagement();
                        break;
                    case 2:
                        handleMemberManagement();
                        break;
                    case 3:
                        handleIssueReturnBooks();
                        break;
                    case 4:
                        handleViewLibraryInfo();
                        break;
                    case 5:
                        performDemoOperations();
                        break;
                    case 6:
                        running = false;
                        System.out.println("\nThank you for using Library Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("✗ Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("✗ Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
    /**
     * Handle book management operations
     */
    private static void handleBookManagement() {
        System.out.println("\n--- Book Management ---");
        System.out.println("1. View All Books");
        System.out.println("2. View Available Books");
        System.out.println("3. View Issued Books");
        System.out.println("4. Add New Book");
        System.out.print("Enter your choice: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    library.displayAvailableBooks();
                    break;
                case 3:
                    library.displayIssuedBooks();
                    break;
                case 4:
                    addNewBook();
                    break;
                default:
                    System.out.println("✗ Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    /**
     * Handle member management operations
     */
    private static void handleMemberManagement() {
        System.out.println("\n--- Member Management ---");
        System.out.println("1. View All Members");
        System.out.println("2. Register New Member");
        System.out.print("Enter your choice: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    library.displayAllMembers();
                    break;
                case 2:
                    registerNewMember();
                    break;
                default:
                    System.out.println("✗ Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    /**
     * Handle issue and return book operations
     */
    private static void handleIssueReturnBooks() {
        System.out.println("\n--- Issue/Return Books ---");
        System.out.println("1. Issue Book");
        System.out.println("2. Return Book");
        System.out.print("Enter your choice: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    issueBook();
                    break;
                case 2:
                    returnBook();
                    break;
                default:
                    System.out.println("✗ Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    /**
     * Handle library information display
     */
    private static void handleViewLibraryInfo() {
        System.out.println("\n--- Library Information ---");
        System.out.println("1. View Statistics");
        System.out.println("2. View Member Details");
        System.out.println("3. View Book Details");
        System.out.print("Enter your choice: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    library.displayStatistics();
                    break;
                case 2:
                    viewMemberDetails();
                    break;
                case 3:
                    viewBookDetails();
                    break;
                default:
                    System.out.println("✗ Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    /**
     * Add a new book to the library
     */
    private static void addNewBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        try {
            library.addBook(new Book(bookId, title, author, isbn));
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * Register a new member
     */
    private static void registerNewMember() {
        System.out.println("\n--- Register New Member ---");
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String membershipDate = dateFormat.format(new java.util.Date());
        
        try {
            library.addMember(new Member(memberId, name, email, phone, membershipDate));
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * Issue a book to a member
     */
    private static void issueBook() {
        System.out.println("\n--- Issue Book ---");
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        
        try {
            library.issueBook(memberId, bookId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * Return a book from a member
     */
    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        
        try {
            library.returnBook(memberId, bookId);
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * View member details and issued books
     */
    private static void viewMemberDetails() {
        System.out.print("\nEnter Member ID: ");
        String memberId = scanner.nextLine();
        // Would need to add findMember method in Library class
    }
    
    /**
     * View book details
     */
    private static void viewBookDetails() {
        System.out.print("\nEnter Book ID: ");
        String bookId = scanner.nextLine();
        // Would need to add findBook method (make it public) in Library class
    }
    
    /**
     * Perform demo operations
     */
    private static void performDemoOperations() {
        System.out.println("\n=== Demo: Sample Library Operations ===");
        
        try {
            // Register a member
            System.out.println("\n1. Registering new member...");
            Member member = new Member("M001", "Rajesh Kumar", "rajesh@email.com", "9876543210", "2025-11-15");
            library.addMember(member);
            
            // Issue books to member
            System.out.println("\n2. Issuing books to member...");
            library.issueBook("M001", "B001");
            library.issueBook("M001", "B002");
            
            // Display library statistics
            System.out.println("\n3. Library statistics after issuing books:");
            library.displayStatistics();
            
            // View available books
            System.out.println("\n4. Available books:");
            library.displayAvailableBooks();
            
            // View issued books
            System.out.println("\n5. Issued books:");
            library.displayIssuedBooks();
            
            // Return a book
            System.out.println("\n6. Returning a book...");
            library.returnBook("M001", "B001");
            
            // Final statistics
            System.out.println("\n7. Final library statistics:");
            library.displayStatistics();
            
            System.out.println("\n✓ Demo operations completed successfully!");
        } catch (Exception e) {
            System.out.println("✗ Error during demo: " + e.getMessage());
        }
    }
}

# HexSoftwares Library Management System

## Project Overview

This is a comprehensive **Library Management System** project built in Java as part of the HexSoftwares Internship Program. The system provides complete functionality for managing a library including books, members, and library operations with an interactive user interface.

## Features

### Core Functionality
- ✅ **Book Management** - Add, view, and track books in the library
- ✅ **Member Management** - Register and manage library members
- ✅ **Issue Books** - Issue books to members with validation
- ✅ **Return Books** - Accept book returns from members
- ✅ **Track Inventory** - Monitor which books are issued and available
- ✅ **Member Limits** - Enforce maximum of 5 books per member
- ✅ **Error Handling** - Prevent invalid operations
- ✅ **Statistics** - View library statistics and reports
- ✅ **Interactive Menu** - User-friendly command-line interface
- ✅ **Demo Operations** - Sample operations to showcase functionality

## Project Structure

```
HexSoftwares_Library_Management/
├── src/
│   ├── Book.java                    # Book class with issue/return logic
│   ├── Member.java                  # Member class managing issued books
│   ├── Library.java                 # Library class managing books and members
│   ├── LibraryManagementSystem.java  # Main class with interactive menu
│   └── LibrarySystemTest.java        # Unit tests (optional)
├── README.md                       # Project documentation
└── .gitignore                      # Git ignore file
```

## Class Description

### Book.java
Represents a book in the library system with the following methods:
- `issueBook(String memberName, String issueDate)` - Issue book to a member
- `returnBook()` - Return book to library
- `isAvailable()` - Check if book is available
- `displayBookDetails()` - Display book information

**Error Handling:**
- Prevents issuing already issued books
- Prevents returning books not in circulation
- Tracks member who issued the book

### Member.java
Represents a library member with these key methods:
- `addIssuedBook(Book book)` - Add book to member's list
- `removeIssuedBook(Book book)` - Remove returned book
- `getIssuedBooksCount()` - Get number of books member has
- `hasReachedLimit()` - Check if member has reached 5-book limit
- `displayIssuedBooks()` - Show all books member has

**Features:**
- Manages up to 5 books per member
- Tracks membership date
- Stores contact information

### Library.java
Core library management class with these operations:
- `addBook(Book book)` - Add new book to library
- `addMember(Member member)` - Register new member
- `issueBook(String memberId, String bookId)` - Issue book to member
- `returnBook(String memberId, String bookId)` - Accept book return
- `displayAvailableBooks()` - Show available books
- `displayIssuedBooks()` - Show issued books
- `displayStatistics()` - Show library statistics

**Validation:**
- Prevents duplicate book IDs
- Prevents duplicate member IDs
- Enforces member book limits
- Validates before operations

### LibraryManagementSystem.java
Main application class with interactive features:
- Menu-driven interface
- Book management operations
- Member management operations
- Issue/Return functionality
- Library information display
- Demo operations showcase

## How to Use

### Compilation
```bash
# Navigate to src directory
cd src

# Compile all Java files
javac *.java
```

### Execution
```bash
# Run the main program
java LibraryManagementSystem
```

### Main Menu Options
```
1. Book Management      - View and manage books
2. Member Management   - Register and view members
3. Issue/Return Books  - Issue or return books
4. View Library Info   - View statistics and details
5. Demo Operations     - Run sample transactions
6. Exit                - Close the application
```

## Usage Example

```java
// Create library
Library library = new Library("Central Library");

// Add books
Book book1 = new Book("B001", "Java Programming", "James Gosling", "978-0134685991");
library.addBook(book1);

// Register member
Member member = new Member("M001", "John Doe", "john@example.com", "555-1234", "2025-11-15");
library.addMember(member);

// Issue book
library.issueBook("M001", "B001");

// Return book
library.returnBook("M001", "B001");

// View statistics
library.displayStatistics();
```

## Error Handling Examples

### Book Already Issued
```
✗ Error: Book is already issued to John Doe
```

### Member Book Limit Reached
```
✗ Error: Member has reached maximum book limit (5 books)
```

### Member Not Found
```
✗ Error: Member with ID M999 not found
```

### Duplicate Member
```
✗ Error: Member with ID M001 already exists
```

## Demo Operations

The system includes a demo feature that performs sample operations:
1. Register a new member
2. Issue 2 books to the member
3. Display library statistics
4. Show available books
5. Show issued books
6. Return 1 book
7. Display final statistics

## Sample Data

The system initializes with 5 sample books:
1. "The Java Programming Language" by James Gosling
2. "Effective Java" by Joshua Bloch
3. "Clean Code" by Robert C. Martin
4. "Design Patterns" by Gang of Four
5. "The Pragmatic Programmer" by David Thomas

## Requirements

- **Java Version:** JDK 8 or higher
- **IDE:** Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command-line compiler
- **Operating System:** Windows, macOS, or Linux

## Key Concepts Demonstrated

- **Object-Oriented Programming (OOP)**
  - Encapsulation
  - Abstraction
  - Class design and relationships
  - Inheritance (extensible)

- **Data Structures**
  - ArrayList for managing collections
  - Proper object relationships

- **Error Handling**
  - Exception throwing and catching
  - Input validation
  - Business logic validation

- **User Interface**
  - Menu-driven application
  - Interactive operations
  - Formatted output

## Library Rules

- Maximum 5 books per member at any time
- Each book can only be issued to one member
- Members must be registered before issuing books
- Books must exist in library before issuing
- Issued books cannot be re-issued until returned

## Extension Ideas

Potential features to extend this system:
- Due date tracking and fine calculation
- Book reservation system
- Search functionality by title/author
- Member history tracking
- Book ratings and reviews
- Automated reminders for overdue books
- Database integration
- GUI implementation using Swing/JavaFX
- Barcode scanning for books
- Email notifications

## Testing

The application has been tested for:
- ✓ Adding and retrieving books
- ✓ Member registration
- ✓ Issuing and returning books
- ✓ Member book limit enforcement
- ✓ Duplicate prevention
- ✓ Error handling
- ✓ Statistics calculation
- ✓ Multiple concurrent members

## Author

**Rahul Singh Kushwah**
- GitHub: [@Ishadowprince716](https://github.com/Ishadowprince716)
- Email: patelmrrahul199@gmail.com
- Institution: RGPV University, Bhopal

## License

This project is created for educational purposes as part of the HexSoftwares Internship Program.

## Contact

For questions or suggestions about this project:
- **Email:** info@hexsoftwares.tech
- **Phone:** +91 9695040540
- **Website:** www.hexsoftwares.tech

## Acknowledgments

- HexSoftwares for providing the internship opportunity
- Thanks to all mentors and instructors for guidance

---

**Last Updated:** November 15, 2025
**Version:** 1.0.0

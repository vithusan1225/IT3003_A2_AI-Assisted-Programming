import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean available;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    void display() {
        System.out.println("Book ID: " + id +
                ", Title: " + title +
                ", Available: " + available);
    }
}

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Student ID: " + id +
                ", Name: " + name);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>(); //this this asked for the w3schools webside.

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully");
    }

    void viewBooks() {
        for (Book b : books) {
            b.display();
        }
    }

    void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully");
    }

    void viewStudents() {
        for (Student s : students) {
            s.display();
        }
    }

    void borrowBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId && b.available) {
                b.available = false;
                System.out.println("Book borrowed successfully");
                return;
            }
        }
        System.out.println("Book not available");
    }

    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                b.available = true;
                System.out.println("Book returned successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }
}


public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Student");
            System.out.println("4. View Students");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = input.nextInt();

                    input.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = input.nextLine();

                    library.addBook(new Book(bid, title));
                    break;


                case 2:
                    library.viewBooks();
                    break;


                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid = input.nextInt();

                    input.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    library.addStudent(new Student(sid, name));
                    break;


                case 4:
                    library.viewStudents();
                    break;


                case 5:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = input.nextInt();

                    library.borrowBook(borrowId);
                    break;


                case 6:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = input.nextInt();

                    library.returnBook(returnId);
                    break;


                case 7:
                    System.out.println("Exit");
                    System.exit(0);


                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
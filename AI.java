import java.util.*;

public class AI {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    // Book Class
    static class Book {
        int id;
        String title;
        String author;
        boolean available;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.available = true;
        }

        void display() {
            System.out.println(
                    "ID: " + id +
                            " | Title: " + title +
                            " | Author: " + author +
                            " | Status: " +
                            (available ? "Available" : "Borrowed")
            );
        }
    }


    // Student Class
    static class Student {
        int id;
        String name;
        ArrayList<Integer> borrowedBooks = new ArrayList<>();

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        void display() {
            System.out.println(
                    "ID: " + id +
                            " | Name: " + name +
                            " | Borrowed Books: " + borrowedBooks.size()
            );
        }
    }


    public static void main(String[] args) {

        while(true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Student");
            System.out.println("4. View Students");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            switch(choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    addStudent();
                    break;

                case 4:
                    viewStudents();
                    break;

                case 5:
                    borrowBook();
                    break;

                case 6:
                    returnBook();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    static void addBook() {

        sc.nextLine();

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book added successfully!");
    }


    static void viewBooks() {

        System.out.println("\n--- Book List ---");

        if(books.isEmpty()) {
            System.out.println("No books available");
        }

        for(Book b : books) {
            b.display();
        }
    }


    static void addStudent() {

        sc.nextLine();

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        students.add(new Student(id,name));

        System.out.println("Student added successfully!");
    }


    static void viewStudents() {

        System.out.println("\n--- Student List ---");

        if(students.isEmpty()) {
            System.out.println("No students registered");
        }

        for(Student s : students) {
            s.display();
        }
    }


    static void borrowBook() {

        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();

        System.out.print("Enter Book ID: ");
        int bid = sc.nextInt();


        Student student = findStudent(sid);
        Book book = findBook(bid);


        if(student == null) {
            System.out.println("Student not found!");
        }
        else if(book == null) {
            System.out.println("Book not found!");
        }
        else if(!book.available) {
            System.out.println("Book already borrowed!");
        }
        else {

            book.available = false;
            student.borrowedBooks.add(book.id);

            System.out.println("Book borrowed successfully!");
        }
    }


    static void returnBook() {

        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();

        System.out.print("Enter Book ID: ");
        int bid = sc.nextInt();


        Student student = findStudent(sid);
        Book book = findBook(bid);


        if(student != null && book != null) {

            if(student.borrowedBooks.contains(bid)) {

                student.borrowedBooks.remove(Integer.valueOf(bid));
                book.available = true;

                System.out.println("Book returned successfully!");

            } else {
                System.out.println("This student did not borrow this book!");
            }

        } else {
            System.out.println("Invalid Student or Book ID!");
        }
    }



    static Book findBook(int id) {

        for(Book b : books) {

            if(b.id == id)
                return b;
        }

        return null;
    }


    static Student findStudent(int id) {

        for(Student s : students) {

            if(s.id == id)
                return s;
        }

        return null;
    }
}
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
// Interface
interface LibraryOperations {
    void borrowBook(int bookId, int studentId);
    void returnBook(int bookId);
}
// Parent class (Inheritance)
class Person {
    protected int id;
    protected String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
// Student inherits Person
class Student extends Person {

    ArrayList<Book> borrowedBooks = new ArrayList<>();

    Student(int id, String name) {
        super(id, name);
    }

    void display() {
        System.out.println("Student ID: " + id +
                " | Name: " + name +
                " | Borrowed Books: " + borrowedBooks.size());
    }
}
// Book class
class Book {

    private int id;
    private String title;
    private String author;
    private boolean available;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }
    int getId() {
        return id;
    }
    String getTitle() {
        return title;
    }
    boolean isAvailable() {
        return available;
    }
    void setAvailability(boolean status) {
        available = status;
    }
    void display() {
        System.out.println(
                "Book ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Available: " + available
        );
    }
}

// Library class
class Library implements LibraryOperations {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();


    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully");
    }


    void viewBooks() {

        if(books.isEmpty()){
            System.out.println("No books available");
            return;
        }

        for(Book b : books)
            b.display();
    }
    void searchBook(String keyword){

        for(Book b : books){

            if(b.getTitle()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())){

                b.display();
            }
        }
    }
    void addStudent(Student student){

        students.add(student);
        System.out.println("Student registered successfully");

    }
    void viewStudents(){

        if(students.isEmpty()){
            System.out.println("No students registered");
            return;
        }

        for(Student s : students)
            s.display();
    }
    @Override
    public void borrowBook(int bookId, int studentId){

        Book selectedBook = null;
        Student selectedStudent = null;
        for(Book b : books){

            if(b.getId()==bookId)
                selectedBook=b;
        }


        for(Student s : students){

            if(s.id==studentId)
                selectedStudent=s;
        }
        if(selectedBook==null || selectedStudent==null){
            System.out.println("Invalid Book or Student ID");
            return;
        }
        if(selectedBook.isAvailable()){

            selectedBook.setAvailability(false);

            selectedStudent.borrowedBooks.add(selectedBook);

            System.out.println(
                    "Book borrowed on: "
                    + LocalDate.now()
            );

        }
        else{

            System.out.println("Book already borrowed");

        }

    }
    @Override
    public void returnBook(int bookId){

        for(Student s : students){

            for(Book b : s.borrowedBooks){

                if(b.getId()==bookId){

                    b.setAvailability(true);

                    s.borrowedBooks.remove(b);

                    System.out.println(
                            "Book returned successfully on "
                            + LocalDate.now()
                    );

                    return;
                }
            }
        }

        System.out.println("Borrow record not found");
    }

}

// Main class
public class AI {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        while(true){

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Student");
            System.out.println("5. View Students");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            System.out.print("Choice : ");

            int choice=sc.nextInt();



            try{

                switch(choice){


                    case 1:

                        System.out.print("Book ID: ");
                        int id=sc.nextInt();

                        sc.nextLine();

                        System.out.print("Title: ");
                        String title=sc.nextLine();

                        System.out.print("Author: ");
                        String author=sc.nextLine();


                        library.addBook(
                                new Book(id,title,author)
                        );

                        break;



                    case 2:

                        library.viewBooks();
                        break;



                    case 3:

                        sc.nextLine();

                        System.out.print("Search title: ");

                        library.searchBook(sc.nextLine());

                        break;




                    case 4:

                        System.out.print("Student ID: ");
                        int sid=sc.nextInt();

                        sc.nextLine();

                        System.out.print("Student Name: ");

                        String name=sc.nextLine();


                        library.addStudent(
                                new Student(sid,name)
                        );

                        break;




                    case 5:

                        library.viewStudents();
                        break;




                    case 6:

                        System.out.print("Book ID: ");
                        int bid=sc.nextInt();

                        System.out.print("Student ID: ");
                        int stid=sc.nextInt();


                        library.borrowBook(bid,stid);

                        break;




                    case 7:

                        System.out.print("Book ID: ");

                        library.returnBook(
                                sc.nextInt()
                        );

                        break;




                    case 8:

                        System.out.println("Thank you!");
                        System.exit(0);



                    default:

                        System.out.println("Invalid option");

                }


            }
            catch(Exception e){

                System.out.println("Error : "+e.getMessage());
                sc.nextLine();

            }

        }

    }
}
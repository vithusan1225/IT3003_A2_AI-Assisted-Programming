import java.util.*;

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<String> books = new ArrayList<>();
    static ArrayList<String> students = new ArrayList<>();
    static ArrayList<String> borrowedBooks = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Student");
            System.out.println("4. View Students");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book name: ");
                    books.add(sc.nextLine());
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.println("\nBooks:");
                    for (String book : books) {
                        System.out.println("- " + book);
                    }
                    break;

                case 3:
                    System.out.print("Enter student name: ");
                    students.add(sc.nextLine());
                    System.out.println("Student added!");
                    break;

                case 4:
                    System.out.println("\nStudents:");
                    for (String student : students) {
                        System.out.println("- " + student);
                    }
                    break;

                case 5:
                    System.out.print("Enter book name to borrow: ");
                    String borrow = sc.nextLine();

                    if (books.contains(borrow)) {
                        books.remove(borrow);
                        borrowedBooks.add(borrow);
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book not available!");
                    }
                    break;

                case 6:
                    System.out.print("Enter book name to return: ");
                    String returned = sc.nextLine();

                    if (borrowedBooks.contains(returned)) {
                        borrowedBooks.remove(returned);
                        books.add(returned);
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("This book was not borrowed!");
                    }
                    break;

                case 7:
                    System.out.println("Exit...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    String name;
    int mark;

    public StudentManagement(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public void display() {
        System.out.println(name + " - " + mark + " - Grade: " + getGrade());
    }

    public boolean isPass() {
        return mark >= 35;
    }

    public char getGrade() {
        switch (mark / 10) {
            case 10, 9:
                return 'A';
            case 8, 7:
                return 'B';
            case 6, 5:
                return 'C';
            case 4, 3:
                return 'D';
            default:
                return 'F';
        }
    }

    public boolean hasDistinction() {
        return mark >= 75;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<StudentManagement> students = new ArrayList<>();

        System.out.print("Enter number of students: ");

        int totalStudents;

        while (true) {
            if (sc.hasNextInt()) {
                totalStudents = sc.nextInt();
                if (totalStudents > 0) {
                    break;
                } else {
                    System.out.print("Enter a positive number: ");
                }
            } else {
                System.out.print("Invalid input! Enter an integer: ");
                sc.next();
            }
        }

        for (int i = 0; i < totalStudents; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.next();

            int mark;

            while (true) {

                System.out.print("Enter Marks (0-100): ");

                if (sc.hasNextInt()) {

                    mark = sc.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }

                } else {
                    System.out.println("Invalid input! Please enter an integer.");
                    sc.next();
                }
            }

            students.add(new StudentManagement(name, mark));
        }

        System.out.println("\n----- Student List -----");

        int passedStudents = 0;
        StudentManagement topper = students.get(0);

        for (StudentManagement student : students) {

            student.display();

            if (student.isPass()) {
                passedStudents++;
            }

            if (student.mark > topper.mark) {
                topper = student;
            }
        }

        System.out.println("\nPassed Students: " + passedStudents);

        System.out.println("Topper:");
        System.out.println(topper.name + " - " + topper.mark);

        System.out.print("\nEnter student name to search: ");
        String searchName = sc.next();

        boolean found = false;

        for (StudentManagement student : students) {

            if (student.name.equalsIgnoreCase(searchName)) {

                System.out.println("\nStudent Found");
                System.out.println("Name         : " + student.name);
                System.out.println("Marks        : " + student.mark);
                System.out.println("Grade        : " + student.getGrade());
                System.out.println("Pass         : " + (student.isPass() ? "Yes" : "No"));
                System.out.println("Distinction  : " + (student.hasDistinction() ? "Yes" : "No"));

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }

        sc.close();
    }
}
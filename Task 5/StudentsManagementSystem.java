import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollno;
    private String grade;

    // Parameterized Constructor to initialize values
    public Student(String name, int rollno, String grade) {
        this.name = name;
        this.rollno = rollno;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollno() { 
        return rollno;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nRoll Number: " + rollno + "\nGrade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> sts = new ArrayList<>();

    // Method to add new Student
    public void addStudent(Student student) {
        sts.add(student);
    }

    // Method to Display all Students
    public List<Student> getStudents() {
        return sts;
    }
    
    // Method to remove Student
    public void removeStudent(int rollno) {
        sts.removeIf(student -> student.getRollno() == rollno);
    }

    // Method to search a Student
    public Student SearchStudent(int rollNumber) {
        for (Student student : sts) {
            if (student.getRollno() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Method to save the data of the students into a file
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(sts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load the information of the students to a file
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            sts = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    } 
}

public class StudentsManagementSystem {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Students");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("7. Exit");
            System.out.print("Enter your Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    Student student = new Student(name, rollNumber, grade);
                    sms.addStudent(student);
                    System.out.println("Student Added.");
                    System.out.println();
                    break;
                
                case 2:
                	List<Student> allStudents = sms.getStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("No students in the system.");
                    } else {
                        for (Student s : allStudents) {
                            System.out.println(s);
                        }
                    }
                    System.out.println();
                    break;
                    
                case 3:
                	System.out.print("Enter Roll Number to Remove: ");
                    int rollToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    sms.removeStudent(rollToRemove);
                    System.out.println("Student Removed.");
                    System.out.println();
                    break;
                
                case 4:
                	System.out.print("Enter Roll Number to Search: ");
                    int rollToSearch = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    Student foundStudent = sms.SearchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Found Student: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    System.out.println();
                    break;
                
                case 5:
                    sms.saveToFile("students.dat");
                    System.out.println("Data saved to file.");
                    System.out.println();
                    break;
                
                case 6:
                    sms.loadFromFile("students.dat");
                    System.out.println("Data loaded from file.");
                    System.out.println();
                    break;
                
                case 7:
                    System.out.println("Thank You....");
                    System.out.println();
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid option. Enter a valid one.");
            }
        }
    }
}

import java.util.Scanner;

public class StudentGradeManagement {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = new String[5];
        int[][] grades = new int[5][3];

        String[] subjects = {"Subject 1", "Subject 2", "Subject 3"};

        // Step 1: Enter Students Data

        for (int i = 0; i < 5; i++) {

            System.out.print("Enter student " + (i + 1) + " name: ");
            names[i] = input.nextLine();

            for (int j = 0; j < 3; j++) {

                while (true) {

                    System.out.print("Enter grade for " + subjects[j] + ": ");
                    int grade = input.nextInt();

                    if (grade >= 0 && grade <= 100) {
                        grades[i][j] = grade;
                        break;
                    } else {
                        System.out.println("Invalid grade.");
                    }
                }
            }

            input.nextLine();
        }

        // Step 2: Main Menu

        int choice;

        do {

            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Show All Students names");
            System.out.println("2. Show all Students grades in each subject");
            System.out.println("3. Search Student by name");
            System.out.println("4. Count Passed Students");
            System.out.println("5. Show Average for each subject");
            System.out.println("6. Show Highest grade in each subject");
            System.out.println("7. Show Letter Grades");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n--- Students Names ---");

                    for (int i = 0; i < 5; i++) {
                        System.out.println(names[i]);
                    }

                    break;

                case 2:

                    System.out.println("\n--- Students Grades ---");

                    for (int i = 0; i < 5; i++) {

                        System.out.println("\nStudent: " + names[i]);

                        for (int j = 0; j < 3; j++) {
                            System.out.println(subjects[j] + ": " + grades[i][j]);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter student name to search: ");
                    String searchName = input.nextLine();

                    boolean found = false;

                    for (int i = 0; i < 5; i++) {

                        if (names[i].equalsIgnoreCase(searchName)) {

                            System.out.println("Student Found: " + names[i]);

                            for (int j = 0; j < 3; j++) {
                                System.out.println(subjects[j] + ": " + grades[i][j]);
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    int passedCount = 0;

                    for (int i = 0; i < 5; i++) {

                        int total = 0;

                        for (int j = 0; j < 3; j++) {
                            total += grades[i][j];
                        }

                        double average = total / 3.0;

                        if (average >= 50) {
                            passedCount++;
                        }
                    }

                    System.out.println("Number of passed students: " + passedCount);

                    break;

                case 5:

                    System.out.println("\n--- Subject Averages ---");

                    for (int j = 0; j < 3; j++) {

                        int total = 0;

                        for (int i = 0; i < 5; i++) {
                            total += grades[i][j];
                        }

                        double average = total / 5.0;

                        System.out.println(subjects[j] + " Average: " + average);
                    }

                    break;

                case 6:

                    System.out.println("\n--- Highest Grades ---");

                    for (int j = 0; j < 3; j++) {

                        int highest = grades[0][j];

                        for (int i = 1; i < 5; i++) {

                            if (grades[i][j] > highest) {
                                highest = grades[i][j];
                            }
                        }

                        System.out.println(subjects[j] + " Highest Grade: " + highest);
                    }

                    break;

                case 7:

                    System.out.println("\n--- Letter Grades ---");

                    for (int i = 0; i < 5; i++) {

                        System.out.println("\nStudent: " + names[i]);

                        for (int j = 0; j < 3; j++) {

                            int grade = grades[i][j];
                            char letter;

                            if (grade >= 85) {
                                letter = 'A';
                            } else if (grade >= 75) {
                                letter = 'B';
                            } else if (grade >= 65) {
                                letter = 'C';
                            } else if (grade >= 50) {
                                letter = 'D';
                            } else {
                                letter = 'F';
                            }

                            System.out.println(subjects[j] + ": " + letter);
                        }
                    }

                    break;

                case 0:

                    System.out.println("Exiting program... Goodbye!");

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        input.close();
    }
}


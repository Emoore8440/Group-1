package suppStud;

import java.util.ArrayList;
import java.util.Scanner;

public class StudLib {
    private ArrayList<StudProfile> profiles;
    private Scanner sc;

    public StudLib(ArrayList<StudProfile> profiles, Scanner sc) {
        this.profiles = profiles;
        this.sc = sc;
    }

    //Runs library menu
    public void runLibMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nStudent Library Menu:");
            System.out.println("1. Access Resources");
            System.out.println("2. Complete Intake Quiz");
            System.out.println("3. Exit");

            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    accessResources(); // Implement this method to display resources
                    break;
                case 2:
                    accessIntakeQuiz(); // Access quiz
                    break;
                case 3:
                    running = false; // Exit the menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //Displays a list of student support resources
    private void accessResources() {
        
        System.out.println("\n=================================");
        System.out.println("     Student Support Resources");
        System.out.println("=================================");

        System.out.println("\nFinancial Aid Resources");
        System.out.println("- FAFSA Information: https://studentaid.gov");
        System.out.println("- Scholarship Search: https://www.scholarships.com");
        System.out.println("- Emergency Student Grants");

        System.out.println("\nMental Health Support");
        System.out.println("- National Mental Health Hotline: 988");
        System.out.println("- Campus Counseling Center");

        System.out.println("\nLGBTQ+ Support");
        System.out.println("- The Trevor Project: https://www.thetrevorproject.org/");
        System.out.println("- Campus LGBTQ+ Resource Center");

        System.out.println("\nSTEM and Career Mentorship");
        System.out.println("- Women in Tech Mentorship Programs");
        System.out.println("- STEM Mentorship Club");

        System.out.println("\nBasic Needs Support");
        System.out.println("- Campus Food Pantry");
        System.out.println("- Housing Assistance Programs");

        System.out.println("\n---------------------------------");
        System.out.println("For more information, please visit your campus support services.");
        System.out.println("---------------------------------");
    }

    //The quiz is called from here StudLib which is called from StudHub
    private void accessIntakeQuiz() {
        int selectedProfileIndex = StudProfile.selectProfile(profiles, sc);
        if (selectedProfileIndex != -1) {
            StudProfile selectedProfile = profiles.get(selectedProfileIndex);
            StudReqs reqs = new StudReqs(selectedProfile); // Instantiate StudReqs with the selected profile
            reqs.runQuiz(sc); // Run the quiz
        } else {
            System.out.println("No valid profile selected.");
        }
    }
}
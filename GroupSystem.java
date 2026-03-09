package suppStud;
// This class manages the eligibility quiz for financial aid. The runQuiz() method gets the user's input, which includes annual income, number of dependents, 
//and health status. Individual methods, such as getIncome(), getDependents(), and getHealthStatus(), are first used to gauge the users situation.
//If it's a little more complicated, recursive calls allow for thorough gathering of information for each dependent. The determineEligibility() method 
//assesses whether the user qualifies for financial aid based on the provided criteria


import java.util.Scanner;
import java.util.InputMismatchException;

public class StudReqs {
    private StudProfile currentProfile;

    public StudReqs(StudProfile profile) {
        this.currentProfile = profile;
    }

    // Method running quiz using individual getters for each question.
    public void runQuiz(Scanner sc) {
        double income = getIncome(sc);
        int dependents = getDependents(sc);
        boolean hasDisability = getHealthStatus(sc);

        String result = determineEligibility(income, dependents, hasDisability);
        System.out.println(result);
    }

    private double getIncome(Scanner sc) {
        while (true) {
            try {
                System.out.print("Please enter your annual income: ");
                double income = sc.nextDouble();
                sc.nextLine(); // Consume the newline character

                if (income < 0) {
                    System.out.println("Income cannot be negative.");
                } else {
                    return income;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    private int getDependents(Scanner sc) {
        while (true) {
            try {
                System.out.print("How many dependents do you have? ");
                int dependents = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                if (dependents < 0) {
                    System.out.println("Number of dependents cannot be negative.");
                } else {
                    if (dependents > 0) {
                        gatherDependentInformation(sc, dependents);
                    }
                    return dependents;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.nextLine();
            }
        }
    }

    private boolean getHealthStatus(Scanner sc) {
        while (true) {
            System.out.print("Do you have any debilitating health issues or disabilities? (yes/no): ");
            String response = sc.nextLine().toLowerCase();

            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                return false;
            } else {
                System.out.println("Please answer with 'yes' or 'no'.");
            }
        }
    }

    private void gatherDependentInformation(Scanner sc, int numDependents) {
        if (numDependents <= 0) return; // Recursion base case

        int age;
        while (true) {
            try {
                System.out.println("Entering details for dependent " + numDependents + ":");
                System.out.print("Enter age: ");
                age = sc.nextInt();
                sc.nextLine();

                if (age < 0) {
                    System.out.println("Age cannot be negative.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.nextLine();
            }
        }

        boolean hasDisability;
        while (true) {
            System.out.print("Does this individual have any disabilities? (yes/no): ");
            String disabilityResponse = sc.nextLine().toLowerCase();

            if (disabilityResponse.equals("yes")) {
                hasDisability = true;
                break;
            } else if (disabilityResponse.equals("no")) {
                hasDisability = false;
                break;
            } else {
                System.out.println("Please answer with 'yes' or 'no'.");
            }
        }

        System.out.println("Entry: Age: " + age + ", Disability: " + hasDisability);
        // Recursive call for the next dependent
        gatherDependentInformation(sc, numDependents - 1);
    }

    private String determineEligibility(double income, int dependents, boolean hasDisability) {
    	// Eligibility logic based on income, dependents, and health
        if (income < 25000 || dependents > 2 || hasDisability) {
            return "You are eligible for financial aid.";
        } else if (income < 50000) {
            return "You may be eligible for some financial aid or scholarships.";
        } else {
            return "Unfortunately, you may not qualify for financial aid based on your income and other considerations.";
        }
    }
}
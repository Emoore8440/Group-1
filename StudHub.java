package suppStud;
// Central hub branching into each class through a switch statement. 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudHub {
	//Holds user generated profiles
    private ArrayList<StudProfile> profiles = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private boolean runna = true;
    private StudMail studMail = new StudMail();
    	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudHub hub = new StudHub();
        hub.runMenu();
	}
	
	//Runs main start menu, calling each class when chosen
	private void runMenu() {
		StudProfile selectedProfile = null;
        while (runna) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Profile Management");
            System.out.println("2. Mail");
            System.out.println("3. Resources");
            System.out.println("4. Connect");
            System.out.println("5. Quit");

            System.out.print("Select an option: ");
            int mainChoice = -1;
            try {
            mainChoice = sc.nextInt();}
            catch(InputMismatchException e) {
            	System.out.println("Error.");
            }
            sc.nextLine();

            switch (mainChoice) {
                case 1:
                	selectedProfile = StudProfile.runProfileMenu(profiles, sc);  // Call profile management menu
                    break;
                case 2:
                	  if (selectedProfile != null) {
                          studMail.runMailMenu(sc, selectedProfile); // Pass the selected profile to the mail menu
                      } else {
                          System.out.println("Please select a profile first.");
                      }
                	break;
                case 3:
                	  StudLib libMenu = new StudLib(profiles, sc);
                      libMenu.runLibMenu(); 
                      break;
                case 4: 
                	GroupSystem.runGroupSystem();
                	break;
                case 5:
                    runna = false;
                    System.out.println(" | | | Exiting Application | | | ");
                    break;
                default:
                    System.out.println("Invalid! Try again.");
            }
        }
  	}
}

package suppStud;
//This class implements a messaging system for individual student profiles, enabling users to send messages to predefined recipients 
//and view their sent messages. StudMail handles several lists normal array and hashed to send strings between lists
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudMail {
	//Hashmaps only purpose is to store sent messages with their respective profile, else all profiles can read each others messages.
	//Likely didn't matter but it annoyed me and I couldn't figure it out without.
	//Not part of course material I doubt it'll be docked off but if anybody disagrees to be safe let me know. I will ask Prof. Meredith
	  private Map<StudProfile, List<String>> profileMessages = new HashMap<>();
	  
	  //Non-array List storing mailing list
	    private static final String[] recipientList = {
	    		"stemclub@school.edu",
	    		"womenintech@school.edu",
	    		"lgbtqsupport@school.edu",
	    		
	    };

	    //Mail menu handler
	    public void runMailMenu(Scanner sc, StudProfile currentProfile) {
	        boolean runna = true;
	        while (runna) {
	            System.out.println("\nMail Menu:");
	            System.out.println("1. Send a Message");
	            System.out.println("2. View Sent Messages");
	            System.out.println("3. Back to Main Menu");

	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    sendMessage(sc, currentProfile);
	                    break;
	                case 2:
	                    viewSentMessages(currentProfile);
	                    break;
	                case 3:
	                    runna = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    //Method handles sending emails 
	    private void sendMessage(Scanner sc, StudProfile currentProfile) {
	        System.out.println("Select a recipient:");
	        for (int i = 0; i < recipientList.length; i++) {
	            System.out.println(i + ". " + recipientList[i]);
	        }
	        System.out.print("Choose a recipient (0 to " + (recipientList.length - 1) + "): ");
	        int recipientIndex = sc.nextInt();
	        sc.nextLine();

	        if (recipientIndex < 0 || recipientIndex >= recipientList.length) {
	            System.out.println("Invalid recipient selection.");
	            return;
	        }

	        System.out.print("Enter your message: ");
	        String message = sc.nextLine();
	        
	        //Storing sent messages to a new arrayList if a new currentProfile key is found, usually when a new profile is selected.
	        profileMessages.computeIfAbsent(currentProfile, k -> new ArrayList<>()).add("To: " + recipientList[recipientIndex] + "\nMessage: " + message);
	        System.out.println("Message sent!");
	    }

	    //Self-explanatory
	    private void viewSentMessages(StudProfile currentProfile) {
	    	List<String> messages = profileMessages.get(currentProfile);
	        if (messages == null || messages.isEmpty()) {
	            System.out.println("No messages sent.");
	        } else {
	            System.out.println("\nOutgoing Messages:");
	            for (String msg : messages) {
	                System.out.println(msg);
	                System.out.println("------------------");
	            }
	        }
	   }
	    
}

import java.util.Scanner;

public class SearchAndSort {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("What algorithm would you like to execute? bubble, selection, insertion, merge, linear, binary? Type \"quit?\" to exit");
		Boolean running = true;
		String type = in.nextLine().toLowerCase();
		String data = in.nextLine().toLowerCase();
		String store = in.nextLine().toLowerCase();

		while (running == true) {
			switch(type) {
			case "bubble":
				System.out.println("What type of data? integers or strings?");
				if (data == "integers") {
					System.out.println("How would you like to store it? An array or list?");
					if (store == "array") {
						///
					}
					else if (store == "list") {
						
					}
				}
				else if (data == "strings") {
					System.out.println("How would you like to store it? An array or list?");
					if (store == "array") {
						///
					}
					else if (store == "list") {
						///
					}
				}
				else {
					System.out.println("Please try again");
				}
			case "selection":
				
			case "insertion":
				
			case "merge":
				
			case "linear":
				
			case "binary":
				
			case "quit":
				System.out.println("Goodbye!");
				running = false;
		}
			}
		}
			
	
}
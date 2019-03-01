import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchAndSort {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("What algorithm would you like to execute? bubble, selection, insertion, merge, linear, binary? Type \"quit?\" to exit");
		Boolean running = true;
		String type = in.nextLine().toLowerCase();
		String data = in.nextLine().toLowerCase();
		String store = in.nextLine().toLowerCase();
		String numbers = in.nextLine();
		String target = in.nextLine().toLowerCase();
		
		while (running == true) {
			switch(type) {
			case "bubble":
				System.out.println("What type of data? integers or strings?");
				if (data == "integers") {
					System.out.println("How would you like to store it? An array or list?");
					//Array of Integers
					if (store == "array") {
						System.out.println("What are the values you would like in the list? Only numbers and commas are allowed; no spaces.");
						if (numbers.matches("[0-9, /,]+")) {
							String[] convertedNumberArray = numbers.split(",");
							int[] intArray = new int[convertedNumberArray.length];
						    for (int i = 0; i < convertedNumberArray.length; i++) {
						         String numberAsString = convertedNumberArray[i];
						         intArray[i] = Integer.parseInt(numberAsString);
						      }
							bubbleSort(intArray);
						}
						
					} 
					//List of Integers
					else if (store == "list") {
						System.out.println("What are the values you would like in the list? Only numbers and commas are allowed; no spaces.");
						if (numbers.matches("[0-9, /,]+")) {
							String[] convertedNumbersArray = numbers.split(",");
							List<Integer> convertedNumberList = new ArrayList<Integer>();
							for (String number : convertedNumbersArray) {
							    convertedNumberList.add(Integer.parseInt(number.trim()));
							}
							//bubbleSort(convertedNumberList);
						}
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
	public static int[] bubbleSort(int[] input) {
		for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input.length; j++) {
                if(input[i] < input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
		return input;
    }
	
	public static List<Integer> bubbleSort(List<Integer> input) {
		for(int i = 0; i < input.size(); i++) {
            for(int j = 0; j < input.size(); j++) {
                if(input.get(i) < input.get(j)) {
                    int temp = input.get(i);
                    input.set(i, input.get(j));
                    input.set(j, temp);
                }
            }
        }
		return input;
    }
	
	public static String bubbleSort(String input) {
		for(int i = 0; i < input.length(); i++) {
            for(int j = 0; j < input.length(); j++) {
                /*if(input.(i) < input.get(j)) {
                    int temp = input.get(i);
                    input.set(i, input.get(j));
                    input.set(j, temp);
                }*/
            }
        }
		return input;
    }
}
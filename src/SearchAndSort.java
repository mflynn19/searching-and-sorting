import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchAndSort {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("What algorithm would you like to execute? bubble, selection, insertion, merge, linear, binary? Type \"quit?\" to exit");
		String type = in.nextLine().toLowerCase();
		String data;
		String store;
		String numbers;
		
		//INPUT DATA
		do {
			System.out.println("What type of data? integers or strings?");
			data = in.nextLine().toLowerCase();
		} 
		while (!(type.matches("bubble") || type.matches("selection") || type.matches("insertion") || type.matches("merge") || type.matches("linear")));
		
		//RETURN DATA TYPE
		do {
			System.out.println("How would you like to store it? An array or list?");
			store = in.nextLine().toLowerCase();
		} 
		while (!(store.matches("list") || store.matches("array")));
	
		//VALUES TO INSERT
		do {
			System.out.println("What are the values you would like in the list? Only numbers and commas are allowed; no spaces.");
			numbers = in.nextLine();
			
		} 
		while (!(numbers.matches("[0-9, /,]+")));
		
		//actual options of what to do
		switch(type) {
			case "bubble":
				if (data == "integers") {
					if (store == "array") {
						String[] convertedNumberArray = numbers.split(",");
						int[] intArray = new int[convertedNumberArray.length];
					    for (int i = 0; i < convertedNumberArray.length; i++) {
					         String numberAsString = convertedNumberArray[i];
					         intArray[i] = Integer.parseInt(numberAsString);
					      }
						bubbleSort(intArray);
						}
					else if (store == "list") {
						System.out.println("What are the values you would like in the list? Only numbers and commas are allowed; no spaces.");
						String[] convertedNumbersArray = numbers.split(",");
						List<Integer> convertedNumberList = new ArrayList<Integer>();
						for (String number : convertedNumbersArray) {
						    convertedNumberList.add(Integer.parseInt(number.trim()));
						}
						bubbleSort(convertedNumberList);
					}
			
				}
				else if (data == "strings") {
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
			if (data == "integers") {
				if (store == "array") {
					String[] convertedNumberArray = numbers.split(",");
					int[] intArray = new int[convertedNumberArray.length];
				    for (int i = 0; i < convertedNumberArray.length; i++) {
				         String numberAsString = convertedNumberArray[i];
				         intArray[i] = Integer.parseInt(numberAsString);
				      }
					selectionSort(intArray);
				}
				else if (store == "list") {
					System.out.println("What are the values you would like in the list? Only numbers and commas are allowed; no spaces.");
					String[] convertedNumbersArray = numbers.split(",");
					List<Integer> convertedNumberList = new ArrayList<Integer>();
					for (String number : convertedNumbersArray) {
					    convertedNumberList.add(Integer.parseInt(number.trim()));
					}
					selectionSort(convertedNumberList);
				}
			}
			else if (data == "strings") {
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
		case "insertion":
			
		case "merge":
			
		case "linear":
			
		case "binary":
			
		case "quit":
			System.out.println("Goodbye!");
	}
	}

	//BUBBLE SORT INTEGER ARRAY 
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
	//BUBBLE SORT INTEGER LIST
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
	//BUBBLE SORT STRING ARRAY
	/*public static String bubbleSort(String input) {
		for(int i = 0; i < input.length(); i++) {
            for(int j = 0; j < input.length(); j++) {
                if(input.get(i) < input.valueOf(j)) {
                    int temp = input.get(i);
                    input.set(i, input.get(j));
                    input.set(j, temp);
                }
            }
        }
		return input;
    }
	//BUBBLE SORT STRING LIST
	public static List<Integer> bubbleSort(String input) {
		for(int i = 0; i < input.length(); i++) {
            for(int j = 0; j < input.length(); j++) {
            	 if((input.get(i)).compareToIgnoreCase(input.get(j))<0){
            		 String t = input.get(j);
            		 input.get(j)=input.get(i);
            		 arr.get(i)=t;
            	 }

            }
        }
		return input;
    }*/
	
	//SELECTION SORT INTEGER ARRAY
	public static int[] selectionSort(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
            int min_idx = i;
            for (int j = i+1; j < input.length; j++)
                if (input[j] < input[min_idx])
                    min_idx = j;

            int temp = input[min_idx];
            input[min_idx] = input[i];
            input[i] = temp;
		}
		return input;
	}
	
	//SELECTION SORT INTEGER LIST
	public static List<Integer> selectionSort(List<Integer> input) {
		for (int i = 0; i < input.size() - 1; i++) {
            int min_idx = i;
            for (int j = i+1; j < input.size(); j++)
                if (input.get(j) < input.get(min_idx))
                    min_idx = j;

            int temp = input.get(min_idx);
            input.set(min_idx, input.get(i));
            input.set(i, temp);
		}
		return input;
    }
	
	//NEED 2 SELECTION SORTS FOR STRINGS
}
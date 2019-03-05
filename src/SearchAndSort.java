import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SearchAndSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SearchAndSort search = new SearchAndSort();

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
		
		String[] dataArray = numbers.split(",");
		String[] strings = numbers.split(",");
		
		//actual options of what to do
		switch(type) {
			case "bubble":
				if (data == "integers") {
					if (store == "array") {
						int ints[] = new int[dataArray.length]; 
						for (int i = 0; i < dataArray.length; i++) {
				            ints[i] = Integer.parseInt(dataArray[i]);
						}
						System.out.println(Arrays.toString(ints));
						System.out.println("Bubble Sort: " + Arrays.toString(search.bubbleSort(ints)));
						break; 
					}
					else if (store == "list") {
						ArrayList<Integer> newList = new ArrayList<Integer>(strings.length);
						for (int i = 0; i < strings.length; i++) {
							newList.add(Integer.parseInt(strings[i])); 
						}
						System.out.println("Bubble Sort: " + search.bubble(newList));
						break; 
					}
				else if (data == "strings") {
					if (store == "array") {
						System.out.println("Bubble Sort: " + Arrays.toString(search.bubbleSort(strings)));
						break; 
					}
					else if (store == "list") {
						ArrayList<String> nList = new ArrayList<String>(strings.length); 
						for (int i = 0; i < strings.length; i++) {
							nList.add(strings[i]);
						}
					}
				}
				else {
					System.out.println("Please try again");
				}
				}
				break;
				
		case "selection":
			if (data == "integers") {
				if (store == "array") {
					/// 
				}
				else if (store == "list") {
					///
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
			}
			break;
			
		case "insertion":
			
		case "merge":
			
			
		case "linear":
			
			
		case "binary":
			
		case "quit":
			in.close();
			System.out.println("Goodbye!");
			return;
		}
	}

	//BUBBLE SORT INTEGER ARRAY 
	private int[] bubbleSort(int[] input) {
		for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input.length; j++) {
                if(input[j] > input[j + 1]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
		return input;
	}
	
	//BUBBLE SORT STRING ARRAY
	public String[] bubbleSort(String[] input) {
		int n = input.length; 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (Integer.parseInt(input[j]) > Integer.parseInt(input[j + 1])) { 
                    String temp = input[j]; 
                    input[j] = input[j + 1]; 
                    input[j + 1] = temp; 
                } 
        return input; 
	}
	
	//BUBBLE SORT INTEGER LIST
	public ArrayList<Integer> bubble(ArrayList<Integer> input) {
		int n = input.size(); 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (input.get(j) > input.get(j + 1)) { 
                	input.set(j, input.set(j + 1, input.get(j)));
                }
        return input; 
	}
	
	//BUBBLE SORT STRING LIST
	public ArrayList<String> bubbleSort(boolean test, ArrayList<String> data) {
		int n = data.size(); 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (Integer.parseInt(data.get(j)) > Integer.parseInt(data.get(j + 1))) { 
                	data.set(j, data.set(j + 1, data.get(j)));
                }
        return data; 
	}
	
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
	
	//SELECTION SORT STRING ARRAY
	public static String[] selectionSort(String [] input) {
		int n = input.length; 
        for (int i = 0; i < n-1; i++) { 
            int min_idx = i; 
            for (int j = i + 1; j < n; j++) 
                if (Integer.parseInt(input[j]) < Integer.parseInt(input[min_idx])) 
                    min_idx = j; 
  
            String temp = input[min_idx]; 
            input[min_idx] = input[i]; 
            input[i] = temp; 
        } 
        return input; 
	}
		
	//SELECTION SORT STRING LIST
	public ArrayList<String> selectionSortString(ArrayList<String> stringArray){
		for(int i = 0; i < stringArray.size(); i++) {
			int minindex = i;
			
			for(int j = i +1; j<stringArray.size(); j++) {
				if(stringArray.get(j).compareTo(stringArray.get(minindex))<0) {
					minindex = j;
				}
			}
			
			String temp = stringArray.get(i);
			stringArray.set(i, stringArray.get(minindex));
			stringArray.set(minindex, temp);
		}
		return stringArray;
	}
	
	//INSERTION SORT INTEGER ARRAY
	public int[] insertionSort(int[] input) {
		int n = input.length; 
        for (int i = 1; i < n; ++i) { 
            int key = input[i]; 
            int j = i - 1; 
  
            while (j >= 0 && input[j] > key) { 
                input[j + 1] = input[j]; 
                j = j-1; 
            } 
            input[j + 1] = key; 
        } 
        return input; 
	}
	
	//INSERTION SORT STRING ARRAY
	public String[] insertionSort(String[] input) {
		int n = input.length; 
        for (int i = 1; i < n; ++i) 
        { 
            String key = input[i]; 
            int j = i - 1; 
  
            while (j >= 0 && Integer.parseInt(input[j]) > Integer.parseInt(key)) 
            { 
                input[j + 1] = input[j]; 
                j = j - 1; 
            } 
            input[j + 1] = key; 
        }
        return input; 
	}
		
	//INSERTION SORT INTEGER LIST
	public ArrayList<String> insertionSort(ArrayList<String> input){
		for(int i = 1; i < input.size(); i++) {
			String key = input.get(i);
			int j = i-1;
			
			while(j >= 0 && input.get(j).compareTo(key) > 0) {
				input.set(j + 1, input.get(j));
				j--;
			}
			input.set(j + 1, key);
		}
		return input;
	}
	
	//INSERTION SORT STRING LIST
		
}
	

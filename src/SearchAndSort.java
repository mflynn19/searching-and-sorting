import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class SearchAndSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SearchAndSort sort = new SearchAndSort();
		System.out.println("What algorithm would you like to execute? bubble, selection, insertion, merge, linear, binary? Type \"quit?\" to exit");
		String type = in.nextLine().toLowerCase();
		String target = "";
		if (type.equals("linear") || type.equals("binary")) {
			do {
				System.out.println("What is the number you're searching for? ");
				target = in.nextLine();
			} while (!(type.matches("[0-9]")));
		}
		else if(type.equals("quit")) {
			System.exit(0);
		}
		
		String data;
		String store;
		String numbers;
		
		do {
			System.out.println("What type of data? integers or strings?");
			data = in.nextLine().toLowerCase();
		} 
		while (!(type.matches("bubble") || type.matches("selection") || type.matches("insertion") || type.matches("merge") || type.matches("linear")));
		
		do {
			System.out.println("How would you like to store it? An array or list?");
			store = in.nextLine().toLowerCase();
		} 
		while (!(store.matches("list") || store.matches("array")));
	
		do {
			System.out.println("What are the values you would like in the list? Only numbers and commas are allowed; no spaces.");
			numbers = in.nextLine();
		} 
		while (!(numbers.matches("[0-9, /,]+")));
	
	//OPTIONS
	if (store.equals("array")) {
		if (data.equals("integers")) {
			String[] intArray = numbers.split(",");
			Integer ints[] = new Integer[intArray.length]; 
			for (int i = 0; i < intArray.length; i++) 
	            ints[i] = Integer.parseInt(intArray[i]);
			System.out.println(Arrays.toString(ints));
			
			switch (type) {
				case "bubble":
					System.out.println("Bubble Sort: " + Arrays.toString(sort.bubbleSort(ints)));
					break; 
				case "selection":
					System.out.println("Selection Sort: " + Arrays.toString(sort.selectionSort(ints)));
					break;
				case "insertion": 
					System.out.println("Insertion Sort: " + Arrays.toString(sort.insertionSort(ints)));
					break;
				case "merge":
					System.out.println("Merge Sort: " + Arrays.toString(sort.mergeSort(ints)));
					break;
				case "linear":
					System.out.println("Linear Search: " + sort.linearSearch(ints, target));
					break;
				case "binary": 
					System.out.println("Binary Search: " + sort.binarySearch(ints, target));
					break; 
			}
		}
		else if (store.equals("strings")) {
			String[] stringArray = numbers.split(",");
			System.out.println(Arrays.toString(stringArray));
			
			switch (type) {
				case "bubble":
					System.out.println("Bubble Sort: " + Arrays.toString(sort.bubbleSort(stringArray)));
					break; 
				case "selection":
					System.out.println("Selection Sort: " + Arrays.toString(sort.selectionSort(stringArray)));
					break;
				case "insertion": 
					System.out.println("Insertion Sort: " + Arrays.toString(sort.insertionSort(stringArray)));
					break;
				case "merge":
					System.out.println("Merge Sort: " + Arrays.toString(sort.mergeSort(stringArray)));
					break;
				case "linear":
					System.out.println("Linear Search: " + sort.linearSearch(stringArray, target));
					break;
				case "binary": 
					System.out.println("Binary Search: " + sort.binarySearch(stringArray, target));
					break; 
				}
		}
	}
	else if (store.equals("list")) {
		if (data.equals("integers")) {
			String[] strings = numbers.split(",");
			ArrayList<Integer> intList = new ArrayList<Integer>(strings.length);
			for (int i = 0; i < strings.length; i++) {
				intList.add(Integer.parseInt(strings[i])); 
			}
			System.out.println(Arrays.toString(strings));
			
			switch (type) {
			case "bubble":
				System.out.println("Bubble Sort: " + sort.bubbleSort(intList));
				break; 
			case "selection":
				System.out.println("Selection Sort: " + sort.selectionSort(intList));
				break;
			case "insertion": 
				System.out.println("Insertion Sort: " + sort.insertionSort(intList));
				break;
			case "merge":
				System.out.println("Merge Sort: " + sort.mergeSort(intList));
				break;
			case "linear":
				System.out.println("Linear Search: " + sort.linearSearch(intList, target));
				break;
			case "binary": 
				System.out.println("Binary Search: " + sort.binarySearch(intList, target));
				break; 
			}

		}
		else if (data.equals("strings")) {
			String[] strings = numbers.split(",");
			ArrayList<String> stringList = new ArrayList<String>(strings.length); 
			for(int i = 0; i < strings.length; i++) {
				stringList.add(strings[i]);
			}
			System.out.println(Arrays.toString(strings)); 
			
			switch (type) {
			case "bubble":
				System.out.println("Bubble Sort: " + sort.bubbleSortString(stringList));
				break; 
			case "selection":
				System.out.println("Selection Sort: " + sort.selectionSortString(stringList));
				break;
			case "insertion": 
				System.out.println("Insertion Sort: " + sort.insertionSortString(stringList));
				break;
			case "merge":
				System.out.println("Merge Sort: " + sort.mergeSortString(stringList));
				break;
			case "linear":
				System.out.println("Linear Search: " + sort.linearSearchString(stringList, target));
				break;
			case "binary": 
				System.out.println("Binary Search: " + sort.binarySearchString(stringList, target));
				break; 
			}
		}
	}
}

		
	//BUBBLE SORT INTEGER ARRAY 
	public Integer[] bubbleSort(Integer[] input) {
		int n = input.length; 
		for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if ( input[j] > input[j+1])
                { 
                	int temp = input[j];
                	input[j] = input[j + 1];
                	input[j + 1] = temp;
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
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> input) {
		int n = input.size(); 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (input.get(j) > input.get(j + 1)) { 
                	input.set(j, input.set(j + 1, input.get(j)));
                }
        return input;
	}
	
	//BUBBLE SORT STRING LIST
	public ArrayList<String> bubbleSortString(ArrayList<String> input) {
		int n = input.size(); 
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++) 
                if (Integer.parseInt(input.get(j)) > Integer.parseInt(input.get(j + 1))) { 
                	input.set(j, input.set(j + 1, input.get(j)));
                }
        return input; 
	}
	
	//SELECTION SORT INTEGER ARRAY
	public Integer[] selectionSort(Integer[] input) {
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
	public ArrayList<Integer> selectionSort(ArrayList<Integer> input) {
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
	public String[] selectionSort(String [] input) {
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
			
			for(int j = i + 1; j < stringArray.size(); j++) {
				if(stringArray.get(j).compareTo(stringArray.get(minindex)) < 0) {
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
	public Integer[] insertionSort(Integer[] input) {
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
		
	//INSERTION SORT STRING LIST
	public ArrayList<String> insertionSortString(ArrayList<String> input){
		for(int i = 1; i < input.size(); i++) {
			String key = input.get(i);
			int j = i - 1;
			
			while(j >= 0 && input.get(j).compareTo(key) > 0) {
				input.set(j + 1, input.get(j));
				j--;
			}
			input.set(j + 1, key);
		}
		return input;
	}
	
	//INSERTION SORT INTEGER LIST
	public ArrayList<Integer> insertionSort(ArrayList<Integer> input) {
		int n = input.size(); 
        for (int i = 1; i < n; ++i) 
        { 
            int key = input.get(i); 
            int j = i - 1; 
  
            while (j >= 0 && input.get(j) > key) { 
            	input.set(j + 1, input.get(j));
            } 
            input.set(j + 1, key); 
        }
        return input; 
	}
	
	//MERGE SORT INTEGER ARRAY
	public Integer[] mergeSort(Integer[] input) {
		if (input.length == 1) {
			return input;
		}
		Integer[] first = Arrays.copyOfRange(input, 0, input.length/ 2);
		Integer[] second = Arrays.copyOfRange(input, input.length/ 2, input.length);
        
		first = mergeSort(first);
		second = mergeSort(second);
		
		int i = 0, j = 0, k = 0; 
        while (i < first.length && j < second.length) { 
            if (first[i] <= second[j]) { 
                input[k] = first[i]; 
                i++; 
            } 
            else { 
                input[k] = first[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < first.length) { 
            input[k] = first[i]; 
            i++; 
            k++; 
        } 
        while (j < second.length) { 
            input[k] = second[j]; 
            j++; 
            k++; 
        } 

		return input;
	}
	
	
	//MERGE SORT STRING ARRAY
	public String[] mergeSort(String[] input) {
		int length = input.length;
		int midpoint = (int) length/2;
		
		if (length < 2) {
			return input;
		}
		
		String[] first = new String[midpoint];
		for (int i = 0; i < midpoint; i++) {
			first[i] = input[i];
		}
		String[] second = new String[length - midpoint];
		for (int i = midpoint; i < length; i++) {
			second[i-midpoint] = input[i];
		}
		
		first = mergeSort(first);
		second = mergeSort(second);
		
		int i = 0;
		int j = 0;
		int k = 0;
	    while (i < midpoint && j < (length-midpoint)) {
	        if (Integer.parseInt(first[i]) <= Integer.parseInt(second[j])) {
	        	input[k++] = first[i++];
	        }
	        else {
	        	input[k++] = second[j++];
	        }
	    }
	    while (i < midpoint) {
	    	input[k++] = first[i++];
	    }
	    while (j < (length-midpoint)) {
	    	input[k++] = second[j++];
	    }
	    return input; 
	}
	
	//MERGE SORT INTEGER LIST
	public ArrayList<Integer> mergeSort(ArrayList<Integer> input) {
		int size = input.size();
		
		if(size < 2) {
			return input;
		}
		
		int middle = size/2;
		ArrayList<Integer> left = new ArrayList<Integer>(middle);
		ArrayList<Integer> right = new ArrayList<Integer>(input.size()- middle);
		
		
		for(int i = 0; i < middle; i++) {
			left.add(input.remove(0));
		}
	    while (input.size()!=0) {
	    	right.add(input.remove(0));
	    }

	    mergeSort(left);  
	    mergeSort(right); 

	    while (left.size()!=0 && right.size()!=0) {
	     
	      if (left.get(0) < right.get(0)) {
	    	  input.add(left.remove(0));
	      }
	      else {
	    	  input.add(right.remove(0));
	      }
	    }

	  
	    while(left.size()!=0) {
	    	input.add(left.remove(0));
	    }
	    while(right.size()!=0) {
	    	input.add(right.remove(0));
	    }
		return input;
	}

	public ArrayList<String> mergeSortString(ArrayList<String> input) {
		int length = input.size();
		int midpoint = (int) length/2;
		
		if (length < 2) {
			return input;
		}
		
		ArrayList<String> first = new ArrayList<String>(midpoint);
		for (int i = 0; i < midpoint; i++) {
			first.set(i, input.get(i));
		}
		ArrayList<String> second = new ArrayList<String>(length - midpoint); 
		for (int i = midpoint; i < length; i++) {
			second.set(i-midpoint, input.get(i));
		}
		
		first = mergeSortString(first);
		second = mergeSortString(second);
		
		int i = 0;
		int j = 0;
		int k = 0;
	    while (i < midpoint && j < (length-midpoint)) {
	        if (Integer.parseInt(first.get(i)) <= Integer.parseInt(second.get(j))) {
	        	input.set(k++, first.get(i++));
	        }
	        else {
	        	input.set(k++, second.get(j++)); 
	        }
	    }
	    while (i < midpoint) {
	    	input.set(k++, first.get(i++));
	    }
	    while (j < (length-midpoint)) {
	    	input.set(k++, second.get(j++));
	    }
	    return input; 
	}
	
	//LINEAR SEARCH INTEGER ARRAY
	public int linearSearch(Integer[] input, String target) { 
		int t = Integer.parseInt(target);
		for (int i = 0; i < input.length; i++) {
			if ((input[i]).equals(t) ) {
				return i;
			}
		}
		return -1;
	}
	
	//LINEAR SEARCH STRING ARRAY
	public int linearSearch(String[] input, String target) { 
		for (int i = 0; i < input.length; i++) {
			if ((input[i]).equals(target) ) {
				return i;
			}
		}
		return -1;
	}
	
	//LINEAR SEARCH INTEGER LIST
	public int linearSearch(ArrayList<Integer> input, String target) { 
		int t = Integer.parseInt(target);
		
		for(int i = 0; i < input.size(); i++) {
			if(input.get(i) == t) {
				return i;
			}
		}
		
		return -1;
	}
	
	//LINEAR SEARCH STRING LIST
	public int linearSearchString(ArrayList<String> input, String target) { 
		for(int i = 0; i< input.size(); i++) {
			if(input.get(i).equals(target)) {
				return i;
			}
		}
		return -1;
	}
	
	//BINARY SEARCH INTEGER ARRAY
	public int binarySearch(Integer[] input, String t) {
		Integer[] sorted = mergeSort(input);
		int target = Integer.parseInt(t);
		int l = 0;
		int h = input.length - 1;
		while(l <= h) {
			int index = l + (h -  l) / 2;
			if (sorted[index] == target) {
				return index;
			}
			else if (sorted[index] > target) {
				h = index - 1;
			}
			else {
				l = index + 1;
			}
		}	
		return -1;
	}
	
	//BINARY SEARCH STRING ARRAY
	public int binarySearch(String[] input, String target) {
		Collator c = Collator.getInstance();
		String[] sorted = mergeSort(input);
		
		int l = 0;
		int h = input.length - 1;
		while(l <= h) {
			int index = l + (h -  l) / 2;
			if (c.compare(sorted[index], target) == 0) {
				return index;
			}
			else if (c.compare(sorted[index], target) > 0) {
				h = index - 1;
			}
			else {
				l = index + 1;
			}
		}	
		return -1;
	}
	//BINARY SEARCH INTEGER LIST
	public int binarySearch(ArrayList<Integer> intArray, String x) {
		ArrayList<Integer> array = selectionSort(intArray);
		int target = Integer.parseInt(x);
		
			int newmid = 0;
			int size = array.size()-1;
			
			while(newmid <= size) {
				int mid = newmid + (array.size()-1)/2;
				if(target == array.get(mid)) {
					return mid;
				}
				else if(target > array.get(mid)) {
					newmid = mid+1;
				}
				else {
					size = mid -1;
				}
			}
			
			return -1;
	}
	
	public int binarySearchString(ArrayList<String> input, String target) {
		ArrayList<String> array = selectionSortString(input);
		
		int newmid = 0;
		int size = array.size()-1;
		
		while(newmid <= size) {
			int mid = newmid + (array.size()-1)/2;
			if(target.equals(array.get(mid))) {
				return mid;
			}
			else if(target.compareTo(array.get(mid)) < 0) {
				newmid = mid+1;
			}
			else {
				size = mid -1;
			}
		}
		
		return -1;
	}
}
	

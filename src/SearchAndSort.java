import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SearchAndSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SearchAndSort sort = new SearchAndSort();
		//type is the algorithm
		String type = "";
		//target is for searches
		String target = "";
		//data is the data type
		String data = "";
		//store is the storage used
		String store = "";
		
		do {
			System.out.println("What algorithm would you like to execute? bubble, selection, insertion, merge, linear, or binary? Type \"quit\" to exit.");
			type = in.nextLine().toLowerCase();
			if(type.matches("quit")) {
				in.close();
				return;
			}
		} while(!(type.matches("bubble") || type.matches("selection") || type.matches("insertion") || type.matches("merge") || type.matches("linear") || type.matches("binary")));
		
		if (type.equals("linear") || type.equals("binary")) {
			boolean valid;
			do {
				valid = true;
				System.out.println("What is the value you are searching for? ");
				target = in.nextLine();
				if (data.equals("integers")) {
					try {
						int i = Integer.parseInt(target);
					}
					catch (NumberFormatException e) {
						valid  = true;
						System.out.println("Try Again.");
					}
				}
			} while(!valid);
		}
		
		do {
			System.out.println("What type of data? integers or strings?");
			data = in.nextLine().toLowerCase();
			if(data.matches("quit")) {
				in.close();
				return;
			}
		} while(!(data.matches("integers") || data.matches("strings")));
		
		
		do {
			System.out.println("What type of storage? array or list");
			store = in.nextLine().toLowerCase();
			if(store.matches("quit")) {
				in.close();
				return;
			}
		} while(!(store.matches("array") || store.matches("list")));
		

		ArrayList<?> bigData = new ArrayList();
		if(data.matches("strings")) {
			System.out.println("What are the values you would like in the list? Only letters and commas are allowed; no spaces."); 
			String entry = in.nextLine();
			ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(entry.split(",")));  
			bigData = stringList;
		} 
		else if (data.matches("integers")) {
			boolean good;
			ArrayList<Integer> intArray;
			do {
				good = true;
				intArray = new ArrayList<Integer>();
				System.out.println("What are the values you would like in the list? Only numbers and commas are allowed; no spaces."); 
				String inputData = in.nextLine();
				String[] temp = inputData.split(",");
				for(int i = 0; i < temp.length; i++) {
					try {intArray.add(Integer.parseInt(temp[i]));} 
					catch(Exception e) {
						good = false;
						System.out.println("Invalid Data");
						break;
					}
				}
			} while(!good);
			bigData = intArray;
		}
		sort.Sort(bigData, type, store, data, target);
		in.close();
		
	}
		
	//OPTIONS
	private void Sort(ArrayList<?> listData, String algorithmType, String storage, String dataType, String target) {
		Integer[] integerArray = null;
		if (dataType.equals("integers")) {
			integerArray =  new Integer[listData.size()];
			integerArray =  listData.toArray(integerArray);
		}
		
		String[] stringArray = null;
		if (dataType.equals("strings")) {
			stringArray =  new String[listData.size()];
			stringArray = (String[]) listData.toArray(stringArray);
		}
		
		switch(algorithmType) {
		case("bubble"):
			if(storage.equals("list")) {
				System.out.println("Bubble Sort:" + Arrays.toString(bubbleSort(listData).toArray()));
			} 
			else if (dataType.equals("strings")) {
				System.out.println("Bubble Sort:" + Arrays.toString(bubbleSort(stringArray)));

			} 
			else {
				System.out.println("Bubble Sort:" + Arrays.toString(bubbleSort(integerArray)));
			}
			break;
			
		case("selection"):
			if(storage.equals("list")) {
				System.out.println("Selection Sort:" + Arrays.toString(selectionSort(listData).toArray()));
			} 
			else if (dataType.equals("strings")) {
				System.out.println("Selection Sort:" + Arrays.toString(selectionSort(stringArray)));

			} 
			else {
				System.out.println("Selection Sort:" + Arrays.toString(selectionSort(integerArray)));
			}
			break;
		case("insertion"):
			if(storage.equals("list")) {
				System.out.println("Insertion Sort:" + Arrays.toString(insertionSort(listData).toArray()));
			} 
			else if (dataType.equals("strings")) {
				System.out.println("Insertion Sort:" + Arrays.toString(insertionSort(stringArray)));

			} 
			else {
				System.out.println("Insertion Sort:" + Arrays.toString(insertionSort(integerArray)));
			}
			break;
		case("merge"):
			if(storage.equals("list")) {
				System.out.println("Merge Sort:" + Arrays.toString(mergeSort(listData).toArray()));

			} 
			else if (dataType.equals("strings")) {
				System.out.println("Merge Sort:" + Arrays.toString(mergeSort(stringArray)));

			} 
			else {
				System.out.println("Merge Sort:" + Arrays.toString(mergeSort(integerArray)));

			}
			break;
		case("linear"):
			if(storage.equals("list")) {
				System.out.println("Linear Search:" + String.valueOf(linearSearch(listData, target)));
			} 
			else if (dataType.equals("strings")) {
				System.out.println("Linear Search:" + String.valueOf(linearSearch(stringArray, target)));
			} 
			else {
				System.out.println("Linear Search:" + String.valueOf(linearSearch(integerArray, target)));
			}
			break;
		case("binary"):
			if(storage.equals("list")) {
				System.out.println("Binary Search:" + String.valueOf(binarySearch(listData, target)));
			} 
			else if (dataType.equals("strings")) {
				System.out.println("Binary Search:" + String.valueOf(binarySearch(stringArray, target)));
			} 
			else {
				System.out.println("Binary Search:" + String.valueOf(binarySearch(integerArray, target)));
			}
			break;
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
		Collator c = Collator.getInstance();
		int n = input.length; 
		for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if ( c.compare(input[j], input[j+1]) > 0) { 
                	String temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
                }
            }
		}
		return input;
	}
	
	//BUBBLE SORT INTEGER & STRING LIST
	public ArrayList<?> bubbleSort(ArrayList<?> input) {
		Collator c = Collator.getInstance();
		int n = input.size(); 
		if (input.get(0) instanceof Integer) {
			for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if ( (int) input.get(j) > (int) input.get(j + 1)) { 
						Collections.swap(input, j, j + 1);
	                } 
	            }
			}
		} 
		else {
			for (int i = 0; i < n-1; i++) {
	            for (int j = 0; j < n-i-1; j++) {
	                if ( c.compare(input.get(j), input.get(j+1)) > 0) { 
						Collections.swap(input, j, j+1);
	                } 
	            }
			}
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
	
	//SELECTION SORT STRING ARRAY
	public String[] selectionSort(String [] input) {
		Collator c = Collator.getInstance();
		for (int i = 0; i < input.length; i++) {
			int minimum = i;	
			for (int j = i; j < input.length; j++) {
				if (c.compare(input[j], input[minimum]) < 0) {
					minimum = j;
				}
			}
			String temp = input[minimum];
			input[minimum] = input[i];
			input[i] = temp;
		}
        return input; 
	}
		
	//SELECTION SORT STRING & INTEGER LIST
	public ArrayList<?> selectionSort(ArrayList<?> input) {
		Collator c = Collator.getInstance();
		for (int j = 0; j < input.size(); j++) {
			int minimum = j;	
			for (int i = j; i < input.size(); i++) {
				if (input.get(0) instanceof Integer) {
					if ((int) input.get(i) < (int) input.get(minimum)) {
						minimum = i;
					}
				}
				else {
					if (c.compare(input.get(i), input.get(minimum)) < 0) {
						minimum = i;
					}
				}
			}
			Collections.swap(input, minimum, j);
		}
		return input;
	}
	
	
	//INSERTION SORT INTEGER ARRAY
	public Integer[] insertionSort(Integer[] input) {
		int n = input.length; 
        for (int i = 1; i < n; ++i) { 
            int key = input[i]; 
            int j = i - 1; 
  
            while (j >= 0 && input[j] > key) { 
                input[j + 1] = input[j]; 
                j = j - 1; 
            } 
            input[j + 1] = key; 
        } 
        return input; 
	}
	
	//INSERTION SORT STRING ARRAY
	public String[] insertionSort(String[] input) {
		Collator c = Collator.getInstance();
		int i;
		int j;
		String compare;
		for (i = 1; i < input.length; i++) { 
			compare = input[i]; 
			j = i - 1; 
			while (j >= 0 && c.compare(input[j], compare) > 0) { 
				input[j + 1] = input[j]; 
				j = j - 1; 
			} 
				input[j + 1] = compare; 
		}
		return input;
	}
		
	//INSERTION SORT STRING & INTEGER LIST
	public ArrayList insertionSort(ArrayList input) {
		if(input.get(0) instanceof Integer) {
			int i;
			int compare;
			int j; 
			for (i = 1; i < input.size(); i++) { 
				compare = (int) input.get(i); 
				j = i - 1; 
				while (j >= 0 && (int) input.get(j) > compare) { 
					input.set(j+1, input.get(j)); 
					j = j-1; 
				} 
				input.set(j + 1, compare); 
			}
		} 
		else {
			Collator c = Collator.getInstance();
			int i;
			int j;
			String compare;
			for (i = 1; i < input.size(); i++) { 
				compare = (String) input.get(i); 
				j = i - 1; 
				while (j >= 0 && c.compare(input.get(j), compare) > 0) { 
					input.set(j + 1, input.get(j)); 
					j = j - 1; 
				} 
				input.set(j + 1, compare); 
			}
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
	    while (i < midpoint && j < (length - midpoint)) {
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
	
	//MERGE SORT INTEGER & STRING LIST
	public ArrayList<?> mergeSort(ArrayList input) {
		Collator c = Collator.getInstance();
		if (input.size() < 2) {
			return input;
		}
		
		ArrayList<?> first = new ArrayList(input.subList(0, input.size()/2));
		ArrayList<?> second = new ArrayList(input.subList(input.size()/2, input.size()));
        
		first = mergeSort(first);
		second = mergeSort(second);
		if(input.get(0) instanceof Integer) {
			int i = 0, j = 0, k = 0; 
	        while (i < first.size() && j < second.size()) { 
	            if ( (int) first.get(i) <= (int) second.get(j)) { 
	            	input.set(k, first.get(i)); 
	                i++; 
	            } 
	            else { 
	            	input.set(k, second.get(j)); 
	                j++; 
	            } 
	            k++; 
	        } 
	        while (i < first.size()) { 
	        	input.set(k, first.get(i)); 
	            i++; 
	            k++; 
	        } 
	        while (j < second.size()) { 
	        	input.set(k, second.get(j)); 
	            j++; 
	            k++; 
	        } 
		} 
		else {
			int i = 0, j = 0, k = 0; 
	        while (i < first.size() && j < second.size()) { 
	            if (c.compare(first.get(i), second.get(j)) < 0) { 
	            	input.set(k, first.get(i)); 
	                i++; 
	            } 
	            else { 
	            	input.set(k, second.get(j)); 
	                j++; 
	            } 
	            k++; 
	        } 
	        while (i < first.size()) { 
	        	input.set(k, first.get(i)); 
	            i++; 
	            k++; 
	        } 
	        while (j < second.size()) { 
	        	input.set(k, second.get(j)); 
	            j++; 
	            k++; 
	        } 		}
		return input;
	}
	
	//LINEAR SEARCH INTEGER ARRAY
	public int linearSearch(Integer[] input, String target) { 
		int targetVal = Integer.parseInt(target);
		for (int i = 0; i < input.length; i++) {
			if ((input[i]).equals(targetVal) ) {
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
	
	//LINEAR SEARCH INTEGER & STRING LIST
	public int linearSearch(ArrayList<?> input, String target) {
		for (int i = 0; i < input.size(); i++) {
			Object k = (Object)target;
			if (input.get(i) instanceof Integer) {
				k =  (Object)Integer.parseInt(k.toString());
			}
			if (((Object)input.get(i)).equals(k) ) {
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
	//BINARY SEARCH INTEGER & STRING LIST
	public int binarySearch(ArrayList<?> input, String target) {
		Collator c = Collator.getInstance();
		ArrayList sorted = mergeSort(input);
		
		Object t = (Object)target;
		if (input.get(0) instanceof Integer) {
			t =  (Object)Integer.parseInt(t.toString());
		}
		int l = 0;
		int h = input.size() - 1;
		while(l <= h) {
			int index = l + (h -  l) / 2;
			if (input.get(0) instanceof Integer) {
				
				if ((Integer) sorted.get(index) == (Integer) t) {
					return index;
				}
				else if ((Integer) sorted.get(index) > (Integer) t) {
					h = index - 1;
				}
				else {
					l = index + 1;
				}
			}
			else {
				if (c.compare(sorted.get(index).toString(),(String) t) == 0) {
					return index;
				}
				else if (c.compare(sorted.get(index).toString(),(String)t) > 0) {
					h = index - 1;
				}
				else {
					l = index + 1;
				}
			}
		}	
		return -1;
	}
}
	

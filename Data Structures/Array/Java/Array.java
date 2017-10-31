

/**
 * 
 * @author ASHUTOSH
 *
 */
public class Array {

	private int[] myNumArray;
	
	
	
	/*
	 * Display all the elements of the array passed as parameter
	 */
	private void displayArray(int[] pIntArray){
		System.out.println("Inside displayArray method :");
		
		int count = 0;		
		System.out.println("List of elements in the array are : ");
		
		while(count < pIntArray.length){
			System.out.println("Element "+ (count+1) + " : "+ pIntArray[count]);
			++count;
		}
		
	}
	
	
	/*
	 * Method to traverse the array
	 */	
	public void traverseArray(){
		
		System.out.println("Inside traverseArray method :");
		
		myNumArray = new int[]{5, 11, 4, 2, 21, 8, 3, 15, 24, 7};
		int count = 0;
		
		System.out.println("List of elements is the array are : ");	
		
		while(count < myNumArray.length){					
			System.out.println("Element "+ (count+1) + " : "+ myNumArray[count]);
			++count;
		}
	}
	
	
	/*
	 * Insert an element ITEM in the array at given position LOC
	 */
	public void insertAtLoc(int pLoc, int pItem){
		
		System.out.println("Inside insertAtLoc method : ");
		
		myNumArray = new int[]{5, 11, 4, 2, 21, 8, 3, 15, 24, 7};
		myNumArray[9] = 0;
		
		if(pLoc >= 0 && pLoc < myNumArray.length){
			int count = myNumArray.length - 1;
			while(count > 0 && (pLoc - 1) != count){
				myNumArray[count] = myNumArray[count-1];
				--count;
			}
			myNumArray[count] = pItem;
		}	
		displayArray(myNumArray);
	}
	
	
	/*
	 * Delete an element which is at position LOC from the array 
	 */
	public void deleteFromLoc(int pLoc){
		
		System.out.println("Inside deleteFomLoc method : ");
		
		myNumArray = new int[]{5, 11, 4, 2, 21, 8, 3, 15, 24, 7};
		
		if(pLoc > 0 && pLoc <= myNumArray.length){
			int count = pLoc - 1;
			int item = myNumArray[count];
			
			while(count < (myNumArray.length - 1)){
				myNumArray[count] = myNumArray[count + 1];
				++count;
			}
			myNumArray[count] = 0;
			
			System.out.println("Element deleted at position " + pLoc + " is : " + item);
			
			this.displayArray(myNumArray);
		}
	}
	
	
	/*
	 * Bubble sort
	 */
	public void bubbleSort(){
		
		System.out.println("Inside bubbleSort method : ");
		
		myNumArray = new int[]{5, 11, 4, 2, 21, 8, 3, 15, 24, 7};
		
		for(int count1 = 0 ; count1 < (myNumArray.length - 1) ; ++count1 ){
			for(int count2 = 0 ; count2 < (myNumArray.length - 1 - count1) ; ++count2){
				
				if(myNumArray[count2] > myNumArray[count2 + 1]){
					
					myNumArray[count2] = myNumArray[count2] + myNumArray[count2 + 1];
					myNumArray[count2 + 1] = myNumArray[count2] - myNumArray[count2 + 1];
					myNumArray[count2] = myNumArray[count2] - myNumArray[count2 + 1];
					
				}				
			}
		}
		this.displayArray(myNumArray);
	}
	
	
	/*
	 * Bubble sort - overloaded
	 */
	public void bubbleSort(int[] pIntArray){
		
		System.out.println("Inside bubbleSort method which excepts array as an argument : ");
		
		if(pIntArray != null){
			myNumArray = pIntArray;
		}
		
		
		for(int count1 = 0 ; count1 < (myNumArray.length - 1) ; ++count1 ){
			for(int count2 = 0 ; count2 < (myNumArray.length - 1 - count1) ; ++count2){
				
				if(myNumArray[count2] > myNumArray[count2 + 1]){
					
					myNumArray[count2] = myNumArray[count2] + myNumArray[count2 + 1];
					myNumArray[count2 + 1] = myNumArray[count2] - myNumArray[count2 + 1];
					myNumArray[count2] = myNumArray[count2] - myNumArray[count2 + 1];
					
				}				
			}
		}
		this.displayArray(myNumArray);
	}
	
	/*
	 * Linear Search
	 */
	public void linearSearch(int pItem){
		
		System.out.println("Inside linearSearch method : ");
		
		myNumArray = new int[]{5, 11, 4, 2, 21, 8, 3, 15, 24, 7};
		int myLoc = 0;
		int count = 0;

		while(count < myNumArray.length && myNumArray[count] != pItem){
			++count;
		}
		
		if(count == myNumArray.length){
			System.out.println("Item not found !!");
		}
		else{
			myLoc = count;
			System.out.println("Item found in array at location : " + (myLoc + 1));
		}
	}
	
	
	/*
	 * Binary Search
	 */
	public void binarySearch(int pItem){
		
		System.out.println("Inside binarySearch method : ");
		
		myNumArray = new int[]{5, 11, 4, 2, 21, 8, 3, 15, 24, 7};
		
		this.bubbleSort(myNumArray);
		
		int myBeg = 0;
		int myEnd = myNumArray.length - 1;
		int myMid = 0;
		
		while(myBeg <= myEnd){
			myMid = (myBeg + myEnd)/2;
			
			if(myNumArray[myMid] == pItem){
				System.out.println("Item found at location : " + (myMid + 1));
				break;
			}
			else if (myNumArray[myMid] > pItem){
				myEnd = myMid - 1;
			}
			else if (myNumArray[myMid] < pItem){
				myBeg = myMid + 1;
			}
		}
		if(myBeg > myEnd){
			System.out.println("Item not found!!");
		}
	}
	
	
	/*
	 * Matrix multiplication
	 */
	public void matrixMultiplication(){
		
		int[][] matrix1 = { {2,1,6}, {4,3,7} };
		int[][] matrix2 = { {1,2,6,4}, {3,8,7,1}, {5,9,4,1} };
		
		int[][] result = new int[matrix1.length][matrix2[0].length];
		
		int sum = 0;
		
		for(int i = 0 ; i < matrix1.length ; ++i){
			for(int k = 0 ; k < matrix2[0].length ; ++k){					
				sum = 0;			
				for(int j = 0 ; j < matrix1[0].length ; ++j){
					sum = sum + matrix1[i][j]*matrix2[j][k];					
				}
				
				result[i][k] = sum;
			}
		}
		
		for(int m = 0 ; m < result.length ; ++m){
			//System.out.println("\nRow " + (m+1) + " : ");
			System.out.println();
			for(int n = 0 ; n < result[m].length ; ++n){
				System.out.print(result[m][n] + "\t");
			}
		}
		
	}
	
}

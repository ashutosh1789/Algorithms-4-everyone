
/**
 * 
 * @author ASHUTOSH
 *
 */
public class Hashing {
	
	class Node {
		private int info;
		private Node link;
		
		public Node (int info) {
			this.info = info;
		}
	}
	
	private int calculateMod(final int pKey, final int pSize) {
		return pKey%pSize;
	}
	
	/**
	 * This method inserts the values in array into a hashtable using Chaining algorithm
	 * @param pArray
	 * @return
	 */
	public Node[] insertIntoHashtableChaining(final int[] pArray) {
				
		Node[] myHashtable = new Node[10];
		int myMappingValue;
		
		for(int i = 0; i < pArray.length; i++) {
			myMappingValue = calculateMod(pArray[i], myHashtable.length);
			
			if(myHashtable[myMappingValue] == null) {
				Node myNode = new Node(pArray[i]);
				myHashtable[myMappingValue] = myNode;
			} else {
				Node PTR = myHashtable[myMappingValue];
				while(PTR.info != pArray[i] && PTR.link != null) {
					PTR = PTR.link;
				}
				if (PTR.info != pArray[i]) {
					Node myNode = new Node(pArray[i]);
					PTR.link = myNode;
				}		
			}
		}
		return myHashtable;
	}
	
	
	/**
	 * This method finds a key in a hashtable which is formed using Chaining. Both hashtable 
	 * and key is passed as parameter. 
	 * @param pHashtable
	 * @param pKey
	 * @return
	 */
	public boolean findKeyChaining(Node[] pHashtable, int pKey) {
		
		boolean flag = false;		
		int myMappingValue = this.calculateMod(pKey,pHashtable.length);		
		Node PTR = pHashtable[myMappingValue];
		
		while(PTR != null) {
			if(PTR.info == pKey) {
				flag = true;
				break;
			} else
				PTR = PTR.link;
		}		
		return flag;
	}
	
	
	/**
	 * This method inserts the values in array into a hashtable using Linear Probing algorithm
	 * @param pArray
	 * @return
	 */
	public Integer[] insertIntoHashtableLinearProbing(final int[] pArray) {
		Integer[] myHashtable = new Integer[30];
		int myMappingValue;
		
		for(int i = 0; i < pArray.length; i++) {
			myMappingValue = calculateMod(pArray[i], 17);
			
			while(myHashtable[myMappingValue] != null) {			    
			    if(myMappingValue + 1 < myHashtable.length)
			        ++myMappingValue;
			    else
			        myMappingValue = 0;
			}
			myHashtable[myMappingValue] = pArray[i];
		}
		return myHashtable;
	}
	
	
	/**
	 * This method finds a key in a hashtable which is formed using Linear Probing. Both hashtable 
     * and key is passed as parameter. 
	 * @param pHashtable
	 * @param pKey
	 * @return
	 */
	public boolean findKeyLinearProbing(final Integer[] pHashtable, final int pKey) {
	    boolean flag = false;
	    
	    int myMappingKey = calculateMod(pKey, 17);
	    
	    while(pHashtable[myMappingKey] != null) {
	        if(pHashtable[myMappingKey] == pKey) {
	            flag = true;
	            break;
	        } else {
	            myMappingKey = (myMappingKey + 1)%pHashtable.length;
	        }  
	    }	    
	    return flag;
	}
	
	
	/**
	 * This method inserts the values in array into a hashtable using Double Hashing algorithm
	 * @param pArray
	 * @return
	 */
	public Integer[] insertIntoHashtableDoubleHashing(final int[] pArray) {
	    Integer[] myHashtable = new Integer[30];
	    int myMappingKey;
	    int myOffset;
	    
	    for(int i = 0; i < pArray.length; i++) {
	        myMappingKey = calculateMod(pArray[i], 17);
	        
	        while(myHashtable[myMappingKey] != null) {
	            myOffset = calculateMod(pArray[i], 19);
	            myMappingKey = myMappingKey + myOffset;
	            if(myMappingKey >= myHashtable.length)
	                myMappingKey = myMappingKey%myHashtable.length;
	        }
	        myHashtable[myMappingKey] = pArray[i];
	    }
	    return myHashtable;
	}

	
	/**
	 * This method finds a key in a hashtable which is formed using Double Hashing. Both hashtable 
     * and key is passed as parameter. 
	 * @param pHashtable
	 * @param pKey
	 * @return
	 */
	public boolean findKeyDoubleHashing(final Integer[] pHashtable, final int pKey) {
	    boolean flag = false;
	    
	    int myMappingKey = calculateMod(pKey, 17);
	    
	    while(pHashtable[myMappingKey] != null) {
	        if(pHashtable[myMappingKey] == pKey) {
	            flag = true;
	            break;
	        } else {
	            myMappingKey = (myMappingKey + calculateMod(pKey, 19))%pHashtable.length;
	        }
	    }
	    
	    return flag;
	}
}

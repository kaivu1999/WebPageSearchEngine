
public class MyHashTable {
	// this is a hash table to impliment inverted page index that is it is hash to map a string ( page ) to wordEnttries
	private Object [] ipList  = new Object[128];
	
	
	public MyHashTable() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 128; i++) {
			ipList[i] = new MyLinkedList<WordEntry>();	
		}
	}

	public int getHashIndex ( String str) {
		int ASCIIOfFirstChar = (int) str.charAt(0);
		return ASCIIOfFirstChar;
		// Create a hash function which maps a string to the index of its word-entry in the hashtable. The implementation of hashtable should support chaining.
	}
	public MyLinkedList<WordEntry>[]  getipList() {
		return (MyLinkedList<WordEntry>[]) this.ipList;
	}

	

	void addPostionForWord (WordEntry w ){
		String word = w.getWord();
		// First find if word entry for the same word exists:
		int index = (int) word.charAt(0);
		if (((MyLinkedList<WordEntry>)ipList[index]).size() == 0) {
			((MyLinkedList<WordEntry>)ipList[index]).insertFirst(w);
		}
		else
		{
			
			MyLinkedList<WordEntry> list = ((MyLinkedList<WordEntry>)ipList[index]);
			int size = list.size();
			// Now I have to find word Entry with word as word
			WordEntry a = new WordEntry();
			int i = 0;
			for( i = 0; i < size ; i++)
			{
				if (list.getChildat(i).getWord().equals(word)) {
					 list.getChildat(i).addPositons(w.getListOfPositions());
					//  System.out.println("Here union occurs");
					//  for (int j = 0; j < list.getChildat(i).getListOfPositions().size(); j++) {
					// 	 String s = list.getChildat(i).getListOfPositions().getChildat(j).getPageEntry().getName();
					// 	 System.out.println(s);
					//  }
					 list.getChildat(i).getListOfPositions();
					break;
				}
			}

			if ( i == size){
				((MyLinkedList<WordEntry>)ipList[index]).insertFirst(w);
			}
			// else
			// {
			// 	System.out.println("Union is being taken");
			// 	a.getListOfPositions().unionof2l(w.getListOfPositions());
			// }
		}

		// This adds an an entry to the hashtable: stringName(w) − > positionList(w). If no wordentryexists, then create a new word entry. However, if a wordentry exists, then merge w with the existing word-entry.
	}


	public WordEntry getWordEntry(String w) {
		WordEntry word = new WordEntry();
		int hashIndex = this.getHashIndex(w);
		// System.out.println(hashIndex);
		MyLinkedList<WordEntry> words = (MyLinkedList<WordEntry>)ipList[hashIndex];
		// System.out.println(words.size());
		for (int i = 0; i < words.size(); i++) {
			if(words.getChildat(i).getWord().equals(w)){
				return words.getChildat(i);
			}
		}
		return word;
	}
}


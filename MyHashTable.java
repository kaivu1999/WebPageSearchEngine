
public class MyHashTable {
	// this is a hash table to impliment inverted page index that is it is hash to map a string ( page ) to wordEnttries
	private MyLinkedList<WordEntry> [] ipList  = new MyLinkedList[128];
	
	
	public MyHashTable() {
		// TODO Auto-generated constructor stub
	}

	public int getHashIndex ( String str) {
		int ASCIIOfFirstChar = (int) str.charAt(0);
		return ASCIIOfFirstChar;
		// Create a hash function which maps a string to the index of its word-entry in the hashtable. The implementation of hashtable should support chaining.
	}
	public MyLinkedList<WordEntry>[]  getipList() {
		return this.ipList;
	}

	

	void addPostionForWord (WordEntry w ){
		String word = w.getWord();
		// First find if word entry for the same word exists:
		int index = (int) word.charAt(0);
		if (ipList[index].size() == 0) {
			ipList[index].insertFirst(w);
		}
		else
		{
			
			MyLinkedList<WordEntry> list = ipList[index];
			int size = list.size();
			// Now I have to find word Entry with word as word
			WordEntry a = new WordEntry();
			int i = 0;
			for( i = 0; i < size ; i++)
			{
				if (list.getChildat(i).getWord().equals(word)) {
					a = list.getChildat(i);
					break;
				}
			}

			if ( i == size){
				ipList[index].insertFirst(w);
			}
			else
			{
				a.getListOfPositions().unionof2l(w.getListOfPositions());
			}
		}

		// This adds an an entry to the hashtable: stringName(w) − > positionList(w). If no wordentryexists, then create a new word entry. However, if a wordentry exists, then merge w with the existing word-entry.
	}
}


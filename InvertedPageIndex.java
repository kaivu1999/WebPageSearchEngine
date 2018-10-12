
public class InvertedPageIndex {
	MyHashTable ipData = new MyHashTable();
	public InvertedPageIndex() {
		// TODO Auto-generated constructor stub
	}

	public void  addPage (PageEntry p) {
		// ADD THE PAGE TO INVERTED PAGE INDEX
		MyLinkedList<WordEntry> a = new MyLinkedList<>();
		a = p.getPageIndex().getWordEntries();
		for (int i = 0; i < a.size(); i++) {
			ipData.addPostionForWord(a.getChildat(i));
		}
	}
	
	public MySet<PageEntry> getPagesWhichContainWord (String str) {
		// Myset having pageentries which contain the word str
		MySet<PageEntry> set = new MySet<>();
			MyLinkedList<WordEntry> Words = ipData.getipList().[ipData.getHashIndex(str)];
			WordEntry requiredWordEntry;
			int i = 0;
			for ( i = 0 ; i<Words.size() ; i++ ) {
				if (Words.getChildat(i).getWord().equals(str)) {
					requiredWordEntry =  Words.getChildat(i);
					break;
				}
			}
			if (i<Words.size()) {
				PageEntry p = new PageEntry();
				int sizeOPositions = requiredWordEntry.getListOfPositions.size();
				for (int i = 0; i < sizeOPositions; i++) {
					p = requiredWordEntry.getListOfPositions().getChildat(i).getPageEntry();
					set.InsertAtFront(p);
				}
			}
		return set;
	}



}

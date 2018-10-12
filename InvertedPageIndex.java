
public class InvertedPageIndex {
	private MyHashTable ipData = new MyHashTable();
	private MySet<String> pages = new MySet<>();
	public InvertedPageIndex() {
		// TODO Auto-generated constructor stub
	}

	public MyHashTable getTable() {
		return this.ipData;
	}

	public MySet<String> getPages() {
		return this.pages;
	}

	public void  addPage (PageEntry p) {
		try {
			// ADD THE PAGE TO INVERTED PAGE INDEX
	
	
			if (this.pages.IsMember(p.getName())) {
				System.out.println("The  is already entered in the database ");
			}
			else
			{
				MyLinkedList<WordEntry> a;
				a = p.getPageIndex().getWordEntries();
				for (int i = 0; i < a.size(); i++)
				 {
					ipData.addPostionForWord(a.getChildat(i));
	
				}
				pages.InsertAtFront(p.getName());
			}

			
		} catch (Exception e) {
			//TODO: handle exception
			System.out.println(e);
		}
	}
	
	public MySet<PageEntry> getPagesWhichContainWord (String str) {
		// Myset having pageentries which contain the word str
		MySet<PageEntry> set = new MySet<>();
			MyLinkedList<WordEntry> Words = (MyLinkedList<WordEntry>)(ipData.getipList()[ipData.getHashIndex(str)]);
			WordEntry requiredWordEntry =new WordEntry();
			int i = 0;
			for ( i = 0 ; i<Words.size() ; i++ ) {
				if (Words.getChildat(i).getWord().equals(str)) {
					requiredWordEntry =  Words.getChildat(i);
					break;
				}
			}
			if (i<Words.size()) {
				PageEntry p = new PageEntry();
				int sizeOPositions = requiredWordEntry.getListOfPositions().size();
				for (int j = 0; j < sizeOPositions; j++) {
					p = requiredWordEntry.getListOfPositions().getChildat(j).getPageEntry();
					set.InsertAtFront(p);
				}
			}
		return set;
	}



}

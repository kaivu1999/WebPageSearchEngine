
public class WordEntry {
	private String str = "";
	private MyLinkedList<Position> listOfPositions = new MyLinkedList<>(); 
	public WordEntry() {
		// TODO Auto-generated constructor stub
	}
	public WordEntry( String word) {
		//  TODO Auto-generated constructor stub
		this.str = word;
	}


	public String getWord() {
		return this.str;
	}

	public MyLinkedList<Position> getListOfPositions(){
		return this.listOfPositions;
	}
	
	public void addPosition (Position position) {
		listOfPositions.insertFirst(position);
	}

	public void addPositons (MyLinkedList<Position> positions){
		// String s = this.listOfPositions.getChildat(0).getPageEntry().getName();
		this.listOfPositions =  this.listOfPositions.unionof2l(positions);
		// String l = positions.getChildat(0).getPageEntry().getName();
		// System.out.println("actual list has page : " + s);
		// System.out.println("after list has page : " + l);
	}
	public MyLinkedList<Position> getAllPositionsForThisWord () {
		return listOfPositions;
	}

	public float getTermFrequency ( String pageString ) {
		float f;
		int count=0 , totalWords = 0;
		PageEntry pE = new PageEntry();
		for (int i = 0; i < listOfPositions.size(); i++) {
			if (this.listOfPositions.getChildat(i).getPageEntry().getName().equals(pageString)) {
				count++;
				pE = this.listOfPositions.getChildat(i).getPageEntry();
			}
		}
		if (count == 0) {
			return 0;
		}
		else
		{

			for (int i = 0; i < pE.getPageIndex().getWordEntries().size(); i++) {
				totalWords += pE.getPageIndex().getWordEntries().getChildat(i).getListOfPositions().size();
			}
			return ((float) count / totalWords);
		}
	}


	
}

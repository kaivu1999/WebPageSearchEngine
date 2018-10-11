
public class WordEntry {
	private String str = "";
	MyLinkedList<Position> listOfPositions = new MyLinkedList<>(); 
	public WordEntry() {
		// TODO Auto-generated constructor stub
	}
	public WordEntry( String word) {
		//  TODO Auto-generated constructor stub
		this.str = word;
	}
	
	public void addPosition (Position position) {
		listOfPositions.insertFirst(position);
	}

	public void addPositons (MyLinkedList<Position> positions){
		this.listOfPositions.unionof2l(positions);
	}
	public MyLinkedList<Position> getAllPositionsForThisWord () {
		return listOfPositions;
	}

	public float getTermFrequency ( String word ) {
		// this is doubt 
	}


	
}

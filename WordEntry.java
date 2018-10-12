
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
		this.listOfPositions.unionof2l(positions);
	}
	public MyLinkedList<Position> getAllPositionsForThisWord () {
		return listOfPositions;
	}

	public float getTermFrequency ( String word ) {
		// this is doubt 
	}


	
}

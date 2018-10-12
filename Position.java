
public class Position {
	
	private PageEntry p;
	private int i;
	public Position( PageEntry p , int wordIndex) {
		// TODO Auto-generated constructor stub
		this.p = p;
		this.i = wordIndex;
	}
	
	public PageEntry getPageEntry () {
		return this.p;
	}
	public int  getWordIndex () {
		return this.i;
	}
	

}

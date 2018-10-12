
public class SearchEngine {
	private InvertedPageIndex invertedPageIndex = new InvertedPageIndex(); 

	public SearchEngine() {
		// TODO Auto-generated constructor stub
	}

	public void performAction (String actionMessage) 
	{

		String[] inputWords = actionMessage.split(" ");
		
		if (inputWords[0].equals("addPage")) {
			//addPage x : Add web page x to the search engine database.  The contents of the webpage are stored in a file named x in the webpages folder

		}
		
		if (inputWords[0].equals("queryFindPagesWhichContainWord")) {
			//
		}
		if (inputWords[0].equals("queryFindPositionsofWordInAPage")) {
			
		}
		
		
		
		
	}
}

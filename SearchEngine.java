
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
			PageEntry page = new PageEntry(inputWords[1]);
			// System.out.println("Page entry created");
			this.invertedPageIndex.addPage(page);
			// System.out.println("This is the ony thing ");
		}
		
		if (inputWords[0].equals("queryFindPagesWhichContainWord")) {
			MySet<String> pluralWords = new MySet<>();
			pluralWords.InsertAtFront("stack");
			pluralWords.InsertAtFront("stacks");
			pluralWords.InsertAtFront("structure");
			pluralWords.InsertAtFront("structures");
			pluralWords.InsertAtFront("application");
			pluralWords.InsertAtFront("applications");
			if (pluralWords.IsMember(inputWords[1].toLowerCase())) {
				String counterPart = "";
				if (inputWords[1].toLowerCase().equals("stack")) {
					counterPart = "stacks";
				} else if (inputWords[1].toLowerCase().equals("stacks")) {
					inputWords[1] = "stack";
				} else if (inputWords[1].toLowerCase().equals("structure")) {
					counterPart  = "structures";
				} else if (inputWords[1].toLowerCase().equals("structures")) {
					counterPart  = "structure";
				} else if (inputWords[1].toLowerCase().equals("applications")) {
					counterPart  = "application";
				} else if (inputWords[1].toLowerCase().equals("application")) {
					counterPart  = "applications";
				}

				// Print the webpages that contain the word  and counterasrt seperated by commas 
				WordEntry a = invertedPageIndex.getTable().getWordEntry(inputWords[1].toLowerCase());
				WordEntry b = invertedPageIndex.getTable().getWordEntry(counterPart);
				String pages = "";
				MySet<String> pagesforword = new MySet<>();
				for (int i = 0; i < a.getListOfPositions().size(); i++) {
					String pName = a.getListOfPositions().getChildat(i).getPageEntry().getName();

					if (!(pagesforword.IsMember(pName))) {
						pagesforword.InsertAtFront(pName);
					}
				}
				for (int i = 0; i < b.getListOfPositions().size(); i++) {
					String pName = b.getListOfPositions().getChildat(i).getPageEntry().getName();

					if (!(pagesforword.IsMember(pName))) {
						pagesforword.InsertAtFront(pName);
					}
				}
				
				if (pagesforword.size() == 0) {
					System.out.println("No webpage contains word " + inputWords[1]);
				}
				pages = pagesforword.printSet();
				System.out.println(pages);


			} 
			else 
			{
				//Print the webpages that contain the word seperated by commas
				WordEntry a = invertedPageIndex.getTable().getWordEntry(inputWords[1].toLowerCase());
				String pages = "";
				MySet<String> pagesforword = new MySet<>();
				for (int i = 0; i < a.getListOfPositions().size(); i++) {
					String pName = a.getListOfPositions().getChildat(i).getPageEntry().getName();

					if(!(pagesforword.IsMember(pName)))
					{
						pagesforword.InsertAtFront(pName);
					}
				}
				if (pagesforword.size() == 0) {
					System.out.println("No webpage contains word " + inputWords[1]);
				}
				pages = pagesforword.printSet();
				System.out.println(pages);
			}
		}
		if (inputWords[0].equals("queryFindPositionsOfWordInAPage")) {
			// 1 shows word and 2 shows page
			// now we will find word entry for word w
			// **** take care of plural here
			if (this.invertedPageIndex.getPages().IsMember(inputWords[2])) {
				
				MySet<Integer> indices = new MySet<>();
				WordEntry positions = this.invertedPageIndex.getTable().getWordEntry(inputWords[1].toLowerCase());
				if (positions == null ) {
					System.out.println("Webpage " + inputWords[2] + " does not contain the word " + inputWords[1]);
				}
				int temp = 0;
				for (int i = 0; i < positions.getListOfPositions().size(); i++) {
					if(positions.getListOfPositions().getChildat(i).getPageEntry().getName().equals(inputWords[2]))
					{
						temp = 1;
						indices.InsertAtFront(positions.getListOfPositions().getChildat(i).getWordIndex());
						// need to check insert front or insert back **
					}
				}
				if (temp == 0) {
					System.out.println("Webpage "+ inputWords[2] + " does not contain the word " + inputWords[1]);
				}
				else{
					String indicesString = indices.printSet();
					System.out.println(indicesString);
				}
			}
			else
			{
				System.out.println("No webpage " + inputWords[2] + "found");
			}
		}
		
	}
}

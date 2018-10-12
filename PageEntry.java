import java.io.*;
import java.util.*;

public class PageEntry {
	private String name = new String();
	private PageIndex pIndex = new PageIndex();
	public PageEntry() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return this.name;
	}

	public  PageEntry(String pageName) {
		// try {
		// 	this.name = pageName;
		// 	// to do : read the file with this name and update the pageIndex accordingly
		// 	File text = new File("/webpages/" + pageName+ ".txt");
		  
		// 	//Creating Scanner instnace to read File in Java
		// 	Scanner scnr = new Scanner(text);

		// 	str = str.replaceAll("\\p{Punct}", "");
			
		// } catch (Exception e) {
		// 	//TODO: handle exception
		// }


		this.name = pageName;



		
		try {
			// String a = "/webpages" + pageName +".txt";
			// File file = new File(a);
			// String content = FileUtils.readFileToString(file);

			// for (int i = 0; i < listOfFiles.length; i++) {
			// 	File file = listOfFiles[i];
			// 	if (file.isFile() && file.getName().endsWith(".txt")) {
			// 		/* do somthing with content */
			// 	}
			// }







			
			FileInputStream fstream = new FileInputStream ( "webpages/" + pageName);
			String doc = "";
			Scanner s = new Scanner ( fstream );
			String snl;
			while (s . hasNextLine ())
			{
				snl = s.nextLine();
				// System . out . println (snl);
				doc += snl + " ";

			}
			s.close();


			// System.out.println("Read something");
			doc = doc.replaceAll("\\p{Punct}", "");
			// Take care of C++ i think + is also removed due to removal of all punctuation **
			// System.out.println(doc);
			String[] finalString = doc.split("\\s+");
			// now for this final string
			int size = finalString.length;
				for (int i = 0; i < size; i++) {
					finalString[i] = finalString[i].toLowerCase();
					// System.out.println(finalString[i] + " line " +i);
				}


			// Set for common words
			String commonWords = "a an the they these this for is are was of or and does will whose";
			String[] arrCommonWords = commonWords.split(" ");
			MySet<String> cW = new MySet<>();
			for (int i = 0; i < arrCommonWords.length; i++) {
				cW.InsertAtFront(arrCommonWords[i]);
			}

			//now start making the pageIndex
			MySet<String> uniqueWords = new MySet<>();
			for (int i = 0 ; i < finalString.length ; i++ )
			{
					if ( !(uniqueWords.getList().isMember(finalString[i])) && !(cW.getList().isMember(finalString[i])) ) {
						uniqueWords.Insert(finalString[i]);
						WordEntry word = new WordEntry(finalString[i]);
						for(int j = i ; j < finalString.length ; j++){
							if (finalString[i].equals(finalString[j])) {
								
								Position pos = new Position(this , j );
								word.addPosition(pos);
							}
						}
						// now all the positions for the word finalString[i] are added ...

						// let's add the word to pageIndex
						this.getPageIndex().getWordEntries().insertFirst(word);
					}
			}
// ** c++ wali galti **
			// System.out.println(uniqueWords.printSet());

		} catch ( FileNotFoundException e) {
		System . out . println (" File not found ");
		}


	}
	
	public PageIndex getPageIndex(){
		return this.pIndex;
	}
}

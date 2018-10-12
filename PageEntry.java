import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PageEntry {
	private String name;
	private PageIndex pIndex;
	public PageEntry() {
		// TODO Auto-generated constructor stub
	}

	public void PageEntry(String pageName) {
		try {
			this.name = pageName;
			// to do : read the file with this name and update the pageIndex accordingly
			File text = new File("/webpages/" + pageName+ ".txt");
		  
			//Creating Scanner instnace to read File in Java
			Scanner scnr = new Scanner(text);

			str = str.replaceAll("\\p{Punct}", "");
			
		} catch (Exception e) {
			//TODO: handle exception
		}






		
		try {
		FileInputStream fstream = new FileInputStream ( "/webpages/" + pageName + ".txt");
		Scanner s = new Scanner ( fstream );
		while (s . hasNextLine ())
		System . out . println (s. nextLine ());
		} catch ( FileNotFoundException e) {
		System . out . println (" File not found ");
		}


	}
	
	public PageIndex getPageIndex(){
		return this.pIndex;
	}
}

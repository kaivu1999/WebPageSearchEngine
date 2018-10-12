import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checker {
    public static void main(String args[]) {
        BufferedReader br = null;
        SearchEngine r = new SearchEngine();
        int i = 1;
        try {
            String actionString;
            br = new BufferedReader(new FileReader("actions (copy).txt"));

            while ((actionString = br.readLine()) != null) {
                
                // System.out.println(i);
                r.performAction(actionString);
                // System.out.println(i);
                i++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}

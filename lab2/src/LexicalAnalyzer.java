import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyzer {

    private String filename;
    AnalyzerParser analyzerParser;

    public LexicalAnalyzer(String filename) {
        this.filename = filename;
        analyzerParser = new AnalyzerParser();
    }


    public String[] readLineFromFile() throws FileNotFoundException {

        String[] lines = new String[20];
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int i = 0;
            for(String line; (line = br.readLine()) != null; ) {
                lines[i] = line;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    void printLines() throws FileNotFoundException {
        String[] lines = readLineFromFile();
        for (int i = 0 ; i< lines.length;i++){
            if (lines[i]!=null)
                System.out.println(lines[i]);
        }
    }

    void analize(String str){
        analyzerParser.parse(str);
    }

}

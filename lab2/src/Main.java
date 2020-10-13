import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        LexicalAnalyzer lexicalAnalyzer= new LexicalAnalyzer("input.txt");

        lexicalAnalyzer.analize("int a = b + 1c; ");
    }
}

import java.util.Arrays;
import java.util.List;

public class CheckForAnalyzerToken {

    private final List<String> keywordList = Arrays.asList("if","while","int","float","double","include","void");

    Boolean isDelimiter(char ch)
    {
        return ch == ' ' || ch == '+' || ch == '-' || ch == '*' ||
                ch == '/' || ch == ',' || ch == ';' || ch == '>' ||
                ch == '<' || ch == '=' || ch == '(' || ch == ')' ||
                ch == '[' || ch == ']' || ch == '{' || ch == '}';
    }

    // Returns 'true' if the character is an OPERATOR.
    Boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' ||
                ch == '/' || ch == '>' || ch == '<' ||
                ch == '=';
    }

    // Returns 'true' if the string is a VALID IDENTIFIER.
    Boolean validIdentifier(String str)
    {
        boolean ok = true;
        for (char c = '0' ; c<= '9' ; c++){
            if (str.charAt(0) == c){
                ok = false;
            }
        }
        if (isDelimiter(str.charAt(0))){
            ok = false;
         }
        return ok;

    }

    Boolean isKeyword(String str){
        for (String kw : keywordList){
            if (kw.equals(str))
                return true;
        }
        return false;
    }

    Boolean  isInteger(String str){
        int i, len = str.length();
        if (len == 0)
            return false;
        for (i = 0 ; i < len ; i++){
            for (char c = '0'; c<= '9'; c++ ){
                if (str.charAt(i)!=c)
                    return false;
            }
        }
        return true;
    }


}

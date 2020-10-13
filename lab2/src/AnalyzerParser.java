public class AnalyzerParser {
    CheckForAnalyzerToken checkForAnalyzerToken;

    public AnalyzerParser() {
        this.checkForAnalyzerToken = new CheckForAnalyzerToken();
    }

    public String subString(String str, int left, int right){

        StringBuilder subStr = new StringBuilder();
        for (int i = left; i<=right; i++){
            subStr.append(str.charAt(i));
        }
        return subStr.toString();

    }


    void parse(String str){
        int left = 0, right = 0;
        int len = str.length();

        while (right < len && left <=right){
            if (!checkForAnalyzerToken.isDelimiter(str.charAt(right)))
                right++;

            if(checkForAnalyzerToken.isDelimiter(str.charAt(right)) && left == right) {
                if (str.charAt(right) != ' ')
                    System.out.println(str.charAt(right) + " IS A DELIMITATOR");
                if (checkForAnalyzerToken.isOperator(str.charAt(right)))
                    System.out.println(str.charAt(right) + " IS AN OPERATOR");
                right++;
                left = right;
            }
            else if (checkForAnalyzerToken.isDelimiter(str.charAt(right)) && left != right){
                if (str.charAt(right) != ' ')
                    System.out.println(str.charAt(right) + " IS A DELIMITATOR");
                String subStr = subString(str,left,right-1);
                if (checkForAnalyzerToken.isKeyword(subStr)){
                    System.out.println(subStr + " IS A KEYWORD");
                }else if (checkForAnalyzerToken.isInteger(subStr))
                    System.out.println(subStr +" IS AN INTEGER");
                else if (checkForAnalyzerToken.validIdentifier(subStr) &&
                        !checkForAnalyzerToken.isDelimiter(str.charAt(right - 1)))
                    System.out.println(subStr +" IS A VALID IDENTIFIER");
                else if (!checkForAnalyzerToken.validIdentifier(subStr) &&
                        !checkForAnalyzerToken.isDelimiter(str.charAt(right - 1)))
                    System.out.println(subStr +" IS NOT A VALID IDENTIFIER");
                left = right;
            }
        }
        return;
    }
}

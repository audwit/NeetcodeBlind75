package neetcode.blind75;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        inputList = List.of("neet","code","love","you");
        EncodeDecode encodeDecode = new EncodeDecode();
        String encodedString = encodeDecode.encode(inputList);
        System.out.println("Encoded string is: " + encodedString);

        System.out.println("Decoded to List:" + encodeDecode.decode(encodedString));
    }

    public String encode(List<String> strs) {
        if(strs.isEmpty())
            return "";
        String encodedStr="";
        for(String str: strs)
            encodedStr = encodedStr + str.length()+ "#" + str;
        return encodedStr;
    }

    public List<String> decode(String str) {
        String strLength="";
        List<String> result = new ArrayList<>();
        String resultStr="";

        for(int i=0; i<str.length(); ){
            if(str.charAt(i)!='#'){
                strLength = strLength + str.charAt(i);
                i++;
            }
            else
            {
                resultStr = str.substring(i+1,i+1+Integer.parseInt(strLength));
                str = str.substring(i+1+Integer.parseInt(strLength));
                result.add(resultStr);
                i=0;
                strLength = "";
            }
        }
        return result;
    }
}

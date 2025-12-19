package neetcode.blind75;

public class PalindromeChecker {
    public static void main(String[] args) {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        palindromeChecker.isPalindrome("Was it a car or a cat I saw?");
    }

    public boolean isPalindrome(String s) {
        // Remove all the spaces from the string and put it in StringBuilder
        StringBuilder spaceRemoved = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                spaceRemoved.append(s.charAt(i));
            }
        }
        System.out.println(spaceRemoved);

        // Remove the non alphanumeric characters
        StringBuilder alphanumOnly = new StringBuilder();
        int j=0;
        for(int i=0; i<spaceRemoved.length(); i++){
            if(Character.isLetterOrDigit(spaceRemoved.charAt(i))) {
                alphanumOnly.append(spaceRemoved.charAt(i));
                j++;
            }
        }
        alphanumOnly.setLength(j);

        System.out.println(alphanumOnly);

        //Get length of string

        // Convert the string to charArray
        char[] charArray = new char[alphanumOnly.length()];
        for(int i=0; i<alphanumOnly.length();i++){
            charArray[i] = Character.toLowerCase(alphanumOnly.charAt(i));
        }


        //Have one pointer march forward from the beginning of the charArray and one pointer from the end (int)length/2 times
        // and check whether they are the same character. If the characters pointed by these pointers do not match return false.
        for(int i=0; i<charArray.length/2; i++){
            if(charArray[i]!=charArray[charArray.length-1-i]) {
                System.out.println("Input is not a palindrome");
                return false;
            }
        }
        System.out.println("Input is a palindrome");
        return true;
    }
}

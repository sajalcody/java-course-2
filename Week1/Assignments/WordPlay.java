/**
 * 1. Write a method isVowel that has one Char parameter named ch. 
 * This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise. 
 * For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.
 * 2. Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. 
 * This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. 
 * For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. 
 * Be sure to call the method isVowel that you wrote.
 * 3. Write a method emphasize with two parameters, a String named phrase and a character named ch. 
 * This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
 * - ‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or
 * - ‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).
 *
 * @author (Sajal Agrawal)
 * @since (08/08/2020)
 */

class WordPlay{
    boolean isVowel(char ch){
        char lch = Character.toLowerCase(ch);
        if (lch == 'a' || lch == 'e' || lch == 'i' || lch == 'o' || lch == 'u')
            return true;
        return false;
    }

    void testIsVowel(){
        char ch = 'F';
        System.out.println(ch + " is vowel?: " + isVowel(ch));
        ch = 'a';
        System.out.println(ch + " is vowel?: " + isVowel(ch));
    }

    String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        for (int i = 0; i < sb.length(); i++){
            if(isVowel(sb.charAt(i)))
                sb.setCharAt(i, ch);
        }
        return sb.toString();
    }

    void testReplaceVowel(){
        String s = "Hello World";
        char ch = '*';
        System.out.println("Replacing vowels in " + s + " with " + ch + " : " + replaceVowels(s, ch));
    }

    String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        char chle = Character.toLowerCase(ch);
        for (int i = 0; i < sb.length(); i++){
            char cle = Character.toLowerCase(sb.charAt(i));
            if (cle == chle && i%2 == 0)
                sb.setCharAt(i, '*');
            else if(cle == chle)
                sb.setCharAt(i, '+');
        }
        return sb.toString();
    }

    void testEmphasize(){
        String s = "dna ctgaaactga", se = "dn* ctg+*+ctg+";
        char ch = 'a';
        String sf = emphasize(s, ch);
        if (sf.equals(se))
            System.out.println("emphasize gives correct output for " + s);
        else
            System.out.println("Expected: " + se + "found: " + sf);
        s = "Mary Bella Abracadabra"; se = "M+ry Bell+ +br*c*d*br+"; sf = emphasize(s, ch);
        if (sf.equals(se))
            System.out.println("emphasize gives correct output for " + s);
        else
            System.out.println("Expected: " + se + "found: " + sf);
    }

    public static void main(String args[]){
        WordPlay w = new WordPlay();
        w.testIsVowel();
        w.testReplaceVowel();
        w.testEmphasize();
    }

}
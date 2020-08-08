import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if(idx != -1){
                char newChar = Character.isLowerCase(currChar) ? Character.toLowerCase(shiftedAlphabet.charAt(idx)) : shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public void testCaesarWithFileResource() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
    public void testCaeser(){
        int key = 17;
        String message = "First Legion";
        System.out.println("Message: " + message + "Encryption with key " + key + ": " + encrypt(message, key));
        key = 23;
        System.out.println("Message: " + message + "Encryption with key " + key + ": " + encrypt(message, key));
        
    }
    
    public String encryptTwoKeys (String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if(idx != -1){
                char newChar;
                if (i%2 == 0)
                    newChar = Character.isLowerCase(currChar) ? Character.toLowerCase(shiftedAlphabet1.charAt(idx)) : shiftedAlphabet1.charAt(idx);
                else
                    newChar = Character.isLowerCase(currChar) ? Character.toLowerCase(shiftedAlphabet2.charAt(idx)) : shiftedAlphabet2.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    public void testCaeserTwoKeys(){
        int key1 = 23, key2 = 17;
        String message = "First Legion";
        String encryptExpected = "Czojq Ivdzle";
        String encryptMsg = encryptTwoKeys(message, key1, key2);
        System.out.println("Message: " + message + " Encryption with keys " + key1 + ", " + key2 + ": " + encryptMsg);
        if (encryptMsg.equals(encryptExpected))
            System.out.println("The two keys encryptions works");
        else
            System.out.println("Expected: " + encryptExpected + " Got: " + encryptMsg);
    }
    
    public void quiz(){
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key1 = 8, key2 = 21;
        String encryptMsg = encryptTwoKeys(message, key1, key2);
        System.out.println("Message: " + message + " Encryption with keys " + key1 + ", " + key2 + ": " + encryptMsg);
        message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key = 15;
        System.out.println("Message: " + message + "Encryption with key " + key + ": " + encrypt(message, key));
    }
}


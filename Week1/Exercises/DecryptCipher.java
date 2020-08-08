public class DecryptCipher{
    public void decrypt(String message){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(message);
        for(int i = 1; i <= 25; i++){
            String key = alphabet.substring(i) + alphabet.substring(0, i);
            for (int j = 0; j < message.length(); j++){
                int idx = alphabet.indexOf(Character.toUpperCase(message.charAt(j)));
                if (idx != -1)
                    sb.setCharAt(j, Character.isLowerCase(message.charAt(j)) ? Character.toLowerCase(key.charAt(idx)) : key.charAt(idx));
            }
            System.out.println("Key: " + i + " Decrypt: " + sb);
        }
    }

    public int [] countOcc (String message){
        int [] count = new int [26];
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < message.length(); i++){
            char ch = Character.toUpperCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1)
                count[index]++;
        }
        return count;
    }

    public int maxIndex(int [] count){
        int maxDex = 0;
        for (int i = 1; i < 26; i++){
            if (count[i] > count[maxDex])
                maxDex = i;
        }
        return maxDex;
    }

    public String decryptStats(String message){
        int [] count = countOcc(message);
        int maxi = maxIndex(count);
        int key = maxi - 4
    }
    public static void main(String args[]){
        DecryptCipher d = new DecryptCipher();
        String message = "Lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula.";
        d.decrypt(message);
        int [] count = d.countOcc("a");
        for (int i = 0; i < 26; i++)
            System.out.println((char)(97+i) + ": " + count[i]);
    }
}
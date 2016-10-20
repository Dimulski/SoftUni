package Problem11Palindromes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by User on 11.6.2016 г..
 */
public class Palindromes {

    public static void main(String[] args) throws IOException {

        TreeSet<String> set = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\W+");
        for (String word : input) {
            boolean isPalindrome = true;
            if (word.length() == 1) {
                break;
            }
            String[] wordArr = word.split("");
            for (int i = 0, j = word.length() - 1; i < word.length() / 2; i++, j--) {
                if (!wordArr[i].equals(wordArr[j])) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                set.add(word);
            }
        }
        System.out.println(set.toString());
    }
}

package Problem3WordCount;

import java.io.*;
import java.util.*;

/**
 * Created by User on 8.6.2016 г..
 */
public class WordCount {

    public static void main(String[] args) throws IOException {

        File words = new File("resources\\Problem3WordCount\\words3.txt");
        File text = new File("resources\\Problem3WordCount\\text3.txt");
        File result = new File("resources\\Problem3WordCount\\03_WordCountOut.txt");

        HashMap<String, Integer> wordsAndOccurrences = new HashMap<>();

        try (BufferedReader wordsReader = new BufferedReader(new FileReader(words));
             BufferedReader textReader = new BufferedReader(new FileReader(text));
             BufferedWriter resultWriter = new BufferedWriter(new FileWriter(result))) {

            String[] wordArr = wordsReader.readLine().split("\\W+");
            for (String word : wordArr) {
                wordsAndOccurrences.put(word, 0);
            }
            String line;
            while ((line = textReader.readLine()) != null) {
                String[] wordsOnLine = line.toLowerCase().split("\\W+");
                for (String word : wordsOnLine) {
                    for (String targetWord : wordArr) {
                        if (word.equals(targetWord.toLowerCase())) {
                            wordsAndOccurrences.put(targetWord, wordsAndOccurrences.get(targetWord) + 1);
                        }
                    }
                }
            }
//            Comparator<String> comparator = new ValueComparator<String, Integer>(wordsAndOccurrences);
//            TreeMap<String, Integer> sortedResult = new TreeMap<String, Integer>(comparator);
//            sortedResult.putAll(wordsAndOccurrences);

            wordsAndOccurrences.entrySet().stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(e -> {
                        try {
                            resultWriter.write(String.format("%s - %d%n", e.getKey(), e.getValue()));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        };
                    });
        }
    }
}

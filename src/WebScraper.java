import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static String[] stringToWordArray(String input) {
        String text = input;
        text = text.toLowerCase();

        text = text.replaceAll("[[^\\w]&&[^']]+"," ");
        String[] words = text.split(" ");
        return words;
    }

    public static int appearanceCount(String[] words, String keyword){
        int counter = 0;
        for (String word : words) {
            if (word.equals(keyword)) {
                counter++;
            }
        }
        return counter;
    }

    public static int uniqueCounter(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        return wordSet.size();
    }

    public static Map<String, Integer> wordFrequencies(String[] words) {
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            if (wordFreq.containsKey(word)) {
                wordFreq.put(word, wordFreq.get(word) + 1);
            } else {
                wordFreq.put(word, 1);
            }
        }
        return wordFreq;
    }

    public static void main(String[] unused) {
        String text = urlToString("http://www.glozman.com/TextPages/Harry%20Potter%201%20-%20Sorcerer's%20Stone.txt");
        String[] words = stringToWordArray(text);
        System.out.println(words.length);
        System.out.println(uniqueCounter(words));
        System.out.println(appearanceCount(words, "apple"));
        System.out.println(wordFrequencies(words).get("apple"));

        ArrayList<Integer> wordFreq = new ArrayList<>(wordFrequencies(words).values());
        Collections.sort(wordFreq);
        Collections.reverse(wordFreq);
        for (int i : wordFreq) {
            System.out.println(i);
        }
    }
}
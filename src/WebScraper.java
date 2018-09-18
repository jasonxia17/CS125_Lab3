import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public static String[] removeEmpty(String[] original) {
        List<String> list = new ArrayList<>(Arrays.asList(original));
        list.removeAll(Arrays.asList("", null));
        return list.toArray(new String[0]);
    }

    public static String[] stringToWordArray(String input) {
        String text = input;
        text = text.toLowerCase();
        text = text.replaceAll("[\\s[\\p{Punct}&&[^']]]"," ");

        String[] words = text.split(" ");
        words = removeEmpty(words);
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

    public static void main(String[] unused) {
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] words = stringToWordArray(text);
        for (String word : words) {
            System.out.println(word.length() + ": " + word);
        }
        System.out.println(words.length);
        System.out.println(appearanceCount(words, "soul"));
    }
}
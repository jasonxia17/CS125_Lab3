import javax.imageio.metadata.IIOInvalidTreeException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ObsoleteCode {
    public static String[] removeEmpty(String[] original) {
        List<String> list = new ArrayList<>(Arrays.asList(original));
        list.removeAll(Arrays.asList("", null));
        return list.toArray(new String[0]);
    }

    public static void printWriterTest() throws IOException {
        PrintWriter writer = new PrintWriter("HPWordFreq.csv", StandardCharsets.UTF_8);
        writer.println("The first line");
        writer.println("The second line");
        writer.close();
    }
}

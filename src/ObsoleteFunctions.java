import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObsoleteFunctions {
    public static String[] removeEmpty(String[] original) {
        List<String> list = new ArrayList<>(Arrays.asList(original));
        list.removeAll(Arrays.asList("", null));
        return list.toArray(new String[0]);
    }
}

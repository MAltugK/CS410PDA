import java.util.Arrays;

public class findIndex {
    public static int findIndex(String arr[], String t) {

        int index = Arrays.binarySearch(arr, t);
        if (t.equals("ε")) index = 0;
        return (index < 0) ? -1 : index;

    }
}

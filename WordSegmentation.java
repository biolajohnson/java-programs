import java.util.*;

public class WordSegmentation {
    Set<String> words;

    public WordSegmentation() {
        this.words = new HashSet<>();
        words.add("algorithms");
        words.add("design");
    }

    public boolean segmentWords(String str) {
        // boolean[] memo = new boolean[str.length() - 1];
        String[] cache = new String[str.length() + 1];
        cache[0] = "";
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                cache[i] = cache[i - 1] + str.substring(j, i);
            }
        }
        System.out.println(Arrays.toString(cache));
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        new WordSegmentation().segmentWords(str);
        scanner.close();
    }
}

import java.util.*;

public class WordSegmentation {
    Set<String> words;

    public WordSegmentation() {
        this.words = new HashSet<>();
        words.add("algorithms");
        words.add("design");
        words.add("catapillar");
        words.add("tap");
        words.add("cat");
        words.add("pillar");
    }

    public boolean segmentWords(String str) {
        int n = str.length();
        boolean[] opt = new boolean[n + 1];
        opt[0] = true;
        for (int i = 1; i < opt.length; i++) {
            for (int j = 0; j < i; j++) {
                if (opt[j] && this.words.contains(str.substring(j, i))) {
                    opt[i] = true;
                }
            }
        }
        return opt[n];
    }

    /* greedy approach */
    public List<Integer> getWordsInLine(String[] words) {
        List<Integer> result = new ArrayList<>();
        int width = 0;
        int maxWidth = 10;
        for (String word : words) {
            int wordLength = word.length();
            if (width >= maxWidth) {
                result.add(width);
                width = 0;
            }
            width += wordLength + 1;
        }
        return result;
    }

    public void makeParagraph(List<Integer> wordBreaks, String[] words) {
        int i = 0;
        int width = 0;
        for (String word : words) {
            int length = word.length();
            width += length;
            int wordBreak = wordBreaks.get(i);
            if (width == wordBreak) {
                System.out.print("\n");
            } else {
                System.out.print(word + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        WordSegmentation ws = new WordSegmentation();
        boolean result = ws.segmentWords(str);
        System.out.println("result: " + result);
        scanner.close();
    }
}

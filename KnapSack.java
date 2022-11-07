// import java.util.*;

// public class KnapSack {
// // public static List<Item> getBestSubset(List<Item> list, int target) {
// // // List<Item> result = new ArrayList<>();
// // // int n = list.size();
// // // int[][] opt = new int[n + 1][target + 1];
// // // for (int j = 1; j < target; j++) {
// // // for (int i = 1; j < target + 1; j++) {
// // // /*
// // // * create an item hash
// // // * check if the item exists in the set
// // // * if item exists in set, dolve recurrence equation else, put val =>
// opt[i
// // -
// // // * 1][j]
// // // */
// // // // if (weight <= target) {
// // // // opt[i][j] = Math.max(opt[i - 1][j], opt[i - 1][target - j] + value);
// // // // } else {
// // // // opt[i][j] = opt[i - 1][j];
// // // // }

// // // }
// // // }
// // // System.out.println(Arrays.deepToString(opt));
// // // return result;
// // }

// public static void main(String[] args) {
// List<Item> list = new ArrayList<>();
// Scanner scanner = new Scanner(System.in);
// while (scanner.hasNextLine()) {
// String input = scanner.nextLine();
// if (input.length() < 1) {
// break;
// }
// Item item = new Item(input);
// list.add(item);
// }
// /* get best subset with value 20 */
// List<Item> items = getBestSubset(list, 3);
// System.out.println(items);
// scanner.close();
// }
// }

// class Item {
// int weight;
// int value;

// public Item() {
// };

// public Item(String input) {
// String[] tokens = input.split(" ");
// weight = Integer.parseInt(tokens[0]);
// value = Integer.parseInt(tokens[1]);
// }

// public String toString() {
// return "{value: " + value + ", weight: " + weight + "}";
// }
// }

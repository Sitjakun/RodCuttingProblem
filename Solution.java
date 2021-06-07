import java.util.*;

class Solution {

    private static final Map<Integer, Integer> prices = new HashMap<>();

    private static final Map<Integer, Integer> memory = new HashMap<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // length of the rod
        int L = in.nextInt();

        // marketable rods
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            int length = in.nextInt();
            int value = in.nextInt();
            prices.put(length, value);
        }

        // initialize memory with a value of zero for every length of rod
        for (int i = 0; i <= L; i++) {
            memory.put(i, 0);
        }

        // print solution
        System.out.println(rodCutting(L));
    }

    public static int rodCutting(int totalLength) {
        // for every possible length of rod
        for(int length = 1; length <= totalLength; length ++) {
            // for how much we can cut
            for (int i = 1; i <= length; i++) {
                int price = prices.get(i) != null ? prices.get(i) : 0;
                int tmp = price + memory.get(length - i);
                // maximize the price we can get from cutting i length
                if (tmp > memory.get(length)) {
                    memory.put(length, tmp);
                }
            }
        }
        return memory.get(totalLength);
    }
}

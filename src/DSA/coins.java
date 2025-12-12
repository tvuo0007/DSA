package DSA;

public class coins {
    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1, 0, 0, 1, 1};
        int[] b = {0, 1, 0, 0};
        int[] c = {0, 1, 0, 0, 1, 1, 0, 1};
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
    }
    public static int solution(int[] A) {
        int n = A.length;
        if (n == 1) return 0;
        int pairs = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1]) pairs++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int gain = 0;
            if (i > 0) {
                if (A[i] == A[i - 1]) gain--;
                else gain++;
            }

            if (i < n - 1) {
                if (A[i] == A[i + 1]) gain--;
                else gain++;
            }

            max = Math.max(max, gain);
            
        }
        return pairs + max;
    }
}

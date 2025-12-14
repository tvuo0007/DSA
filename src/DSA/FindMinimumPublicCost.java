package DSA;

public class FindMinimumPublicCost {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 29, 30};
        int[] b = {};
        int[] c = {15};
        int[] d = {1, 2, 3, 4, 5, 6, 7};
        int[] e = {1, 10, 20, 30};
        int[] f = {1, 2, 3, 4, 5, 6, 7, 25, 26};
        int[] g = {1, 2, 3, 4, 5, 15};
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
        System.out.println(solution(d));
        System.out.println(solution(e));
        System.out.println(solution(f));
        System.out.println(solution(g));
    }

    public static int solution(int[] A) {
        int n = A.length;
        if (n == 30) return 25;
        int cnt1Day = 0;
        int cnt7Day = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                int targ = A[i] + 6;
                int idx = i + 1;
                int l = i + 1;
                int r = n - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (A[mid] <= targ) {
                        idx = mid;
                        l = mid + 1;
                    }
                    else r = mid - 1;
                }
                int num = idx - i + 1;
                if (2*num >= 7) {
                    cnt7Day++;
                }
                else {
                    cnt1Day += num;
                }
                i = idx;
            }
            else cnt1Day++;
        }
        if (2*cnt1Day + 7*cnt7Day < 25) return 2*cnt1Day + 7*cnt7Day;
        else return 25;
    }
}

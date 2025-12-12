package DSA;

public class extreme {
    public static void main(String[] args) {
        int[] a = {9, 4, -3, -10};
		System.out.println(solution(a));
    }
    public static int solution(int[] A) {
		int n = A.length;
		if (n == 0) return -1;
		long sum = 0;
		for (int x : A) {
			sum += x;
		}
		double avg = sum*1.0/ n;
		int idx = 0;
		double extreme = Math.abs(A[0] - avg);
		for (int i = 0; i < n; i++) {
			double dev = Math.abs(A[i] - avg);
			if (dev > extreme) {
				extreme = dev;
				idx = i;
			}
		}
		return idx;
	}
}

package DSA;

import java.util.*;

public class SeatReservation {
    public static void main(String[] args) {
        int N1 = 2;
        String S1 = "1A 2F 1C";
        int N2 = 1;
        String S2 = "";
        int N3 = 6;
        String S3 = "1A 2B 1C 3D 4D 4F 5D";
        System.out.println(solution(N1, S1));
        System.out.println(solution(N2, S2));
        System.out.println(solution(N3, S3));
    }

    public static int solution(int N, String S) {
        int res = 3*N;
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < S.length() - 1; i+=3) {
            if (!map.containsKey(Integer.parseInt(String.valueOf(S.charAt(i))))) {
                Set<Character> set = new HashSet<>();
                set.add(S.charAt(i + 1));
                map.put(Integer.parseInt(String.valueOf(S.charAt(i))), set);
            }
            else {
                Set<Character> update = map.get(Integer.parseInt(String.valueOf(S.charAt(i))));
                update.add(S.charAt(i + 1));
            }
        }
        for (Integer x : map.keySet()) {
            if (map.get(x).contains('A') || map.get(x).contains('B') || map.get(x).contains('C')) {
                res--;
            }
            if (map.get(x).contains('E') || map.get(x).contains('F')) {
                res--;
            }
            else if (map.get(x).contains('D') && map.get(x).contains('G')) {
                res--;
            }

            if (map.get(x).contains('H') || map.get(x).contains('J') || map.get(x).contains('K')) {
                res--;
            }
        }
        return res;
    }
}

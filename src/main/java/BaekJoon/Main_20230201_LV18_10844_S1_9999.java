package BaekJoon;

import java.io.*;

public class Main_20230201_LV18_10844_S1_9999 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] store;

    //흠... 감이 안오는데 따져보자
    // 1 -> 1 2 3 4 5 6 7 8 9   -> 9
    // 2 -> 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 90 09 -> 18 인데 09 제외 -1
    //
    public static void main(String[] args) throws IOException {
        n= Integer.parseInt(br.readLine());

        store = new int[n+1];

    }
}

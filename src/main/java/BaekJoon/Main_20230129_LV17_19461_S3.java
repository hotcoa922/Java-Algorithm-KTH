package BaekJoon;

import java.io.*;

public class Main_20230129_LV17_19461_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int t;
    static int n;
    static long[] store;
    //1 1 1 2 2 3 4 5 7 9
    // 점화식은 dp[n] = dp[n-2] + dp[n-3]
    //해보니까 int로 안되네 이거
    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        store = new long[101];
        store[1] = store[2] =store[3] = 1;

        for (int j =4; j < 101; j++) {
            store[j] = store[j-2] + store[j-3];
        }

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());


            bw.write(String.valueOf(store[n] + "\n") );

        }
        bw.close();
    }
}

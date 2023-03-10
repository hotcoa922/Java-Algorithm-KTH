package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230201_LV18_11053_S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr;
    static int[] dp;    //i번째 요소까지의 최대 수열길이를 각각 저장
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            if(max < dp[i]) max = dp[i];
        }

        bw.write(String.valueOf(max));
        bw.close();



    }
}

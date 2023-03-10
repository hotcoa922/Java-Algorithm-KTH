package BaekJoon;

import java.io.*;

public class Main_20230207_LV18_9251_G5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String s1;
    static String s2;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        s1 = br.readLine();
        s2 = br.readLine();

        dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){  //문자가 같다면
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{   //문자가 다르다면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        bw.write(String.valueOf(dp[s1.length()][s2.length()]));
        bw.close();

    }
}

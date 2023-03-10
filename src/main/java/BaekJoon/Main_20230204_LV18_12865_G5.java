package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230204_LV18_12865_G5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;   //물품 종류 갯수
    static int k;   //총 한계 무게
    static int w;   //각 물건의 무게
    static int v;   //각 물건의 가치
    static int[][] dic; //가격표 같은 느낌
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dic = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            dic[i][0] = Integer.parseInt(st2.nextToken());  //각 무게 저장, w
            dic[i][1] = Integer.parseInt(st2.nextToken());  //각 가치 저장, v
        }

        //학교에서 했던 냅색 문제
        //근데 벌써 까먹었네 ㅋ....
        //dp가 아마 물건 번호수 +견딜수 있는 무게 였던거로 기억 즉 dp[n][k] -> dp[아이템 idx][무게]

        dp = new int[n][k];

        for (int i = 0; i < n; i++) {   //다음 i로(다음 아이템) 담을 경우 초기값은 이전에 각 무게마다 담은 가치 그대로 가져옴
            for (int j = 0; j < k; j++) {
                dp[i][k] = Math.max(dp[i - 1][k], dic[i][1] + dp[i - 1][k - dic[i][0]]);
            }
        }

        bw.write(dp[n-1][k-1]);
        bw.close();






    }
}

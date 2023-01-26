package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230124_LV16_14889_S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int player;
    static int min = Integer.MAX_VALUE;
    static int[][] status;
    static boolean[] isVisted;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        status = new int[n][n];
        isVisted = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        player = n/2;
        dfs(0, 0);
        bw.write(String.valueOf(min));
        bw.close();

    }

    static void dfs(int a, int d)  {
        if(d  == player){   //팀 결성 완료 -> 이제 점수차이를 비교해 봐야겠지?
            interval();
            return;
        }

        for (int i = a; i < n; i++) {   //정신 차리자 0아님 a임
            if(isVisted[i]==false){
                isVisted[i]=true;
                dfs(i+1, d+1);
                isVisted[i]=false;
            }
        }
    }

    //팀간 격차
    static void interval() {
        //하나는 올 true팀 하나는 올 false팀
        int a_tot= 0;
        int b_tot=0;
        int diff = 0;   //두팀 임시 격차

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                //둘다 방문 되어야 되거나 방문 안되어야함
                if(isVisted[i]== true && isVisted[j]==true){
                    a_tot += (status[i][j] + status[j][i]);
                }
                else if(isVisted[i]== false && isVisted[j]==false){
                    b_tot += (status[i][j] + status[j][i]);
                }
            }
        }

        diff = Math.abs(a_tot - b_tot);    //절대값

        /*
        if(diff==0){
            bw.write(String.valueOf("0"));
            bw.close();
            System.exit(0);
        }
        */

        if(min>diff){
            min = diff;
        }
    }
}

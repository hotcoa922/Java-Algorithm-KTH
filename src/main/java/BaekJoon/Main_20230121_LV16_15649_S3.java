package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230121_LV16_15649_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] point;
    static boolean[] isVisted;


    public static void main(String[] args) throws IOException {
        //백트래킹
        //모든 경우의 수를 찾아보지만 가능성이 있는 것만 찾아보는 알고리즘
        // 대체로 DFS를 이용하여 구현(BFS도 구현 가능하나 보통 DFS로 구함)
        // 사실 대다수의 문제들은 DFS로 풀면 답은 다 나온다고 한다


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        point = new int[m];
        isVisted = new boolean[n+1];    //1부터 시작

        isVisted[0] = true;
        dfs(0);

        bw.close();


    }

    public static void dfs(int d) throws IOException{
        if(d == m) { //원하는 갯수만큼 탐색 끝
            for(int i=0; i<m; i++){
                bw.write(String.valueOf(point[i] + " "));
            }
            bw.write(String.valueOf("\n"));
            return;
        }

        for (int i = 1; i <n+1; i++) {
            if(isVisted[i]==false){ //미방문 상태시
                isVisted[i] = true;
                point[d] = i;       //얘는 그대로 넣으면 됨
                dfs(d+1);
                isVisted[i] = false;
            }

        }

    }
}

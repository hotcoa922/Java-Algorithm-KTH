package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230115_LV16_15650_S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;

    static int[] point;
    static boolean[] isVisted;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        point = new int[m];
        isVisted = new boolean[n];    //1부터 시작 -> 이렇게 하니깐 난잡하다 걍 0으로 가자


        dfs(0, 0);

        bw.close();

    }

    public static void dfs(int d, int s) throws IOException {
        if (d == m) { //원하는 갯수만큼 탐색 끝
            for (int i = 0; i < m; i++) {
                bw.write(String.valueOf(point[i] + " "));
            }
            bw.write(String.valueOf("\n"));
            return;
        }

        for (int i = s; i < n; i++) {
            if (isVisted[i] == false) {
                isVisted[i] = true;
                point[d] = i + 1; //0으로 처리됬으니깐...
                dfs(d + 1, i + 1);
                isVisted[i] = false;
            }
        }
    }
}

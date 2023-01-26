package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230115_LV16_15651_S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;

    static int[] point;


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        point = new int[m];


        dfs(0);

        bw.close();

    }

    //문제 설계가 잘못된듯 그냥 전체탐색이다 사실상 -> dfs가 아님 사실상 isVisted 노필요
    public static void dfs(int d) throws IOException {
        if (d == m) { //원하는 갯수만큼 탐색 끝
            for (int i = 0; i < m; i++) {
                bw.write(String.valueOf(point[i] + " "));
            }
            bw.write(String.valueOf("\n"));
            return;
        }

        for (int i = 0; i < n; i++) {
            point[d] = i + 1; //0으로 처리됬으니깐...
            dfs(d+1);
        }
    }
}

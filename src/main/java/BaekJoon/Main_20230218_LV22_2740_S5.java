package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230218_LV22_2740_S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m1;
    static int m2;
    static int k;
    static int[][] a;
    static int[][] b;

    static int[][] c;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());

        a = new int[n][m1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j <m1; j++) {
                a[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        m2 = Integer.parseInt(st3.nextToken());
        k = Integer.parseInt(st3.nextToken());

        b = new int[m2][k];
        for (int i = 0; i < m2; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                b[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        c = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {

                for (int l = 0; l < m1; l++) {
                    c[i][j] += a[i][l] * b[l][j];
                }
                bw.write(String.valueOf(c[i][j] + " "));
            }
            bw.write(String.valueOf("\n"));
        }
        bw.close();






        
    }
}

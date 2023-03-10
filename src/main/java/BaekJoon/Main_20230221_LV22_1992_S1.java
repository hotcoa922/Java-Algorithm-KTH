package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230221_LV22_1992_S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] movie;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        movie = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j <str.length(); j++) {
                movie[i][j] = str.charAt(j) - '0';
            }
        }

        div(0, 0, n);
        bw.close();

    }

    public static void div(int a, int b, int size) throws IOException{


        if(check(a, b, size) == true){
            bw.write(String.valueOf(movie[a][b]));
            return;
        }
        bw.write(String.valueOf("("));
        int t_size = size/2;

        //아래꺼 순서 중요하네...

        div(a, b, t_size);
        div(a, b+t_size, t_size);
        div(a+t_size, b, t_size);
        div(a+t_size, b+t_size, t_size);
        bw.write(String.valueOf(")"));
    }

    public static boolean check(int a, int b, int size){
        int standard = movie[a][b];
        for (int i = a; i < a+size; i++) {
            for (int j = b; j < b+size; j++) {
                if(movie[i][j] != standard) return false;
            }
        }

        return true;
    }
}

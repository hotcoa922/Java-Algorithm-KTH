package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230221_LV22_1780_S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int n;
    static int[][] paper;
    static int c1;
    static int c2;
    static int c3;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0,0,n);

        bw.write(String.valueOf(c1 + "\n"+c2 + "\n"+c3 + "\n"));
        bw.close();
    }

    public static void div(int a, int b, int size){
        if(colorCheck(a, b, size) == true){
            if(paper[a][b] == -1) c1++;
            else if(paper[a][b] == 0) c2++;
            else if(paper[a][b] == 1) c3++;

            return;
        }

        int t_size = size/3;

        div(a, b, t_size);  // 전화다이얼로 치면 1
        div(a, b+t_size, t_size);   //2
        div(a, b+t_size+t_size, t_size);   //3
        div(a+t_size, b, t_size);
        div(a+t_size, b+t_size, t_size);
        div(a+t_size, b+t_size+t_size, t_size);
        div(a+t_size+t_size, b, t_size);
        div(a+t_size+t_size, b+t_size, t_size);
        div(a+t_size+t_size, b+t_size+t_size, t_size);



    }

    public static boolean colorCheck(int a, int b, int size){
        int standard = paper[a][b];

        for (int i = a; i < a+size; i++) {
            for (int j = b; j < b+size; j++) {
                if(paper[i][j] != standard) return false;
            }
        }

        return true;
    }
}

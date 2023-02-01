package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230128_LV17_9184_S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int a;
    static int b;
    static int c;

    static int store[][][] = new int[21][21][21];

    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }


            bw.write(String.valueOf("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n"));
        }
        bw.close();

    }

    //재귀 식
//    static int w (int a, int b, int c){
//        if(a <= 0 || b <= 0 || c <= 0) {
//            return 1;
//        }
//
//        if(a > 20 || b > 20 || c > 20) {
//            return w(20, 20, 20);
//        }
//
//        if(a < b && b < c) {
//            return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
//        }
//
//        return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
//    }

    //DP
    static int w(int a, int b, int c) {


        //음수처리 , 가장 먼저해야함
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        //a b c중에서 하나라도 20 초과시
        if(a > 20 || b > 20 || c > 20) {
            return store[20][20][20] = w(20, 20, 20);
        }


        //저장되 있는값 발견시 즉시 반환후 종료
        if(store[a][b][c] != 0){
            return store[a][b][c];
        }


        if(a < b && b < c) {
            return store[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return store[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}

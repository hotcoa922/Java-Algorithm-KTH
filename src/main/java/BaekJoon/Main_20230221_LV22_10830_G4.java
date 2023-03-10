package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230221_LV22_10830_G4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static long b;

    static int[][] arr;
    //static int[][] result;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken()) % 1000;   //미리 나누기
            }
        }


        //흠 난해한데..
        // a^8 = a^4 * a^4 = a^2 .... 성질 이용할까?

        //그럼 지수가 홀수면?
        // a^9 = a^8 a^8 a
        // a^13 = a^6 a^6 a =

        int[][] result = func(arr, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(String.valueOf(result[i][j] + " "));
            }
            bw.write(String.valueOf("\n"));
        }
        bw.close();
    }

    static int[][] func(int[][] target, long tot){

        //종료 처리
        if(tot==1){
            return target;
        }

        //쪼개기 짝수 홀수 작업
        int tmp[][] = func(target, tot/2);
        tmp = square(tmp, tmp);

        if(tot%2 == 1){
            tmp = square(tmp, target);
        }

        return tmp;
    }

    //제곱
    static int[][] square(int[][] tmp1, int[][] tmp2){
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += tmp1[i][k] * tmp2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;

    }
}

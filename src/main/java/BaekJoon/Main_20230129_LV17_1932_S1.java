package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230129_LV17_1932_S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] arr;

    //흠 일단 편하게 풀기위해 특이한 2차원 배열 생각해보자
    //            5
    //
    //            5
    //            4 6
    //            3 5 7
    //            2 4 6 8
    //            1 3 5 7 9
    //
    //
    //            4
    //
    //            4
    //            3 5
    //            2 4 6
    //            1 3 5 7
    //위 생각 파기 -> 굳이 이럴필요 없이 코드로도 간단히 구현가능 위처럼 짜는게 생각보다 골치아픔(할수는 있음)

    //11 부터 넣는다고 생각
    //33 이면 이전에 볼 것들은 22 23


    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];      //앞에 요소가 깊이, n+1이유는 맨 마지막 오류 방지

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
            }
        }

        int max = arr[1][1];
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, arr[n][i]);
        }

        bw.write(String.valueOf(max));
        bw.close();



    }
}

package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20230213_LV19_11399_S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //시간소요 짧은 사람이 앞으로 가야함
        Arrays.sort(arr);

        int tot = 0;

        //첫번쨰 요소 * n + 두번째 요소 *n-1 ...
        for (int i = 0; i < n; i++) {
            tot += arr[i]*(n-i);
        }

        bw.write(String.valueOf(tot));
        bw.close();


    }
}

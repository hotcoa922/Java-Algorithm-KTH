package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20230114_LV10_25305_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int k =Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        bw.write(String.valueOf(arr[n-k]));
        bw.close();

    }
}

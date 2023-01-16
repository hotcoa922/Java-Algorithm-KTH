package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Main_20230114_LV10_2587_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        //주어진 수 n개 일때 n이 짝수이면 중앙값은 2개의 평균임
        //근데 이문제는 5개 픽스라 고민 x

        int[] arr = new int[5];

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i]= Integer.parseInt(br.readLine());
            sum+=arr[i];
        }

        Arrays.sort(arr);

        bw.write(String.valueOf(sum/5 + "\n" + arr[2]));
        bw.close();

    }
}

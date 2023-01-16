package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Main_20230115_LV10_1427_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();   //오랫만에 쓰는데 이거로 문자열 하나씩 쪼개서 배열쳐넣음

        Arrays.sort(arr);

        for (int i = arr.length -1; i >=0; i--) {
            bw.write(String.valueOf(arr[i]));
        }


        bw.close();
    }
}

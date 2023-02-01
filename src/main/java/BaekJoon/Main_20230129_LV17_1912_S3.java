package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230129_LV17_1912_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr;
    static int[] store;     //x번째부터 x+i번째까지 더한 값중에 가장 큰게 store[x]에 저장
    static int max;

    //연속된 수 합
    //얼핏보면 dp 노필요할거 같은데?
    //근데 dp써야겠네 더한값 계속 재탕해야함
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        store = new int[n];
        arr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max = arr[0];
        store[0] = arr[0];


        for (int i = 1; i < n; i++) {
            store[i] = Math.max(store[i-1]+arr[i], arr[i]);
            max = Math.max(store[i], max);
        }

        bw.write(String.valueOf(max));
        bw.close();

    }
}

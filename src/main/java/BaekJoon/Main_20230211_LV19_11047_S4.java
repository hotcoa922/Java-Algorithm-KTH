package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230211_LV19_11047_S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int k;
    static int[] value;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        value = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        //가치가 가장 큰 것부터 채워보기
        //동전 가치 오름차순으로 입력됨 -> 거꾸로 ㄱ

        for (int i = n-1; i >= 0; i--) {
            if(value[i]<=k){
                cnt += k/value[i];
                k= k%value[i];  //나머지값
            }
        }

        bw.write(String.valueOf(cnt));
        bw.close();



    }
}

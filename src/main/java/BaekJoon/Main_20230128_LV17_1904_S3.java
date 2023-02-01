package BaekJoon;

import java.io.*;

public class Main_20230128_LV17_1904_S3 {
    //접근방법 생각이안나네 음...
    //하나씩 일단 생각해보자
    //n=1 : 1                                                   1
    //n=2 : 11 00                                               2
    //n=3 : 111 100 001                                         3
    //n=4 : 1111 1100 1001 0011 0000                            5
    //n=5 : 11111 11100 11001 10011 00011 10000 00100 00001     8
    //이거 피보나치랑 똑같네 ㅋㅋ
    //store[n] = store[n-1] + store[n-2]
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] store;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        store = new int[1000001];

        store[1] = 1;
        store[2] = 2;

        //bw.write(String.valueOf(dp(n)%15746));
        bw.write(String.valueOf(dp(n)));
        bw.close();
    }


    static int dp(int n){
        for (int i = 3; i <= n; i++) {
            //store[i] = store[i-1] + store[i-2];
            store[i] = (store[i-1] + store[i-2])%15746;

        }
        return store[n];
    }
}

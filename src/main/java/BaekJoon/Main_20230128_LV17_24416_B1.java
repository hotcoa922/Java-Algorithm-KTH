package BaekJoon;

import javax.imageio.IIOException;
import java.io.*;

public class Main_20230128_LV17_24416_B1 {
    static int cnt1 = 0;
    static int cnt2 = 0;
    static int[] store;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        //다이나믹 프로그래밍(또는 동적 계획법)은 기본적인 아이디어
        //하나의 큰 문제를 여러 개의 작은 문제로 나누어서 그 결과를 저장하여 다시 큰 문제를 해결할 때 사용하는 것

        //DP사용조건 2가지
        //1. 동일한 작은 문제들이 반복하여 나타나는 경우에 사용이 가능
        //2. 부분 문제의 최적 결과 값을 사용해 전체 문제의 최적 결과를 낼 수 있는 경우를 의미 ->그래서 특정 문제의 정답은 문제의 크기에 상관없이 항상 동일

        //DP 방법 2가지
        //1. Top-down
        //2. Bottom-up
        //나는 Bottom-up 선호 -> 고로 이거로 앵간하면 풀 예정

        int n = Integer.parseInt(br.readLine());
        store = new int[n];
        store[0] = store[1] = 1;

        fib_recu(n);
        fib_dp_bu(n);

        bw.write(String.valueOf(cnt1 + " " + cnt2));
        bw.close();


    }

    static int fib_recu(int n){
        if(n==1 || n==2){
            cnt1++;
            return 1;
        }
        return fib_recu(n-1) + fib_recu(n-2);
    }
    static void fib_dp_bu(int n){
        for (int i = 2; i < n; i++) {
            cnt2++;
            store[i] = store[i-1] + store[i-2];
        }
    }
}

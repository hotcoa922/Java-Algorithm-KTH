package BaekJoon;

import java.io.*;

public class Main_20230201_LV18_1463_S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] store;

//    X가 3으로 나누어 떨어지면, 3으로 나눈다.
//    X가 2로 나누어 떨어지면, 2로 나눈다.
//            1을 뺀다
    //최대한 위에 방법으로 가야함
    //는 아니네 -> Math.min이용해야하네
    //store에 필요 횟수 저장 -> store 20 은 store 5 +1
    public static void main(String[] args) throws IOException {
        n= Integer.parseInt(br.readLine());
        store = new int[n+1];

        store[0] = store[1] = 0;

        //6의 배수도 고려해야함 -> if else if 하면 안돼
        for (int i = 2; i < n+1; i++) {
            store[i] = store[i-1] + 1;  //일단 이거는 5같은거 처리 위해서 먼저 계산해야함, 더 나은 경우는 아래에서 판별(Math.min)
            if(i%3==0){
                store[i] = Math.min(store[i/3]+1, store[i]);
            }
            if(i%2==0){
                store[i] = Math.min(store[i/2]+1, store[i]);
            }
        }

        bw.write(String.valueOf(store[n]));
        bw.close();

    }
}

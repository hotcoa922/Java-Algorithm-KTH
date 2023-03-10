package BaekJoon;

import java.io.*;

public class Main_20230201_LV18_2156_S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int n;
    static int[] podo;
    static int[] store;

    //경우 따져보자
    //1. oox    -> store[i] = store[i-1]
    //2. oxo    -> store[i] = store[i-2] + podo[i]
    //3. xoo    -> store[i] = store[i-3] + podo[i] + podo[i-1]
    //깔끔하네
    //근데 처음이랑 2, 3번쨰 까지는 수도응로 저장해줘야할듯

    public static void main(String[] args) throws IOException {
        n =Integer.parseInt(br.readLine());

        podo = new int[10001];
        store = new int[10001];

        for (int i = 0; i < n; i++) {
            podo[i] = Integer.parseInt(br.readLine());
        }

        store[0] = podo[0];
        store[1] = store[0] + podo[1];
        //store[2] = store[1] + podo[2]; -> 이거 이러면 안되네
        store[2] = Math.max(store[1], Math.max(store[0]+ podo[2], podo[1] + podo[2]));  //3개 다 따져주자
        for (int i = 3; i < n; i++) {
            store[i] = Math.max(store[i-1], Math.max(store[i-2] + podo[i], store[i-3] + podo[i] + podo[i-1]));
        }

        bw.write(String.valueOf(store[n-1]));
        bw.close();

        

    }
}

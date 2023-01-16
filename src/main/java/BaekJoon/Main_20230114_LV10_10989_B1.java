package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main_20230114_LV10_10989_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //앞문제랑 코드 똑같은디...
        //메모리 문제 어케하는지 몰겠다...
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(list.get(i) + "\n"));
        }
        bw.close();


    }
}

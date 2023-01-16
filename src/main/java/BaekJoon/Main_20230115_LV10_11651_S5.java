package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20230115_LV10_11651_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xy, (k1, k2) ->{
            if(k1[1]==k2[1]){   //y좌표 동일시
                return k1[0] - k2[0];          //x좌표 비교
            }
            else{
                return k1[1] - k2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(xy[i][0] +" " + xy[i][1] + "\n"));
        }
        bw.close();



    }
}

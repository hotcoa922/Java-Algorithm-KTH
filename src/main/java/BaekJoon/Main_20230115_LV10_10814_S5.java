package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_20230115_LV10_10814_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[][] str = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken(); //나이
            str[i][1] = st.nextToken(); //이름
        }

        //Integer.parseInt 는 문자열 형을 숫자형으로 변환
        Arrays.sort(str, new Comparator<String[]>() {   //나이순 정렬 용도
            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);   //나이 비교
            }
        });

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(str[i][0] + " " + str[i][1] + "\n"));
        }
        bw.close();
    }
}

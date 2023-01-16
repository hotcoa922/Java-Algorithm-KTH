package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main_20230115_LV10_1181_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }


        //문자열 길이 같으면 사전순
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }
                else{
                    return s1.length() - s2.length();   //양수면 위치 바꾸는거 알지? (양수면 길이 앞에가 길다는 거니깐 뒤로 보내는거지)
                }
            }
        });

        //타임 중복제거 해줘야하네...

        bw.write(String.valueOf(str[0] + "\n"));
        for (int i = 1; i < n; i++) {
            if(!str[i-1].equals(str[i])){
                bw.write(String.valueOf(str[i] + "\n"));
            }
        }
        bw.close();
    }
}

package BaekJoon;

import java.io.*;

public class Main_20230213_LV19_1541_S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String[] str;

    public static void main(String[] args) throws IOException {
        str = br.readLine().split("-");    //- 연산자 기준으로 나눔

        //최소가 되려면 +끼리 죄다 묶어버리면 된다
        // 3 + 4 - 5 + 6 - 7 + 8 + 9 + 10 -> 3+4(0) 5+6(1) 7+8+9+10(2) 총 3개 -> 첫번쨰 요소 빼고 다 빼줌(괄호는 인덱스)


        int result = 0;
        for (int i = 0; i < str.length; i++) {
            //+ 분리작업
            String[] tmp = str[i].split("\\+");   //여기 +로 하면 안되고 \\+ 로 해야함.. 개고생했네...
            int sum = 0;    //임시 +요소들 저장
            for (int j = 0; j < tmp.length; j++) {
                sum += Integer.parseInt(tmp[j]);    //형변환
            }
            if(i==0){   //첫 요소는 마이너스 아님
                result+=sum;
            }
            else{
                result-=sum;
            }
        }

        bw.write(String.valueOf(result));
        bw.close();



    }
}

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230129_LV17_11054_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //상승부분과 하락부분을 나눠서 생각해야할듯?
    //그리고 둘에 대한 합산중에 최고 길이를 출력하자

    static int n;
    static int[] arr;
    static int[] up_phase;
    static int[] down_phase;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        up_phase = new int[n];  //가장 긴부분의 수열길이(상승)
        down_phase = new int[n];    //가장 긴부분의 수열길이(하락)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //가장 긴 상승부분의 수열 길이 + 가장 긴 하락부분의 수열길이 합치면될듯?

        //상승 부분
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if(arr[i]>arr[j]){  //앞에꺼가 더 클떄, 상승페이즈가 아니라는 거임
                    max = Math.max(max, up_phase[j]);
                }
            }
            up_phase[i] = max +1; //기본적인 길이는 본인 포함이라 +1
        }

        //하락 부분
        for (int i = n-1; i >= 0 ; i--) {
            int max = 0;
            for (int j = n-1; j >= 0; j--) {
                if(arr[i]>arr[j]){  //앞에꺼가 더 클떄, 상승페이즈가 아니라는 거임 (역순)
                    max = Math.max(max, down_phase[j]);
                }
            }
            down_phase[i] = max+1;
        }

        int result = 0;
        //up+down-1 값이 최대인것 찾아야함
        for (int i = 0; i < n; i++) {
            result = Math.max(result, up_phase[i]+down_phase[i]-1);
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}

package BaekJoon;

import java.io.*;

public class Main_20230129_LV17_2579_S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr;
    static int[] tot;

//    계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
//    연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
//    마지막 도착 계단은 반드시 밟아야 한다.
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        //arr = new int[n];
        //tot = new int[n];
        //인덱스 오류남
        arr = new int[300];
        tot = new int[300];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tot[0] = arr[0];
        tot[1] = arr[0] + arr[1];
        tot[2] = Math.max(arr[0], arr[1]) + arr[2];
        System.out.println(tot[2]);
        //n번째 계단을 밟는 경우의 수
        //1. n-3 n-1 밟고오기, 이때 처리 잘하자
        //2. n-2 밟고오기
        for (int i = 3; i < n; i++) {
            tot[i] = arr[i] + Math.max(tot[i-3]+arr[i-1], tot[i-2]);
        }

        bw.write(String.valueOf(tot[n-1]));
        bw.close();

    }
}

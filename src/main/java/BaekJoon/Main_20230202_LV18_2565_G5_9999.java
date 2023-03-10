package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20230202_LV18_2565_G5_9999 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] connect;
    static int[] store;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        connect = new int[n][2];    //첫째 줄부터 연결된 전기줄 정보 저장
        store = new int[n];     //i번째 포함했을 때 최대 갯수
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            connect[i][0] = Integer.parseInt(st.nextToken()) - 1;   //위치랑 인덱스 일치 시켜주면 보기 편할거 같아서 -1
            connect[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        Arrays.fill(store, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(connect[i][1] <connect[j][1]){   //후속의 것이 더 멀리떨어진것과 연결되어야 함

                }
            }
        }


        //발상이 안되는데 흠...
        //차라리 최대를 구해서 전체에서 뺴는게 나을듯
        //안풀려서 찾아봄
        //LIS기법 사용하라고 한다
        //여기서dp[x]는 x번째 수를 마지막 문자로 가지는 LIS의 길이
        //1. dp배열을 1로 초기화
        //2. i번째와 그보다 왼쪽의수(작은수)의 크기 비교
        //3. 비교해서 i번째가 더 크다면 순서대로 되어 있으므로 dp배열 값 업데이트
        //4. dp배열 돌면서 가장 큰 길이의 LIS구함
        //5. 전체 길이에서 LIS만큼 뺴주면 최소 전깃줄 갯수


    }
}

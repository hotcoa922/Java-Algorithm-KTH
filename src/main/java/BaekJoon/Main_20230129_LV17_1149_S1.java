package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230129_LV17_1149_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;

    //1번 집의 색은 2번 집의 색과 같지 않아야 한다.
    //N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
    //i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

    //규칙 잘 안보이네.. 따져보자 -> 가격 3개 주어지면 1 2 3 순으로 가격 적은거를 갯수 많이주가
    //1     1 0 0       1
    //2     1 1 0       1 2
    //3     1 1 1       1 2 3
    //4     2 1 1       1 2 3 1
    //5     2 2 1       1 2 3 1 2
    //6     2 2 2       1 2 3 1 2 3
    //즉 이게 따지고보면 저런식으로 배치되는데  1 2 3에 각각 멀 넣느냐에 따라서 총 3개의 해가 나오고 3개의 해중에 최소를 구해야하네ㅋ
    //2차원배열로 세트 묶고 두번째 요소[2]한다음에 각각 구하면 깔끔할듯

    //타임 발상 잘못함 3 일떄 1 2 3 일필요 없이 1 2 1이어도 되네...
    //위 아이디어 파기.. ㅅㅂ ㅠㅠ

    static int[][] cost;

    public static void main(String[] args) throws IOException {
         n = Integer.parseInt(br.readLine());
         cost = new int[n][3];

         //0은 red 1 green 2 blue
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            //시작이 빨강
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);

            //시작이 초록
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);

            //시작이 파랑
            cost[i][2] += Math.min(cost[i-1][1], cost[i-1][0]);
        }

        bw.write(String.valueOf(Math.min(Math.min(cost[n-1][0], cost[n-1][1]),cost[n-1][2])));

        bw.close();
    }
}

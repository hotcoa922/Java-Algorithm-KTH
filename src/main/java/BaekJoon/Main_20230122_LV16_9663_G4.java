package BaekJoon;

import javax.imageio.IIOException;
import java.io.*;

public class Main_20230122_LV16_9663_G4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] where;
    static boolean[][] isVisted;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        where = new int[n][n];
        isVisted = new boolean[n][n];

        recu(0);

        bw.write(String.valueOf(cnt));
        bw.close();

    }
    //어차피 nxn행렬에 n개 들어가려면 각 행에 1개는 무조건 들어가야함
    //따라서 위부터 탐색
    public static void recu(int d) throws IOException{
        if(d==n){
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isVisted[d][i]==false){
                isVisted[d][i]=true;
                where[d][i] = 1;
                check(d, i);
                recu(d+1);

            }

            /* 이전 상태로 돌아가기 */
            where[d][i] = 0;	// 퀸을 빼고,
            init_visit();	// 초기화를 시킨뒤

            /* 이전에 두었던 퀸의 위치 복원 */
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    if (where[a][b] == 1)
                        check(a, b);
                }
            }
        }
    }

    //퀸의 공격방향(즉 놓을 수 없는곳, 방문해버린거 처리로 하자)
    public static void check(int x, int y){

        //직선방향 -> 는 생각해보니 양 옆은 차피 안되고 아래만 보면되네
        for (int i = x; i < n; i++) {
            isVisted[i][y]=true;
        }

        //우측 대각선(<모양 대각선들) -> 는 생각해보니 위에서부터 순차니깐 우측 아래 대각선만
        int tmp1 = 0;
        for (int i = x; i < n; i++) {
            isVisted[i][y+tmp1]=true;
            tmp1++;

            if(tmp1+y >= n) break;
        }

        //좌측 대각선(>모양 대각선들) -> 는 생각해보니 위에서부터 순차니깐 좌측 아래 대각선만
        int tmp2 = 0;
        for (int i = x; i < n; i++) {
            isVisted[i][y-tmp2]=true;
            tmp2++;

            if(y-tmp2 < 0) break;
        }

    }

    public static void init_visit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isVisted[i][j] = false;
            }
        }
    }

}

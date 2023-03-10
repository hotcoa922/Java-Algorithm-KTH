package BaekJoon;


import java.io.*;
import java.util.StringTokenizer;

//분할정복
// 문제를 나눌 수 없을 때 까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘
// 분할 가능할 경우 2개 이상으로 문제를 나누고 여러개로 나눔
// 이후 다시 병합
//재귀호출 자주사용
public class Main_20230218_LV22_2630_S2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] paper;

    static int w_cnt= 0;
    static int b_cnt = 0;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0, n);

        bw.write(String.valueOf(w_cnt + "\n" + b_cnt));
        bw.close();






    }

    public static void div(int a, int b, int size){
        if(colorCheck(a, b, size) == true){   //전원 같은색깔
            if(paper[a][b] == 0) w_cnt++;
            else b_cnt++;

            return;
        }

        int t_size = size/2;

        div(a, b, t_size);  //2사
        div(a, b+t_size, t_size);  //1사
        div(a+t_size, b, t_size);  //3사
        div(a+t_size, b+t_size, t_size);  //4사

    }

    public static boolean colorCheck(int a, int b, int size){

        int standard = paper[a][b]; //기준 색깔

        for (int i = a; i < a+size; i++) {
            for (int j = b; j < b+size; j++) {
                if(paper[i][j] != standard) return false;
            }
        }

        return true;

    }
}

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20230123_LV16_14888_S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int n;
    static int[] n_arr; //숫자 집합
    static int[] o_arr; //연산자 집합


    public static void main(String[] args) throws IOException {

        n= Integer.parseInt(br.readLine());//수 갯수
        n_arr = new int[n];
        o_arr = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            n_arr[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            o_arr[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(n_arr[0], 1);
        bw.write(String.valueOf(max + "\n" + min));
        bw.close();

    }

    public static void dfs(int result, int d){  //최종 결과와 깊이를 요소로 받음
        if(d==n){
            if(max<result) max=result;
            if(min>result) min=result;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(o_arr[i]>0){ //연산자 존재하는 경우
                o_arr[i]--; //해당 연산자 사용할 거니깐 하나 뺴줌

                if(i==0){   //+
                    dfs(result + n_arr[d], d+1);
                }
                else if(i==1){  //-
                    dfs(result - n_arr[d], d+1);
                }
                else if(i==2){  //*
                    dfs(result * n_arr[d], d+1);
                }
                else if(i==3){  ///
                    dfs(result / n_arr[d], d+1);
                }
                o_arr[i]++; //회복시켜주기
            }
            
        }
    }
}

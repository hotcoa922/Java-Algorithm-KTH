package BaekJoon;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_20230212_LV19_1931_S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] time;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        time = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        //종료시간을 기준으로 정렬해야할 것 같다
        //가장 빨리 종료되는게 가장 먼저로

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                //종료시간 같을 경우 시작시간이 빠른게 앞에 와야함 -> 오름차순
                if(o1[1] == o2[1]){
                    return o1[0]-o2[0];
                }

                //기본베이스 -> 오름차순
                return o1[1] - o2[1];

            }
        });

        int tmp = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(tmp <= time[i][0]){  //시작시간이 이전 종료시간(tmp)보다 크다면
                tmp = time[i][1];
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }
}

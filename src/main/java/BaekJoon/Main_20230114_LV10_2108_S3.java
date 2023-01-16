package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main_20230114_LV10_2108_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int[] cnt = new int[8001];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
            sum+=list.get(i);
            if(list.get(i)>=0){
                cnt[list.get(i)]++;
            }
            else{
                int tmp = (-1) * (list.get(i))+4000;
                cnt[tmp]++;
            }
        }

        int max = -1;
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            int tmp = i;
            if(max==cnt[i]){
                if(i>=4001){
                    tmp = (-1)*(tmp-4000);
                }
                list2.add(tmp);
            }
            else if(max<cnt[i]){
                if(i>=4001){
                    tmp = (-1)*(tmp-4000);
                }
                list2.clear();
                list2.add(tmp);
                max=cnt[i];
            }
        }

        int manyIdx;
        Collections.sort(list2);
        if(list2.size()==1){
            manyIdx = list2.get(0);
        }
        else{
            manyIdx=list2.get(1);
        }


        Collections.sort(list);


        //String avg = String.format("%.0f", (double)sum/n); -> 이렇게 하면 0 -0 문제 발생
        int avg = (int)Math.round((double)sum/n);

        bw.write(String.valueOf(avg + "\n" + list.get(n/2) + "\n" + manyIdx + "\n" +  (list.get(n-1)-list.get(0))));
        bw.close();




    }
}

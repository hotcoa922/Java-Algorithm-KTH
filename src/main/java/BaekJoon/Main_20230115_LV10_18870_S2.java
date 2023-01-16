package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_20230115_LV10_18870_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sarr = new int[n];    //정렬할 배열
        HashMap<Integer,Integer> kv = new HashMap<Integer,Integer>();   //key-value 저장할 곳 ex) 최저값-0

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sarr = arr.clone(); //배열 깊은복사(원본 안바뀜)
        Arrays.sort(sarr);


        int cnt = 0;
        kv.put(sarr[0], cnt);

        for (int i = 1; i < n; i++) {
            if (sarr[i] != sarr[i - 1]) { // 이전의값과 동일할 경우 넣을 필요 없음, 중복값임 -> hashmap에 중복된키는 원래 존재하지 않음
                kv.put(sarr[i], ++cnt);
            }
        }

        //key를 통해 value 찾자 가물가물하니깐 이부분 검색하자 -> 해쉬맵.get(키)

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(kv.get(arr[i]) + " "));
            //최저값 null로 나오는데 원인 찾아야한다...
            //개 빠가사린가??? sarr[0] = 0 이 코드 지워서 해결 슈발...
        }
        bw.close();




    }
}

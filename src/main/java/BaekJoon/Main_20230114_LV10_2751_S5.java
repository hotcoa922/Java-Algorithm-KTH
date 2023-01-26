package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main_20230114_LV10_2751_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //와 Arrays.sort 이제 못쓸듯... 시간복잡도 문제 생김
        //Arrays.sort의 시간복잡도는 평균 O(nlogn)이지만 최악의 경우 시간복잡도는 O(n^2)
        //즉 O(n^2)인 경우 해결 안되나봄
        //Collections.sort이용하여 해결 가능

        //하는김에 정렬 종류 정리해보자
        //선택정렬 - O(n^2), 선택된 값과 나머지 데이터중에 비교하여 알맞은 자리를 찾는 알고리즘, 별로네
        //삽입정렬 - O(n^2) (최선의 경우 n), 데이터 집합을 순회하면서 정렬이 필요한 요소롤 뽑아내어 이를 다시 적당한곳으로 삽입하는 알고리즘
        //버블정렬 - O(n^2), 둘 이상의 부분집합으로 가르고,  인접한 두 수를 비교하여 오름차순or 내림차순
        //병합정렬 - O(nlogn), 둘 이상의 부분집합으로 가르고, 각 부분집합을 정렬한 다음 부분집합들을 다시 정렬된 형태로 합치는 방식
        //힙정렬 - O(nlogn),트리 기반으로 최대 힙 트리or 최소 힙 트리를 구성해 정렬을 하는 방법
        //퀵정렬 - O(nlogn), 데이터 집합내에 임의의 기준(pivot)값을 정하고 해당 피벗으로 집합을 기준으로 두개의 부분 집합으로 나눈다.

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        //맞추고 다른사람 풀이들 보니 StringBuilder통해 속도 향상 가능
        /*
        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(list.get(i) + "\n"));
        }
        bw.close();

         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(String.valueOf(list.get(i) + "\n"));
        }
        bw.write(sb.toString());
        bw.close();

        //엥 안빨라지는데...?

    }
}

package test;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
    }

    public int[] solution(int[][] v) {

        v = new int[3][2];
        int answer[] = new int[2];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            v[i][0] = sc.nextInt();
            v[i][1] = sc.nextInt();
        }
        if(v[0][0] == v[1][0])
            answer[0] = v[2][0];
        else if (v[0][0] == v[2][0])
            answer[0] = v[1][0];
        else
            answer[0] = v[0][0];

        if(v[0][1] == v[1][1])
            answer[1] = v[2][1];
        else if (v[0][1] == v[2][1])
            answer[1] = v[1][1];
        else
            answer[1] = v[0][1];


        sc.close();
        return answer;
    }

}

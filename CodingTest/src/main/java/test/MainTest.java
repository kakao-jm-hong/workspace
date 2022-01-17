package test;

import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        ArrayList[][] map = new ArrayList[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = new ArrayList<Integer>();
            }
        }

        map[1][2].add(1);
        map[1][2].add(2);
    }

}

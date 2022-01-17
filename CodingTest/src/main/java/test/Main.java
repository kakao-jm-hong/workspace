package test;

import user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int year;
    static int month;
    static int day;
    static int week;

    static Map<String,Integer> hash = new HashMap<>();

    static void init(){
        hash.put("MON",1);
        hash.put("TUE",2);
    }

    public static void main(String[] args) throws IOException {
        init();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        String[] split = input.split(" ");

//        StringTokenizer st = new StringTokenizer(split[0],"/");
//
//        year = Integer.parseInt(st.nextToken());
//        month = Integer.parseInt(st.nextToken());
//        day = Integer.parseInt(st.nextToken());

        String[] splitStream = split[0].split("/");

        year = Integer.parseInt(splitStream[0]);
        month = Integer.parseInt(splitStream[1]);
        day = Integer.parseInt(splitStream[2]);


        week = hash.get(split[1]);

        System.out.println("year = " + year );
        System.out.println("month = " + month );
        System.out.println("day = " + day );
        System.out.println("week = " + week );


    }
}

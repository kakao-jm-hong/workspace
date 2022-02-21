package ch03;

public class Main {

    interface SingleInterface {
        int 씨발(int test);
    }

    static public Integer lamdaTest(SingleInterface singleInterface, int test) {
        int i = 4;

        return test + singleInterface.씨발(i);

    }

    public static void main(String[] args) {

        int ret = lamdaTest(e -> {
            return e * 3;
        }, 3);

        System.out.println("ret= " + ret);

    }
}

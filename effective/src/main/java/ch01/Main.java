package ch01;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigInteger;
import java.util.*;

public class Main {

    // 정
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.probablePrime(2000, new Random());
        System.out.println(bigInteger);

    }

    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public int size() {
                return a.length;
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }
        };
    }
}

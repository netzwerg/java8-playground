package ch.netzwerg.euler;

import java.util.function.Function;

/**
 * @author rahel.luethy@gmail.com
 */
public class Lambda {

    private static Function<Integer, Integer> times3 = (Integer x) -> (x * 3);

    interface Times {
        int times(int x);
    }

    private static Times fortyTwo = (int x) -> (x * 42);

    public static void main(String[] args) {
        System.out.println("2 * 3 = " + times3.apply(2));
        System.out.println("42 * 2 = " + fortyTwo.times(2));
    }

}

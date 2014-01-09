package ch.netzwerg.euler;

import java.util.function.Function;

/**
 * @author rahel.luethy@gmail.com
 */
@SuppressWarnings("ALL")
public class Lambda {

    // Generic Function interface
    private static Function<Integer, Integer> times3 = (Integer x) -> {return x * 3;};

    // Statement lambda can be replaced with expression lambda
    private static Function<Integer, Integer> times4 = (Integer x) -> x * 3;

    // Argument types may be omitted if compiler can infer them
    private static Function<Integer, Integer> times5 = x -> x * 5;

    // Custom functional interface
    interface Times {
        int times(int x);
    }

    // Custom functional interface, again with type inference
    private static Times fortyTwo = x -> x * 42;

    // Method reference
    private static Times ninetyNine = Lambda::ninetyNine;

    public static int ninetyNine(int x) {
        return x * 99;
    }

    public static void main(String[] args) {
        System.out.println("2 * 3 = " + times3.apply(2));
        System.out.println("7 * 4 = " + times4.apply(7));
        System.out.println("6 * 5 = " + times5.apply(6));
        System.out.println("42 * 2 = " + fortyTwo.times(2));
        System.out.println("99 * 10 = " + ninetyNine.times(10));
    }

}

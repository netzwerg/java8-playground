package ch.netzwerg;

import java.util.stream.IntStream;

/**
 * @author rahel.luethy@gmail.com
 */
public class ProjectEuler {

    public static void main(String[] args) {
        System.out.println("Problem 001: " + problem001());
    }

    private static int problem001() {
        return IntStream.range(1, 1000).filter(x -> (x % 5 == 0 || x % 3 == 0)).sum();
    }

}

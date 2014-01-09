package ch.netzwerg;

/**
 * @author rahel.luethy@gmail.com
 */
@SuppressWarnings("UnusedDeclaration")
public class DefaultMethodExamples {


    interface Dog {
        String bark();

        default String wagTail() {
            return "left right left right left";
        }
    }

    static class DefaultDog implements Dog {
        @Override
        public String bark() {
            return "wuff!";
        }

    }

    static class SpecialDog extends DefaultDog {
        @Override
        public String wagTail() {
            return "wiggle wiggle wiggle";
        }
    }

    interface HappyDog {
        default String wagTail() {
            return "wiggle waggle";
        }
    }

    static class HappySpecialDog extends SpecialDog implements HappyDog {
        // inheritance vs. interface defaults
    }

    public static void main(String[] args) {
        // default implementation at work
        System.out.println(new DefaultDog().wagTail());

        // overridden default implementation
        System.out.println(new SpecialDog().wagTail());

        // class method declarations are preferred to interface defaults
        System.out.println(new HappySpecialDog().wagTail());
    }

}

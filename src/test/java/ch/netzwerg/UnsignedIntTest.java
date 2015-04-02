package ch.netzwerg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnsignedIntTest {

    @Test
    public void roundTrip() {

        // compile error: 2^32 - 1 is too large for an int
        // int intValue = 4294967295;

        long longValue = (long) Math.pow(2, 32) - 1;
        String longValueAsString = String.valueOf(longValue);

        int unsignedInt = Integer.parseUnsignedInt(longValueAsString);

        long result = Integer.toUnsignedLong(unsignedInt);

        assertEquals(longValue, result);

    }

}
import static org.junit.Assert.*;

public class UtilitiesTest {

    public Utilities util;

    @org.junit.Before
    public void setup() {
        util = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() throws Exception {
        char[] input = "hello".toCharArray(); // = new char[] {'h','e','l','l','o'}
        char[] expected = "el".toCharArray();
        assertArrayEquals(expected, util.everyNthChar(input, 2));
        assertArrayEquals(input, util.everyNthChar(input, 6));
    }

    @org.junit.Test
    public void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned after null sent", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
    }

    @org.junit.Test
    public void converter() {
        assertEquals(300, util.converter(10,5));

    }
    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_divideBy0() {
        util.converter(10,0);
    }


    @org.junit.Test
    public void nullIfOddLength() {
        assertEquals("Hello!", util.nullIfOddLength("Hello!"));
        assertNull(util.nullIfOddLength("Hello"));
    }
}
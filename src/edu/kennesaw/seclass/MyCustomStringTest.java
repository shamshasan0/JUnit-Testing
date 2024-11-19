/** Shams Hasan
 * Software Testing & QA
 * Assignment 4
 */

package edu.kennesaw.seclass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @BeforeEach
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @AfterEach
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    /** Testing a string with numbers */
    public void testCountNumbers1() {
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    @Test
    /** Testing a string with no numbers */
    public void testCountNumbers2() {
        mycustomstring.setString("Hello, World!");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    /** Testing a null string */
    public void testCountNumbers3() {
        mycustomstring.setString(null);
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    /** Testing an empty string */
    public void testCountNumbers4() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    /** Testing a string with one number */
    public void testCountNumbers5() {
        mycustomstring.setString("I have 2 apples.");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    /** Testing a string with consecutive numbers */
    public void testCountNumbers6() {
        mycustomstring.setString("123 456 789");
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    /** Testing reverseNCharacters with n less than string length */
    public void testReverseNCharacters1() {
        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srep.", mycustomstring.reverseNCharacters(4, false));
    }

    @Test
    /** Testing reverseNCharacters with padding */
    public void testReverseNCharacters2() {
        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srepXXX.", mycustomstring.reverseNCharacters(4, true));
    }

    @Test
    /** Testing reverseNCharacters with n greater than string length */
    public void testReverseNCharacters3() {
        mycustomstring.setString("abc");
        assertEquals("cba", mycustomstring.reverseNCharacters(5, false));
    }

    @Test
    /** Testing reverseNCharacters with padding */
    public void testReverseNCharacters4() {
        mycustomstring.setString("abc");
        assertEquals("baXc", mycustomstring.reverseNCharacters(2, true));
    }

    @Test
    /** Testing reverseNCharacters with negative n value */
    public void testReverseNCharacters5() {
        mycustomstring.setString("abc");
        assertThrows(IllegalArgumentException.class, () -> {
            mycustomstring.reverseNCharacters(-1, false);
        });
    }

    @Test
    /** Testing reverseNCharacters with n = 0 */
    public void testReverseNCharacters6() {
        mycustomstring.setString("abc");
        assertThrows(IllegalArgumentException.class, () -> {
            mycustomstring.reverseNCharacters(0, false);
        });
    }

    @Test
    /** Testing reverseNCharacters with null string */
    public void testReverseNCharacters7() {
        assertThrows(NullPointerException.class, () -> {
            mycustomstring.reverseNCharacters(2, false);
        });
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with digits in range */
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        mycustomstring.convertDigitsToNamesInSubstring(17, 24);
        assertEquals("H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!", mycustomstring.getString());
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with no digits */
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("Hello World");
        mycustomstring.convertDigitsToNamesInSubstring(1, 11);
        assertEquals("Hello World", mycustomstring.getString());
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with invalid start index */
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("12345");
        assertThrows(MyIndexOutOfBoundsException.class, () -> {
            mycustomstring.convertDigitsToNamesInSubstring(-1, 5);
        });
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with invalid end index */
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("12345");
        assertThrows(MyIndexOutOfBoundsException.class, () -> {
            mycustomstring.convertDigitsToNamesInSubstring(0, 10);
        });
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with null string */
    public void testConvertDigitsToNamesInSubstring5() {
        assertThrows(NullPointerException.class, () -> {
            mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        });
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with no digits */
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("abcdefg");
        mycustomstring.convertDigitsToNamesInSubstring(1, 7);
        assertEquals("abcdefg", mycustomstring.getString());
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with only digits */
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("789");
        mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        assertEquals("Seveneightnine", mycustomstring.getString());
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with mixed characters */
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("H3llo2");
        mycustomstring.convertDigitsToNamesInSubstring(2, 6);
        assertEquals("HThreelloTwo", mycustomstring.getString());
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with first character as digit */
    public void testConvertDigitsToNamesInSubstring9() {
        mycustomstring.setString("4friends");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("Fourfriends", mycustomstring.getString());
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with both digits and letters */
    public void testConvertDigitsToNamesInSubstring10() {
        mycustomstring.setString("abc123def");
        mycustomstring.convertDigitsToNamesInSubstring(4, 6);
        assertEquals("abcOnetwothreedef", mycustomstring.getString());
    }

    @Test
    /** Testing convertDigitsToNamesInSubstring with overlapping ranges */
    public void testConvertDigitsToNamesInSubstring11() {
        mycustomstring.setString("H4ppy 2023!");
        mycustomstring.convertDigitsToNamesInSubstring(2, 8);
        assertEquals("HFourppy Twozero23!", mycustomstring.getString());
    }
}

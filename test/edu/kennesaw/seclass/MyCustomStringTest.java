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
    public void testCountNumbers1() {
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        // Testing a string with no numbers
        mycustomstring.setString("Hello, World!");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers3() {
        // Testing a null string
        mycustomstring.setString(null);
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {
        // Testing an empty string
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
        // Testing a string with one number
        mycustomstring.setString("I have 2 apples.");
        assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        // Testing a string with consecutive numbers
        mycustomstring.setString("123 456 789");
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    public void testReverseNCharacters1() {
        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srep.", mycustomstring.reverseNCharacters(4, false));
    }

    @Test
    public void testReverseNCharacters2() {
        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srepXXX.", mycustomstring.reverseNCharacters(4, true));
    }

    @Test
    public void testReverseNCharacters3() {
        // Testing with n greater than string length
        mycustomstring.setString("abc");
        assertEquals("cba", mycustomstring.reverseNCharacters(5, false));
    }

    @Test
    public void testReverseNCharacters4() {
        // Testing with padding
        mycustomstring.setString("abc");
        assertEquals("baXc", mycustomstring.reverseNCharacters(2, true));
    }

    @Test
    public void testReverseNCharacters5() {
        // Testing with a negative value of n
        mycustomstring.setString("abc");
        assertThrows(IllegalArgumentException.class, () -> {
            mycustomstring.reverseNCharacters(-1, false);
        });
    }

    @Test
    public void testReverseNCharacters6() {
        // Testing with n = 0
        mycustomstring.setString("abc");
        assertThrows(IllegalArgumentException.class, () -> {
            mycustomstring.reverseNCharacters(0, false);
        });
    }

    @Test
    public void testReverseNCharacters7() {
        // Testing reversing with null string
        assertThrows(NullPointerException.class, () -> {
            mycustomstring.reverseNCharacters(2, false);
        });
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        mycustomstring.convertDigitsToNamesInSubstring(17, 24);
        assertEquals("H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        // Testing with a substring that has no digits
        mycustomstring.setString("Hello World");
        mycustomstring.convertDigitsToNamesInSubstring(1, 11);
        assertEquals("Hello World", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        // Testing with invalid start index
        mycustomstring.setString("12345");
        assertThrows(MyIndexOutOfBoundsException.class, () -> {
            mycustomstring.convertDigitsToNamesInSubstring(-1, 5);
        });
    }

    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        // Testing with invalid end index
        mycustomstring.setString("12345");
        assertThrows(MyIndexOutOfBoundsException.class, () -> {
            mycustomstring.convertDigitsToNamesInSubstring(0, 10);
        });
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        // Testing conversion with null string
        assertThrows(NullPointerException.class, () -> {
            mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        });
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        // Testing conversion of a substring without digits
        mycustomstring.setString("abcdefg");
        mycustomstring.convertDigitsToNamesInSubstring(1, 7);
        assertEquals("abcdefg", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        // Testing conversion where all characters are digits
        mycustomstring.setString("789");
        mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        assertEquals("Seveneightnine", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        // Testing conversion with mixed characters
        mycustomstring.setString("H3llo2");
        mycustomstring.convertDigitsToNamesInSubstring(2, 6);
        assertEquals("HThreelloTwo", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring9() {
        // Testing conversion with the first character as a digit
        mycustomstring.setString("4friends");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("Fourfriends", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring10() {
        // Testing conversion when the substring includes both digits and letters
        mycustomstring.setString("abc123def");
        mycustomstring.convertDigitsToNamesInSubstring(4, 6);
        assertEquals("abcOnetwothreedef", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring11() {
        // Testing conversion with overlapping ranges
        mycustomstring.setString("H4ppy 2023!");
        mycustomstring.convertDigitsToNamesInSubstring(2, 8);
        assertEquals("HFourppy Twozero23!", mycustomstring.getString());
    }
}

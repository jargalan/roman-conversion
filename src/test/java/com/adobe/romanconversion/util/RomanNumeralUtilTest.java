package com.adobe.romanconversion.util;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
public class RomanNumeralUtilTest {

    @Rule
    public final ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenLessThan1ThrownThenRuleIsApplied() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Wrong number for Roman numeral. Enter a valid number from 1 to 3999.");
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        assertThrows(IllegalArgumentException.class, () -> subject.convertIntToRoman(0));
    }

    @Test
    public void whenGreaterThan3999ThrownThenRuleIsApplied() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Wrong number for Roman numeral. Enter a valid number from 1 to 3999.");
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        assertThrows(IllegalArgumentException.class, () -> subject.convertIntToRoman(4000));
    }

    @Test
    public void shouldConvertIntToRoman100() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        assertEquals(subject.convertIntToRoman(100), "C");
        assertEquals(subject.convertIntToRoman(500), "D");
        assertEquals(subject.convertIntToRoman(1000), "M");
    }

    @Test
    public void shouldConvertIntToRoman234() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        final String actual = subject.convertIntToRoman(234);
        final String expected = "CCXXXIV";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldConvertIntToRoman826() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        final String actual = subject.convertIntToRoman(826);
        final String expected = "DCCCXXVI";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldConvertIntToRoman2759() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        final String actual = subject.convertIntToRoman(2759);
        final String expected = "MMDCCLIX";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldConvertIntToRoman3445() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        final String actual = subject.convertIntToRoman(3445);
        final String expected = "MMMCDXLV";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldConvertIntToRoman3999() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        final String actual = subject.convertIntToRoman(3999);
        final String expected = "MMMCMXCIX";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldConvertIntToRoman1_10() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        assertEquals(subject.convertIntToRoman(1), "I");
        assertEquals(subject.convertIntToRoman(2), "II");
        assertEquals(subject.convertIntToRoman(3), "III");
        assertEquals(subject.convertIntToRoman(4), "IV");
        assertEquals(subject.convertIntToRoman(5), "V");
        assertEquals(subject.convertIntToRoman(6), "VI");
        assertEquals(subject.convertIntToRoman(7), "VII");
        assertEquals(subject.convertIntToRoman(8), "VIII");
        assertEquals(subject.convertIntToRoman(9), "IX");
        assertEquals(subject.convertIntToRoman(10), "X");
    }

    @Test
    public void shouldConvertIntToRoman11_20() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        assertEquals(subject.convertIntToRoman(11), "XI");
        assertEquals(subject.convertIntToRoman(12), "XII");
        assertEquals(subject.convertIntToRoman(13), "XIII");
        assertEquals(subject.convertIntToRoman(14), "XIV");
        assertEquals(subject.convertIntToRoman(15), "XV");
        assertEquals(subject.convertIntToRoman(16), "XVI");
        assertEquals(subject.convertIntToRoman(17), "XVII");
        assertEquals(subject.convertIntToRoman(18), "XVIII");
        assertEquals(subject.convertIntToRoman(19), "XIX");
        assertEquals(subject.convertIntToRoman(20), "XX");
    }

    @Test
    public void shouldConvertIntToRoman50_60() {
        final RomanNumeralUtil subject = new RomanNumeralUtil();
        assertEquals(subject.convertIntToRoman(50), "L");
        assertEquals(subject.convertIntToRoman(51), "LI");
        assertEquals(subject.convertIntToRoman(52), "LII");
        assertEquals(subject.convertIntToRoman(53), "LIII");
        assertEquals(subject.convertIntToRoman(54), "LIV");
        assertEquals(subject.convertIntToRoman(55), "LV");
        assertEquals(subject.convertIntToRoman(56), "LVI");
        assertEquals(subject.convertIntToRoman(57), "LVII");
        assertEquals(subject.convertIntToRoman(58), "LVIII");
        assertEquals(subject.convertIntToRoman(59), "LIX");
        assertEquals(subject.convertIntToRoman(60), "LX");
    }

}

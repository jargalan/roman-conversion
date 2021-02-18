package com.adobe.romanconversion.service;

import com.adobe.romanconversion.model.RomanNumeral;
import com.adobe.romanconversion.util.RomanNumeralUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class RomanNumeralServiceTest {

    @Mock
    RomanNumeralUtil romanNumeralUtil;

    RomanNumeralService subject;

    @Before
    public void setUp() {
        subject = new RomanNumeralService(romanNumeralUtil);
        when(romanNumeralUtil.convertIntToRoman(any())).thenReturn("IV");
    }

    @Test
    public void convertIntToRoman_shouldInvokeServiceWithCorrectParams() {
        subject.getRomanNumeral(4);
        verify(romanNumeralUtil).convertIntToRoman(4);
    }

    @Test
    public void convertIntToRomanl_shouldInvokeServiceWithCorrectParams() {
        RomanNumeral actual = subject.getRomanNumeral(4);
        RomanNumeral expected = new RomanNumeral("4", "IV");
        assertEquals(actual, expected);
    }
}

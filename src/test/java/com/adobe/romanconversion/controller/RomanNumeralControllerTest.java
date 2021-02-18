package com.adobe.romanconversion.controller;

import com.adobe.romanconversion.model.RomanNumeral;
import com.adobe.romanconversion.service.RomanNumeralService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringJUnit4ClassRunner.class)
public class RomanNumeralControllerTest {
    @Mock
    RomanNumeralService romanNumeralService;

    RomanNumeralController subject;
    MockMvc mockMvc;

    @Before
    public void setUp() {
        subject = new RomanNumeralController(romanNumeralService);
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
        when(romanNumeralService.getRomanNumeral(any())).thenReturn(
                new RomanNumeral("4", "IV")
        );
    }

    @Test
    public void getRomanNumeral_shouldHaveEndpointToGetConversionNumberTest() throws Exception {
        mockMvc.perform(
                get("/romannumeral?query=4")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    public void getRomanNumeral_shouldInvokeServiceWithCorrectParams() {
        subject.getRomanNumeral(10);
        verify(romanNumeralService).getRomanNumeral(10);
    }

    @Test
    public void getRomanNumeral_shouldReturnRomanNumeral() {
        subject.getRomanNumeral(4);
        verify(romanNumeralService).getRomanNumeral(4);
    }
}

package com.adobe.romanconversion.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RomanNumeralUtil {
    static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }

    public String convertIntToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Wrong number for Roman numeral. Enter a valid number from 1 to 3999.");
        }
        StringBuilder sb = new StringBuilder();
        int d = 1000;
        while(num > 0) {
            int k = num/d;
            if(k > 0) {
                if (k <= 3) {
                    for(int i=0; i<k; i++) {
                        sb.append(map.get(d));
                    }
                } else if (k == 4) {
                    sb.append(map.get(d));
                    sb.append(map.get(5*d));
                } else if (k == 5) {
                    sb.append(map.get(5*d));
                } else if (k == 9) {
                    sb.append(map.get(d));
                    sb.append(map.get(10*d));
                } else {
                    sb.append(map.get(5*d));
                    for(int i=0; i<k-5; i++) {
                        sb.append(map.get(d));
                    }
                }
                num = num - k*d;
            }
            d /= 10;
        }
        return sb.toString();
    }
}

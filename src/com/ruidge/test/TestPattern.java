package com.ruidge.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    //匹配8005551212或者80055512121234...
    static String[] arr = { "800-555-1212", "800 555 1212", "800.555.1212", "(800) 555-1212",
            "1-800-555-1212", "800-555-1212-1234", "800-555-1212x1234", "800-555-1212 ext. 1234",
            "work 1-(800) 555.1212 #1234" };

    public static void main( String[] args ) {
        // String format =
        // "(^(1-)?\d{3}-\d{3}-\d{4})|(\d{3}_\d{3}\_\d{4})|(\d{3},\d{3},\d{4})|((\d{3}))\_\d\{3}-\d{4})|((\d{3}-\d{3}-\d\{4}(-|x|
        // ext. )\d{4})?)|(work 1-(\d{3}) \d(3).\d{4} #\d(4))";
        String format = "[(1-)?\\d{3}-\\d{3}-\\d{4}][\\d{3} \\d{3} \\d{4}][\\d{3}.\\d{3}.\\d{4}]"
                + "[\\(\\d{3}\\) \\d{3}-\\d{4}][(\\d{3}-\\d{3}-\\d{4}(-|x| ext. )\\d{4})?]"
                +"[work 1-(\\d{3}) \\d(3).\\d{4} #\\d(4)]";
        format = "^(1-)?\\d{3}-\\d{3}-\\d{4}|\\d{3} \\d{3} \\d{4}][\\d{3}.\\d{3}.\\d{4}|\\(\\d{3}\\) \\d{3}-\\d{4}";
        format = "^(1-)?\\d{3}-\\d{3}-\\d{4}";
        for (String str : arr) {
            Pattern p = Pattern.compile(format);
            Matcher m = p.matcher(str);
            if(m.find()){
                m.start();
            }
        }
    }
}

package com.ruidge.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestWBKeyword {

    // 关键字匹配,但是不匹配@ #中间的.

    static String str1 = "@ asdi@sdAA fhpo@AAaisd@dsAAdAA@AAB h@AAB!fp@AABss#AAss#oaisdjf#AA# pakjdfla#ssAA## jdflAAhasodfAAhpao##hshsAAs#iss";
    static String str2 = "阿斯蒂芬的@说的中文 呵####aaa#呵po@中文aisd@ds中文d中文@中文B h@中文B!fp@中文Bss#中文ss#oaisdjf#中文" +
    		"# pakjdfla#ss中文asd&**## jdfl中文hasodf你好中文哈哈hpao##包含中文话题#iss#：、哈哈54、……&#";

    String httpRegex = "[hH]ttp(s)?://[0-9A-Za-z]+\\.[0-9A-Za-z:/[-]_#[?][=][.][&]]*";
    
    static String testStr = str1 + str2;
    static String keyword = "AA";
//    static String keyword = "中文";
    
    public static void main( String[] args ) {
        //最后分组的时候不关系AT和话题只要屏蔽过去不影响最后关键字的判断就行
        String regexAt = "@[\\w[\\u4e00-\\u9fa5]]*"+keyword+"[\\w[\\u4e00-\\u9fa5]]* ?";//匹配中英文混合的@,"不大关心什么结尾"
        String regexTopic = "#[\\w[\\u4e00-\\u9fa5]]*"+keyword+"[\\w[\\u4e00-\\u9fa5]]*#";//匹配中英文混合的话题,特殊字符会截断
        String regexNormal = keyword;
        // String regex = regexAt + "|" + regexTopic + "|" + regexNormal;
        String regex = "(" + regexAt + ")|(" + regexTopic + ")|(" + regexNormal + ")";
        Pattern p = Pattern.compile(regex);
        
//        Matcher matcher = p.matcher(testStr);
//        // 匹配所有
//        while (matcher.find()) {
//            String group = matcher.group();
//            System.out.println(group);
//        }
        // 只匹配组三
        System.out.println("-------------");
        long start = System.nanoTime();
        Matcher matcher = p.matcher(testStr);
        while (matcher.find()) {
            String group = matcher.group(3);
            if (group != null) {
                System.out.println(String.format("result : %s ; start : %d ; end : %d", group,
                        matcher.start(3), matcher.end(3)));
            }
        }
        long delta = System.nanoTime() - start;
        System.out.println(delta / 1000 / 1000 + "ms");
        
    }

}

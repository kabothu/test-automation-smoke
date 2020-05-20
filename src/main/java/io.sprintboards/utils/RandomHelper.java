package io.sprintboards.utils;
import org.apache.commons.lang3.RandomStringUtils;


public class RandomHelper {


    public static String getRandomAlphaNumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static Integer getRandomNumber(int length) {
        return Integer.valueOf(RandomStringUtils.randomNumeric(length));
    }

    public static String getRandomNumberAsString(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String getRandomAlphabeticString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getRandomEmailAddress() {
        String email = "test_automation_"+getRandomAlphaNumericString(4)+"@test.com";
        return email;
    }

    public static String getRandomActivity() {
        String activity =  "automation_activity_"+RandomStringUtils.randomAlphanumeric(4);
        return activity;
    }

    public static String getRandomMemberName(){
        String name =  "automation_member_"+RandomStringUtils.randomAlphabetic(4);
        return name;
    }

    public static String getRandomVisitorName(){
        String name =  "automation_visitor_"+RandomStringUtils.randomAlphabetic(4);
        return name;
    }
    public static String getRandomMobileNumber(){
        return RandomStringUtils.randomNumeric(10);
    }

    public static String getRandomProductName(){
        String name =  "auto_product_"+RandomStringUtils.randomAlphabetic(1);
        return name;
    }
}

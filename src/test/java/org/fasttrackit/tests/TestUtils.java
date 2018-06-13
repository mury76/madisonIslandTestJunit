package org.fasttrackit.tests;

public class TestUtils {

    // After all, I decided to not use this email in order to keep my tests independent.
    private static String unicEmail;

    public static String getEmail() {

        if (unicEmail == null) {
            unicEmail = "mail" + System.currentTimeMillis() + "@mail.com";
        }
        return unicEmail;
    }


}

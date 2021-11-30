package com.translantik.utilities;

import java.util.Locale;

public class UserGenerator {
    public static String username = null;
    public static String password = null;

    /**
     * this method is used for generate user type based on the parameters from login.feature
     * @param userType
     */
    public static void userGen(String userType){

        switch (userType.toLowerCase()) {
            case "driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");

                break;
            case "salesmanager":
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");

                break;
            case "storemanager":
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");

                break;
            default:
                System.out.println("WARNING: <You did not enter a valid keyword on the feature page or check properties page");
                break;
        }


    }
}

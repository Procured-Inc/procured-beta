package tmalpha.procuredinc.com.procuredalpha;

import android.provider.BaseColumns;

/**
 * Created by Nuzha on 05-09-2016.
 */

public class UserData {

    UserData(){}

    public static abstract class UserInfo implements BaseColumns{

        public static final String USERNAME = "uname";
        public static final String PASSWORD = "pword";
        public static final String COMPANY = "db_name";
        public static final String COLLEGE = "table_name";

    }
}

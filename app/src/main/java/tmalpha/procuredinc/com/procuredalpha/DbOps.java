package tmalpha.procuredinc.com.procuredalpha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Nuzha on 05-09-2016.
 */

public class DbOps extends SQLiteOpenHelper {


    public static final int database_version = 1;
    public String CREATE_QUERY ="CREATE TABLE " + UserData.UserInfo.COLLEGE + "(" + UserData.UserInfo.USERNAME+" TEXT,"+UserData.UserInfo.PASSWORD+" TEXT );";

    public DbOps(Context context){
        super(context, UserData.UserInfo.COMPANY, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void putInformation(DbOps dbo, String uname, String upass){
        SQLiteDatabase SQ =  dbo.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(UserData.UserInfo.USERNAME, uname);
        cv.put(UserData.UserInfo.PASSWORD, upass);

        long flag = SQ.insert(UserData.UserInfo.COLLEGE, null, cv);
        Log.d("DbOps","One Row Created");
    }

    public Cursor getInformation(DbOps dbo){
        SQLiteDatabase SQ = dbo.getReadableDatabase();
        String[] col = {UserData.UserInfo.USERNAME, UserData.UserInfo.PASSWORD};
        return SQ.query(UserData.UserInfo.COLLEGE, col, null, null, null, null, null);
    }

    public void deleteAll(DbOps dbo){
        SQLiteDatabase SQ = dbo.getWritableDatabase();
        SQ.execSQL("Delete from " + UserData.UserInfo.COLLEGE);
        SQ.close();
    }
}

package com.demosql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDb extends SQLiteOpenHelper {
	
	public static String DATABASENAME="demosql1.db";
	
	

	public MyDb(Context context) {
		super(context, DATABASENAME, null, 1);
		// TODO Auto-generated constructor stub
         }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql="CREATE TABLE demotable (id INTEGER PRIMARY KEY, fname TEXT , lname TEXT) ";
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql="DROP TABLE IF EXISTS demotable  ";
		db.execSQL(sql);
		onCreate(db);
	}

}

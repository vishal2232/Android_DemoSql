package com.demosql;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Select extends Activity {
    /** Called when the activity is first created. */
	TextView t1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);
        t1=(TextView)findViewById(R.id.textView1);
		MyDb mydb=new MyDb(Select.this);
		SQLiteDatabase database= mydb.getReadableDatabase();
		Cursor cursor= database.rawQuery("Select * from demotable", null);
		String s="";
		if(cursor.moveToFirst())
		{
			do{
				String fname=cursor.getString(cursor.getColumnIndex("fname"));
				String lname=cursor.getString(cursor.getColumnIndex("lname"));
				s=s+"F Name="+fname+"\tL name="+lname+"\n";
				t1.setText(s);
			}while(cursor.moveToNext());
		}
		cursor.close();
		database.close();

        
    }
}
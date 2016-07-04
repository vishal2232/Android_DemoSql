package com.demosql;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends Activity {
    /** Called when the activity is first created. */
	EditText e1;
	Button b1;
	String fname1,lname1,id;
	int check=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        e1=(EditText)findViewById(R.id.editText1);
        b1=(Button)findViewById(R.id.button1);
       
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				
			String fname=e1.getText().toString().trim();
			MyDb mydb=new MyDb(Update.this);
			SQLiteDatabase database= mydb.getReadableDatabase();
			Cursor cursor= database.rawQuery("Select * from demotable", null);
		
			if(cursor.moveToFirst())
			{
				do{
					 id=cursor.getString(cursor.getColumnIndex("id"));			
					 fname1=cursor.getString(cursor.getColumnIndex("fname"));
					 lname1=cursor.getString(cursor.getColumnIndex("lname"));
					
					if(fname.equals(fname1))
					{
						check=1;
						break;	
					}
				}while(cursor.moveToNext());
			}
			cursor.close();
			database.close();
			if(check==1)
			{
				Intent i =new Intent(Update.this,UpdateProcess.class);
				i.putExtra("id", id);
				i.putExtra("fname", fname1);
				i.putExtra("lname", lname1);
				startActivity(i);
				//Toast.makeText(getApplicationContext(), "DataFound", Toast.LENGTH_LONG).show();
			}
			else
				Toast.makeText(getApplicationContext(), "DataNotFound", Toast.LENGTH_LONG).show();
			}
		});
        
    }
}
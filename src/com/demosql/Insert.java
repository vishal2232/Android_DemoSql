package com.demosql;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends Activity {
    /** Called when the activity is first created. */
	EditText fname;
	EditText lname;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
         fname=(EditText)findViewById(R.id.editText1);
         lname=(EditText)findViewById(R.id.editText2);
        Button b1=(Button)findViewById(R.id.button1);
        
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ff=fname.getText().toString().trim();
				String ll=lname.getText().toString().trim();
				MyDb mydb=new MyDb(Insert.this);
				SQLiteDatabase database=mydb.getWritableDatabase();
				ContentValues context = new ContentValues();
				context.put("fname", ff);
				context.put("lname", ll);
				long a=database.insert("demotable", null, context);
				if(a>0){
					Toast.makeText(getApplicationContext(), "insert", Toast.LENGTH_LONG).show();
				}
				else{
					Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_LONG).show();
					
				}
				 
				
				
				
				
			}
		});
        
    }
}
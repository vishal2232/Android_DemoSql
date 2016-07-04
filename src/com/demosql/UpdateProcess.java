package com.demosql;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateProcess extends Activity{
TextView t1;
EditText e1;
Button b1;
String fname,lname,id;

	/** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateprocess);
      t1=(TextView)findViewById(R.id.textView1);
      e1=(EditText)findViewById(R.id.editText1);
      b1=(Button)findViewById(R.id.button1);
      Intent i= getIntent();
    id=i.getStringExtra("id");
      fname=i.getStringExtra("fname");
      
      lname=i.getStringExtra("lname");
      t1.setText(fname);
     e1.setText(lname);
    b1.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			lname=e1.getText().toString().trim();
			MyDb mydb=new MyDb(UpdateProcess.this);
			SQLiteDatabase database=mydb.getWritableDatabase();
			ContentValues context = new ContentValues();
			
			context.put("fname", fname);
			context.put("lname", lname);
			long a=database.update("demotable", context, "id="+id, null);
			if(a>0){
				Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_LONG).show();
			}
			else{
				Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_LONG).show();
				
			}
		}
	});
      

}
}
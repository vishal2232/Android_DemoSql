package com.demosql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b1=(Button)findViewById(R.id.button1);
        Button b2=(Button)findViewById(R.id.button2);
        Button b3=(Button)findViewById(R.id.button3);
        Button b4=(Button)findViewById(R.id.button4);
   
        
        
        //insert
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i=new Intent(Main.this,Insert.class);
			startActivity(i);
				
			}
		});
        
      //Select 
        b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i=new Intent(Main.this,Select.class);
			startActivity(i);
				
			}
		});
        
      //Update 
        b3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i=new Intent(Main.this,Update.class);
			startActivity(i);
				
			}
		});
        
      //Delete 
        b4.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i=new Intent(Main.this,Delete.class);
			startActivity(i);
				
			}
		});
    }
}
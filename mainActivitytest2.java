package com.example.contacts;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.PhoneLookup;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView ContactName,number;
	LinearLayout layout;
	ScrollView scroll;
	String name;
	String num;
	Button next,back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Uri contactsUri=Uri.parse("content://contacts/people");
		scroll=new ScrollView(this);
		layout=new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		Cursor c=getContentResolver().query(contactsUri, null, null, null, null);
		int i=0;
		while(c.moveToNext()&&i<9){;
			int nameIndex=c.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			int numIndex=c.getColumnIndex(PhoneLookup.NUMBER);
			name=c.getString(nameIndex);
			num=c.getString(numIndex);
			ContactName=new TextView(this);
			number=new TextView(this);
			number.setText(num);
			ContactName.setText(name);
			ContactName.setTextSize(30);
			layout.addView(ContactName);
			layout.addView(number);
			i++;
			
	}
		next=new Button(this);
		back=new Button(this);
		layout.addView(next);
		layout.addView(back);
		scroll.addView(layout);
		next.setText("next");
		back.setText("back");
		setContentView(scroll);
	}

}
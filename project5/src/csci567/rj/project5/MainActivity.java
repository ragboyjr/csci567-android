package csci567.rj.project5;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private StringModel sm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.sm = new StringModel(this.getApplicationContext());
		this.setupClickListeners();
	}

	private void setupClickListeners() {
		Button add_b  = (Button) findViewById(R.id.addDbButton),
			   read_b = (Button) findViewById(R.id.readDbButton);
	
		add_b.setOnClickListener(this);
		read_b.setOnClickListener(this);
	}
	
	public void onClick(View v)
	{
		EditText et = (EditText) findViewById(R.id.dbStringText);
		TextView tv = (TextView) findViewById(R.id.dbTextView);
		
		switch (v.getId())
		{
		    case R.id.addDbButton:
		    	this.addTextToDb(et);
		    	break;
		    case R.id.readDbButton:
		    	this.readTextFromDb(tv);
		    	break;
		}
	}
	
	private void addTextToDb(EditText et) {
		boolean ret;
    	String txt = et.getText().toString();
    
    	ret = this.sm.addString(txt);
    	
    	if (ret) {
    		this.toastMessage("String '" + txt + "' was successfully added");
    	}
    	else {
    		this.toastMessage("String '" + txt + "' wasn't added to the db");
    	}
	}
	
	private void readTextFromDb(TextView tv) {
		StringBuilder sb = new StringBuilder();
		String[] strings = this.sm.getStrings();
		
		if (strings.length == 0) {
			this.toastMessage("There are no strings in the db");
			return;
		}
		
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			
			sb.append(i + 1);
			sb.append(": ");
			sb.append(s);
			sb.append('\n');
		}
		
		tv.setText(sb.toString());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void toastMessage(String message) {
		Toast toast = Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 30);
		toast.show();
	}
}

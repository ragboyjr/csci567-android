package csci567.rj.project4;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	private FileModel fm;
	private Context ctx;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.ctx = this.getApplicationContext();
		this.fm  = new FileModel(ctx.getFilesDir().getAbsolutePath());
		
		this.setupClickListeners();
	}
	
	private void setupClickListeners() {
		Button append_b = (Button) findViewById(R.id.appendFileButton),
			   write_b  = (Button) findViewById(R.id.writeFileButton),
			   read_b   = (Button) findViewById(R.id.readFileButton);
		
		append_b.setOnClickListener(this);
		write_b.setOnClickListener(this);
		read_b.setOnClickListener(this);
	}
	
	public void onClick(View v)
	{
		EditText et = (EditText) findViewById(R.id.fileEditText);
		TextView tv = (TextView) findViewById(R.id.fileTextView);
		
		switch (v.getId())
		{
			case R.id.appendFileButton:
				this.fm.appendFile(et.getText().toString());
				et.setText("");
				break;
			case R.id.writeFileButton:
				this.fm.writeFile(et.getText().toString());
				et.setText("");
				break;
			case R.id.readFileButton:
				tv.setText(this.fm.readFile());
				break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

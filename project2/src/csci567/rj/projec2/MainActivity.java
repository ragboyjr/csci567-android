package csci567.rj.projec2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	int prev_val;
	int cur_val;
	
	public MainActivity()
	{
		this.prev_val = 0;
		this.cur_val  = 1;
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //this.fibUpdateText();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void fibReset(View v) {
    	this.prev_val = 0;
    	this.cur_val  = 1;
    	
    	this.fibUpdateText();
    }
    
    public void fibNext(View v) {
    	int tmp = this.cur_val;
    	
    	this.cur_val = this.cur_val + this.prev_val;
    	this.prev_val = tmp;
    	
    	this.fibUpdateText();
    }
    
    private void fibUpdateText() {
    	TextView tv = (TextView) findViewById(R.id.fibTextView);
    	tv.setText(Integer.toString(this.cur_val));
    }
}

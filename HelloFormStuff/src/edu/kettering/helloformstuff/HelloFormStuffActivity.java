package edu.kettering.helloformstuff;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class HelloFormStuffActivity extends Activity {
    
	private OnClickListener radio_listener = new OnClickListener() {
		public void onClick(View v) {
			// Perform actions on clicks
			RadioButton rb = (RadioButton) v;
			Toast.makeText(HelloFormStuffActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
		}
	};
	
	private OnClickListener button_listener = new OnClickListener() {
		public void onClick(View v) {
			// Perform action on clicks
			Toast.makeText(HelloFormStuffActivity.this, "Beep Bop!", Toast.LENGTH_SHORT).show();
		}
	};
    
    private OnClickListener checkbox_listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// Perform actions on clicks, depending on whether it is now checked
			if (((CheckBox) v).isChecked()) {
				Toast.makeText(HelloFormStuffActivity.this, "Selected", Toast.LENGTH_SHORT).show();
			}
			else {
				Toast.makeText(HelloFormStuffActivity.this, "Not Selected", Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	private OnClickListener togglebutton_listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// Perform actions on clicks
			if (((ToggleButton) v).isChecked()) {
				Toast.makeText(HelloFormStuffActivity.this, "Checked", Toast.LENGTH_SHORT).show();
			}
			else {
				Toast.makeText(HelloFormStuffActivity.this, "Not Checked", Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	private OnKeyListener edittext_listener = new OnKeyListener() {
        @Override
    	public boolean onKey(View v, int keyCode, KeyEvent event) {
        	EditText et = (EditText) v;
        	
    		// If the event is a key-down event on the "Enter" button
    		if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
    			// Perform action on key press
    			Toast.makeText(HelloFormStuffActivity.this, et.getText(), Toast.LENGTH_SHORT).show();
    			return true;
    		}
    		return false;
    	}
    };
    
    private OnRatingBarChangeListener ratingbar_listener = new OnRatingBarChangeListener() {
		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
			Toast.makeText(HelloFormStuffActivity.this, "New Rating: " + rating, Toast.LENGTH_SHORT).show();
		}
	};
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button button = (Button) findViewById(R.id.button);
        final EditText edittext = (EditText) findViewById(R.id.edittext);
        final CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
        final RadioButton radio_red = (RadioButton) findViewById(R.id.radio_red);
        final RadioButton radio_blue = (RadioButton) findViewById(R.id.radio_blue);
        final ToggleButton togglebutton = (ToggleButton) findViewById(R.id.togglebutton);
        final RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        
        button.setOnClickListener(button_listener);
        edittext.setOnKeyListener(edittext_listener);
        checkbox.setOnClickListener(checkbox_listener);
        radio_red.setOnClickListener(radio_listener);
        radio_blue.setOnClickListener(radio_listener);
        togglebutton.setOnClickListener(togglebutton_listener);
        ratingbar.setOnRatingBarChangeListener(ratingbar_listener);
    }
}
package edu.kettering.hellodatepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class HelloDatePickerActivity extends Activity {
	
	private TextView mDateDisplay;
	private Button mPickDate;
	private int mYear;
	private int mMonth;
	private int mDay;
	
	static final int DATE_DIALOG_ID = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Capture view elements
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);
        
        // Add a Click Listener to the Button
        mPickDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);
			}
		});
        
        // Show the Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        
        // Call to update the display with the current date
        updateDisplay();
    }
    
    // Updates the Date in the TextView
    private void updateDisplay() {
    	mDateDisplay.setText(
    			new StringBuilder()
    				// Month is 0 based, add 1
    				.append(mMonth + 1).append("-")
    				.append(mDay).append("-")
    				.append(mYear).append(" "));
    }
    
    // The callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener = 
    		new DatePickerDialog.OnDateSetListener() {
    	
    			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
    				mYear = year;
    				mMonth = monthOfYear;
    				mDay = dayOfMonth;
    				updateDisplay();
    			}
    };
    
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_DIALOG_ID:
            return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }
}
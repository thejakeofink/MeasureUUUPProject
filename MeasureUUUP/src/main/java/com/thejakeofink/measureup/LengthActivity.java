package com.thejakeofink.measureup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class LengthActivity extends Activity {
    private final String TAG = "LengthActivity";
    private final int INCHES = R.id.inches_radio;
    private final int FEET = R.id.feet_radio;
    private final int YARDS = R.id.yards_radio;
    private final int MILES = R.id.miles_radio;
    private final int MILLIMETERS = R.id.millimeters_radio;
    private final int CENTIMETERS = R.id.centimeters_radio;
    private final int METERS = R.id.meters_radio;
    private final int KILOMETERS = R.id.kilometers_radio;
    private final BigDecimal IN_TO_FEET = new BigDecimal(12);
    private final BigDecimal FEET_TO_YARD = new BigDecimal(3);
    private final BigDecimal FEET_TO_MILE = new BigDecimal(5280);
    private final BigDecimal IN_TO_MILLI = new BigDecimal(25.4);
    private final BigDecimal METRIC = new BigDecimal(10);
    private final int roundAmount = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leng);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.length, menu);
        return true;
    }

    public void computeClicked(View view)
    {

        EditText editText = (EditText)findViewById(R.id.length_num);
        String textInput = editText.getText().toString();

        //Log.i(TAG, textInput);
        RadioGroup lengthGroup = (RadioGroup)findViewById(R.id.length_radio_group);
        TextView displayText = (TextView)findViewById(R.id.length_display);

        //Log.i(TAG, "This radio buttons id is: " + Integer.toString(dataGroup.getCheckedRadioButtonId()));
        if (validateInput(textInput))
        {
            BigDecimal userInput = new BigDecimal(textInput);
            LengthConverter userData = new LengthConverter(lengthGroup.getCheckedRadioButtonId(), userInput);
            userData.computeLength(this);
            userData.display(displayText);
        }
        else
        {
            displayPrompt(displayText);
        }
    }

    private void displayPrompt(TextView textDisplay)
    {
        Log.i(TAG,"toast after this");
        Toast.makeText(this, "Please input a number.", Toast.LENGTH_SHORT).show();
        //String prompt = new String("Please input a number.");
        //textDisplay.setText(prompt);
    }


    private boolean validateInput(String userIn)
    {
        if (!userIn.equalsIgnoreCase(""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public class LengthConverter extends UnitOfMeasure
    {
        private BigDecimal inches;
        private BigDecimal feet;
        private BigDecimal yards;
        private BigDecimal miles;
        private BigDecimal millimeters;
        private BigDecimal centimeters;
        private BigDecimal meters;
        private BigDecimal kilometers;
        String myDisplay;

        public LengthConverter(int i, BigDecimal d)
        {
            super(i,d);
            inches = new BigDecimal(0);
            feet = new BigDecimal(0);
            yards = new BigDecimal(0);
            miles = new BigDecimal(0);
            millimeters = new BigDecimal(0);
            centimeters = new BigDecimal(0);
            meters = new BigDecimal(0);
            kilometers = new BigDecimal(0);
            myDisplay = "";
        }

        public void computeLength(Context context)
        {
            switch (this.getType())
            {
                case INCHES:
                    inches = this.getInputValue();
                    computeAll();
                    break;
                case FEET:
                    inches = this.getInputValue().multiply(IN_TO_FEET);
                    computeAll();
                    break;
                case YARDS:
                    inches = (this.getInputValue().multiply(IN_TO_FEET)).multiply(FEET_TO_YARD);
                    computeAll();
                    break;
                case MILES:
                    inches = ((this.getInputValue().multiply(IN_TO_FEET)).multiply(FEET_TO_MILE));
                    computeAll();
                    break;
                case MILLIMETERS:
                    inches = this.getInputValue().divide(IN_TO_MILLI,roundAmount, BigDecimal.ROUND_FLOOR);
                    computeAll();
                    break;
                case CENTIMETERS:
                    inches = this.getInputValue().divide(IN_TO_MILLI,roundAmount, BigDecimal.ROUND_FLOOR).multiply(METRIC);
                    computeAll();
                    break;
                case METERS:
                    inches = (this.getInputValue().divide(IN_TO_MILLI,roundAmount, BigDecimal.ROUND_FLOOR).multiply(METRIC)).multiply(METRIC).multiply(METRIC);
                    computeAll();
                    break;
                case KILOMETERS:
                    inches = ((this.getInputValue().divide(IN_TO_MILLI,roundAmount, BigDecimal.ROUND_FLOOR).multiply(METRIC)).multiply(METRIC)).multiply(METRIC).multiply(METRIC).multiply(METRIC);
                    computeAll();
                    break;
                case -1:
                    Toast.makeText(context,"Please select a unit.", Toast.LENGTH_SHORT).show();
                    //myDisplay = "Please select a unit.";
                    break;
            }
        }

        public void display(TextView textDisplay)
        {
            textDisplay.setText(myDisplay);
        }

        //Figure out coefficients for each conversion then make them into final BigDecimals
        //for use in multiply and or divide functions...
        private void computeAll()
        {
            myDisplay += inches + " Inches\n";
            feet = inches.divide(IN_TO_FEET,roundAmount, BigDecimal.ROUND_FLOOR);
            myDisplay += feet + " Feet\n";
            //Log.i(TAG, "Feet " + feet);
            yards = feet.divide(FEET_TO_YARD,roundAmount, BigDecimal.ROUND_FLOOR);
            myDisplay += yards + " Yards\n";
            miles = feet.divide(FEET_TO_MILE,roundAmount, BigDecimal.ROUND_FLOOR);
            myDisplay += miles + " Miles\n";
            millimeters = inches.multiply(IN_TO_MILLI);
            myDisplay += millimeters + " Millimeters\n";
            centimeters = millimeters.divide(METRIC,roundAmount, BigDecimal.ROUND_FLOOR);
            myDisplay += centimeters + " Centimeters\n";
            meters = centimeters.divide(METRIC,roundAmount, BigDecimal.ROUND_FLOOR).divide(METRIC,roundAmount,BigDecimal.ROUND_FLOOR);
            myDisplay += meters + " Meters\n";
            kilometers = meters.divide(METRIC,roundAmount, BigDecimal.ROUND_FLOOR).divide(METRIC,roundAmount, BigDecimal.ROUND_FLOOR);
            myDisplay += kilometers + " Kilometers\n";
        }
    }
}

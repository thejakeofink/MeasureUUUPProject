package com.thejakeofink.measureup;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

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

        EditText editText = (EditText)findViewById(R.id.input_num);
        String textInput = editText.getText().toString();

        //Log.i(TAG, textInput);
        RadioGroup dataGroup = (RadioGroup)findViewById(R.id.data_radio_group);
        TextView displayText = (TextView)findViewById(R.id.data_display);

        //Log.i(TAG, "This radio buttons id is: " + Integer.toString(dataGroup.getCheckedRadioButtonId()));
        if (validateInput(textInput))
        {
            BigDecimal userInput = new BigDecimal(textInput);
            LengthConverter userData = new LengthConverter(dataGroup.getCheckedRadioButtonId(), userInput);
            userData.computeData();
            userData.display(displayText);
        }
        else
        {
            displayPrompt(displayText);
        }
    }

    private void displayPrompt(TextView textDisplay)
    {
        String prompt = new String("Please input a number.");
        textDisplay.setText(prompt);
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

        public void computeData()
        {
            switch (this.getType())
            {
                case INCHES:
                    inches = this.getInputValue();
                    computeAll();
                    break;
                case FEET:
                    //inches = this.getInputValue().multiply(BITDIVIDER);
                    computeAll();
                    break;
                case YARDS:
                    //inches = (this.getInputValue().multiply(BITDIVIDER)).multiply(BITDIVIDER);
                    computeAll();
                    break;
                case MILES:
                    //inches = ((this.getInputValue().multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER);
                    computeAll();
                    break;
                case MILLIMETERS:
                    //inches = (((this.getInputValue().multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER);
                    computeAll();
                    break;
                case CENTIMETERS:
                    //inches = this.getInputValue().multiply(BYTED);
                    computeAll();
                    break;
                case METERS:
                    //inches = (this.getInputValue().multiply(BYTED)).multiply(BYTEDIVIDER);
                    computeAll();
                    break;
                case KILOMETERS:
                    //inches = ((this.getInputValue().multiply(BYTED)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER);
                    computeAll();
                    break;
                case -1:
                    myDisplay = "Please select a unit.";
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
            //feet = inches.divide(BITDIVIDER);
            myDisplay += feet + " Feet\n";
            //yards = feet.divide(BITDIVIDER);
            myDisplay += yards + " Yards\n";
            //miles = yards.divide(BITDIVIDER);
            myDisplay += miles + " Miles\n";
            //millimeters = inches.divide(BITDIVIDER);
            myDisplay += millimeters + " Millimeters\n";
            //centimeters = millimeters.divide(BYTED);
            myDisplay += centimeters + " Centimeters\n";
            //meters = centimeters.divide(BYTEDIVIDER);
            myDisplay += meters + " Meters\n";
            //kilometers = meters.divide(BYTEDIVIDER);
            myDisplay += kilometers + " Kilometers\n";
        }
    }
}

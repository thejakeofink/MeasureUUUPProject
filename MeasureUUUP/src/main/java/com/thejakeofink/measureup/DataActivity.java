package com.thejakeofink.measureup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.math.BigDecimal;

public class DataActivity extends Activity {
    //private final String TAG = "DataActivity";
    private final int BIT = R.id.bits_radio;
    private final int KBIT = R.id.kilobits_radio;
    private final int MBIT = R.id.megabits_radio;
    private final int GBIT = R.id.gigabits_radio;
    private final int TBIT = R.id.terabits_radio;
    private final int BYTE = R.id.bytes_radio;
    private final int KBYTE = R.id.kilobytes_radio;
    private final int MBYTE = R.id.megabytes_radio;
    private final int GBYTE = R.id.gigabytes_radio;
    private final int TBYTE = R.id.terabytes_radio;
    private final BigDecimal BITDIVIDER = new BigDecimal(1000);
    private final BigDecimal BYTEDIVIDER = new BigDecimal(1024);
    private final BigDecimal BYTED = new BigDecimal(8);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.data, menu);
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
            DataConverter userData = new DataConverter(dataGroup.getCheckedRadioButtonId(), userInput);
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

    public class DataConverter extends UnitOfMeasure
    {
        private BigDecimal bits;
        private BigDecimal kbits;
        private BigDecimal mbits;
        private BigDecimal gbits;
        private BigDecimal tbits;
        private BigDecimal bytes;
        private BigDecimal kbytes;
        private BigDecimal mbytes;
        private BigDecimal gbytes;
        private BigDecimal tbytes;
        private String myDisplay;

        public DataConverter(int dataID, BigDecimal dataLong)
        {
            super(dataID, dataLong);
            bits = new BigDecimal(0);
            kbits = new BigDecimal(0);
            mbits = new BigDecimal(0);
            gbits = new BigDecimal(0);
            tbits = new BigDecimal(0);
            bytes = new BigDecimal(0);
            kbytes = new BigDecimal(0);
            mbytes = new BigDecimal(0);
            gbytes = new BigDecimal(0);
            tbytes = new BigDecimal(0);
            myDisplay = "";
        }

        public void computeData()
        {
            switch (this.getType())
            {
                case BIT:
                    bits = this.getInputValue();
                    computeAll();
                    break;
                case KBIT:
                    bits = this.getInputValue().multiply(BITDIVIDER);
                    computeAll();
                    break;
                case MBIT:
                    bits = (this.getInputValue().multiply(BITDIVIDER)).multiply(BITDIVIDER);
                    computeAll();
                    break;
                case GBIT:
                    bits = ((this.getInputValue().multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER);
                    computeAll();
                    break;
                case TBIT:
                    bits = (((this.getInputValue().multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER);
                    computeAll();
                    break;
                case BYTE:
                    bits = this.getInputValue().multiply(BYTED);
                    computeAll();
                    break;
                case KBYTE:
                    bits = (this.getInputValue().multiply(BYTED)).multiply(BYTEDIVIDER);
                    computeAll();
                    break;
                case MBYTE:
                    bits = ((this.getInputValue().multiply(BYTED)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER);
                    computeAll();
                    break;
                case GBYTE:
                    bits = (((this.getInputValue().multiply(BYTED)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER);
                    computeAll();
                    break;
                case TBYTE:
                    bits = ((((this.getInputValue().multiply(BYTED)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER);
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

        private void computeAll()
        {
            myDisplay += bits + " Bits\n";
            kbits = bits.divide(BITDIVIDER);
            myDisplay += kbits + " Kilobits\n";
            mbits = kbits.divide(BITDIVIDER);
            myDisplay += mbits + " Megabits\n";
            gbits = mbits.divide(BITDIVIDER);
            myDisplay += gbits + " Gigabits\n";
            tbits = gbits.divide(BITDIVIDER);
            myDisplay += tbits + " Terabits\n";
            bytes = bits.divide(BYTED);
            myDisplay += bytes + " Bytes\n";
            kbytes = bytes.divide(BYTEDIVIDER);
            myDisplay += kbytes + " Kilobytes\n";
            mbytes = kbytes.divide(BYTEDIVIDER);
            myDisplay += mbytes + " Megabytes\n";
            gbytes = mbytes.divide(BYTEDIVIDER);
            myDisplay += gbytes + " Gigabytes\n";
            tbytes = gbytes.divide(BYTEDIVIDER);
            myDisplay += tbytes + " Terabytes\n";
        }
    }

    //method that detects which unit is selected

    //method that converts numbers based on unit selected

    //method that displays converted numbers
}

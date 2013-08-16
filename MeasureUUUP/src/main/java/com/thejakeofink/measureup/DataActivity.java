package com.thejakeofink.measureup;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class DataActivity extends Activity {
    private final String TAG = "DataActivity";
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
        long userinput = 0;
        EditText editText = (EditText)findViewById(R.id.input_num);
        String textInput = editText.getText().toString();

        Log.i(TAG, textInput);

        userinput = Long.parseLong(textInput);

        RadioGroup dataGroup = (RadioGroup)findViewById(R.id.data_radio_group);

        Log.i(TAG, "This radio buttons id is: " + Integer.toString(dataGroup.getCheckedRadioButtonId()));

    }

    public void displayResults(long bits, long kbits, long mbits, long gbits, long tbits, long bytes, long kbytes, long mbytes, long gbytes, long tbytes)
    {

    }

    public class DataConverter
    {
        private int ID;
        private long dataInput;

        public DataConverter(int dataID, long dataLong)
        {
            ID = dataID;
            dataInput = dataLong;
        }

        public long computeBits()
        {
            switch (ID)
            {
                case BIT:

                    break;
                case KBIT:

                    break;
                case MBIT:

                    break;
                case GBIT:

                    break;
                case TBIT:

                    break;
                case BYTE:

                    break;
                case KBYTE:

                    break;
                case MBYTE:

                    break;
                case GBYTE:

                    break;
                case TBYTE:

                    break;
            }
            return dataInput;
        }
    }

    //method that detects which unit is selected

    //method that converts numbers based on unit selected

    //method that displays converted numbers
}

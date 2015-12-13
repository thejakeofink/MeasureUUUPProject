package com.thejakeofink.measureup

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

import java.math.BigDecimal

class DataActivity : Activity() {
    private val TAG = "DataActivity"
    private val BIT = R.id.bits_radio
    private val KBIT = R.id.kilobits_radio
    private val MBIT = R.id.megabits_radio
    private val GBIT = R.id.gigabits_radio
    private val TBIT = R.id.terabits_radio
    private val BYTE = R.id.bytes_radio
    private val KBYTE = R.id.kilobytes_radio
    private val MBYTE = R.id.megabytes_radio
    private val GBYTE = R.id.gigabytes_radio
    private val TBYTE = R.id.terabytes_radio
    private val BITDIVIDER = BigDecimal(1000)
    private val BYTEDIVIDER = BigDecimal(1024)
    private val BYTED = BigDecimal(8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.data, menu)
        return true
    }

    fun computeClicked(view: View) {

        val editText = findViewById(R.id.input_num) as EditText
        val textInput = editText.text.toString()

        //Log.i(TAG, textInput);
        val dataGroup = findViewById(R.id.data_radio_group) as RadioGroup
        val displayText = findViewById(R.id.data_display) as TextView

        //Log.i(TAG, "This radio buttons id is: " + Integer.toString(dataGroup.getCheckedRadioButtonId()));
        if (validateInput(textInput)) {
            val userInput = BigDecimal(textInput)
            val userData = DataConverter(dataGroup.checkedRadioButtonId, userInput)
            userData.computeData(this)
            userData.display(displayText)
        } else {
            displayPrompt(displayText)
        }
    }

    private fun displayPrompt(textDisplay: TextView) {
        //Log.i(TAG, "toast after this");
        Toast.makeText(this, "Please input a number.", Toast.LENGTH_SHORT).show()
        //String prompt = new String("Please input a number.");
        //textDisplay.setText(prompt);
    }

    private fun validateInput(userIn: String): Boolean {
        if (!userIn.equals("", ignoreCase = true)) {
            return true
        } else {
            return false
        }
    }

    inner class DataConverter(dataID: Int, dataLong: BigDecimal) : UnitOfMeasure(dataID, dataLong) {
        private var bits: BigDecimal? = null
        private var kbits: BigDecimal? = null
        private var mbits: BigDecimal? = null
        private var gbits: BigDecimal? = null
        private var tbits: BigDecimal? = null
        private var bytes: BigDecimal? = null
        private var kbytes: BigDecimal? = null
        private var mbytes: BigDecimal? = null
        private var gbytes: BigDecimal? = null
        private var tbytes: BigDecimal? = null
        private var myDisplay: String? = null

        init {
            bits = BigDecimal(0)
            kbits = BigDecimal(0)
            mbits = BigDecimal(0)
            gbits = BigDecimal(0)
            tbits = BigDecimal(0)
            bytes = BigDecimal(0)
            kbytes = BigDecimal(0)
            mbytes = BigDecimal(0)
            gbytes = BigDecimal(0)
            tbytes = BigDecimal(0)
            myDisplay = ""
        }

        fun computeData(context: Context) {
            when (this.type) {
                BIT -> {
                    bits = this.inputValue
                    computeAll()
                }
                KBIT -> {
                    bits = this.inputValue.multiply(BITDIVIDER)
                    computeAll()
                }
                MBIT -> {
                    bits = (this.inputValue.multiply(BITDIVIDER)).multiply(BITDIVIDER)
                    computeAll()
                }
                GBIT -> {
                    bits = ((this.inputValue.multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER)
                    computeAll()
                }
                TBIT -> {
                    bits = (((this.inputValue.multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER)).multiply(BITDIVIDER)
                    computeAll()
                }
                BYTE -> {
                    bits = this.inputValue.multiply(BYTED)
                    computeAll()
                }
                KBYTE -> {
                    bits = (this.inputValue.multiply(BYTED)).multiply(BYTEDIVIDER)
                    computeAll()
                }
                MBYTE -> {
                    bits = ((this.inputValue.multiply(BYTED)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)
                    computeAll()
                }
                GBYTE -> {
                    bits = (((this.inputValue.multiply(BYTED)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)
                    computeAll()
                }
                TBYTE -> {
                    bits = ((((this.inputValue.multiply(BYTED)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)).multiply(BYTEDIVIDER)
                    computeAll()
                }
                -1 -> Toast.makeText(context, "Please select a unit.", Toast.LENGTH_SHORT).show()
            }//myDisplay = "Please select a unit.";
        }

        fun display(textDisplay: TextView) {
            textDisplay.text = myDisplay
        }

        private fun computeAll() {
//            myDisplay += bits!! + " Bits\n"
//            kbits = bits!!.divide(BITDIVIDER)
//            myDisplay += kbits!! + " Kilobits\n"
//            mbits = kbits!!.divide(BITDIVIDER)
//            myDisplay += mbits!! + " Megabits\n"
//            gbits = mbits!!.divide(BITDIVIDER)
//            myDisplay += gbits!! + " Gigabits\n"
//            tbits = gbits!!.divide(BITDIVIDER)
//            myDisplay += tbits!! + " Terabits\n"
//            bytes = bits!!.divide(BYTED)
//            myDisplay += bytes!! + " Bytes\n"
//            kbytes = bytes!!.divide(BYTEDIVIDER)
//            myDisplay += kbytes!! + " Kilobytes\n"
//            mbytes = kbytes!!.divide(BYTEDIVIDER)
//            myDisplay += mbytes!! + " Megabytes\n"
//            gbytes = mbytes!!.divide(BYTEDIVIDER)
//            myDisplay += gbytes!! + " Gigabytes\n"
//            tbytes = gbytes!!.divide(BYTEDIVIDER)
//            myDisplay += tbytes!! + " Terabytes\n"
        }
    }

    //method that detects which unit is selected

    //method that converts numbers based on unit selected

    //method that displays converted numbers
}

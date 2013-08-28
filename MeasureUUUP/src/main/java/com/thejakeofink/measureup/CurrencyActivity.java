package com.thejakeofink.measureup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class CurrencyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.currency, menu);
        return true;
    }
    
}

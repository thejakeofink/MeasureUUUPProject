package com.thejakeofink.measureup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MassActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mass, menu);
        return true;
    }
    
}

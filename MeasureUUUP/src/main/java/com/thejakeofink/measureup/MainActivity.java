package com.thejakeofink.measureup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void runLength(View v)
    {
        /*Button button = (Button)findViewById(R.id.length_button);
        TextView textView = (TextView)findViewById(R.id.test_textview);
        String text = button.getText().toString();
        textView.setText(text);*/

        Intent intent = new Intent(this, LengthActivity.class);
        startActivity(intent);
    }

    public void runVolume(View v)
    {
        /*Button button = (Button)findViewById(R.id.volume_button);
        TextView textView = (TextView)findViewById(R.id.test_textview);
        String text = button.getText().toString();
        textView.setText(text);*/

        Intent intent = new Intent(this, VolumeActivity.class);
        startActivity(intent);
    }

    public void runTemp(View v)
    {
        /*Button button = (Button)findViewById(R.id.temp_button);
        TextView textView = (TextView)findViewById(R.id.test_textview);
        String text = button.getText().toString();
        textView.setText(text);*/

        Intent intent = new Intent(this, TempActivity.class);
        startActivity(intent);
    }

    public void runMass(View v)
    {
        /*Button button = (Button)findViewById(R.id.mass_button);
        TextView textView = (TextView)findViewById(R.id.test_textview);
        String text = button.getText().toString();
        textView.setText(text);*/

        Intent intent = new Intent(this, MassActivity.class);
        startActivity(intent);
    }

    public void runCurrency(View v)
    {
        /*Button button = (Button)findViewById(R.id.currency_button);
        TextView textView = (TextView)findViewById(R.id.test_textview);
        String text = button.getText().toString();
        textView.setText(text);*/

        Intent intent = new Intent(this, CurrencyActivity.class);
        startActivity(intent);
    }

    public void runData(View v)
    {
        /*Button button = (Button)findViewById(R.id.data_button);
        TextView textView = (TextView)findViewById(R.id.test_textview);
        String text = button.getText().toString();
        textView.setText(text);*/

        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }

    public void runTip(View v)
    {
        Intent intent = new Intent(this, TipActivity.class);
        startActivity(intent);
    }

}

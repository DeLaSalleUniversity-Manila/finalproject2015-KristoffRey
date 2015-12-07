package com.kristoff.eyedetection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AssistActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist);

        InputStream input_File = getResources().openRawResource(R.raw.assist);
        TextView helpme = (TextView)findViewById(R.id.assist_text);
        try{
            helpme.setText(convertToString(input_File));
        }
        catch (Exception e){
            helpme.setText(R.string.errorTxt);
        }
    }

    public String convertToString(InputStream filename) {
        StringBuilder strBuffer = new StringBuilder();
        BufferedReader txt_file = new BufferedReader(new InputStreamReader(filename));
        String init;
        try {
            while((init = txt_file.readLine()) != null){
                strBuffer.append(init).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuffer.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
}

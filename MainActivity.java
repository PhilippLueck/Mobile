package com.philipplueck.twitterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String daten;
    String eingabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buttonClick(View view){
        EditText editText = findViewById(R.id.editText);
        eingabe =editText.getText().toString();

        Hilfsklasse cloud1 = new Hilfsklasse();
        cloud1.execute("http://webtechlecture.appspot.com/timeline?screenname"+eingabe);

    }
//    TextView textView1 = findViewById(R.id.textView);
    public void textaendern (String string){

       // textView1.setText(string);
        System.out.println((String) string);
        daten=string;
        text();
    }
    public void text(){
        EditText editText1 =findViewById(R.id.editText2);
        editText1.setText(daten);
    }

}


package jp.techacademy.naoyuki.iwamoto.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import org.w3c.dom.Text;

import static jp.techacademy.naoyuki.iwamoto.aisatsuapp.R.id.textView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
    }
    private void showTimePickerDialog() {
        TimePickerDialog TimePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker v, int hourOfDay, int minute) {
                    Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        doGreeting(hourOfDay, minute);
                    }
                },
                19,
                0,
                true);
        TimePickerDialog.show();
    }
    String greeting = "おはよう";

    private void doGreeting(int hourOfDay, int minute) {
        if (hourOfDay >= 2 && hourOfDay < 10) {
                greeting = "おはよう";
        }else if (hourOfDay >= 10 && hourOfDay < 18) {
                greeting = "こんにちは";
        }else {
                greeting = "こんばんは";
            }
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(greeting);
        }
    }

package com.example.rnishiha.dialogfragmentsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_open_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SampleDialog.show(getApplicationContext());
            }
        });

        findViewById(R.id.button_open_dialog_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SampleDialogFragment().show(getFragmentManager(), null);
            }
        });
    }
}

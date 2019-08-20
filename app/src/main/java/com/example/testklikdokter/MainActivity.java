package com.example.testklikdokter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.testklikdokter.helper.DataHelper;

public class MainActivity extends AppCompatActivity {
    EditText txt_title, txt_description;
    Button btn_submit, btn_showlistdata;
    DataHelper SQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLite = new DataHelper(this);

        txt_title = findViewById(R.id.txtTitle);
        txt_description = findViewById(R.id.txtDescription);
        btn_submit = findViewById(R.id.btnSubmit);
        btn_showlistdata = findViewById(R.id.btnShowList);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        btn_showlistdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContentList.class);
                startActivity(intent);
            }
        });
    }

    private void blank(){
        txt_title.requestFocus();
        txt_title.setText(null);
        txt_description.setText(null);
    }

    private void save(){
        SQLite.insert(txt_title.getText().toString().trim(), txt_description.getText().toString().trim());
        blank();
    }
}

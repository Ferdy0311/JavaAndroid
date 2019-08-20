package com.example.testklikdokter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txt_id, txt_title, txt_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txt_id = findViewById(R.id.txtId);
        txt_title = findViewById(R.id.txtTitle);
        txt_description = findViewById(R.id.txtDescription);

        txt_id.setText(getIntent().getStringExtra(ContentList.TAG_ID));
        txt_title.setText(getIntent().getStringExtra(ContentList.TAG_TITLE));
        txt_description.setText(getIntent().getStringExtra(ContentList.TAG_DESCRIPTION));
    }
}

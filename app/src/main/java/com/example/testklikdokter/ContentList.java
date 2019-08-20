package com.example.testklikdokter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.testklikdokter.model.Data;
import com.example.testklikdokter.adapter.Adapter;
import com.example.testklikdokter.helper.DataHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContentList extends AppCompatActivity {

    ListView listView;
    List<Data> itemList = new ArrayList<Data>();
    Adapter adapter;
    DataHelper SQLite = new DataHelper(this);

    public static final String TAG_ID = "id";
    public static final String TAG_TITLE = "title";
    public static final String TAG_DESCRIPTION = "description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_content);

        SQLite = new DataHelper(getApplicationContext());
        listView = findViewById(R.id.listView);

        adapter = new Adapter(ContentList.this, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String idx = itemList.get(position).getId();
                final String title = itemList.get(position).getTitle();
                final String description = itemList.get(position).getDescription();

                Intent intent = new Intent(ContentList.this, DetailActivity.class);
                intent.putExtra(TAG_ID, idx);
                intent.putExtra(TAG_TITLE, title);
                intent.putExtra(TAG_DESCRIPTION, description);
                startActivity(intent);
            }
        });

        getAllData();
    }
    private void getAllData(){
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();
        for(int i = 0; i < row.size(); i++){
            String id = row.get(i).get(TAG_ID);
            String title = row.get(i).get(TAG_TITLE);
            String description = row.get(i).get(TAG_DESCRIPTION);

            Data data = new Data();
            data.setId(id);
            data.setTitle(title);
            data.setDescription(description);
            itemList.add(data);
        }
        adapter.notifyDataSetChanged();
    }
}

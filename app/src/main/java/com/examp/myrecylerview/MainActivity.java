package com.examp.myrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] images = {
            R.drawable.aus1, R.drawable.bang, R.drawable.bhu, R.drawable.cai, R.drawable.cana, R.drawable.den, R.drawable.eng

    };
    MyAdapter myAdapter;
    String[] title, desc;


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        title = getResources().getStringArray(R.array.Country_Names);
        desc = getResources().getStringArray(R.array.coumtry_desc);


        myAdapter = new MyAdapter(this,title,desc,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getApplicationContext(),"onItem click : "+position,Toast.LENGTH_LONG).show();

            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(getApplicationContext(),"onItemLong Click : "+position,Toast.LENGTH_LONG).show();
            }
        });




    }
}
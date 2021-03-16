package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> myworldList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);

        for (int i = 0; i < 20; i++) {
            myworldList.addLast("word" + i);
        }
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new WordListAdapter(this, myworldList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public void onClick(View view) {

            int wordListSize = myworldList.size();
            myworldList.addLast("+ Word" + wordListSize);
            mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
            mRecyclerView.smoothScrollToPosition(wordListSize);


    }
}
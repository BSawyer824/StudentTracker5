package com.wgu_android.studenttracker5;

import android.content.Intent;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wgu_android.studenttracker5.Adapters.TermAdapter;
import com.wgu_android.studenttracker5.Entities.TermsEntity;
import com.wgu_android.studenttracker5.Entities.database.SampleData;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TermSummaryActivity extends AppCompatActivity {

    //Bind Objects on Screen for Butter Knife
    @BindView(R.id.recyclerView_TermSummary)
    RecyclerView mRecyclerView;


    private List<TermsEntity> termsData = new ArrayList<>();
    private TermAdapter mAdapter;
    public static final int NEW_TERM_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_summary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        initRecyclerView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TermSummaryActivity.this, TermDetailActivity.class);
//                intent.putExtra("productID",mProductViewModel.lastID()+1);
                startActivityForResult(intent, NEW_TERM_ACTIVITY_REQUEST_CODE);
            }
        });

        //Show sample data
        termsData.addAll(SampleData.getTerms());

    }

    //Other Methods
    private void initRecyclerView() {
        //passes parameters to the recycler view when called
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new TermAdapter(termsData, this);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

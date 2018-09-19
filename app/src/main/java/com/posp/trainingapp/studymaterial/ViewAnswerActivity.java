package com.posp.trainingapp.studymaterial;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.posp.trainingapp.R;
import com.posp.trainingapp.core.models.PracticeModuleEntity;
import com.posp.trainingapp.utility.Constants;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ViewAnswerActivity extends AppCompatActivity {
    ViewAnswerAdapter viewAnswerAdapter;
    RecyclerView rvModule;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    List<PracticeModuleEntity> practiceModuleEntityList;
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        type = getIntent().getIntExtra(Constants.TYPE, 0);
        init();
        bindAdapter();
    }

    private void bindAdapter() {
        viewAnswerAdapter = new ViewAnswerAdapter(this,practiceModuleEntityList);
        rvModule.setAdapter(viewAnswerAdapter);
    }

    private void init() {
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String practiceModelSet = sharedPreferences.getString(Constants.MODEL_PRACTICE, "");
        Type listType = new TypeToken<ArrayList<PracticeModuleEntity>>() {
        }.getType();
        practiceModuleEntityList = new Gson().fromJson(practiceModelSet, listType);
        rvModule = (RecyclerView) findViewById(R.id.rvModule);
        rvModule.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvModule.setLayoutManager(mLayoutManager);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

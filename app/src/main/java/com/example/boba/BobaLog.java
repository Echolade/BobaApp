package com.example.boba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BobaLog extends AppCompatActivity {

    String bobaplace[], description[];
    int logos[] = {R.drawable.boba_guys, R.drawable.ten_ren, R.drawable.mr_suns, R.drawable.n7, R.drawable.tea_era, R.drawable.teaspoon,
            R.drawable.sunbright, R.drawable.happy_lemon, R.drawable.share_tea};
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boba_log);

        recycleView = findViewById(R.id.recycleView);

        bobaplace = getResources().getStringArray(R.array.bobaplace);
        description = getResources().getStringArray(R.array.description);

        recyclerAdapter recyclerAdapter = new recyclerAdapter(this, bobaplace, description, logos);
        recycleView.setAdapter(recyclerAdapter);

        //responsible for measuring and positioning items within recycleview and policy regarding items not in view
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        
//        bobasearch = getResources().findViewbyId(R.id.bobasearch);

    }

//    button to return back to main activity
    public void home(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

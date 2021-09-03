package com.example.boba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class BobaLog extends AppCompatActivity implements recyclerAdapter.onNoteListener {

    private RecyclerView recycleView;
    private recyclerAdapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Data> cardinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // inside your activity (if you did not enable transitions in your theme)
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        // animations
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Fade());
        getWindow().setTransitionBackgroundFadeDuration(1000);

        setContentView(R.layout.activity_boba_log);

        //Hides title in action bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        fillList();
        setup();

    }
        private void fillList() {
            cardinfo = new ArrayList<>();
            cardinfo.add(new Data("Boba Guys", "too sweet", R.drawable.boba_guys));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));
            cardinfo.add(new Data("Mr. Suns", "cool mustache", R.drawable.mr_suns));
            cardinfo.add(new Data("N7", "elemental nitrogen", R.drawable.n7));
            cardinfo.add(new Data("Ten Era", "good tea", R.drawable.tea_era));
            cardinfo.add(new Data("Teaspoon", "good tea", R.drawable.teaspoon));
            cardinfo.add(new Data("Sunbright", "good tea", R.drawable.sunbright));
            cardinfo.add(new Data("Happy Lemon", "good tea", R.drawable.happy_lemon));
            cardinfo.add(new Data("Share Tea", "good tea", R.drawable.share_tea));
            cardinfo.add(new Data("7 Leaves", "good tea", R.drawable.seven_leaves));
            cardinfo.add(new Data("Yi Fang", "good tea", R.drawable.yi_fang));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));
            cardinfo.add(new Data("Ten Ren", "good tea", R.drawable.ten_ren));

        }

        public void setup () {

            recycleView = findViewById(R.id.recycleView);
            layoutManager = new LinearLayoutManager(this);
            Adapter = new recyclerAdapter(cardinfo, this);
            recycleView.setLayoutManager(layoutManager);
            recycleView.setAdapter(Adapter);

    }


//searchview menu instantiation
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.boba_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                applies filters for searach and hides home button
                Adapter.getFilter().filter(newText);
                View b = findViewById(R.id.button2);
                b.setVisibility(View.GONE);
                if (newText.isEmpty()) {
                    b.setVisibility(View.VISIBLE);
                }

                return false;
            }
        });

        return true;
    }


//    button to return back to main activity
    public void home(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

//   Recycleviewer onclick destinations
    @Override
    public void onNoteClick(int position) {

//      https://stackoverflow.com/questions/28767413/how-to-open-a-different-activity-on-recyclerview-item-onclick
        Intent intent;
        switch (position) {
            case 0: intent = new Intent(this, MainActivity.class);
                    break;
            case 1: intent = new Intent(this, testActivity.class);
                break;
            case 2: intent = new Intent(this, testActivity.class);
                break;

            case 3: intent = new Intent(this, testActivity.class);
                break;

            case 4: intent = new Intent(this, testActivity.class);
                break;

            case 5: intent = new Intent(this, testActivity.class);
                break;

            case 6: intent = new Intent(this, testActivity.class);
                break;

            case 7: intent = new Intent(this, testActivity.class);
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        startActivity(intent);


//        Intent boop = new Intent(this, MainActivity.class);
//        startActivity(boop);
    }
}

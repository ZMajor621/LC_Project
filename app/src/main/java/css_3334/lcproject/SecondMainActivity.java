package css_3334.lcproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SecondMainActivity extends AppCompatActivity {

    Context context;
    Button buttonReturn;
    RecyclerView recyclerViewSinner;

    MainViewModel mainViewModel;
    SinnerAdapter sinnerAdapter;
    String name;
    String rarity;
    Integer health;
    Integer speedLow;
    Integer speedHigh;
    String blunt;
    String pierce;
    String slash;

    String attack1;
    String attack2;
    String attack3;

    String sin1;
    String sin2;
    String sin3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinner_viewer);
        context = getApplicationContext();
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //Bind

        //Extras from Main
        Bundle extras = getIntent().getExtras();
        Sinner sinner = (Sinner) extras.getSerializable("sinner");
        name = sinner.getName();
        rarity = sinner.getRarity();
        health = sinner.getHealth();
        speedLow = sinner.getSpeedLow();
        speedHigh = sinner.getSpeedHigh();
        blunt = sinner.getBlunt();
        pierce = sinner.getPierce();
        slash = sinner.getSlash();
        attack1 = sinner.getAttack1();
        attack2 = sinner.getAttack2();
        attack3 = sinner.getAttack3();
        sin1 = sinner.getSin1();
        sin2 = sinner.getSin2();
        sin3 = sinner.getSin3();

        //Save to database
        mainViewModel.insert(name, rarity, health, speedLow, speedHigh, blunt, pierce, slash, attack1, attack2, attack3, sin1, sin2, sin3);
        //setupReturnButton();
        setupLiveDataObserver();
        setupRecycleView();
        setupReturnButton();
    }

    private void setupRecycleView()
    {
        recyclerViewSinner = findViewById(R.id.SinnerRecyclerView);
        sinnerAdapter = new SinnerAdapter(getApplication(), context);
        recyclerViewSinner.setAdapter(sinnerAdapter);
        recyclerViewSinner.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupReturnButton() {
        buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Return button clicked");   // log button click for debugging using "CIS 3334" tag
                Intent intent = new Intent();
                startActivity(intent);
            }
        });
    }

    private void setupLiveDataObserver() {
        // Create the observer for the list of heart rates
        mainViewModel.getAll().observe(this, new Observer<List<Sinner>>() {
            @Override
            public void onChanged(@Nullable List<Sinner> allSinners) {
                Log.d("CIS 3334", "MainActivity -- LiveData Observer -- Number of Sinners = "+allSinners.size());
                //editTextDisplay.setText("Number of heartrates = "+allHeartrates.size());
                // TODO: update the RecycleView Array Adapter
                sinnerAdapter.updateSinnerList(allSinners);
                sinnerAdapter.notifyDataSetChanged();
            }
        });
    }

}

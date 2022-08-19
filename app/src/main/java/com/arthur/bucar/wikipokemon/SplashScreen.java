package com.arthur.bucar.wikipokemon;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.arthur.bucar.wikipokemon.view.pokemonlist.PokemonListActivity;

public class SplashScreen extends AppCompatActivity {

    private  static  int SPLASH_SCREEN = 5000;

    ImageView imageView;
    TextView txTitle, txHint;
    Animation top, bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.spash_screen);

        imageView = findViewById(R.id.imageView);
        txTitle = findViewById(R.id.textViewTitle);
        txHint = findViewById(R.id.textViewHint);


        top = AnimationUtils.loadAnimation(this, R.anim.top);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);
        imageView.setAnimation(top);
        txHint.setAnimation(bottom);
        txHint.setAnimation(bottom);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, PokemonListActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}

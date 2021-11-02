package com.cookandroid.gif;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cookandroid.gif.listfragments.MyPostsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("GO For It");


        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentConainer, new Fragment_home()).commit();

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()) {

                    case R.id.home:
                        fragment = new Fragment_home();
                        break;
                    case R.id.community:
                        fragment = new Fragment_community();
                        break;

                    case R.id.wishlist:
                        fragment = new Fragment_wishlist();
                        break;

                    case R.id.mypage:
                        fragment = new MyPostsFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentConainer, fragment).commit();


                return true;
            }
        });

    }

}
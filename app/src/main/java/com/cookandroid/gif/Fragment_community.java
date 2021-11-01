package com.cookandroid.gif;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.cookandroid.gif.databinding.FragmentCommunityBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

//MainActivity.java를 Fragment_community.java로 옮겨옴.
//Fragment_community에서 MainFragment를 불러오고 거기서

public class Fragment_community extends AppCompatActivity {

    private FloatingActionButton fab;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentCommunityBinding binding = FragmentCommunityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fab = binding.fab;

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.setGraph(R.navigation.nav_graph);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.MainFragment) {
                fab.setVisibility(View.VISIBLE);
                fab.setOnClickListener(view -> {
                    navController.navigate(R.id.action_MainFragment_to_NewPostFragment);
                });
            } else {
                fab.setVisibility(View.GONE);
            }
        });
    }

}

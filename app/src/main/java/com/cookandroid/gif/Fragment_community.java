package com.cookandroid.gif;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.cookandroid.gif.databinding.FragmentCommunityBinding;
import com.cookandroid.gif.listfragments.PostListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import org.jetbrains.annotations.NotNull;

//MainActivity.java를 Fragment_community.java로 옮겨옴.
//Fragment_community에서 MainFragment를 불러오고 거기서

public class Fragment_community extends PostListFragment {

    private FloatingActionButton fab;
    private NavController navController;
    private FragmentCommunityBinding binding;


    public Fragment_community() {
    }

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // [START recent_posts_query]
        // Last 100 posts, these are automatically the 100 most recent
        // due to sorting by push() keys
        Query recentPostsQuery = databaseReference.child("posts")
                .limitToFirst(100);
        // [END recent_posts_query]

        return recentPostsQuery;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.fab).setVisibility(View.VISIBLE);
        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NewPostFragment.class);
                startActivity(intent);
            }
        });

    }

    //
//    @Nullable
//    @org.jetbrains.annotations.Nullable
//    @Override
//    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
//        binding = FragmentCommunityBinding.inflate(getLayoutInflater());
//
//        return binding.getRoot();
//    }
//
//    @Override
//    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//        fab = binding.fab;
//
//        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
//        navController.setGraph(R.navigation.nav_graph);
//        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
//            if (destination.getId() == R.id.MainFragment) {
//                fab.setVisibility(View.VISIBLE);
//                fab.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(getContext(), NewPostFragment.class);
//                        startActivity(intent);
//                    }
//                });
//            } else {
//                fab.setVisibility(View.GONE);
//            }
//        });
//    }
}

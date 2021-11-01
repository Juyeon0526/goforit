package com.cookandroid.gif;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_wishlist  extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_wishlist,container,false);

        return rootView;
/*
        private void onStarClicked(DatabaseReference postRef) {
            postRef.runTransaction(new Transaction.Handler() {
                @Override
                public Transaction.Result doTransaction(MutableData mutableData) {
                    Post p = mutableData.getValue(Post.class); if (p == null) {
                        return Transaction.success(mutableData);
                    } if (p.stars.containsKey(getUid())) {
                        // Unstar the post and remove self from stars
                        p.starCount = p.starCount - 1;
                        p.stars.remove(getUid());
                    } else {
                        // Star the post and add self to stars
                        p.starCount = p.starCount + 1;
                        p.stars.put(getUid(), true);
                    }
                    // Set value and report transaction success
                    mutableData.setValue(p);
                    return Transaction.success(mutableData);
                }
                @Override
                public void onComplete(DatabaseError databaseError, boolean committed,
                                       DataSnapshot currentData) {
                    // Transaction completed
                    Log.d(TAG, "postTransaction:onComplete:" + databaseError);
                }
            });
        }
*/
    }


}

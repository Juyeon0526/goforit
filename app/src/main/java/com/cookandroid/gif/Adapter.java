package com.cookandroid.gif;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    private ArrayList<Product_list> arrayList;
    //private ArrayList<ssdlist> arrayList1;
    //private ArrayList<cpulist> arrayList;
    private Context context;
    private int type = 0;
    //어댑터에서 액티비티 액션을 가져올 때 context가 필요한데 어댑터에는 context가 없다.
    //선택한 액티비티에 대한 context를 가져올 때 필요하다.

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    public Adapter(ArrayList<Product_list> arrayList, Context context, int type) {
        this.arrayList = arrayList;
        this.context = context;
        this.type = type;

        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동
        databaseReference = database.getReference("wish-list").child(getUid()); // DB 테이블 연결

    }

    public String createTransactionID() throws Exception {
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    //public Adapter(ArrayList<ssdlist> arrayList, Context context) {
    //    this.arrayList1 = arrayList1;
    //    this.context = context;
    //}

    @NonNull
    @Override
    //실제 리스트뷰가 어댑터에 연결된 다음에 뷰 홀더를 최초로 만들어낸다.
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cpulist, parent, false);
        //CustomViewHolder holder = new CustomViewHolder(view);
        //return holder;

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.listitem, parent, false);
        CustomViewHolder vh = new CustomViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.prod_name.setText(arrayList.get(position).getProd_name());
        holder.price.setText(arrayList.get(position).getPrice());

        Glide.with(holder.image.getContext())
                .load("https:" + arrayList.get(position).getImgUrl())
                .into(holder.image);

        holder.button_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (holder.button_star.isSelected()) {

                        databaseReference.child(arrayList.get(position).getProd_name()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                holder.button_star.setSelected(false);
                                if (type == 1) {
                                    arrayList.remove(position);
                                    notifyItemRemoved(position);
                                }
                            }
                        });
                    } else {
                        databaseReference.child(arrayList.get(position).getProd_name()).setValue(arrayList.get(position)).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                holder.button_star.setSelected(true);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        databaseReference.child(arrayList.get(position).getProd_name()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    holder.button_star.setSelected(true);
                } else {
                    holder.button_star.setSelected(false);
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView prod_name;
        TextView price;
        ImageView image;
        ImageView button_star;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.image = itemView.findViewById(R.id.image);
            this.prod_name = itemView.findViewById(R.id.prod_name);
            this.price = itemView.findViewById(R.id.price);
            this.button_star = itemView.findViewById(R.id.button_star);
        }
    }
}


package com.cookandroid.gif;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    private ArrayList<Product_list> arrayList;
    //private ArrayList<ssdlist> arrayList1;
    //private ArrayList<cpulist> arrayList;
    private Context context;
    //어댑터에서 액티비티 액션을 가져올 때 context가 필요한데 어댑터에는 context가 없다.
    //선택한 액티비티에 대한 context를 가져올 때 필요하다.

    public Adapter(ArrayList<Product_list> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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

        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.listitem, parent, false) ;
        CustomViewHolder vh = new CustomViewHolder(view) ;

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.prod_name.setText(arrayList.get(position).getProd_name());
        holder.price.setText(arrayList.get(position).getPrice());
        holder.prod_info.setText(arrayList.get(position).getProd_info());

        Glide.with(holder.image.getContext())
                .load("https:"+arrayList.get(position).getImgUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView prod_name;
        TextView price;
        TextView prod_info;
        ImageView image;



        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.image = itemView.findViewById(R.id.image);
            this.prod_name = itemView.findViewById(R.id.prod_name);
            this.price = itemView.findViewById(R.id.price);
            this.prod_info = itemView.findViewById(R.id.prod_info);
        }
    }
}


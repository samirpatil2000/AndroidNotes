package com.example.a40_recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder> {
    private static final String TAG = "recyclerViewAdapter";

    private ArrayList<String> name= new ArrayList<>();
    private ArrayList<String> images= new ArrayList<>();

    public recyclerViewAdapter(ArrayList<String> name, ArrayList<String> images, Context gContext) {
        this.name = name;
        this.images = images;
        this.gContext = gContext;
    }

    private Context gContext ;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // it will show how muck=h the item in list
        Log.d(TAG, "onBindViewHolder: called. ");

        Glide.with(gContext)
                .asBitmap()
                .load(images.get(position))
                .into(holder.image);
        holder.textView.setText(name.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                Toast.makeText(gContext,name.get(position) ,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView textView;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            imageView=itemView.findViewById(R.i)
            textView = itemView.findViewById(R.id.textView);
            image=itemView.findViewById(R.id.imageView);
            parentLayout=itemView.findViewById(R.id.parent_layout);


        }
    }
}

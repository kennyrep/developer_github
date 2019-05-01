package com.example.githubdeveloper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.githubdeveloper.controller.DetailActivity;
import com.example.githubdeveloper.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemsArrayList){
        this.context = applicationContext;
        this.items = itemsArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void  onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i){
        viewHolder.username.setText(items.get(i).getLogin());
        viewHolder.githublink.setText(items.get(i).getHtmlurl());
        //viewHolder.repository.setText(items.get(i).getReposurl());

        Picasso.with(context)
                .load(items.get(i).getAvatarurl())
                .placeholder(R.drawable.progress)
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView username, githublink;
        private CircleImageView imageView;


        public ViewHolder(View view){
            super(view);
            username = view.findViewById(R.id.username);
            githublink = view.findViewById(R.id.githublink);
           // repository = view.findViewById(R.id.repository);
            imageView = view.findViewById(R.id.image_view);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Item clikedDataItem = items.get(pos);
                        Intent i = new Intent(context, DetailActivity.class);

                        i.putExtra("login", items.get(pos).getLogin());
                        i.putExtra("html_url", items.get(pos).getHtmlurl());
                        i.putExtra("avatar_url", items.get(pos).getAvatarurl());
                       // i.putExtra("repository", items.get(pos).getReposurl());
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);
                        Toast.makeText(v.getContext(), "You Clicked " + clikedDataItem.getLogin(), Toast.LENGTH_SHORT).show();



                    }
                }
            });
        }
    }
}

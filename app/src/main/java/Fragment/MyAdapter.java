package Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kr.co.eyc.cafeseek.R;

public class MyAdapter extends RecyclerView.Adapter{

    Context context;
    ArrayList<Item> items;

    public MyAdapter(Context context, ArrayList<Item> items){
        this.context= context;
        this.items= items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.item_cardview, parent, false);

        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VH vh= (VH)holder;

        final Item item= items.get(position);
        Glide.with(context).load(item.img).into(vh.itemimage);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView itemimage;

        public VH(@NonNull View itemView) {
            super(itemView);
            itemimage= itemView.findViewById(R.id.iv);

        }
    }
}

package com.tistory.ckdgus.subject11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CchAdapter extends RecyclerView.Adapter<CchAdapter.ViewHolder> {

    private ArrayList<Todo> mData;
    private DBHelper dbHelper;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2;
        ImageButton button1;

        ViewHolder(View itemView) {
            super(itemView);

            dbHelper = DBHelper.getInstance(itemView.getContext());
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            button1 = itemView.findViewById(R.id.button1);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dbHelper.delete(MainActivity.list.get(getAdapterPosition()));
                    MainActivity.list.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }

    }


    CchAdapter(ArrayList<Todo> list) {
        mData = list;
    }

    @Override
    public CchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        CchAdapter.ViewHolder vh = new CchAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(CchAdapter.ViewHolder holder, int position) {
        String text = mData.get(position).getTodo();
        holder.text2.setText(text);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}

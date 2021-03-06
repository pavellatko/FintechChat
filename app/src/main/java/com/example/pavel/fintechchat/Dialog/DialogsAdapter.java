package com.example.pavel.fintechchat.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pavel.fintechchat.OnItemClickListener;
import com.example.pavel.fintechchat.R;

import java.util.List;

/**
 * Created by pavel on 3/23/17.
 */

public class DialogsAdapter extends RecyclerView.Adapter<DialogsAdapter.ViewHolder>  {

    private List<DialogItem> dataset;
    private OnItemClickListener clickListener;

    public DialogsAdapter(List<DialogItem> dataset, OnItemClickListener clickListener) {
        this.dataset = dataset;
        this.clickListener = clickListener;
    }

    @Override
    public DialogsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_dialog, parent, false);
        return new ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(dataset.get(position).getTitle());
        holder.desc.setText(dataset.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView desc;

        public ViewHolder(View view, OnItemClickListener listener) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_dialog_title);
            desc = (TextView) view.findViewById(R.id.tv_dialog_desc);
            setListener(listener);
        }

        private void setListener(final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}

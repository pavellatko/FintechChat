package com.example.pavel.fintechchat.Message;

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

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder>  {

    private List<MessageItem> dataset;
    private OnItemClickListener clickListener;

    public MessagesAdapter(List<MessageItem> dataset, OnItemClickListener clickListener) {
        this.dataset = dataset;
        this.clickListener = clickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView message;

        public ViewHolder(View view, OnItemClickListener listener) {
            super(view);
            message = (TextView) view.findViewById(R.id.tv_message);
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

    public static class ViewHolderIn extends  ViewHolder {
        public ViewHolderIn(View view, OnItemClickListener listener) {
            super(view, listener);
        }
    }

    public static class ViewHolderOut extends  ViewHolder {
        public ViewHolderOut(View view, OnItemClickListener listener) {
            super(view, listener);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (dataset.get(position).getIncoming()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_message_incoming, parent, false);
                return new ViewHolderIn(view, clickListener);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_message_outgoing, parent, false);
                return new ViewHolderOut(view, clickListener);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                ViewHolderIn viewHolderIn = (ViewHolderIn)holder;
                break;
            default:
                ViewHolderOut viewHolderOut = (ViewHolderOut)holder;
                break;
        }
        holder.message.setText(dataset.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

package com.example.pavel.fintechchat.Dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pavel.fintechchat.Message.MessageActivity;
import com.example.pavel.fintechchat.OnItemClickListener;
import com.example.pavel.fintechchat.R;

import java.util.ArrayList;
import java.util.List;


public class DialogsFragment extends Fragment {

    private View fragmentView;
    private RecyclerView recyclerView;
    private DialogsAdapter adapter;

    public static DialogsFragment newInstance() {
        DialogsFragment fragment = new DialogsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView =  inflater.inflate(R.layout.fragment_dialogs, container, false);
        initRecyclerView();
        return fragmentView;
    }


    private void initRecyclerView() {
        recyclerView = (RecyclerView) fragmentView.findViewById(R.id.recycler_view_dialogs);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DialogsAdapter(createDataset(), new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                intent.putExtra(getString(R.string.dialog_intent), position);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private List<DialogItem> createDataset() {
        List<DialogItem> list = new ArrayList<>();
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        list.add(new DialogItem("title", "desc"));
        return list;
    }

}

package com.example.homework32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FirstFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private ArrayList<String> arrayList;

    public FirstFragment() {
    }


    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        initRecycler(view);
    }

    private void initRecycler(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        mainAdapter = new MainAdapter();
        mainAdapter.addItems(arrayList);
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.MainAdapterListener(new MainAdapter.ItemClickListener() {
            @Override
            public void OnClick(String text) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.conteiner,SecondFragment.newInstance(text,text))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void createList() {
        arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");

    }
}
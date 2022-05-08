package com.example.novel.tabs;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.novel.Book;
import com.example.novel.BookViewModel;
import com.example.novel.R;
import com.example.novel.adapter.GroupAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecommentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecommentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private RecyclerView rvGroup;
    private List<Book>bookList;
    private LinearLayoutManager layoutManagerGroup;
    private BookViewModel bookViewModel;
    GroupAdapter adapterGroup;
    public RecommentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecommentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecommentFragment newInstance(String param1, String param2) {
        RecommentFragment fragment = new RecommentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookViewModel= new ViewModelProvider(this).get(BookViewModel.class);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_recomment,container,false);
        rvGroup=view.findViewById(R.id.rv_group);
        bookList = new ArrayList<>();
        adapterGroup = new GroupAdapter(getActivity(),bookList);
        layoutManagerGroup = new LinearLayoutManager(getActivity());
        rvGroup.setLayoutManager(layoutManagerGroup);
        rvGroup.setAdapter(adapterGroup);
        bookViewModel.getBookList();
        bookViewModel.getBookLiveData().observe(getViewLifecycleOwner(), list->{
            bookList.addAll(list);
            adapterGroup.notifyDataSetChanged();
        });
        return view;
    }
}
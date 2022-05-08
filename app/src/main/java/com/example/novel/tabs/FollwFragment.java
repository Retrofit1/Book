package com.example.novel.tabs;



import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.novel.R;
import com.example.novel.activity.AllCategoryActivity;
import com.example.novel.adapter.CategoryAdapter;
import com.example.novel.adapter.DiscountedProductAdapter;
import com.example.novel.adapter.RecentlyViewedAdapter;
import com.example.novel.mode.Category;
import com.example.novel.mode.DiscountedProducts;
import com.example.novel.mode.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FollwFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FollwFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    private RecyclerView discountedRecycleView,categoryRecycleView,recentlyViewedRecycler;
    private DiscountedProductAdapter discountedProductAdapter;
    private ArrayList<DiscountedProducts>discountedProductsList;

    private CategoryAdapter categoryAdapter;
    private ArrayList<Category>categoryList;

    private RecentlyViewedAdapter recentlyViewedAdapter;
    private ArrayList<RecentlyViewed>recentlyViewedArrayList;

    private ImageView allCategory;

    public FollwFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FollwFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FollwFragment newInstance(String param1, String param2) {
        FollwFragment fragment = new FollwFragment();
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
        view=inflater.inflate(R.layout.fragment_follw,container,false);
        discountedRecycleView=view.findViewById(R.id.discountedRecycler);
        categoryRecycleView=view.findViewById(R.id.categoryRecycler);
        allCategory=view.findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler=view.findViewById(R.id.recently_item);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AllCategoryActivity.class);
                startActivity(intent);
            }
        });

        initData();
        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedArrayList);
        // Inflate the layout for this fragment
        return view;
    }

    private void setDiscountedRecycler(ArrayList<DiscountedProducts>dataList) {
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        discountedRecycleView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(getActivity(),dataList);
        discountedRecycleView.setAdapter(discountedProductAdapter);
    }
    private void setCategoryRecycler(ArrayList<Category>categoryDataList) {
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        categoryRecycleView.setLayoutManager(layoutManager);
        categoryAdapter= new CategoryAdapter(getActivity(),categoryDataList);
        categoryRecycleView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(ArrayList<RecentlyViewed>recentlyViewedDataArrayList) {
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter= new RecentlyViewedAdapter(getActivity(),recentlyViewedDataArrayList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

    private void initData(){
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.mystory));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.newbook));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.readinglab));
        discountedProductsList.add(new DiscountedProducts(4, R.drawable.mystory));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.newbook));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.readinglab));

        categoryList = new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.ic_baseline_home_24));
        categoryList.add(new Category(2,R.drawable.ic_baseline_home_24));
        categoryList.add(new Category(3,R.drawable.ic_baseline_home_24));
        categoryList.add(new Category(4,R.drawable.ic_baseline_home_24));
        categoryList.add(new Category(5,R.drawable.ic_baseline_home_24));
        categoryList.add(new Category(6,R.drawable.ic_baseline_home_24));

        recentlyViewedArrayList = new ArrayList<>();
        recentlyViewedArrayList.add(new RecentlyViewed("挪威的森林",
                "一个日本人写的",
                "80$",
                "2",
                "JP",
                R.drawable.mystory,R.drawable.mystory));


    }

      


}
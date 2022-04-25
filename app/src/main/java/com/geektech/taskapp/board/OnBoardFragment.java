package com.geektech.taskapp.board;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.taskapp.R;
import com.geektech.taskapp.databinding.FragmentOnBoardBinding;


public class OnBoardFragment extends Fragment {
    private FragmentOnBoardBinding binding;
    private BoardAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewPager();
        initListeners();
    }

    private void initViewPager() {
        adapter=new BoardAdapter();
        binding.mainVp.setAdapter(adapter);
    }

    private void initListeners() {
    }
}
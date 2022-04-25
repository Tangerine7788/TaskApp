package com.geektech.taskapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.geektech.taskapp.R;
import com.geektech.taskapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements TaskAdapter.OnItemClick{
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private TaskAdapter adapter = new TaskAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        initRecyclerView();
    }

    private void initRecyclerView() {
        for (int i = 0; i < 11; i++) {

            adapter.setTask("Task:"+i);
            
        }
        adapter.setListener(this);
        binding.taskRv.setAdapter(adapter);
    }

    private void initListeners() {
        binding.addTaskBtn.setOnClickListener(v -> {
            openDetailFragment();
        });
    }

    private void openDetailFragment() {
        NavController navController =Navigation.findNavController(requireActivity(),R.id.
                main_container);
        navController.navigate(R.id.detailFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(String task) {
        Toast.makeText(requireContext(),task,Toast.LENGTH_LONG).show();
    }
}
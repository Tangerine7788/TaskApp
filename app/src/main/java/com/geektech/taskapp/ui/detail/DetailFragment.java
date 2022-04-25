package com.geektech.taskapp.ui.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.taskapp.R;
import com.geektech.taskapp.databinding.FragmentDetailBinding;


public class DetailFragment extends Fragment {
        private FragmentDetailBinding binding;


        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            initListeners();
        }

    private void initListeners() {
            binding.btnAdd.setOnClickListener(v->{
                String add =  binding.taskEt.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("add",add);
                getActivity().getSupportFragmentManager().setFragmentResult("add",bundle);
//            getActivity().getSupportFragmentManager().popBackStack();
                NavController navController = Navigation.findNavController(requireActivity(),R.id.main_container);
                navController.navigateUp();

                sendData();
                closeFragment();
            });
    }

    private void closeFragment() {

    }

    private void sendData(){

    }

}

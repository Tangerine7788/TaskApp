package com.geektech.taskapp.ui.notifications;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.geektech.taskapp.R;
import com.geektech.taskapp.databinding.FragmentNotificationsBinding;

public class NotificationsFragment<v> extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int permissionStatusContact;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            permissionStatusContact = requireContext().checkSelfPermission(Manifest.permission.
                    READ_CONTACTS);
        }else {
            permissionStatusContact = 0;
        }
        String[] permissions ={Manifest.permission.READ_CONTACTS
        };
        binding.readBtn.setOnClickListener(v -> {
            if(permissionStatusContact==PackageManager.PERMISSION_GRANTED){
                Log.e("Tag","permissionStatusContact: good");
            }else {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
                requireActivity().requestPermissions(permissions,101);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Log.e("Tag","onRequestPermissionResult: read");
                }else {
                    Log.e("Tag","onRequestPermissionResult: not read");
                }

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
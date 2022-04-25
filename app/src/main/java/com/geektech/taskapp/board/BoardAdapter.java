package com.geektech.taskapp.board;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.taskapp.R;
import com.geektech.taskapp.databinding.ItemBoardBinding;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder>{
    private int[] imgList = {R.drawable.photo_one,R.drawable.photo_two,R.drawable.photo_three};
    private String[] titlelist = {"First","Second","Third"};
    private String[] subTitle = {"FIRST Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "SECOND Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "THIRD Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    };
    private ArrayList<String> list = new ArrayList<>();
    private ItemBoardBinding binding;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board,parent,
                false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(imgList[position],titlelist[position],subTitle[position]);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTv, subtitleTv;
        private ImageView img;
        public ViewHolder(@NonNull View view) {
            super(view);
            titleTv = view.findViewById(R.id.board_title_tv);
            subtitleTv = view.findViewById(R.id.board_subtitle_tv);
            img = view.findViewById(R.id.board_iv);
        }


        public void onBind(int image, String title, String subtitle) {
            titleTv.setText(title);
            subtitleTv.setText(subtitle);
            img.setImageResource(image);
        }
    }

}

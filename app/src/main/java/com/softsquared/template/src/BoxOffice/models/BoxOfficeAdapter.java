package com.softsquared.template.src.BoxOffice.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.softsquared.template.R;

import java.util.ArrayList;

public class BoxOfficeAdapter extends RecyclerView.Adapter<BoxOfficeAdapter.ItemHolder> {



    Context mContext;
    LayoutInflater mInflater;
    ArrayList<DailyBoxOfficeList> mBoxOfficeData;


    public BoxOfficeAdapter(Context mContext, ArrayList<DailyBoxOfficeList> boxOfficeData) {
        this.mContext = mContext;
        this.mBoxOfficeData = boxOfficeData;

        mInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View v =mInflater.inflate(R.layout.item_layout_boxoffice,parent,false);



        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {



        holder.onBind(   mBoxOfficeData.get(position)    );
    }



    @Override
    public int getItemCount() {
        return mBoxOfficeData.size();
    }


    class ItemHolder extends RecyclerView.ViewHolder{


        TextView rank,title,showcnt;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            rank=itemView.findViewById(R.id.rank_item_layout);
            title=itemView.findViewById(R.id.movie_name_item_layout);
            showcnt=itemView.findViewById(R.id.audiAcc_itemlayout);
        }


        void onBind(DailyBoxOfficeList    dailyBoxOfficeList   ) {
            rank.setText(dailyBoxOfficeList.getRank());
            title.setText(dailyBoxOfficeList.getMovieNm());
            showcnt.setText(dailyBoxOfficeList.getAudiCnt());




        }
    }
}

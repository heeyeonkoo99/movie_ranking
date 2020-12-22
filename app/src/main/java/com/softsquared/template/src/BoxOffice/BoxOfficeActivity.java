package com.softsquared.template.src.BoxOffice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.BoxOffice.interfaces.BoxOfficeActivityView;
import com.softsquared.template.src.BoxOffice.interfaces.BoxOfifceRetrofitInterface;
import com.softsquared.template.src.BoxOffice.models.BoxOfficeAdapter;
import com.softsquared.template.src.BoxOffice.models.BoxOfficeResponse;
import com.softsquared.template.src.BoxOffice.models.DailyBoxOfficeList;

import java.util.ArrayList;

public class BoxOfficeActivity extends BaseActivity implements BoxOfficeActivityView {






    BoxOfficeAdapter boxOfficeAdapter;
    RecyclerView recyclerView;
    ArrayList<DailyBoxOfficeList> dailyBoxOfficeListArrayList;
    BoxOfficeService boxOfficeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_office2);
        boxOfficeService=new BoxOfficeService(this);
        boxOfficeService.getBoxOffice();

        dailyBoxOfficeListArrayList=new ArrayList<>();
        recyclerView=findViewById(R.id.day_box_office_boxoffice_activity);
        boxOfficeAdapter=new BoxOfficeAdapter(this,dailyBoxOfficeListArrayList);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(boxOfficeAdapter);
    }


    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void SuccessBoxOffice(BoxOfficeResponse boxOfficeResponse) {


        dailyBoxOfficeListArrayList.addAll(boxOfficeResponse.getBoxOfficeResult().getDailyBoxOfficeList());


// 밑이랑 똑같은 구문 .
//        for(int i =0 ;i< boxOfficeResponse.getBoxOfficeResult().getDailyBoxOfficeList().size();i++)
//        {
//
//            dailyBoxOfficeListArrayList.add(boxOfficeResponse.getBoxOfficeResult().getDailyBoxOfficeList().get(i));
//        }
//
        System.out.println("d?");

        boxOfficeAdapter.notifyDataSetChanged();

        ///
    }


}
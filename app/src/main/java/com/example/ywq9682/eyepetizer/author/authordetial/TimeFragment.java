package com.example.ywq9682.eyepetizer.author.authordetial;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.ywq9682.eyepetizer.R;
import com.example.ywq9682.eyepetizer.base.BaseFragment;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by dllo on 16/7/21.
 */
public class TimeFragment extends BaseFragment {
    private ListView listview;
    private TimeBean datas;
    private TimeAdapter timeAdapter;
    private String url = "http://baobab.wandoujia.com/api/v3/pgc/videos?pgcId=";
    private String endUrl = "&strategy=date&udid\" +\n" +
            "\"=cd1ee9c5b44e4f9487a505a4fe31ddcb07441cc8&vc=121&vn=\" + \"2.3.5&deviceModel=MI%205&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23";

    @Override
    public int setLayout() {
        return R.layout.fragment_author_time;

    }

    @Override
    public void initView(View view) {
        Log.d("TimeFragment", "kkkkkkk");
        Intent bacIntent = getActivity().getIntent();
        int id = bacIntent.getIntExtra("lll", 0);
        String allUrl = url + id + endUrl;
        listview = (ListView) view.findViewById(R.id.time_listview);
        datas = new TimeBean();
        timeAdapter = new TimeAdapter(context);
        OkHttpUtils.get().url(allUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson = new Gson();
                datas = gson.fromJson(response, TimeBean.class);
                Log.d("TimeFragment", "datas.getTotal():" + datas.getItemList().get(id).getData().getTitle());
                timeAdapter.setTimeBean(datas);
                listview.setAdapter(timeAdapter);
            }
        });
    }

    @Override
    protected void initData() {
    }
}

package com.example.ywq9682.eyepetizer.discover.top;

import android.view.View;
import android.widget.ListView;

import com.example.ywq9682.eyepetizer.R;
import com.example.ywq9682.eyepetizer.base.BaseFragment;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by dllo on 16/7/29.
 */
public class TotalFragment extends BaseFragment {
    private ListView listView;
    private WeekBean weekBean;
    private WeekAdapter weekAdapter;
    private String url = "http://baobab.wandoujia.com/api/v3/ranklist?num=10&strategy=weekly&udid=cd1ee9c5b44e4f9487a5" +
            "05a4fe31ddcb07441cc8&vc=121&vn=2.3.5&deviceModel=MI%205&first_channel=eyepetizer_xiaomi_market&last_chann" +
            "el=eyepetizer_xiaomi_market&system_version_code=23";
    @Override
    public int setLayout() {
        return R.layout.fragment_week;
    }

    @Override
    public void initView(View view) {

        listView = (ListView) view.findViewById(R.id.fragment_week_listview);
        weekAdapter = new WeekAdapter(context);

        listView = (ListView) view.findViewById(R.id.fragment_week_listview);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

                Gson gson = new Gson();
                weekBean = gson.fromJson(response, WeekBean.class);
                weekAdapter.setWeekBean(weekBean);
            }
        });
        listView.setAdapter(weekAdapter);


    }

    @Override
    protected void initData() {

    }
}

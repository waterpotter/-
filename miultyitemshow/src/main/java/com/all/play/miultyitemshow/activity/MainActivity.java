package com.all.play.miultyitemshow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.all.play.miultyitemshow.R;
import com.all.play.miultyitemshow.adapter.CityAdapter;
import com.all.play.miultyitemshow.entrity.CityEntity;
import com.all.play.miultyitemshow.utils.ToastUtil;
import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.tinypinyin.lexicons.android.cncity.CnCityDict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import me.yokeyword.indexablerv.SimpleHeaderAdapter;

public class MainActivity extends AppCompatActivity {

    private IndexableLayout indexableLayout;
    private SimpleHeaderAdapter mHotCityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //设置样式 4列
        indexableLayout.setLayoutManager(new GridLayoutManager(this,1));

        // 多音字处理
        Pinyin.init(Pinyin.newConfig().with(CnCityDict.getInstance(this)));
        // 快速排序。  排序规则设置为：只按首字母  （默认全拼音排序）  效率很高，是默认的10倍左右。  按需开启～
        indexableLayout.setCompareMode(IndexableLayout.MODE_FAST);


        // setAdapter
        CityAdapter adapter = new CityAdapter(this);
        indexableLayout.setAdapter(adapter);
        // set Datas
        List<CityEntity> entityList = initDatas();
        //给列表设置书库
        adapter.setDatas(entityList);
        // set Center OverlayView
        indexableLayout.setOverlayStyle_Center();//往里边添加textview

        // set Listener
        adapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<CityEntity>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, CityEntity entity) {
                if (originalPosition >= 0) {
                    ToastUtil.showShort(MainActivity.this, "选中:" + entity.getName() + "  当前位置:" + currentPosition + "  原始所在数组位置:" + originalPosition);
                } else {
                    ToastUtil.showShort(MainActivity.this, "选中Header:" + entity.getName() + "  当前位置:" + currentPosition);
                }

                startActivity(new Intent(MainActivity.this,MyFirstActivity.class));
            }
        });

        adapter.setOnItemTitleClickListener(new IndexableAdapter.OnItemTitleClickListener() {
            @Override
            public void onItemClick(View v, int currentPosition, String indexTitle) {
                ToastUtil.showShort(MainActivity.this, "选中:" + indexTitle + "  当前位置:" + currentPosition);
            }
        });

        // 添加 HeaderView DefaultHeaderAdapter接收一个IndexableAdapter, 使其布局以及点击事件和IndexableAdapter一致
        // 如果想自定义布局,点击事件, 可传入 new IndexableHeaderAdapter
        mHotCityAdapter = new SimpleHeaderAdapter<>(adapter, "热", "热门城市", iniyHotCityDatas());
        // 热门城市
        indexableLayout.addHeaderAdapter(mHotCityAdapter);



    }



    /**
     * 添加头部
     * @return
     */
    private List<CityEntity> iniyHotCityDatas() {
        List<CityEntity> list = new ArrayList<>();
        list.add(new CityEntity("杭州市"));
        list.add(new CityEntity("北京市"));
        list.add(new CityEntity("上海市"));
        list.add(new CityEntity("广州市"));
        return list;

    }

    /**
     * 初始化view
     */
    private void initView() {
        indexableLayout = (IndexableLayout) findViewById(R.id.indexableLayout);
    }


    private List<CityEntity> initDatas() {
        List<CityEntity> list = new ArrayList<>();
        List<String> cityStrings = Arrays.asList(getResources().getStringArray(R.array.city_array));
        for (String item : cityStrings) {
            CityEntity cityEntity = new CityEntity();
            cityEntity.setName(item);
            list.add(cityEntity);
        }
        return list;
    }
}

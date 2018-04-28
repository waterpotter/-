package com.all.play.miultyitemshow.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.all.play.miultyitemshow.R;
import com.all.play.miultyitemshow.adapter.BannerHeaderAdapter;
import com.all.play.miultyitemshow.adapter.ContactAdapter;
import com.all.play.miultyitemshow.adapter.MenuHeaderAdapter;
import com.all.play.miultyitemshow.entrity.MenuEntity;
import com.all.play.miultyitemshow.entrity.UserEntity;
import com.all.play.miultyitemshow.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableHeaderAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import me.yokeyword.indexablerv.SimpleFooterAdapter;
import me.yokeyword.indexablerv.SimpleHeaderAdapter;

/**
 * Created by 聪明一只哈 on 2018/4/27.
 * Time: 2018/4/27  10:33
 */

public class MyFirstActivity extends AppCompatActivity {

    private IndexableLayout indexableLayout;
    private ContactAdapter contactAdapter;
    private MenuHeaderAdapter mMenuHeaderAdapter;
    private BannerHeaderAdapter mBannerHeaderAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initView();

        initData();
    }

    private void initData() {

        contactAdapter = new ContactAdapter(MyFirstActivity.this);
        indexableLayout.setAdapter(contactAdapter);

        contactAdapter.setDatas(initDatas());


        // set Material Design OverlayView  // 前者Material Design风格右侧气泡 ， 后者 居中 IOS风格气泡
       // indexableLayout.setOverlayStyle_MaterialDesign(int Color) & setOverlayStyle_Center()
        indexableLayout.setOverlayStyle_MaterialDesign(Color.BLUE);
        //indexableLayout.setOverlayStyle_Center();

        // 全字母排序。  排序规则设置为：每个字母都会进行比较排序；速度较慢
        indexableLayout.setCompareMode(IndexableLayout.MODE_ALL_LETTERS);

        // set Listener
        contactAdapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<UserEntity>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, UserEntity entity) {
                if (originalPosition >= 0) {
                    ToastUtil.showShort(MyFirstActivity.this, "选中:" + entity.getNick() + "  当前位置:" + currentPosition + "  原始所在数组位置:" + originalPosition);
                } else {
                    ToastUtil.showShort(MyFirstActivity.this, "选中Header/Footer:" + entity.getNick() + "  当前位置:" + currentPosition);
                }
            }
        });

        contactAdapter.setOnItemTitleClickListener(new IndexableAdapter.OnItemTitleClickListener() {
            @Override
            public void onItemClick(View v, int currentPosition, String indexTitle) {
                ToastUtil.showShort(MyFirstActivity.this, "选中:" + indexTitle + "  当前位置:" + currentPosition);
            }
        });

        // 添加我关心的人
        indexableLayout.addHeaderAdapter(new SimpleHeaderAdapter<>(contactAdapter, "☆", "我关心的", initFavDatas()));

        // 构造函数里3个参数,分别对应 (IndexBar的字母索引, IndexTitle, 数据源), 不想显示哪个就传null, 数据源传null时,代表add一个普通的View
        mMenuHeaderAdapter = new MenuHeaderAdapter(MyFirstActivity.this,"↑", null, initMenuDatas());
        // 添加菜单
        indexableLayout.addHeaderAdapter(mMenuHeaderAdapter);
        mMenuHeaderAdapter.setOnItemHeaderClickListener(new IndexableHeaderAdapter.OnItemHeaderClickListener<MenuEntity>() {
            @Override
            public void onItemClick(View v, int currentPosition, MenuEntity entity) {
                ToastUtil.showShort(MyFirstActivity.this, entity.getMenuTitle());
            }
        });

        // 这里BannerView只有一个Item, 添加一个长度为1的任意List作为第三个参数
        List<String> bannerList = new ArrayList<>();
        bannerList.add("");
        mBannerHeaderAdapter = new BannerHeaderAdapter(MyFirstActivity.this,null, null, bannerList);
        // 添加 Banner
        indexableLayout.addHeaderAdapter(mBannerHeaderAdapter);

        // FooterView
        indexableLayout.addFooterAdapter(new SimpleFooterAdapter<>(contactAdapter, "尾", "我是FooterView", initFavDatas()));



    }

    private List<UserEntity> initFavDatas() {

        List<UserEntity> list = new ArrayList<>();
        list.add(new UserEntity("张三", "10000"));
        list.add(new UserEntity("李四", "10001"));
        return list;
    }

    private List<MenuEntity> initMenuDatas() {

        List<MenuEntity> list = new ArrayList<>();
        list.add(new MenuEntity("新的朋友", R.mipmap.icon_1));
        list.add(new MenuEntity("群聊", R.mipmap.icon_2));
        list.add(new MenuEntity("标签", R.mipmap.icon_3));
        list.add(new MenuEntity("公众号", R.mipmap.icon_4));
        return list;
    }

    private List<UserEntity> initDatas() {
        List<UserEntity> list = new ArrayList<>();
        // 初始化数据
        List<String> contactStrings = Arrays.asList(getResources().getStringArray(R.array.contact_array));
        List<String> mobileStrings = Arrays.asList(getResources().getStringArray(R.array.mobile_array));
        for (int i = 0; i < contactStrings.size(); i++) {
            UserEntity contactEntity = new UserEntity(contactStrings.get(i), mobileStrings.get(i));
            list.add(contactEntity);
        }
        return list;
    }

    /**
     * 初始化view
     */
    private void initView() {
        indexableLayout = (IndexableLayout) findViewById(R.id.firstindexableLayout);
        indexableLayout.setLayoutManager(new LinearLayoutManager(this));
    }


}

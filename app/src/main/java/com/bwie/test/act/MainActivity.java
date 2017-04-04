package com.bwie.test.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.bwie.test.CrashApplication;
import com.bwie.test.R;
import com.bwie.test.fragment.HomePage;
import com.bwie.test.fragment.PersonalPage;
import com.bwie.test.fragment.ShopPage;
import com.bwie.test.fragment.SortPage;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/16 13:09
 */

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout frameLayout;
    private RadioButton home;
    private RadioButton sort;
    private RadioButton shop;
    private RadioButton personal;
    private HomePage homePage;
    private SortPage sortPage;
    private ShopPage shopPage;
    private PersonalPage personalPage;
    private List<RadioButton> list;
    private RadioGroup radioGroup;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
       
            home.setChecked(true);
            radioButtonColor();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl, homePage).show(homePage)
                    .add(R.id.fl, sortPage).hide(sortPage)
                    .add(R.id.fl, shopPage).hide(shopPage)
                    .add(R.id.fl, personalPage).hide(personalPage)
                    .commit();
      

    }

    private void radioButtonColor() {
        for (RadioButton rb : list) {
            if (rb.isChecked()) {
                rb.setChecked(true);
                //rb.setTextColor(Color.RED);
            } else {
                rb.setChecked(false);
                //rb.setTextColor(Color.BLACK);
            }
        }
    }

    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.fl);
        home = (RadioButton) findViewById(R.id.home);
        sort = (RadioButton) findViewById(R.id.sort);
        shop = (RadioButton) findViewById(R.id.shop);
        personal = (RadioButton) findViewById(R.id.personal);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);
        fragment = new Fragment();
        list = new ArrayList<>();
        list.add(home);
        list.add(sort);
        list.add(shop);
        list.add(personal);
        homePage = new HomePage();
        sortPage = new SortPage();
        shopPage = new ShopPage();
        personalPage = new PersonalPage();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().show(homePage)
                        .hide(fragment).commit();
                fragment = homePage;
                radioButtonColor();
                break;
            case R.id.sort:
                getSupportFragmentManager().beginTransaction().show(sortPage)
                        .hide(fragment).commit();
                fragment = sortPage;
                radioButtonColor();
                break;
            case R.id.shop:
                getSupportFragmentManager().beginTransaction().show(shopPage)
                        .hide(fragment).commit();
                fragment = shopPage;
                radioButtonColor();
                break;
            case R.id.personal:
                getSupportFragmentManager().beginTransaction().show(personalPage)
                        .hide(fragment).commit();
                fragment = personalPage;
                radioButtonColor();
                break;
        }
    }
}

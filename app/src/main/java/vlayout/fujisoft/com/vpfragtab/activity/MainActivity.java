package vlayout.fujisoft.com.vpfragtab.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import vlayout.fujisoft.com.vpfragtab.R;
import vlayout.fujisoft.com.vpfragtab.factory.MainFragmentFactory;

public class MainActivity extends AppCompatActivity {
    private static final String HOME = "HOME";
    private static final String CATEGORY = "CATEGORY";
    private static final String SEARCH = "SEARCH";
    private static final String ME = "ME";
    private BottomBar bottomBar;
    private String willHideFragment;//上一个显示页面的标记

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomBar();
    }

    private void initBottomBar() {
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home_page:
                        showFragment(HOME,MainFragmentFactory.HOME);
                        break;
                    case R.id.tab_task_hall:
                        showFragment(CATEGORY,MainFragmentFactory.CATEGORY);
                        break;
                    case R.id.tab_flower_mall:
                        showFragment(SEARCH,MainFragmentFactory.SEARCH);
                        break;
                    case R.id.tab_me:
                        showFragment(ME,MainFragmentFactory.ME);
                        break;
                }
            }
        });
    }

    /**
     * 显示对应的fragment
     * @param willShowing 将要被显示的fragment
     * @param tag 将要被显示的fragment的标记
     */
    private void showFragment(String willShowing,String tag) {
        //1 通过FragmentManager获取Fragment 2 如果不存在，就通过MainFragmentFactory创建 3 如果存在，显示
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(willShowing);
        FragmentTransaction ft = manager.beginTransaction();
        if (fragment == null) {
            //添加
            ft.add(R.id.contentContainer,MainFragmentFactory.getFragment(tag),willShowing);
        }else {
            //直接显示
            ft.show(fragment);
        }
        if (willHideFragment != willShowing && willHideFragment != null) {
            Fragment hideFragment = manager.findFragmentByTag(willHideFragment);
            ft.hide(hideFragment);
        }
        //标记当前显示的页面
        willHideFragment = willShowing;
        ft.commit();
    }
}

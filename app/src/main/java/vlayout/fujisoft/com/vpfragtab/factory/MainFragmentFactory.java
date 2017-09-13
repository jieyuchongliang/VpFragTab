package vlayout.fujisoft.com.vpfragtab.factory;


import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import vlayout.fujisoft.com.vpfragtab.fragment.main_fragment.CategoryFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.main_fragment.HomeFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.main_fragment.MeFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.main_fragment.SearchFragment;

/**
 * Created by 860617010 on 2017/9/13.
 */

public class MainFragmentFactory {
    public static final String HOME = "HOME";
    public static final String CATEGORY = "CATEGORY";
    public static final String SEARCH = "SEARCH";
    public static final String ME = "ME";
    private static Map<String, Fragment> map = new HashMap<>();

    /**
     * 获取对应的fragment对象
     *
     * @param tag 对应标记
     * @return
     */
    public static Fragment getFragment(String tag) {
        Fragment fragment = null;
        //优先缓存集合中取出来
        if (map.containsKey(tag)) {
            fragment = map.get(tag);
            return fragment;
        }
        switch (tag) {
            case HOME:
                fragment = new HomeFragment();
                break;
            case CATEGORY:
                fragment = new CategoryFragment();
                break;
            case SEARCH:
                fragment = new SearchFragment();
                break;
            case ME:
                fragment = new MeFragment();
                break;
        }
        map.put(tag,fragment);
        return fragment;
    }
}

package vlayout.fujisoft.com.vpfragtab.factory;

import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import vlayout.fujisoft.com.vpfragtab.fragment.AmusementFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.CarFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.JinanFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.JokeFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.RecommendFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.SocietyFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.SportFragment;
import vlayout.fujisoft.com.vpfragtab.fragment.VideoFragment;

/**
 * Created by 860617010 on 2017/9/13.
 */

public class CategoryFragmentFactory {
    public static final String AMUSEMENT = "AMUSEMENT";
    public static final String CAR = "CAR";
    public static final String JINAN = "JINAN";
    public static final String JOKE = "JOKE";
    public static final String RECOMMEND = "RECOMMEND";
    public static final String SOCIETY = "SOCIETY";
    public static final String SPORT = "SPORT";
    public static final String VIDEO = "VIDEO";
    private static Map<String, Fragment> fragmentMap = new HashMap<>();

    public static Fragment getFragment(String tag) {
        Fragment fragment = null;
        if (fragmentMap.containsKey(tag)) {
            fragment = fragmentMap.get(tag);
            return fragment;
        }
        switch (tag) {
            case AMUSEMENT:
                fragment = new AmusementFragment();
                break;
            case CAR:
                fragment = new CarFragment();
                break;
            case JINAN:
                fragment = new JinanFragment();
                break;
            case JOKE:
                fragment = new JokeFragment();
                break;
            case RECOMMEND:
                fragment = new RecommendFragment();
                break;
            case SOCIETY:
                fragment = new SocietyFragment();
                break;
            case SPORT:
                fragment = new SportFragment();
                break;
            case VIDEO:
                fragment = new VideoFragment();
                break;
            default:
                break;
        }
        return fragment;
    }
}

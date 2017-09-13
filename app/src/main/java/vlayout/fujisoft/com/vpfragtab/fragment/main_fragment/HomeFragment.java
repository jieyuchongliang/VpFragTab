package vlayout.fujisoft.com.vpfragtab.fragment.main_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vlayout.fujisoft.com.vpfragtab.R;
import vlayout.fujisoft.com.vpfragtab.adapter.CategoryVpFragAdapter;
import vlayout.fujisoft.com.vpfragtab.factory.CategoryFragmentFactory;

/**
 * Created by 860617010 on 2017/9/13.
 */

public class HomeFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private String[] titles = new String[]{"娱乐","汽车","济南","搞笑","推荐","社会","运动","视频"};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(CategoryFragmentFactory.getFragment(CategoryFragmentFactory.AMUSEMENT));
        fragmentList.add(CategoryFragmentFactory.getFragment(CategoryFragmentFactory.CAR));
        fragmentList.add(CategoryFragmentFactory.getFragment(CategoryFragmentFactory.JINAN));
        fragmentList.add(CategoryFragmentFactory.getFragment(CategoryFragmentFactory.JOKE));
        fragmentList.add(CategoryFragmentFactory.getFragment(CategoryFragmentFactory.RECOMMEND));
        fragmentList.add(CategoryFragmentFactory.getFragment(CategoryFragmentFactory.SOCIETY));
        fragmentList.add(CategoryFragmentFactory.getFragment(CategoryFragmentFactory.SPORT));
        fragmentList.add(CategoryFragmentFactory.getFragment(CategoryFragmentFactory.VIDEO));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        return view;
    }

    private void initView() {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(titles[0]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[1]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[2]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[3]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[4]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[5]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[6]));
        tabLayout.addTab(tabLayout.newTab().setText(titles[7]));
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new CategoryVpFragAdapter(getFragmentManager(),fragmentList,titles));
        tabLayout.setupWithViewPager(viewPager);
    }
}

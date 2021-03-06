package com.coyoal.zsc.cnode.views.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.coyoal.zsc.cnode.views.fragment.TopicsFragment
import java.util.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class TopicPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
    private val titles = arrayOf("精华", "分享", "问答", "招聘")
    private val fragments = ArrayList<Fragment>()

    init {
        for (tab in arrayOf("good", "share", "ask", "job")) {
            val f = TopicsFragment()
            val bundle = Bundle()
            bundle.putString("tab_key", tab)
            f.arguments = bundle
            fragments.add(f)
        }
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}
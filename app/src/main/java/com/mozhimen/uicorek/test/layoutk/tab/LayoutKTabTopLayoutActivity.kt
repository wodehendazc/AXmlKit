package com.mozhimen.uicorek.test.layoutk.tab

import android.os.Bundle
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVB
import com.mozhimen.basick.manifestk.permission.annors.APermissionCheck
import com.mozhimen.basick.manifestk.cons.CPermission
import com.mozhimen.basick.manifestk.annors.AManifestKRequire
import com.mozhimen.basick.utilk.android.widget.showToast
import com.mozhimen.basick.utilk.android.content.UtilKRes
import com.mozhimen.uicorek.layoutk.tab.commons.ITabSelectedListener
import com.mozhimen.uicorek.layoutk.tab.top.mos.MTabTop
import com.mozhimen.uicorek.test.R
import com.mozhimen.uicorek.test.databinding.ActivityLayoutkTabTopLayoutBinding

/**
 * @ClassName TabTopLayoutActivity
 * @Description TODO
 * @Author Kolin Zhao
 * @Date 2021/8/4 17:17
 * @Version 1.0
 */
@AManifestKRequire(CPermission.INTERNET)
@APermissionCheck(CPermission.INTERNET)
class LayoutKTabTopLayoutActivity : BaseActivityVB<ActivityLayoutkTabTopLayoutBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        initTabTopLayout()
    }

    private val _tabTop1 by lazy {
        MTabTop(
            "推荐",
            R.drawable.layoutk_tab_bottom_layout_fire,
            R.drawable.layoutk_tab_bottom_layout_fire,
            UtilKRes.gainColor(com.mozhimen.uicorek.R.color.cok_blue_4785ef)
        )
    }

    private val _tabTop2 by lazy {
        MTabTop(
            "推荐1",
            R.drawable.layoutk_tab_bottom_layout_fire,
            R.drawable.layoutk_tab_bottom_layout_fire,
            UtilKRes.gainColor(com.mozhimen.uicorek.R.color.cok_blue_4785ef),
            UtilKRes.gainColor(com.mozhimen.uicorek.R.color.cok_blue_287ff1)
        )
    }

    private val _tabStr = arrayListOf(
        "数码", "鞋子", "零食", "家电", "汽车", "百货", "家居", "热门", "装修", "运动"
    )

    private fun initTabTopLayout() {
        val infoList = ArrayList<MTabTop>()
        val colorDefault = UtilKRes.gainColor(com.mozhimen.uicorek.R.color.cok_blue_4785ef)
        val colorSelected = UtilKRes.gainColor(com.mozhimen.uicorek.R.color.cok_blue_287ff1)
        infoList.apply {
            add(_tabTop1)
            add(_tabTop2)
        }
        for (str in _tabStr) infoList.add(MTabTop(str, colorDefault, colorSelected))
        vb.layoutkTabTopLayout.inflateTabItem(infoList)
        vb.layoutkTabTopLayout.addTabItemSelectedListener(object : ITabSelectedListener<MTabTop> {
            override fun onTabItemSelected(index: Int, prevItem: MTabTop?, currentItem: MTabTop) {
                currentItem.name!!.showToast()
            }
        })
        vb.layoutkTabTopLayout.defaultSelected(infoList[0])
        vb.layoutkTabTopLayout.setTabTopBackground(UtilKRes.gainColor(com.mozhimen.uicorek.R.color.cok_blue_e8f3ff))
    }
}

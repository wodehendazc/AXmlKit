package com.mozhimen.xmlk.test.dialogk.temps

import android.view.ViewGroup

/**
 * @ClassName IDialogKBuilder
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Version 1.0
 */
interface IDialogKBuilder {
    var layoutId: Int

    var width: Float//单位: dp

    var height: Float//单位: dp

    var layoutParams: ViewGroup.LayoutParams

    var animStyleId: Int?

    var styleId: Int

    var cancelable: Boolean
}
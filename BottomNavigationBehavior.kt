package com.example.dell.rubixk1

import android.os.Parcel
import android.os.Parcelable
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.view.View

//
//CoordinatorLayout.Behavior<BottomNavigationBehavior>()
// CoordinatorLayout.Behavior<BottomNavigationView>()


class BottomNavigationBehavior() : CoordinatorLayout.Behavior<BottomNavigationView>(), Parcelable {
    private var height: Int = 0

    constructor(parcel: Parcel) : this() {
        height = parcel.readInt()
    }

    override fun onLayoutChild(parent: CoordinatorLayout, child: BottomNavigationView, layoutDirection: Int): Boolean {
        height = child!!.height
        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout,
                                     child: BottomNavigationView, directTargetChild: View, target: View,
                                     axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: BottomNavigationView,
                                target: View, dxConsumed: Int, dyConsumed: Int,
                                dxUnconsumed: Int, dyUnconsumed: Int,
                                @ViewCompat.NestedScrollType type: Int) {
        if (dyConsumed > 0) {
            slideDown(child)
        } else if (dyConsumed < 0) {
            slideUp(child)
        }
    }

    private fun slideUp(child: BottomNavigationView) {
        child.clearAnimation()
        child.animate().translationY(0f)
    }

    private fun slideDown(child: BottomNavigationView) {
        child.clearAnimation()
        child.animate().translationY(height.toFloat())
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BottomNavigationBehavior> {
        override fun createFromParcel(parcel: Parcel): BottomNavigationBehavior {
            return BottomNavigationBehavior(parcel)
        }

        override fun newArray(size: Int): Array<BottomNavigationBehavior?> {
            return arrayOfNulls(size)
        }
    }
}
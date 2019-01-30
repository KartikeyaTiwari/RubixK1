package com.example.dell.rubixk1

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val layoutParams = navigation.getLayoutParams() as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationBehavior()

       switchContent(baseContext)
        navigation.setOnNavigationItemReselectedListener(mOnNavigationItemSelectedListener)
//
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //switchContent(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_trainerkit -> {
               // switchContent(trainerKitFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_study -> {
               // switchContent(studyFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
               // switchContent(profileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun switchContent(fragment: Context) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}

private fun BottomNavigationView.setOnNavigationItemReselectedListener(mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener) {

}

private fun FragmentTransaction.replace(frame: Int, fragment: Context) {

}

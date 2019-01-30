package com.example.dell.rubixk1

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.support.annotation.RequiresApi
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.example.dell.rubixk1.R.*
import com.example.dell.rubixk1.R.drawable.*
import kotlinx.android.synthetic.main.list_group.*
import kotlinx.android.synthetic.main.list_group.view.*
import kotlinx.android.synthetic.main.list_item.*

import java.util.ArrayList
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    // new change
    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null
    private var myFont: Typeface? = null



    val data: HashMap<String, List<String>>
        @SuppressLint("ResourceType")
        get() {
            val listData = HashMap<String, List<String>>()
         //  java.util.Collections.sort(listData["A-Z"])641  895


            val redmiMobiles = ArrayList<String>()

            redmiMobiles.add(getString(string.c1))
            redmiMobiles.add("2.Put the GREEN centre piece in front (facing you) ")
            redmiMobiles.add("3.Find the GREEN/ WHITE edge piece (it only has 2 colours) and \n"+
                    "turn it to one of the positions shown below (keeping white on top and green in front)")
            redmiMobiles.add("4.Choose the options below that matches your situation and follow the arrow steps\n " +
                    "to place the GREEN/ WHITE edge piece in place.")

            redmiMobiles.add("Redmi 5 Plus")
            redmiMobiles.add("Redmi Y1")
            redmiMobiles.add("Redmi 3S Plus")




            val redmiMobilesimage = ArrayList<Image>()

            redmiMobiles.add(getDrawable(step1))






            val micromax = ArrayList<String>()
           // micromax.add(R.string.r2.toString())
            micromax.add("Micromax Bharat 5 Pro")
            micromax.add("Micromax Bharat 5")
            micromax.add("Micromax Canvas 1")
            micromax.add("Micromax Dual 5")

            val appleMobiles = ArrayList<String>()
            appleMobiles.add("iPhone 8")
            appleMobiles.add("iPhone 8 Plus")
            appleMobiles.add("iPhone X")
            appleMobiles.add("iPhone 7 Plus")
            appleMobiles.add("iPhone 7")
            appleMobiles.add("iPhone 6 Plus")

            val samsungMobiles = ArrayList<String>()
            samsungMobiles.add("Samsung Galaxy S9+")
            samsungMobiles.add("Samsung Galaxy Note 7")
            samsungMobiles.add("Samsung Galaxy Note 5 Dual")
            samsungMobiles.add("Samsung Galaxy S8")
            samsungMobiles.add("Samsung Galaxy A8")
            samsungMobiles.add("Samsung Galaxy Note 4")

           // listData[(R.string.r1.toString()).toString()] = redmiMobiles


            listData[getString(string.r1)]= redmiMobiles
           // listData[expandedListItem.imageView.setImageDrawable(R.drawable.step1)]=redmiMobilesimage
            listData[getString(string.r2)] = micromax
            listData[getString(string.r3)] = appleMobiles
            listData[getString(string.r4)] = samsungMobiles
            listData[getString(string.r5)] = samsungMobiles
            listData[getString(string.r6)] = samsungMobiles
            listData[getString(string.r7)] = samsungMobiles
          /*  listData[getString(R.string.r8)] = samsungMobiles
            listData[getString(R.string.r9)] = samsungMobiles
           listData[getString(R.string.r10)] = redmiMobiles
            listData[getString(R.string.r11)] =micromax
            listData[getString(R.string.r12)] = appleMobiles
            listData[getString(R.string.r13)] = samsungMobiles
*/







            listData.toSortedMap()
            return listData
        }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        expandableListView = findViewById(id.expandableListView)
        if (expandableListView != null) {
            val listData = data
           titleList = ArrayList(listData.keys.sorted())

            //titleList = ArrayList(listData.keys)
           // myFont =  resources.getFont(R.font.cac_champagne)
          //  myFont = ResourcesCompat.getFont(baseContext, R.font.cac_champagne)


            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)

            expandableListView!!.setOnGroupExpandListener { childPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[childPosition] + " List Expanded.", Toast.LENGTH_SHORT).show() }

            expandableListView!!.setOnGroupCollapseListener { childPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[childPosition] + " List Collapsed.", Toast.LENGTH_SHORT).show() }

            expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
             //   Toast.makeText(applicationContext, "Clicked: " + (titleList as ArrayList<String>)[childPosition] + " -> " + listData[(titleList as ArrayList<String>)[childPosition]]!!.get(groupPosition), Toast.LENGTH_SHORT).show()
                false
            }
        }
    }
}
//
private fun <E> ArrayList<E>.add(element: Drawable?) {

    val array_image = ArrayList<Int>()
    array_image.add(abc_ab_share_pack_mtrl_alpha);

}

private fun <E> MutableSet<E>.sorted(listData: HashMap<E, List<E>>): List<E> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

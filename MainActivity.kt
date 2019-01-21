package com.example.dell.rubixk1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast

import java.util.ArrayList
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null

    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()
         //  java.util.Collections.sort(listData["A-Z"])


            val redmiMobiles = ArrayList<String>()

            redmiMobiles.add("redmi")
            redmiMobiles.add("Redmi S2")
            redmiMobiles.add("Redmi Note 5 Pro")
            redmiMobiles.add("arrow_forward Create and deploy autoscaling Kotlin backends for your mobile apps\n" +
                    "arrow_forward Write Kotlin using your favorite Java frameworks and libraries\n" +
                    "arrow_forward Use fully-managed MySQL/PostgreSQL or Firebase for your application database\n" +
                    "arrow_forward Run Kotlin in a containerized application at scale on Google Kubernetes Engine\n" +
                    "arrow_forward Use IntelliJ with Google Cloud Tools Plugins to add Google Cloud API libraries and deploy to App Engine.")
            redmiMobiles.add("Redmi 5 Plus")
            redmiMobiles.add("Redmi Y1")
            redmiMobiles.add("Redmi 3S Plus")


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


            listData[getString(R.string.r1)]= redmiMobiles
            listData[getString(R.string.r2)] = micromax
            listData[getString(R.string.r3)] = appleMobiles
            listData[getString(R.string.r4)] = samsungMobiles
            listData[getString(R.string.r5)] = samsungMobiles
            listData[getString(R.string.r6)] = samsungMobiles
            listData[getString(R.string.r7)] = samsungMobiles
            listData[getString(R.string.r8)] = samsungMobiles
            listData[getString(R.string.r9)] = samsungMobiles
           listData[getString(R.string.r10)] = redmiMobiles
            listData[getString(R.string.r11)] =micromax
            listData[getString(R.string.r12)] = appleMobiles
            listData[getString(R.string.r13)] = samsungMobiles








            listData.toSortedMap()
            return listData
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expandableListView = findViewById(R.id.expandableListView)
        if (expandableListView != null) {
            val listData = data
           titleList = ArrayList(listData.keys.sorted())
            //titleList = ArrayList(listData.keys)
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

private fun <E> MutableSet<E>.sorted(listData: HashMap<E, List<E>>): List<E> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

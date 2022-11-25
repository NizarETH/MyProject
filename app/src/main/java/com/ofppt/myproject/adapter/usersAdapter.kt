package com.ofppt.myproject.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ofppt.myproject.R
import com.ofppt.myproject.beans.User
import com.ofppt.myproject.ui.MainActivity
import com.ofppt.myproject.ui.MapFragment

class usersAdapter(val users : MutableList<User>, val context : Context) : BaseAdapter() {


    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(p0: Int): Any {
        return users.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return users.get(p0).id.toLong()

    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, viewGroup, false)
        }

        val user = getItem(position) as User

        val username = convertView?.findViewById(R.id.username) as TextView
        val name = convertView!!.findViewById(R.id.name) as TextView
        val phone = convertView!!.findViewById(R.id.company_name) as TextView
        val image = convertView!!.findViewById(R.id.item_list_avatar) as ImageView


        username.text = user.username
        name.text = user.name
        phone.text = user.phone

        convertView.setOnClickListener(View.OnClickListener {

            val transaction =  ( context as MainActivity).
            supportFragmentManager.beginTransaction()
            val b = Bundle()
            val fragm =  MapFragment()
            b.putString("name", user.name)
            b.putDouble("lat",user.lat)
            b.putDouble("lng",user.lng)
            fragm .arguments = b
            fragm.show(transaction,"MapFragment")
        })
        return convertView
    }
}
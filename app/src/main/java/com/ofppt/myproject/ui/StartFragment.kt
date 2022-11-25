package com.ofppt.myproject.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnDragListener
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ofppt.myproject.R


class StartFragment : Fragment() {

    var v : View? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // throw RuntimeException("Crash object") // Force a crash


        v = inflater.inflate(R.layout.start, container, false)

        v?.findViewById<Button>(R.id.start)
            ?.setOnClickListener {

                activity?.  supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frameLayout, ListFragment())?.commit()
            }



        return  v
    }


}
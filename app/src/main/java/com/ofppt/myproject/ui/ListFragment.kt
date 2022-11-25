package com.ofppt.myproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ofppt.myproject.R
import com.ofppt.myproject.adapter.usersAdapter
import com.ofppt.myproject.api.ApiClient
import com.ofppt.myproject.beans.User
import com.ofppt.myproject.repository.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private val apiClient = ApiClient()
    private var v : View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.list_users, container, false)

        executeCall()
        return v
    }

    private fun executeCall()
    {
        val repo = UserRepository(requireActivity())
        val listUsers = repo.getAllUsers() as MutableList<User>

        if(!listUsers.isEmpty())
        {
            val listView = v!!.findViewById<ListView>(R.id.listview) as ListView

            listView.adapter = usersAdapter(listUsers, requireActivity())
        }
        else
        {
            GlobalScope.launch {
                val response = apiClient.apiService.getUsers()
                if (response.isSuccessful && response.body() != null) {
                    val content = response.body()
                    //do something

                    val list  = content as MutableList<User>

                    repo.insertAllUserS(list)

                    val listView = v!!.findViewById<ListView>(R.id.listview) as ListView

                    activity?.runOnUiThread({
                        listView.adapter = usersAdapter(listUsers, requireActivity())

                    })

                }

            }

        }



    }
}
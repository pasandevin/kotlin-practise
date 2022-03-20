package com.pasandevin.android.seng22243

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.pasandevin.android.seng22243.api.UserAPIService
import com.pasandevin.android.seng22243.databinding.FragmentFirstBinding
import com.pasandevin.android.seng22243.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val userAPIService = UserAPIService.create()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val editableid = binding.textId.text
            val id = editableid.toString()
            val user = userAPIService.getUser(id)
            user.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val body = response.body()
                    body?.let {
//                        Log.i("FirstFragment Email: ", it.email )

//                        val id = searchView.getQuery()
                        binding.textviewId.text = "ID : " + id
                        binding.textviewUsername.text = "User Name : " + it.username
                        binding.textviewName.text = "Name : " + it.name
                        binding.textviewEmail.text = "Email  : " + it.email
                        binding.textviewTelephone.text = "Phone : " + it.phone
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
//            binding.buttonFirst.setOnClickListener {
//                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//            }

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
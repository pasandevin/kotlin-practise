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
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasandevin.android.seng22243.adapter.PhotoAdapter
import com.pasandevin.android.seng22243.api.UserAPIService
import com.pasandevin.android.seng22243.databinding.FragmentFirstBinding
import com.pasandevin.android.seng22243.model.Photo
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

        // RecyclerView //
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
        val photos = userAPIService.getPhotos()
        Log.i("beforeenqueing", "before enqueing")
        photos.enqueue(object:Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photosBody = response.body()
                val adapter = PhotoAdapter(photosBody!!)
                binding.recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        // RecyclerView //





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
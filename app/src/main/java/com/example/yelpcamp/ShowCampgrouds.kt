package com.example.yelpcamp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yelpcamp.helpers.CampsAdapter
import com.example.yelpcamp.models.model
import com.example.yelpcamp.services.ServiceBulider
import com.example.yelpcamp.services.WebServices
import kotlinx.android.synthetic.main.activity_show_campgrounds.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowCampgrouds : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_campgrounds)

    }

    override fun onResume() {
        super.onResume()
        loadCampgroundList()
    }

    private fun loadCampgroundList() {
        val webServices=ServiceBulider.buildService(WebServices::class.java)
        val requestService = webServices.getCampgroungList()

        requestService.enqueue(object : Callback<List<model>>{
            override fun onFailure(call: Call<List<model>>, t: Throwable) {
                Log.v("camps",t.toString())
                Toast.makeText(this@ShowCampgrouds, t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<model>>, response: Response<List<model>>) {
                if (response.isSuccessful){
                    val campgroundList=response.body()!!
//                    recycler_view.adapter = CampsAdapter(campgroundList)
                    recycler_view.apply {
                        layoutManager= LinearLayoutManager(this@ShowCampgrouds)
                        adapter = CampsAdapter(campgroundList)
                    }
//                    for(i in campgroundList) {
//                    Toast.makeText(this@ShowCampgrouds, i.toString(), Toast.LENGTH_SHORT).show()
////                        Log.v("tagc", i.city+' '+i.country)
//                    }

                }
            }

        })
    }

    fun addCampground(){

    }
}
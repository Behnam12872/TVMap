package ir.entekhab.motaharzamir.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.entekhab.motaharzamir.adapter.LocationListAdapter
import ir.entekhab.motaharzamir.databinding.ActivityShowMapBinding
import ir.entekhab.motaharzamir.room.LocationDao

class ShowMapActivity : AppCompatActivity() {
    lateinit var adapter: LocationListAdapter
    lateinit var locationDao: LocationDao
    lateinit var binding: ActivityShowMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun showAllData() {
            val locationData = locationDao.getAllLocations()
            binding!!.rvLocation.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            adapter = LocationListAdapter(ArrayList(locationData), this)
            binding!!.rvLocation.adapter = adapter

        }

//        val locationList = arrayListOf(
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1"),
//            Location("دفتر فنی و مهندسی", "ضلع شمالی کیا صنعت", "1")
//
//
//        )
//        val myAdapter = LocationListAdapter(locationList,this)
//
//        binding.rvLocation.adapter = myAdapter
//        binding.rvLocation.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}
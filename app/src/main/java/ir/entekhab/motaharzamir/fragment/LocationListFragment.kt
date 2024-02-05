package ir.entekhab.motaharzamir.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.entekhab.motaharzamir.adapter.LocationListAdapter
import ir.entekhab.motaharzamir.databinding.FragmentLocationListBinding
import ir.entekhab.motaharzamir.room.LocationDao
import ir.entekhab.motaharzamir.room.MyDatabase

class LocationListFragment : Fragment() {
    private var binding: FragmentLocationListBinding? = null
    lateinit var adapter: LocationListAdapter
    lateinit var locationDao: LocationDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        locationDao = MyDatabase.getDatabase(requireActivity()).locationDao
        showAllData()

//        binding!!.txtSearch.addTextChangedListener { editTextInput ->
//            if (editTextInput!!.isNotEmpty()) {
//
//                val cloneList = locationList.clone() as ArrayList<Location>
//                val filteredList = cloneList.filter { locationItem ->
//                    locationItem.txtLocation.contains(editTextInput)
//
//                }
//                adapter.setData(ArrayList(filteredList))
//
//            } else {
//
//                adapter.setData(locationList.clone() as ArrayList<Location> /* = java.util.ArrayList<ir.entekhab.motaharzamir.room.Location> */)
//            }
//
//
//        }
        return binding?.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


    }

    private fun showAllData() {
        val locationData = locationDao.getAllLocations()
        binding = FragmentLocationListBinding.inflate(layoutInflater)
        binding!!.rvLocation.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        adapter = LocationListAdapter(ArrayList(locationData), requireActivity())
        binding!!.rvLocation.adapter = adapter

    }
}


//    val locationList = arrayListOf(
//        Location("دفتر مدیر پلنت", "در محدوده ضلع شرقی شرکت کیا صنعت", 382, 277, 0, 20f, 5000),
//        Location("مدیریت تولید", "در محدوده ضلع شمالی شرکت مطهر ضمیر", 563, 364, 0, 20f, 5000),
//        Location("رئیس تولید", "در محدوده ضلع شمالی شرکت مطهر ضمیر", 589, 363, 0, 20f, 5000),
//        Location("آزمایشگاه کیفیت", "در محدوده ضلع شمالی شرکت مطهر ضمیر", 563, 343, 0, 20f, 5000),
//        Location("کلین روم", "در محدوده ضلع شمالی شرکت مطهر ضمیر", 589, 347, 0, 20f, 5000),
//        Location("کمد و رختکن", "در محدوده ضلع شمالی شرکت مطهر ضمیر", 584, 378, 0, 20f, 5000),
//        Location("اتاق تکمه چین", "در محدوده ضلع شمالی شرکت مطهر ضمیر", 565, 353, 0, 20f, 5000),
//        Location("شو روم", "در محدوده ضلع شمالی شرکت مطهر ضمیر", 605, 325, 0, 20f, 5000),
//        Location("سالن تولید تلویزیون", "", 602, 240, 0, 6f, 5000),
//        Location("خط یک", "", 613, 237, 0, 8f, 5000),
//        Location("خط دو", "", 569, 237, 0, 8f, 5000),
//        Location("سالن برد", "", 662, 240, 0, 8f, 5000),
//        Location("جمعداری برد", "", 678, 278, 0, 20f, 5000),
//        Location("سالن فیکسچر", "", 678, 198, 0, 20f, 5000),
//        Location("آزمایشگاه برد", "", 678, 278, 0, 20f, 5000),
//        Location("اداری برد", "", 678, 293, 0, 20f, 5000),
//        Location("رختکن برادران", "", 678, 308, 0, 20f, 5000),
//        Location("رختکن خواهران", "", 678, 168, 0, 20f, 5000),
//        Location("سالن تولید پنل", "", 712, 263, 0, 9f, 5000),
//        Location("اتاق ایزوله", "", 702, 197, 0, 20f, 5000),
//        Location("انبارک پنل", "", 716, 173, 0, 20f, 5000),
//        Location("رختکن پنل", "", 702, 175, 0, 20f, 5000),
//        Location("کفشداری", "", 702, 159, 0, 20f, 5000),
//        Location("انتظامات", "", 366, 427, 0, 20f, 5000),
//        Location("دفتر کارگزینی", "", 353, 417, 0, 20f, 5000),
//        Location("چاپ بارکد", "", 336, 417, 0, 20f, 5000),
//        Location("دفتر کیفیت", "", 320, 417, 0, 20f, 5000),
//        Location("ایمنی", "", 330, 417, 0, 20f, 5000),
//        Location("دفتر فنی مهندسی", "", 291, 408, 0, 20f, 5000),
//        Location("آشپزخانه", "", 272, 408, 0, 20f, 5000),
//        Location("انبار آشپزخانه", "", 279, 400, 0, 6f, 5000),
//        Location("کارگاه نت", "", 406, 279, 0, 8f, 5000),
//        Location("رختکن نت", "", 258, 420, 0, 8f, 5000),
//        Location("دفتر نت", "", 245, 416, 0, 8f, 5000),
//        Location("مدیریت نت", "", 234, 419, 0, 20f, 5000),
//        Location("کارگاه برق", "", 246, 401, 0, 20f, 5000),
//        Location("دفتر کیفی", "", 224, 418, 0, 20f, 5000),
//        Location("مدیریت کیفی", "", 226, 403, 0, 20f, 5000),
//        Location("انبار نت", "", 209, 410, 0, 20f, 5000),
//        Location("پست برق", "", 161, 414, 0, 20f, 5000),
//        Location("انبار محصول مرجوعی", "", 162, 365, 0, 9f, 5000),
//        Location("انبار ضایعات", "", 163, 313, 0, 20f, 5000),
//        Location("انبارک ضایعات", "", 215, 290, 0, 20f, 5000),
//        Location("انبار بازبینی محصول", "", 168, 273, 0, 20f, 5000),
//        Location("پارکینگ لیفتراک", "", 219, 250, 0, 20f, 5000),
//        Location("سالن محصول بازبینی", "", 174, 220, 0, 20f, 5000),
//        Location("سالن تولید تلویزیون", "", 198, 178, 0, 20f, 5000),
//        Location("آزمایشگاه کنترل کیفیت", "", 149, 145, 0, 20f, 5000),
//        Location("سالن تست برد", "", 185, 146, 0, 20f, 5000),
//        Location("کارگاه خلاقیت", "", 295, 178, 0, 20f, 5000),
//        Location("غذاخوری", "", 285, 220, 0, 20f, 5000),
//        Location("کمپرسور باد", "", 246, 215, 0, 20f, 5000),
//        Location("انبار محصول", "", 279, 242, 0, 20f, 5000),
//        Location("نمازخانه", "", 325, 240, 0, 20f, 5000),
//        Location("انبار خدمات", "", 327, 214, 0, 20f, 5000),
//        Location("انبار قطعات", "", 358, 209, 0, 8f, 5000),
//        Location("ساختمان تحقیق و توسعه", "", 68, 384, 0, 20f, 5000),
//        Location("مدیریت تحقیق و توسعه", "", 71, 363, 0, 20f, 5000),
//        Location("دفتر تخحقیق و توسعه", "", 69, 406, 0, 20f, 5000),
//        Location("آزمایشگاه تحقیق و توسعه", "", 69, 382, 0, 20f, 5000),
//        Location("انبارک تحقیق و توسعه", "", 63, 363, 0, 20f, 5000),
//        Location("سرویس بهداشتی", "", 382, 316, 0, 20f, 5000),
//        Location("فضای سبز", "", 265, 350, 0, 6f, 5000),
//        Location("انبار فوم", "", 482, 413, 0, 20f, 5000),
//        Location("انبار قطعات", "", 494, 319, 0, 7f, 5000),
//        Location("انبار قطعات برد", "", 427, 198, 0, 20f, 5000),
//        Location("انبار ملزومات", "", 463, 192, 0, 20f, 5000),
//        Location("سالن جمعداری", "", 501, 207, 0, 20f, 5000),
//        Location("آماده سازی", "", 467, 152, 0, 20f, 5000),
//        Location("سالن لیزر", "", 528, 203, 0, 20f, 5000),
//        Location("دفتر برنامه ریزی", "", 460, 229, 0, 20f, 5000),
//        Location("دفتر انبار", "", 442, 203, 0, 20f, 5000),
//        Location("دفتر کیفیت", "", 412, 236, 0, 20f, 5000),
//        Location("دفتر توسعه و بهره وری", "", 412, 245, 0, 20f, 5000),
//        Location("پارک", "", 406, 330, 0, 9f, 5000),
//        Location("طبقه اول انبار ملزومات", "", 90, 278, 0, 20f, 5000),
//        Location("طبقه اول انبار قطعات برد", "", 56, 278, 0, 9f, 5000)
//    )

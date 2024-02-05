package ir.entekhab.motaharzamir.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.pspdfkit.configuration.PdfConfiguration
import com.pspdfkit.configuration.page.PageScrollDirection
import com.pspdfkit.ui.PdfFragment
import ir.entekhab.motaharzamir.R
import ir.entekhab.motaharzamir.room.Location

class LocationListAdapter(val data: ArrayList<Location>, val context: Context) :
    RecyclerView.Adapter<LocationListAdapter.LocationViewHolder>() {

    inner class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtId = itemView.findViewById<TextView>(R.id.lblID)
        val txtLocation = itemView.findViewById<TextView>(R.id.lblLocation)
        val txtInfo = itemView.findViewById<TextView>(R.id.lblInfo)



        fun bindData(position: Int) {
            txtLocation.text = data[position].txtLocation
            txtInfo.text = data[position].txtInfo
            //txtId.text = data[position].txtId


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_location_info, parent, false)
        return LocationViewHolder(view)

    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bindData(position)
        val focusX = data[position].focusX
        val focusY = data[position].focusY
        val pageIndex = data[position].pageIndex
        val targetScale =data[position].targetScale
        val duration = data[position].duration
        val uri = Uri.parse("file:///android_asset/map.pdf")
        val configuration = PdfConfiguration.Builder()
            .scrollDirection(PageScrollDirection.HORIZONTAL).build()
        val fragment = PdfFragment.newInstance(uri, configuration)
        holder.itemView.setOnClickListener {
            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .addToBackStack(null).replace(R.id.map_fragment, fragment).commit()
            fragment.zoomTo(focusX, focusY, pageIndex, targetScale, duration)


        }
    }

    override fun getItemCount(): Int {
        return data.size

    }

    fun setData(newList: ArrayList<Location>) {
        data.clear()
        data.addAll(newList)
        notifyDataSetChanged()
    }


}

package ir.entekhab.motaharzamir.adapter
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pspdfkit.configuration.PdfConfiguration
import com.pspdfkit.configuration.page.PageScrollDirection
import ir.entekhab.motaharzamir.R

class ItemAdaptor(private var mList: ArrayList<String>, context: Context) :
    RecyclerView.Adapter<ItemAdaptor.ViewHolder>() {
    private var mcontext: Context? = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.item.text = item
        val uri = Uri.parse("file:///android_asset/map.pdf")
        val configuration = PdfConfiguration.Builder()
            .scrollDirection(PageScrollDirection.HORIZONTAL).build()
        holder.item.setOnClickListener {


        }
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val item: TextView = ItemView.findViewById(R.id.rvItem)
    }
}







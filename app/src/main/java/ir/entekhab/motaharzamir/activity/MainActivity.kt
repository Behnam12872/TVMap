package ir.entekhab.motaharzamir.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.pspdfkit.configuration.PdfConfiguration
import com.pspdfkit.configuration.page.PageScrollDirection
import com.pspdfkit.ui.PdfFragment
import ir.entekhab.motaharzamir.dialog.BottomSheet
import ir.entekhab.motaharzamir.adapter.ItemAdaptor
import ir.entekhab.motaharzamir.R

class MainActivity : AppCompatActivity() {

    private lateinit var dialog: BottomSheetDialog
    private lateinit var itemAdaptor: ItemAdaptor
    private lateinit var search: TextView
    private lateinit var guid: TextView
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search = findViewById(R.id.search)
        guid=findViewById(R.id.guid)
        val uri = Uri.parse("file:///android_asset/map.pdf")
        val guidUri = Uri.parse("file:///android_asset/guid.pdf")

        val configuration = PdfConfiguration.Builder()
            .scrollDirection(PageScrollDirection.HORIZONTAL).build()
        val fragment = PdfFragment.newInstance(uri, configuration)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            .commit()
        val order = BottomSheet(true)
        order.getbool()

        search.setOnClickListener {
            val intent = Intent(this@MainActivity, ShowMapActivity()::class.java)
            startActivity(intent)
            finish()
        }
        guid.setOnClickListener {
            val configuration1 = PdfConfiguration.Builder()
                .scrollDirection(PageScrollDirection.HORIZONTAL).build()
            val fragment1 = PdfFragment.newInstance(guidUri, configuration)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, fragment1)
                .commit()
        }
    }
    private fun showBottomSheet(list: ArrayList<String>) {
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet, null)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        recyclerView = dialogView.findViewById(R.id.rvselect)
        itemAdaptor = ItemAdaptor(list, this)
        recyclerView.adapter = itemAdaptor
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                layoutManager.orientation

            )
        )
        dialog.show()
    }
}

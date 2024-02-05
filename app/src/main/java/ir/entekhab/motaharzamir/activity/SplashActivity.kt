package ir.entekhab.motaharzamir.activity

//import dagger.hilt.android.AndroidEntryPoint
//import ir.entekhab.group.matris.G
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowInsets
import android.view.WindowMetrics
import androidx.appcompat.app.AppCompatActivity
import ir.entekhab.motaharzamir.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val tag = SplashActivity::class.java.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivitySplashBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.root.viewTreeObserver.addOnGlobalLayoutListener {
                val displayMetrics = DisplayMetrics()
                val height: Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
                    val insets: android.graphics.Insets =
                        windowMetrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
                    windowMetrics.bounds.height() - insets.top - insets.bottom
                } else {
                    windowManager.defaultDisplay.getMetrics(displayMetrics)
                    displayMetrics.heightPixels
                }
                binding.lyLogo.animate().translationY(((height / 2)).toFloat() * -1)
                    .alpha(1F).duration = 2000
//                binding.lblAppName.animate().translationY(((height / 2)).toFloat() * -1)
//                    .alpha(1F).duration = 1000
                binding.lyLogo.animate().withEndAction {
                    val intent = Intent(this@SplashActivity, MainActivity()::class.java)
                    startActivity(intent)
                    finish()
                    /* if (G.getAccount() == null)
                     {
                         val intent = Intent(this@SplashActivity, MainActivity()::class.java)
                         startActivity(intent)
                         finish()
                     }
                     else
                     {
                         val intent = Intent(this@SplashActivity, MainActivity()::class.java)
                         startActivity(intent)
                         finish()
                     }*/

                }.startDelay = 0
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(tag, "onCreate: " + e.message, e.cause)
        }
    }
}
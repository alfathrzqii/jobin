package dev.alfathrzqii.jobin

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.accessibility.AccessibilityManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvDescription: TextView
    private lateinit var btnAction: Button
    private lateinit var tvHideIconDesc: TextView
    private lateinit var btnHideIcon: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDescription = findViewById(R.id.tvDescription)
        btnAction = findViewById(R.id.btnAction)
        tvHideIconDesc = findViewById(R.id.tvHideIconDesc)
        btnHideIcon = findViewById(R.id.btnHideIcon)

        btnAction.setOnClickListener {
            if (!isAccessibilityServiceEnabled()) {
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                startActivity(intent)
            }
        }

        btnHideIcon.setOnClickListener {
            hideAppIcon()
        }
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun updateUI() {
        if (isAccessibilityServiceEnabled()) {
            tvDescription.text = getString(R.string.setup_desc_granted)
            btnAction.visibility = View.GONE
            tvHideIconDesc.visibility = View.VISIBLE
            btnHideIcon.visibility = View.VISIBLE
        } else {
            tvDescription.text = getString(R.string.setup_desc_not_granted)
            btnAction.visibility = View.VISIBLE
            tvHideIconDesc.visibility = View.GONE
            btnHideIcon.visibility = View.GONE
        }
    }

    private fun isAccessibilityServiceEnabled(): Boolean {
        val am = getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        val enabledServices = am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC)
        for (service in enabledServices) {
            val serviceInfo = service.resolveInfo.serviceInfo
            if (serviceInfo.packageName == packageName && serviceInfo.name == PowerMenuService::class.java.name) {
                return true
            }
        }
        return false
    }

    private fun hideAppIcon() {
        val componentName = ComponentName(this, MainActivity::class.java)
        packageManager.setComponentEnabledSetting(
            componentName,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        Toast.makeText(this, R.string.icon_hidden_toast, Toast.LENGTH_LONG).show()
        finish()
    }
}

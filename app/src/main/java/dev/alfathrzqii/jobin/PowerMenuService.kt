package dev.alfathrzqii.jobin

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import java.lang.ref.WeakReference

class PowerMenuService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = WeakReference(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == ACTION_OPEN_POWER_MENU) {
            performGlobalAction(GLOBAL_ACTION_POWER_DIALOG)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Not used, but required to override
    }

    override fun onInterrupt() {
        // Not used, but required to override
    }

    override fun onDestroy() {
        super.onDestroy()
        if (instance?.get() == this) {
            instance = null
        }
    }

    companion object {
        const val ACTION_OPEN_POWER_MENU = "dev.alfathrzqii.jobin.ACTION_OPEN_POWER_MENU"
        var instance: WeakReference<PowerMenuService>? = null
            private set

        fun showPowerMenu(): Boolean {
            val service = instance?.get()
            return service?.performGlobalAction(GLOBAL_ACTION_POWER_DIALOG) ?: false
        }
    }
}

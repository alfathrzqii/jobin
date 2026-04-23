package dev.alfathrzqii.jobin

import android.content.Intent
import android.service.quicksettings.TileService
import android.widget.Toast
import android.app.PendingIntent
import android.os.Build

class PowerMenuTileService : TileService() {
    override fun onClick() {
        super.onClick()

        // Attempt to show power menu using the accessibility service instance
        val success = PowerMenuService.showPowerMenu()

        if (!success) {
            // If the instance is null or performGlobalAction failed, try starting the service with an intent
            val intent = Intent(this, PowerMenuService::class.java).apply {
                action = PowerMenuService.ACTION_OPEN_POWER_MENU
            }
            try {
                startService(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Accessibility Service is not enabled.", Toast.LENGTH_SHORT).show()
                // Open app to guide user
                val launchIntent = Intent(this, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    val pendingIntent = PendingIntent.getActivity(
                        this,
                        0,
                        launchIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                    )
                    startActivityAndCollapse(pendingIntent)
                } else {
                    @Suppress("DEPRECATION")
                    startActivityAndCollapse(launchIntent)
                }
            }
        }
    }
}

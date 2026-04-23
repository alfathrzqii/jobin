package dev.alfathrzqii.jobin

import android.content.Context
import android.media.AudioManager
import android.service.quicksettings.TileService

class VolumeUpTileService : TileService() {
    override fun onClick() {
        super.onClick()
        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.adjustStreamVolume(
            AudioManager.STREAM_MUSIC,
            AudioManager.ADJUST_RAISE,
            AudioManager.FLAG_SHOW_UI
        )
    }
}

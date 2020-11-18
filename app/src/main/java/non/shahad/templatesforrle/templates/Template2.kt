package non.shahad.templatesforrle.templates

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.google.android.exoplayer2.*
import non.shahad.buttons.OnPlayPauseListener
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.databinding.ActivityTemplate2Binding
import timber.log.Timber


class Template2 : BaseActivity<ActivityTemplate2Binding>(),Player.EventListener {

    override val layoutRes: Int
        get() = R.layout.activity_template2

    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareAudio()

        player.addListener(this)
        viewBinding.playButton.setOnPlayPauseListener(object: OnPlayPauseListener{
            override fun onPlayPause(isPlaying: Boolean) {
                if (isPlaying){
                    player.play()
                }else{
                    player.pause()
                }
            }
        })

    }

    private fun prepareAudio(){
        player = SimpleExoPlayer.Builder(this).build()
        val mediaItem = MediaItem.fromUri(Uri.parse("https://www.bensound.com/bensound-music/bensound-ukulele.mp3"))
        player.setMediaItem(mediaItem)
        player.prepare()
    }

    override fun onPlayerError(error: ExoPlaybackException) {
        super.onPlayerError(error)
        Timber.e(error)
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
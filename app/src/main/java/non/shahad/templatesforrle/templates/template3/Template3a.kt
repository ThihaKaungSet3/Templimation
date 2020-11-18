package non.shahad.templatesforrle.templates.template3

import android.os.Bundle
import com.github.squti.androidwaverecorder.WaveRecorder
import non.shahad.buttons.recorder.RecordListener
import non.shahad.templatesforrle.R
import non.shahad.templatesforrle.common.base.BaseActivity
import non.shahad.templatesforrle.databinding.ActivityTemplate3aBinding
import timber.log.Timber

class Template3a : BaseActivity<ActivityTemplate3aBinding>() {

    private val waveRecorder = WaveRecorder("${externalCacheDir?.absolutePath}/audioFile.wav")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("$externalCacheDir")

        viewBinding.recorderButton.setOnRecordListener(object: RecordListener{
            override fun onStartRecording() {
                try {
                    waveRecorder.startRecording()
                }catch (e: Throwable){
                    Timber.e(e)
                }

                Timber.d("Start Recording")
            }

            override fun onStopRecording() {
                waveRecorder.stopRecording()
            }

        })
    }

    override val layoutRes: Int
        get() = R.layout.activity_template3a
}
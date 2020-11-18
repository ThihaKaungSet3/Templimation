package non.shahad.buttons.recorder.utils

import android.content.Context
import android.media.MediaRecorder
import android.util.Log
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MediaRecorderUtil(
        private val context: Context
) {

    private val TAG = "MediaRecorderUtil"

    private val recorder by lazy { MediaRecorder() }

    private val audioFile by lazy { recordedFile() }

    init {
        try {
            recorder.apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                setAudioEncodingBitRate(16)
                setAudioSamplingRate(44100)
                setOutputFile(audioFile.absolutePath)
            }.prepare()
        }catch (e: Throwable){
            Log.d(TAG, ": ${e.message} ")
        }
    }

    private fun recordedFile(): File {
        val timeStamp = SimpleDateFormat("yyyy-MM-dd:HH-mm-ss",Locale.ENGLISH).format(Date())
        val fileName = "Audio_$timeStamp"
        val storageDir = context.getExternalFilesDir(null)

        
        return File.createTempFile(fileName,".3gp",storageDir)
    }

    fun record(){
        recorder.start()
    }

    fun stop(): String {
        recorder.stop()
        recorder.release()
        return getRecordedFilePath()
    }

    private fun getRecordedFilePath() = audioFile.absolutePath

}
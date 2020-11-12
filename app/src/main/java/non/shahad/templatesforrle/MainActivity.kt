package non.shahad.templatesforrle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import non.shahad.templatesforrle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
        createRecyclerView()
    }

    private fun createRecyclerView(){
        viewBinding.recyclerView.apply {
            adapter = MainRecyclerViewAdapter(dump(),::onItemClick)
        }
    }

    private fun onItemClick(item: Int){
        startActivityByClassName(item)
    }

    private fun startActivityByClassName(number: Int){
        val activityPackage = "non.shahad.templatesforrle.templates.Template${number}"
        try {
            val c = Class.forName(activityPackage)
            startActivity(Intent(this,c))
        }catch (e: Throwable){
            Log.e("MainActivity", "startActivityByClassName: $e", )
        }

    }

    private fun dump() = listOf(
        Pair(1,"Template-1"),
        Pair(2,"Template-2"),
        Pair(3,"Template-3"),
        Pair(4,"Template-4"),
        Pair(5,"Template-5"),
        Pair(6,"Template-6"),
        Pair(7,"Template-7"),
        Pair(8,"Template-8"),
        Pair(9,"Template-9"),
        Pair(10,"Template-10"),
        Pair(11,"Template-11"),
        Pair(12,"Template-12")
    )
}
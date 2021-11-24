package jaydeep.project.gamezone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rv=findViewById<RecyclerView>(R.id.recyclerView)
        rv.adapter=MyAdapter(applicationContext)

        var layout = GridLayoutManager(applicationContext,2)
        rv.layoutManager = layout




        }

    fun onImageFromCameraClick(view: View) {}

}


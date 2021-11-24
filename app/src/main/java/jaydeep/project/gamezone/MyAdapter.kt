package jaydeep.project.gamezone

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(applicationContext: Context) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var gimg= arrayOf(R.drawable.tec_tac_toe,R.drawable.numberpulzz,R.drawable.puzzalgame)
    var gnm = arrayOf("Tic Tac Teo","Number Pulzz","Puzzal Game")
    var context:Context = applicationContext

    inner class MyHolder(view : View) : RecyclerView.ViewHolder(view){
        var gimg : ImageView
        var gnm : TextView

        init {
            gimg=view.findViewById(R.id.image)
            gnm = view.findViewById(R.id.title)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.mylayout,parent,false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.gimg.setImageResource(gimg[position])
        holder.gnm.text = gnm[position]

        holder.gimg.setOnClickListener {
            //Toast.makeText(context,gimg[position],Toast.LENGTH_LONG).show()
            when(position){
                0->{
                    var intent=Intent(holder.gimg.context,TicTacToe::class.java)
                    holder.gimg.context.startActivity(intent)
                }
                1->{
                    var intent=Intent(holder.gimg.context,NumberPulzz::class.java)
                    holder.gimg.context.startActivity(intent)
                }
                2->{
                    var intent=Intent(holder.gimg.context,PuzzleGame::class.java)
                    holder.gimg.context.startActivity(intent)
                }
            }


            
        }
    }

    override fun getItemCount(): Int {
        return gnm.size
    }
}
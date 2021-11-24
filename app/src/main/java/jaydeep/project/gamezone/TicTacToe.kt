package jaydeep.project.gamezone

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class TicTacToe : AppCompatActivity(), View.OnClickListener {

    lateinit var b0:Button
    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var b3:Button
    lateinit var b4:Button
    lateinit var b5:Button
    lateinit var b6:Button
    lateinit var b7:Button
    lateinit var b8:Button
    lateinit var tv:TextView

    var player1=0
    var player2=1
    var activePlayer=player1
    var gameActive=true
    var filledPos= intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        b0=findViewById(R.id.btn0)
        tv=findViewById(R.id.textView2)

        b1=findViewById(R.id.btn1)
        b2=findViewById(R.id.btn2)
        b3=findViewById(R.id.btn3)
        b4=findViewById(R.id.btn4)
        b5=findViewById(R.id.btn5)
        b6=findViewById(R.id.btn6)
        b7=findViewById(R.id.btn7)
        b8=findViewById(R.id.btn8)

        b0.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(!gameActive)
            return

        var but_clicked=findViewById<Button>(p0!!.id)
        var clicked_tag=but_clicked.tag.toString().toInt()

        if(filledPos[clicked_tag]!=-1)
            return

        filledPos[clicked_tag]=activePlayer

        if(activePlayer==player1){
            but_clicked.setText("0")
            activePlayer=player2
            tv.setText("Player-2 Turn")
            but_clicked.setTextColor(Color.BLACK)
            but_clicked.backgroundTintList=getColorStateList(android.R.color.holo_blue_bright)
        }else{
            but_clicked.setText("X")
            activePlayer=player1
            tv.setText("Player-1 Turn")
            but_clicked.setTextColor(Color.BLACK)
            but_clicked.backgroundTintList=getColorStateList(android.R.color.holo_orange_light)
        }
        checkForWin()

    }

    private fun checkForWin() {
        var winPos= arrayOf(intArrayOf(0,1,2), intArrayOf(3,4,5), intArrayOf(6,7,8)
            ,intArrayOf(0,3,6), intArrayOf(1,4,7), intArrayOf(2,5,8), intArrayOf(0,4,8), intArrayOf(2,4,6))

        for(i in 0 until winPos.size){
            var val0=winPos[i][0]
            var val1=winPos[i][1]
            var val2=winPos[i][2]

            if(filledPos[val0]==filledPos[val1] && filledPos[val1]==filledPos[val2]){
                if(filledPos[val0]!=-1){
                    gameActive=false
                    if(filledPos[val0]==player1){
                        showMessage("Player-1 is Winner")
                    }else{
                        showMessage("Player-2 is Winner")
                    }
                    return
                }
            }
        }
        var count=0
        for(i in 0 until filledPos.size){
            if(filledPos[i]==-1)
                count++
        }
        if(count==0){
            showMessage("It's Deaw")
            return
        }
    }

    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setTitle("Tic Tac Toe - Winner")
            .setMessage(s)
            .setPositiveButton("ok",DialogInterface.OnClickListener { dialogInterface, i ->
                restart()
            }).show()
    }

    private fun restart() {
        gameActive=true
        filledPos= intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)
        activePlayer=player1
        tv.setText("Player-1 Trun")
        b0.setText("")
        b1.setText("")
        b2.setText("")
        b3.setText("")
        b4.setText("")
        b5.setText("")
        b6.setText("")
        b7.setText("")
        b8.setText("")
        b0.backgroundTintList=getColorStateList(R.color.black)
        b1.backgroundTintList=getColorStateList(R.color.black)
        b2.backgroundTintList=getColorStateList(R.color.black)
        b3.backgroundTintList=getColorStateList(R.color.black)
        b4.backgroundTintList=getColorStateList(R.color.black)
        b5.backgroundTintList=getColorStateList(R.color.black)
        b6.backgroundTintList=getColorStateList(R.color.black)
        b7.backgroundTintList=getColorStateList(R.color.black)
        b8.backgroundTintList=getColorStateList(R.color.black)
    }
}















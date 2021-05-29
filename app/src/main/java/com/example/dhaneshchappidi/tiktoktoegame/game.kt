package com.example.dhaneshchappidi.tiktoktoegame

import android.graphics.Color.green
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*

class game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        restart.setOnClickListener {
            restartGame()
        }
    }

    fun buClick(view: View) {
        val buselected=view as Button
        var cellid=0
        when(buselected.id){
            R.id.bu1 -> cellid=1
            R.id.bu2 -> cellid=2
            R.id.bu3 -> cellid=3
            R.id.bu4 -> cellid=4
            R.id.bu5 -> cellid=5
            R.id.bu6 -> cellid=6
            R.id.bu7 -> cellid=7
            R.id.bu8 -> cellid=8
            R.id.bu9 -> cellid=9
        }
        playgame(cellid,buselected)
    }
    var activeplayer=1
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    fun playgame(cellid: Int, buselected: Button) {
        if(activeplayer==1){
            buselected.text="x"
            buselected.setBackgroundResource(R.color.green)
            player1.add(cellid)
            activeplayer=2
        }
        else{
            buselected.text="0"
            buselected.setBackgroundResource(R.color.blue)
            player2.add(cellid)
            activeplayer=1
        }
        buselected.isEnabled=false
        checkwinner()
    }

    fun checkwinner() {
        var winer = 0
        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }
        // cross 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winer = 2
        }
        // cross 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winer = 2
        }



        if (winer == 1) {
            Toast.makeText(this, "PLAYER 1 WIN", Toast.LENGTH_SHORT).show()
            restartGame()
        } else if (winer == 2) {
            Toast.makeText(this, "PLAYER 2 WIN", Toast.LENGTH_LONG).show()
            restartGame()
        }
    }
    fun restartGame() {
        activeplayer=1
        player1.clear()
        player2.clear()
        for(cellid in 1..9){
            val buselected:Button=when(cellid){
                1-> bu1
                2-> bu2
                3-> bu3
                4-> bu4
                5-> bu5
                6-> bu6
                7-> bu7
                8-> bu8
                9-> bu9
                else ->bu1
            }
            buselected.text=""
            buselected.setBackgroundResource(R.color.white)
            buselected.isEnabled=true
        }
    }

}
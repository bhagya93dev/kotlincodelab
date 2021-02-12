package com.example.samplekotlinapp

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

 private fun initViews(){

     val rollDiceButton:Button  =findViewById(R.id.roll)

     rollDiceButton.setOnClickListener{(rollDice())}

 }

private fun rollDice(){
    val  diceImage : ImageView = findViewById(R.id.imageView)

    val dice = Dice()
    val rolledNumber = dice.roll()
    val drawableId = when (rolledNumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 ->R.drawable.dice_3
        4 ->  R.drawable.dice_4
        5 -> R.drawable.dice_5

        else ->  R.drawable.dice_6
    }
    diceImage.setImageResource(drawableId)

}
    class Dice {
        val totalDiceValue = 6

        fun roll(): Int {
            return (1..totalDiceValue).random()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
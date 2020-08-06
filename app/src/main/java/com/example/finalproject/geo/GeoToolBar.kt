package com.example.finalproject.geo

import android.content.Intent
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


open class GeoToolBar: AppCompatActivity(){
    /**
     * @return Boolean
     * inflate the menu into layout
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.geo_toolbar_menu,menu)
        return true
    }
    /**
     * @return Boolean
     * action when specific item is selected in toolbar
     */


    open fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Look at your menu XML file. Put a case for every id in that file:
        when (item.itemId) {
            R.id.donate_toolbar -> {
                val alertDialogBuilder1 = AlertDialog.Builder(this)
                alertDialogBuilder1.setTitle("Give me generously $$$")
                alertDialogBuilder1.setMessage("How much money do you want to donate?")
                val input = EditText(this)
                input.inputType = InputType.TYPE_CLASS_TEXT
                alertDialogBuilder1.setView(input)

                // add the buttons
                alertDialogBuilder1.setPositiveButton("Thank you", null)
                alertDialogBuilder1.setNegativeButton("Cancel", null)              // create and show the alert dialog
                val dialog = alertDialogBuilder1.create()
                dialog.show()
            }
            R.id.API_toolbar -> {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_BROWSABLE)
                intent.data = Uri.parse("https://lyricsovh.docs.apiary.io/#")
                startActivity(intent)
            }
            R.id.instruction_toolbar -> {
                val alertDialogBuilder = AlertDialog.Builder(this)
               alertDialogBuilder.setTitle("Click a title to view the details. Click Favourite with option note, to save an article to Favourites.")
                alertDialogBuilder.setNegativeButton("Exit", null)
                alertDialogBuilder.create().show()
            }
        }
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.tbABout ->{
                val about = layoutInflater.inflate(R.layout.geo_about_dialog, null)

                val builder = AlertDialog.Builder(this)
                builder.setMessage("About")
                        .setPositiveButton("OK") { dialog, which -> }
                        .setView(about)
                builder.create().show()
            }
            R.id.tbSaved ->{
                startActivity(Intent(applicationContext, SavedCities::class.java))
            }
        }
        return true
    }
}
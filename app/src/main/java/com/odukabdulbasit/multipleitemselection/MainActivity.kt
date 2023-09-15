package com.odukabdulbasit.multipleitemselection

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var selectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        selectButton = findViewById(R.id.selectButton)

        // Sample list of items
        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        // Create an ArrayAdapter to populate the ListView
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items)
        listView.adapter = adapter

        // Set the ListView choice mode to multiple
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        selectButton.setOnClickListener {
            val checkedItems = mutableListOf<String>()

            // Iterate through the ListView to get checked items
            for (i in 0 until listView.count) {
                if (listView.isItemChecked(i)) {
                    checkedItems.add(items[i])
                }
            }

            // Display the selected items
            val selectedItemsText = checkedItems.joinToString(", ")
            Toast.makeText(this, "Selected Items: $selectedItemsText", Toast.LENGTH_SHORT).show()
        }
    }
}

package io.nicode.a1_first_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Access to the button & override .xml config
        val btnClickMe = findViewById<Button>(R.id.btn_a01)
        val helloWorldText = findViewById<TextView>(R.id.txt_a01)
        var timesClicked = 0
        //btnClickMe.text = "Well Done"

        // Define a listener for the button
        btnClickMe.setOnClickListener {
            timesClicked++
            Toast.makeText(this, "Counter updated to $timesClicked", Toast.LENGTH_SHORT).show()
            if (helloWorldText.text == "Hello World!") {
                helloWorldText.text = "You Change me"
            } else {
                helloWorldText.text = "Nice Trick! $timesClicked"
            }
        }
    }
}
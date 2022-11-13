package io.nicode.a002_age_minute_calculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView? = null
    private var tvAgeInMinute: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure date picker button
        val btnDatePicker = findViewById<Button>(R.id.date_picker_cta_btn)
        tvSelectedDate = findViewById(R.id.selected_date_txt)
        tvAgeInMinute = findViewById(R.id.age_in_minutes_txt)
        btnDatePicker.setOnClickListener {
            datePickerBtnHandler()
        }
    }

    private fun datePickerBtnHandler() {
        // Create calendar object to get date parts
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Create date picker widget
        val dpd = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                // Show a toast with picked date
                Toast.makeText(
                    this,
                    "$selectedDayOfMonth ${selectedMonth + 1} $selectedYear",
                    Toast.LENGTH_SHORT
                ).show()

                // Create string date from user picked date
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate?.text = selectedDate

                // Create date object usable in calculation
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)
                val theDate = sdf.parse(selectedDate)

                // Convert in minutes using null safety
                theDate?.let {
                    val selectedDateInMinutes = theDate.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time / 6000
                        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                        tvAgeInMinute?.text = differenceInMinutes.toString()
                    }
                }

            },
            year,
            month,
            day
        )

        // Limit date picker to date in the past
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000 // 86 400 000 ms = 24h
        dpd.show()
    }
}

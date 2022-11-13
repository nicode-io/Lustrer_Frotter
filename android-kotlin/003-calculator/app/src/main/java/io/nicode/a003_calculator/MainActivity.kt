package io.nicode.a003_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var tvResult: TextView? = null
    private var lastNumeric: Boolean = false
    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.result)
    }

    fun onDigit(view: View) {
        tvResult?.append((view as Button).text)

        lastNumeric = true
        lastDot = false
    }

    fun onClear(view: View) {
        tvResult?.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            tvResult?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        val operator = (view as Button).text.toString()

        tvResult?.text?.let {
            if (!isOperatorAdded(it.toString(), operator)) {
                tvResult?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }

        }
    }

//    fun onEqual(view: View) {
//        if (lastNumeric) {
//            val result = tvResult?.text.toString()
//
//            try {
//
//            } catch (e: ArithmeticException) {
//
//            }
//        }
//    }

    private fun isOperatorAdded(value: String, operator: String): Boolean {
        try {
            return if (operator == "-" && (value == "")) {
                false
            } else {
                if (value[0] == '-' && value.length > 1) {
                    (value.substring(1).contains("-")
                            || value.substring(1).contains("/")
                            || value.substring(1).contains("*")
                            || value.substring(1).contains("+"))
                } else {
                    (value.contains("-")
                            || value.contains("/")
                            || value.contains("*")
                            || value.contains("+"))
                }
            }
        } catch (e: ArithmeticException) {
            Log.i("OPERATOR", "ERROR")
            return false
        }
    }
}
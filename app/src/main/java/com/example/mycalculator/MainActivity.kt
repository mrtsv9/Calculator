package com.example.mycalculator

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.example.mycalculator.databinding.ActivityMainBinding
import com.udojava.evalex.Expression
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    lateinit var tvInput: TextView
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        tvInput = binding?.tvInput!!
        tvResult = binding?.tvResult!!

        tvInput.setOnClickListener {  }
        tvResult.setOnClickListener {  }

        val btnOne = binding?.btnOne?.setOnClickListener { appendSymbol("1") }
        val btnTwo = binding?.btnTwo?.setOnClickListener { appendSymbol("2") }
        val btnThree = binding?.btnThree?.setOnClickListener { appendSymbol("3") }
        val btnFour = binding?.btnFour?.setOnClickListener { appendSymbol("4") }
        val btnFive = binding?.btnFive?.setOnClickListener { appendSymbol("5") }
        val btnSix = binding?.btnSix?.setOnClickListener { appendSymbol("6") }
        val btnSeven = binding?.btnSeven?.setOnClickListener { appendSymbol("7") }
        val btnEight = binding?.btnEight?.setOnClickListener { appendSymbol("8") }
        val btnNine = binding?.btnNine?.setOnClickListener { appendSymbol("9") }
        val btnZero = binding?.btnZero?.setOnClickListener { appendSymbol("0") }
        val btnDot = binding?.btnDot?.setOnClickListener { appendSymbol(".") }
        val btnClearAll = binding?.btnClear?.setOnClickListener { tvInput.text = "" }
        val btnDeleteOne = binding?.btnDeleteOne?.setOnClickListener {
            tvInput.text =  tvInput.text.dropLast(1)
        }
        val btnPercent = binding?.btnPercent?.setOnClickListener { appendSymbol("%") }
        val btnDivide = binding?.btnDivide?.setOnClickListener { appendSymbol("/") }
        val btnMultiply = binding?.btnMultiply?.setOnClickListener { appendSymbol("*") }
        val btnMinus = binding?.btnMinus?.setOnClickListener { appendSymbol("-") }
        val btnPlus = binding?.btnPlus?.setOnClickListener { appendSymbol("+") }
        val btnEquals = binding?.btnEquals?.setOnClickListener {
            try {
                tvResult.text = Expression(tvInput.text.toString()).eval().toString()
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Invalid Output!!", Toast.LENGTH_SHORT).show()
                tvResult.text = "ERROR"
            }
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            val btnOpenBracket = binding?.btnBracketOpen?.setOnClickListener { appendSymbol("(") }
            val btnCloseBracket = binding?.btnBracketClose?.setOnClickListener { appendSymbol(")") }
            val btnSin = binding?.btnSin?.setOnClickListener { appendSymbol("SIN(") }
            val btnCor = binding?.btnCos?.setOnClickListener { appendSymbol("COS(") }
            val btnTg = binding?.btnTg?.setOnClickListener { appendSymbol("TAN(") }
            val btnLog = binding?.btnLog?.setOnClickListener { appendSymbol("LOG(") }
            val btnPov = binding?.btnPov?.setOnClickListener { appendSymbol("^") }
            val btnSqrt = binding?.btnSqrt?.setOnClickListener { appendSymbol("SQRT(") }
            val btnE = binding?.btnE?.setOnClickListener { appendSymbol("e") }
            val btnPi = binding?.btnPi?.setOnClickListener { appendSymbol("PI") }
            val btnFact = binding?.btnFact?.setOnClickListener { appendSymbol("FACT(") }
            val btnAsin = binding?.btnAsin?.setOnClickListener { appendSymbol("ASIN(") }
            val btnAcos = binding?.btnAcos?.setOnClickListener { appendSymbol("ACOS(") }
            val btnAtg = binding?.btnAtg?.setOnClickListener { appendSymbol("ATAN(") }
            val btnLog10 = binding?.btnLog10?.setOnClickListener { appendSymbol("LOG10(") }

        }

    }

    private fun appendSymbol(value: String) {
        if (tvInput.text == "Input") tvInput.text = ""
        tvInput.append(value)
    }

}
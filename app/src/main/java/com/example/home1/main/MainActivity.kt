package com.example.home1.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.home1.databinding.ActivityMainBinding
import com.example.home1.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick()
        presenter.attachView(this)
    }

    private fun initClick() {
        binding.btnIncrement.setOnClickListener {
            presenter.increment()
        }
    }

    override fun getCounter(count: Int) {
        binding.tvCount.text = count.toString()

    }

    override fun getShowToast() {
        Toast.makeText(this, "Good", Toast.LENGTH_LONG).show()
    }

    override fun getSetTextColor() {
        val textColor = ContextCompat.getColor(this, presenter.model.setColortText)
        binding.tvCount.setTextColor(textColor)
    }
}
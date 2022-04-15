package com.example.konversicelcius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.konversicelcius.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.konversiButton.setOnClickListener{ calculateTip() }
    }

    fun calculateTip() {
        val stringInTextField = binding.inputCelcius.text.toString()
        val celcius = stringInTextField.toDouble()
        // memilih suhu
        val pilihSuhu = binding.pilihanKonversi.checkedRadioButtonId
        val hasilnya = when (pilihSuhu) {
            R.id.c_tofahrenheit -> (9/5 * celcius) + 32
            R.id.c_toreamur -> 5/4 * celcius
            else -> celcius + 273
        }
        //konversi angka tidak ada koma
        val suhuKonversi = ("%.2f".format(hasilnya))
        // menampilkan di hp
        val hasil: TextView = findViewById(R.id.hasil_konversi)
        hasil.text = suhuKonversi.toString()



    }
}
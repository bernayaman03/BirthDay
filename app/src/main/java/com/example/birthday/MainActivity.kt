
package com.example.birthday

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class MainActivity : AppCompatActivity() {

    private lateinit var etGun: EditText
    private lateinit var etAy: EditText
    private lateinit var etYil: EditText
    private lateinit var btnHesapla: Button
    private lateinit var tvSonuc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etGun = findViewById(R.id.etGun)
        etAy = findViewById(R.id.etAy)
        etYil = findViewById(R.id.etYil)
        btnHesapla = findViewById(R.id.btnHesapla)
        tvSonuc = findViewById(R.id.tvSonuc)

        btnHesapla.setOnClickListener {
            try {
                val g = etGun.text.toString().toInt()
                val a = etAy.text.toString().toInt()
                val y = etYil.text.toString().toInt()

                val dogumTarihi = LocalDate.of(y, a, g)
                val bugun = LocalDate.now()

                val fark = ChronoUnit.DAYS.between(dogumTarihi, bugun)

                tvSonuc.text = "$fark gündür hayattasınız!"

            } catch (e: Exception) {
                tvSonuc.text = "Lütfen geçerli bir tarih giriniz!"
            }
        }
    }
}

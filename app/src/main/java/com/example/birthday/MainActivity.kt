package com.example.birthday

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class MainActivity : AppCompatActivity() {

    // 1. ADIM: Görsel nesneleri "lateinit var" ile tanımla
    private lateinit var etGun: EditText
    private lateinit var etAy: EditText
    private lateinit var etYil: EditText
    private lateinit var btnHesapla: Button
    private lateinit var tvSonuc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. ADIM: XML'deki ID'leri bulup koda bağla
        etGun = findViewById(R.id.etGun)
        etAy = findViewById(R.id.etAy)
        etYil = findViewById(R.id.etYil)
        btnHesapla = findViewById(R.id.btnHesapla)
        tvSonuc = findViewById(R.id.tvSonuc)

        // 3. ADIM: Buton tıklama olayını yaz
        btnHesapla.setOnClickListener {
            try {
                // EditText'lerdeki metni oku ve sayıya (Int) çevir
                val g = etGun.text.toString().toInt()
                val a = etAy.text.toString().toInt()
                val y = etYil.text.toString().toInt()

                // Tarih nesnelerini oluştur
                val dogumTarihi = LocalDate.of(y, a, g)
                val bugun = LocalDate.now()

                // GÜN FARKINI HESAPLA (Sınavın kalbi burası!)
                val fark = ChronoUnit.DAYS.between(dogumTarihi, bugun)

                // Sonucu TextView'a yazdır
                tvSonuc.text = "$fark gündür hayattasınız!"

            } catch (e: Exception) {
                // Yanlış tarih girilirse (Örn: 32. ay) burası çalışır
                tvSonuc.text = "Lütfen geçerli bir tarih giriniz!"
            }
        }
    }
}
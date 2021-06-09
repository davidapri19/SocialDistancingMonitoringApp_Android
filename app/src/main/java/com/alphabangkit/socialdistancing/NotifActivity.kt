package com.alphabangkit.socialdistancing

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.alphabangkit.socialdistancing.databinding.ActivityNotifBinding
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.*

class NotifActivity : AppCompatActivity() {
    private lateinit var notifBinding: ActivityNotifBinding
    private lateinit var number: String
    private lateinit var tujuan: String
    private lateinit var pesanterkirim: String
    companion object {
        const val EXTRA_IMAGE = "extra_image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifBinding = ActivityNotifBinding.inflate(layoutInflater)
        setContentView(notifBinding.root)
        supportActionBar?.title="Form Notifikasi"
        val urlgambar = intent.getStringExtra(EXTRA_IMAGE)
        fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
            val formatter = SimpleDateFormat(format, locale)
            return formatter.format(this)
        }
        fun getCurrentDateTime() : Date {
            return Calendar.getInstance().time
        }
        val date = getCurrentDateTime()
        val dateInString = date.toString("yyyy/MM/dd")
        notifBinding.tanggal.text = dateInString
        notifBinding.rdGrup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.keuangan -> {
                    number = "6285648033832"
                    tujuan = "Kadiv. Keuangan"
                }
                R.id.pemasaran -> {
                    number = "6285648033832"
                    tujuan = "Kadiv. Pemasaran"
                }
                R.id.gudang -> {
                    number = "6285748543953"
                    tujuan = "Kadiv. Gudang"
                }
                R.id.hrd -> {
                    number = "6285748543953"
                    tujuan = "Kadiv. HRD"
                }
            }
            val kalimat = "Sistem kami telah mendeteksi ada pelanggaran Protokol Kesehatan di ruangan divisi ini. Mohon untuk diperhatikan dan terimakasih."

            notifBinding.btnKirim.setOnClickListener {
                if (notifBinding.pesan.text.toString().length == 0){
                    pesanterkirim = "Tanggal : ${dateInString}\n\nUntuk : ${tujuan}\nPesan : ${kalimat}\n\n Bukti : ${urlgambar}"
                }
                else{
                    pesanterkirim = "Tanggal : ${dateInString}\n\nUntuk : ${tujuan}\nPesan : ${notifBinding.pesan.text.toString()}\n\n Bukti : ${urlgambar}"
                }

                val packageManager : PackageManager = packageManager
                val i = Intent(Intent.ACTION_VIEW)
                val url = "https://api.whatsapp.com/send?phone=" + number + "&text="+ URLEncoder.encode(pesanterkirim,"UTF-8")
                i.setPackage("com.whatsapp")
                i.data = Uri.parse(url)
                if(i.resolveActivity(packageManager) != null){
                    startActivity(i)
                }
            }
        }
    }
}
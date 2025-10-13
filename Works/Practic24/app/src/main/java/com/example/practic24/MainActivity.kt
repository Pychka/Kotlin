package com.example.practic24

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var im: ImageView? = null
        var bGenerate: Button? = null
        im = findViewById<ImageView>(R.id.im)
        var edT: EditText = findViewById<EditText>(R.id.ed)
        bGenerate = findViewById<Button>(R.id.bt)
        bGenerate?.setOnClickListener {
            try {
                val barcodeEncode: BarcodeEncoder = BarcodeEncoder()
                val bitmap: Bitmap = barcodeEncode.encodeBitmap(
                    edT.getText().toString(),
                    BarcodeFormat.QR_CODE,
                    750,
                    750
                )
                im?.setImageBitmap(bitmap)
            } catch (e: WriterException) {
            }
        }
    }
}
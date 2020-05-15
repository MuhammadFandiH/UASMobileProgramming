package com.example.backend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_petunjuk.*

class PetunjukActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petunjuk)

        val context = this

        InfoBack.setOnClickListener{
            intent = Intent(context,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

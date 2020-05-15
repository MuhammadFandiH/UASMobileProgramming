package com.example.backend

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_register.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnLogout.setOnClickListener{
            val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@HomeActivity,LoginActivity::class.java))
            finish()
        }

        val context = this

        btnPetunjuk.setOnClickListener{
            val intent = Intent(context,PetunjukActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnTest.setOnClickListener{
            intent = Intent(context,TestActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

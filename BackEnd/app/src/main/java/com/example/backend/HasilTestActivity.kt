package com.example.backend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_hasil_test.*
import org.json.JSONObject

class HasilTestActivity : AppCompatActivity() {

    var nilai1 = toString()
    var nilai2 = toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_test)

        val context = this

        val extras = intent.extras

        getdariserver()

        btnLobi.setOnClickListener{
            val intent = Intent(context,HomeActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    public fun getdariserver() {
        AndroidNetworking.get("http://192.168.100.130/UMB/biodata_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i: Int in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("kotlintitle", jsonObject.optString("nis"))

                        textnim.setText(jsonObject.optString("nis"))
                    }

                    val jsonArray1 = response.getJSONArray("result")
                    for (i: Int in 0 until jsonArray1.length()) {
                        val jsonObject = jsonArray1.getJSONObject(i)
                        Log.e("kotlintitle", jsonObject.optString("Nama"))

                        textnama.setText(jsonObject.optString("Nama"))
                    }

                    val jsonArray2 = response.getJSONArray("result")
                    for (i: Int in 0 until jsonArray2.length()) {
                        val jsonObject = jsonArray2.getJSONObject(i)
                        Log.e("kotlintitle", jsonObject.optString("minat1"))

                        txtHasil1.setText(jsonObject.optString("minat1"))
                    }

                    val jsonArray3 = response.getJSONArray("result")
                    for (i: Int in 0 until jsonArray3.length()) {
                        val jsonObject = jsonArray3.getJSONObject(i)
                        Log.e("kotlintitle", jsonObject.optString("minat2"))

                        txtHasil2.setText(jsonObject.optString("minat2"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("err", anError.toString())
                }
            })
    }
}

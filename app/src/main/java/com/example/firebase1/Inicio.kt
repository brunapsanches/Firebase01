package com.example.firebase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        txtUsuarioLogado = findViewById<TextView>(R.id.txtUsuarioLogado)
        btnLogout = findViewById<Button>(R.id.btnLogout)

        txtUsuarioLogado.text = autenticationFirebase.currentUser?.email

        btnLogout.setOnClickListener {
            logout()
        }
    }
}
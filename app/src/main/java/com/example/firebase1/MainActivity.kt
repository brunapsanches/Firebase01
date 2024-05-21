package com.example.firebase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    data class UserModelo(
        val email: String,
        val senha: String
    )

    private val autenticacaoFirebase by lazy {
        FirebaseAuth.getInstance()
    }

    private fun cadastrarUsuario(email: String, senha: String) {
        val user = UserModelo(email, senha)
        autenticacaoFirebase.createUserWithEmailAndPassword(user.email, user.senha)
            .addOnSuccessListener {
                Inicio()
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Erro ao efetuar o cadastro", Toast.LENGTH_LONG).show()
            }
    }

    private fun fazerLogin(email: String, senha: String) {
        val user = UserModelo(email, senha)
        autenticacaoFirebase.signInWithEmailAndPassword(user.email, user.senha)
            .addOnSuccessListener {
                Inicio()
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Erro ao efetuar o login", Toast.LENGTH_LONG).show()
            }
    }

    override fun onStart() {
        super.onStart()
        verificarLogin()
    }

    private fun verificarLogin() {
        val user = autenticacaoFirebase.currentUser
        if (user != null) {
            Inicio()
        }
    }

    private fun logout() {
        autenticacaoFirebase.signOut()
        finish()
    }
}
package com.cotemig.atividade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usuario = Usuario()
        usuario.user = "admin"
        usuario.senha = "1234"
        BD.usuarios.add(usuario)

        val cadastrar = findViewById<Button>(R.id.btnCadastrar)
        cadastrar.setOnClickListener {
            telacadastro()
        }
        val login = findViewById<Button>(R.id.btnEntrar)
        login.setOnClickListener {
            acesso()
        }
    }

    fun telacadastro () {
        val navegar = Intent (this, Cadastro::class.java)
        startActivity(navegar)
    }
    fun acesso () {
        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etSenha = findViewById<EditText>(R.id.etSenha)

        if (etUsuario.text.toString() != "") {
            if (etSenha.text.toString() != "") {
                val usuarioBD = BD.usuarios.firstOrNull  { x -> x.user == etUsuario.text.toString() }

                if (usuarioBD != null) {

                    if (usuarioBD.senha == etSenha.text.toString()) {
                        Toast.makeText(this, "Seja bem vindo ${usuarioBD.user}!", Toast.LENGTH_SHORT).show()
                        val nav = Intent (this, Lista::class.java)
                        startActivity(nav)
                    } else {
                        Toast.makeText(this, "UsuÃ¡rio ou senha invÃ¡lidos", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Toast.makeText(this, "Usuario nÃ£o cadastro", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Digite a senha", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Digite o usuÃ¡rio", Toast.LENGTH_SHORT).show()
        }
    }
}
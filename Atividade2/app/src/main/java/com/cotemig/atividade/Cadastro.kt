package com.cotemig.atividade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)






        val back = findViewById<Button>(R.id.Voltar)
        back.setOnClickListener {
            telaprincipal()
        }
        val salvar = findViewById<Button>(R.id.btnSalvar)
        salvar.setOnClickListener {
            cadastrar()
        }



    }
    fun telaprincipal() {
        val telaprincipal = Intent(this, MainActivity::class.java)
        startActivity(telaprincipal)
    }

    fun cadastrar() {

        val usuariof = findViewById<EditText>(R.id.etUsuarioCadastro).text.toString()
        val senhaf=findViewById<EditText>(R.id.etSenhaCadastro).text.toString()
        val confirmarsenha=findViewById<EditText>(R.id.etConfirmarSenha)
        val usuarioBD: Boolean = BD.usuarios.any{ x -> x.user == usuariof}

        if (usuariof == "" || senhaf == "") {
            Toast.makeText(this, "Digite o Usuario/senha", Toast.LENGTH_SHORT).show()
        }
        if (confirmarsenha.text.toString() == "") {
            Toast.makeText(this, "confirme a senha", Toast.LENGTH_SHORT).show()
        }
        if (usuariof != "" && senhaf != "" && confirmarsenha.text.toString() != "") {

            if (usuarioBD) {
                Toast.makeText(this, "Este nome já existe", Toast.LENGTH_SHORT).show()
            }
            if (senhaf == confirmarsenha.text.toString()) {
                Toast.makeText(this, "Cadastro completo", Toast.LENGTH_SHORT).show()
                val aux = Usuario()
                aux.user = usuariof
                aux.senha = senhaf
                BD.usuarios.add(aux)
                finish()
            }
        }
        else
            Toast.makeText(this,"As senhas nao coiencidem", Toast.LENGTH_SHORT).show()
    }


}



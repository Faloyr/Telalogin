package com.cotemig.atividade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.cotemig.atividade.BD.Companion.usuarios

class Lista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)



        val nav =findViewById<Button>(R.id.button)
        nav.setOnClickListener { finish() }



        val listView= findViewById<ListView>(R.id.lista)

        val user = usuarios.map {it.user}
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,user)



        listView.adapter = adapter
        



    }

}
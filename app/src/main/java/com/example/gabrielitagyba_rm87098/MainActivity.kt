package com.example.gabrielitagyba_rm87098

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var databind: MainActivity

    var listHab = mutableListOf<String>()
    var perfil = Dados(habilidades = listHab)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setTheme(Theme.currentTheme)
        setContentView(R.layout.activity_main)

        perfil.nome = getString(R.string.name)
        perfil.descicao = getString(R.string.desc)


        val btnChange = findViewById<Button>(R.id.mudarTema)
        val nome = findViewById<TextView>(R.id.textView)
        val descricao = findViewById<TextView>(R.id.textView3)
        val btnAddSkill = findViewById<Button>(R.id.btnAddSkill)
        val textHabilidades = findViewById<TextView>(R.id.textView5)

        nome.text = perfil.nome;
        descricao.text = perfil.descicao

        btnChange.setOnClickListener {
            Theme.switchTheme()
            recreate()
        }

        btnAddSkill.setOnClickListener() {
            val intent = Intent(this, SkillsActivity::class.java)
            intent.putExtra("PERFIL", perfil)
            resultLauncher.launch(intent)
        }
    }



    fun atualizarSkills(dado : Dados){
        listHab = dado.habilidades
        perfil = dado;
        val textHabilidades = findViewById<TextView>(R.id.textView5)
        var habilidadesFormat = ""

        for(habilidade in listHab){
            habilidadesFormat += "> ${habilidade}\n"
        }
        textHabilidades.text = habilidadesFormat
    }

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let { data ->
                val dado = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    data.getParcelableExtra("PERFIL", Dados::class.java)
                } else {
                    data.getParcelableExtra<Dados>("PERFIL")
                }
                if(dado != null) {
                    println("ATUALIZAR DADOS")
                    println(dado)
                    atualizarSkills(dado);
                }
            }
        }

    }

}
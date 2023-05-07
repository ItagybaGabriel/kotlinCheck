package com.example.gabrielitagyba_rm87098

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity


class SkillsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(Theme.currentTheme)
        setContentView(R.layout.activity_skills)

        val perfil : Dados? = intent.getParcelableExtra("PERFIL")
        println("\n\n\n\n\n")
        println(perfil)

        val switch1 = findViewById<Switch>(R.id.switch1)
        val switch2 = findViewById<Switch>(R.id.switch2)
        val switch3 = findViewById<Switch>(R.id.switch3)
        val switch4 = findViewById<Switch>(R.id.switch4)
        val switch5 = findViewById<Switch>(R.id.switch5)
        val voltar = findViewById<Button>(R.id.voltar)

        if(perfil != null){
            switch1.isChecked = perfil.habilidades.contains(getString(R.string.deep_sadness))
            switch2.isChecked = perfil.habilidades.contains(getString(R.string.unbearable_cry))
            switch3.isChecked = perfil.habilidades.contains(getString(R.string.contagious_melancholy))
            switch4.isChecked = perfil.habilidades.contains(getString(R.string.tsunami_of_tears))
            switch5.isChecked = perfil.habilidades.contains(getString(R.string.self_deprecating_humor))
        }

        voltar.setOnClickListener(){
            if (perfil != null){

                if (switch1.isChecked &&  !perfil.habilidades.contains(getString(R.string.deep_sadness))){
                    perfil.habilidades.add(getString(R.string.deep_sadness))
                } else if (!switch1.isChecked) {
                    switch1.isChecked = false;
                    perfil.habilidades.remove(getString(R.string.deep_sadness))
                }

                if (switch2.isChecked &&  !perfil.habilidades.contains(getString(R.string.unbearable_cry))){
                    perfil.habilidades.add(getString(R.string.unbearable_cry))
                } else if (!switch2.isChecked) {
                    switch2.isChecked = false;
                    perfil.habilidades.remove(getString(R.string.unbearable_cry))
                }

                if (switch3.isChecked && !perfil.habilidades.contains(getString(R.string.contagious_melancholy))){
                    perfil.habilidades.add(getString(R.string.contagious_melancholy))
                } else if (!switch3.isChecked) {
                    switch3.isChecked = false;
                    perfil.habilidades.remove(getString(R.string.contagious_melancholy))
                }

                if (switch4.isChecked && !perfil.habilidades.contains(getString(R.string.tsunami_of_tears))){
                    perfil.habilidades.add(getString(R.string.tsunami_of_tears))
                } else if (!switch4.isChecked) {
                    switch4.isChecked = false;
                    perfil.habilidades.remove(getString(R.string.tsunami_of_tears))
                }

                if (switch5.isChecked && !perfil.habilidades.contains(getString(R.string.self_deprecating_humor))){
                    perfil.habilidades.add(getString(R.string.self_deprecating_humor))
                } else if (!switch5.isChecked) {
                    switch5.isChecked = false;
                    perfil.habilidades.remove(getString(R.string.self_deprecating_humor))
                }
            }

            Intent().apply {
                putExtra("PERFIL", perfil)
                setResult(RESULT_OK, this)
            }
            this.finish()
        }



    }

}
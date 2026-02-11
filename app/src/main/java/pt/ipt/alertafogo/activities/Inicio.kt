package pt.ipt.alertafogo.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pt.ipt.alertafogo.databinding.ActivityInicioBinding
import kotlin.jvm.java

class Inicio : AppCompatActivity() {

    // ViewBinding - gera automaticamente a classe ActivityInicioBinding
    private lateinit var binding: ActivityInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar o layout usando ViewBinding
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar botões
        setupButtons()
    }

    private fun setupButtons() {
        // Acesso direto aos elementos - sem findViewById!

        // Botão "Quem somos?"
        binding.btnInfo.setOnClickListener {
            startActivity(Intent(this, Info::class.java))
        }

        // Botão "Iniciar Sessão"
        binding.btnIniciarSessao.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        // Botão "Registo"
        binding.btnRegisto.setOnClickListener {
            startActivity(Intent(this, Registo::class.java))
        }

        // Link "Entrar como Convidado"
        binding.btnConvidado.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("GUEST_MODE", true)
            startActivity(intent)
        }
    }
}
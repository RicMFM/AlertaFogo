package pt.ipt.alertafogo.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pt.ipt.alertafogo.databinding.ActivityRegistoBinding

class Registo : AppCompatActivity() {

    private lateinit var binding: ActivityRegistoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Botão Registar
        binding.btnRegistar.setOnClickListener {
            val nome = binding.etNome.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmarPassword = binding.etConfirmarPassword.text.toString().trim()

            if (validarCampos(nome, email, password, confirmarPassword)) {
                fazerRegisto(nome, email, password)
            }
        }

        // Link "Já tem conta?"
        binding.tvJaTemConta.setOnClickListener {
            finish() // Voltar para a tela anterior (Login ou Inicio)
        }
    }

    private fun validarCampos(
        nome: String,
        email: String,
        password: String,
        confirmarPassword: String
    ): Boolean {
        // Validar nome vazio
        if (nome.isEmpty()) {
            binding.etNome.error = "Nome obrigatório"
            return false
        }

        // Validar email vazio
        if (email.isEmpty()) {
            binding.etEmail.error = "Email obrigatório"
            return false
        }

        // Validar formato de email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Email inválido"
            return false
        }

        // Validar password vazia
        if (password.isEmpty()) {
            binding.etPassword.error = "Password obrigatória"
            return false
        }

        // Validar tamanho mínimo da password
        if (password.length < 6) {
            binding.etPassword.error = "Password deve ter pelo menos 6 caracteres"
            return false
        }

        // Validar se as passwords coincidem
        if (password != confirmarPassword) {
            binding.etConfirmarPassword.error = "Passwords não coincidem"
            return false
        }

        return true
    }

    private fun fazerRegisto(nome: String, email: String, password: String) {
        // TODO: Implementar registo real (Firebase, API, etc.)

        // Simulação de registo
        Toast.makeText(this, "Registo bem-sucedido!", Toast.LENGTH_SHORT).show()

        // Ir para MainActivity
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
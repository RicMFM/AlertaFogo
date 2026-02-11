package pt.ipt.alertafogo.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pt.ipt.alertafogo.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Botão Login
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (validarCampos(email, password)) {
                fazerLogin(email, password)
            }
        }

        // Link "Esqueceu a password?"
        binding.tvEsqueceuPassword.setOnClickListener {
            Toast.makeText(this, "Funcionalidade em desenvolvimento", Toast.LENGTH_SHORT).show()
        }

        // Link "Criar conta"
        binding.tvCriarConta.setOnClickListener {
            val intent = Intent(this, Registo::class.java)
            startActivity(intent)
        }
    }

    private fun validarCampos(email: String, password: String): Boolean {
        // Validar email vazio
        if (email.isEmpty()) {
            binding.etEmail.error = "Email obrigatório"
            return false
        }

        // Validar password vazia
        if (password.isEmpty()) {
            binding.etPassword.error = "Password obrigatória"
            return false
        }

        // Validar formato de email (simples)
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Email inválido"
            return false
        }

        return true
    }

    private fun fazerLogin(email: String, password: String) {
        // TODO: Implementar autenticação real (Firebase, API, etc.)

        // Simulação de login (aceita qualquer email/password por agora)
        Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()

        // Ir para MainActivity
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
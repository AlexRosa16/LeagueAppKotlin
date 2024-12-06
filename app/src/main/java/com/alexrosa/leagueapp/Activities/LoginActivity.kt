package com.alexrosa.leagueapp.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alexrosa.leagueapp.R
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private var isRegisterMode = false

    @SuppressLint("CutPasteId", "SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val fondologin = findViewById<ImageView>(R.id.ntImageViewFondo)
        Glide.with(this).load(R.drawable.dianaluna).into(fondologin)

        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val etUser = findViewById<TextInputEditText>(R.id.ntTextInputEditTextuser)
        val etPass = findViewById<TextInputEditText>(R.id.ntTextInputEditTextpassword)
        val btnLogin = findViewById<MaterialButton>(R.id.ntButtonLogin)
        val chkRecordar = findViewById<CheckBox>(R.id.CheckboxRecordar)
        val tvCambiarVista = findViewById<TextView>(R.id.TvCambiarVista)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)

        etUser.setText("")
        etPass.setText("")

        if (sharedPreferences.getBoolean("recordar", false)) {
            etUser.setText(sharedPreferences.getString("user", ""))
            etPass.setText(sharedPreferences.getString("password", ""))
            chkRecordar.isChecked = true
        }

        btnLogin.setOnClickListener {
            val user = etUser.text.toString()
            val password = etPass.text.toString()

            if (isRegisterMode) {
                if (user.isNotEmpty() && password.isNotEmpty()) {
                    val storedUser = sharedPreferences.getString("user", null)
                    if (storedUser == user) {
                        Snackbar.make(it, "El usuario ya está registrado", Snackbar.LENGTH_SHORT).show()
                    } else {
                        editor.putString("user", user)
                        editor.putString("password", password)
                        editor.apply()
                        Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    if (user.isEmpty()) etUser.error = "Por favor, introduce un usuario"
                    if (password.isEmpty()) etPass.error = "Por favor, introduce una contraseña"
                }
            } else {
                val storedUser = sharedPreferences.getString("user", null)
                val storedPassword = sharedPreferences.getString("password", null)
                if (user == storedUser && password == storedPassword) {
                    editor.putBoolean("recordar", chkRecordar.isChecked)
                    editor.apply()
                    val intent = Intent(this, PrincipalActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Snackbar.make(it, "Usuario o contraseña incorrectos", Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        tvCambiarVista.setOnClickListener {
            isRegisterMode = !isRegisterMode
            if (isRegisterMode) {
                tvTitle.text = "Registrarse"
                btnLogin.text = "Registrar"
                tvCambiarVista.text = "¿Ya tienes cuenta? Iniciar Sesión"
            } else {
                tvTitle.text = "Iniciar Sesión"
                btnLogin.text = "Entrar"
                tvCambiarVista.text = "¿No tienes cuenta? Registrarse"
            }
        }

        val passwordField = findViewById<TextInputEditText>(R.id.ntTextInputEditTextpassword)
        val textInputLayout = findViewById<TextInputLayout>(R.id.ntTextInputLayoutpassword)

        var isPasswordVisible = false
        textInputLayout.setEndIconOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                textInputLayout.endIconDrawable = ContextCompat.getDrawable(this, R.drawable.ic_visibility)
            } else {
                passwordField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                textInputLayout.endIconDrawable = ContextCompat.getDrawable(this, R.drawable.ic_visibility_off)
            }
            passwordField.setSelection(passwordField.text?.length ?: 0)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

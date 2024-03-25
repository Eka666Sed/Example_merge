package com.yandexpracticum.example_merge

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

internal class ProfileFragment : Fragment() {

    private companion object {
        const val LOG_TAG = "ProfileFragment"
    }

    private var buttonSave: Button? = null
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSave = view.findViewById(R.id.buttonSave)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextPassword = view.findViewById(R.id.editTextPassword)

        buttonSave?.setOnClickListener {
            saveUserProfile()
        }
    }

    private fun saveUserProfile() {
        val email = editTextEmail?.text?.toString().orEmpty()
        val password = editTextPassword?.text?.toString().orEmpty()

        val hashedPassword = UserHashGenerator.generateHashedUUID(password)

        // Дополнительная логика для обработки сохранения профиля пользователя
        // ...
        Log.d(LOG_TAG, "Email: $email, hashedPassword: $hashedPassword")
    }
}
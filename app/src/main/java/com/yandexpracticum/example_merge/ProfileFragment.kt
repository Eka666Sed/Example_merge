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
    private var buttonMove: Button? = null
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(LOG_TAG, "onViewCreated")
        buttonSave = view.findViewById(R.id.buttonSave)
        buttonMove = view.findViewById(R.id.buttonMove)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextPassword = view.findViewById(R.id.editTextPassword)

        buttonSave?.setOnClickListener {
            saveUserProfile()
        }
        buttonMove?.setOnClickListener {
            openNextScreen()
        }
    }

    private fun saveUserProfile() {
        Log.d(LOG_TAG, "saveUserProfile")
        val email = editTextEmail?.text?.toString().orEmpty()
        val password = editTextPassword?.text?.toString().orEmpty()

        val hashedPassword = UserHashGenerator.getPasswordHash(password)

        // Дополнительная логика для обработки сохранения профиля пользователя
        // ...
        Log.d(LOG_TAG, "Email: $email, password: $password")
        Log.d(LOG_TAG, "hashedPassword: $hashedPassword")
    }

    private fun openNextScreen() {
        val password = editTextPassword?.text?.toString().orEmpty()
        val hashedPassword = UserHashGenerator.getPasswordHash(password)

        val nextFragment = NextFragment.newInstance(hashedPassword)
        parentFragmentManager.beginTransaction()
            .add(nextFragment, "NextFragment")
            .commit()
    }
}
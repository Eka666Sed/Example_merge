package com.yandexpracticum.example_merge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf

internal class NextFragment : Fragment() {

    companion object {

        private const val ARGS_PASSWORD = "password"

        fun newInstance(password: String) = Fragment().apply {
            arguments = bundleOf(ARGS_PASSWORD to password)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val passwordFromArguments = arguments?.getString(ARGS_PASSWORD).orEmpty()
        val nextFragmentTitle = view.findViewById<TextView>(R.id.nextFragmentTitle)

        nextFragmentTitle.text = passwordFromArguments
    }

}
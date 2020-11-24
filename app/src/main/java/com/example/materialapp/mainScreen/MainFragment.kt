package com.example.materialapp.mainScreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.materialapp.MyTextWatcher
import com.example.materialapp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainFragment : Fragment() {

    companion object
    interface Listener {
        fun alertBtnClicked()
        fun fabClicked()
    }

    private var listener: Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)

        val alertBtn = root.findViewById<MaterialButton>(R.id.alertBtn)
        alertBtn?.setOnClickListener { listener?.alertBtnClicked() }

        val fab = root.findViewById<FloatingActionButton>(R.id.fab)
        fab?.setOnClickListener { listener?.fabClicked() }

        val passEt = root.findViewById<TextInputEditText>(R.id.myEt2)
        val passLayout = root.findViewById<TextInputLayout>(R.id.textInputLayout2)
        val myWatcher = MyTextWatcher(passLayout, passEt)
        passEt?.addTextChangedListener(myWatcher)

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }
}
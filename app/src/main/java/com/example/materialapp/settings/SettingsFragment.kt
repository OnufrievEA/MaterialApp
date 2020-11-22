package com.example.materialapp.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialapp.R
import com.google.android.material.button.MaterialButton

class SettingsFragment : Fragment() {

    companion object
    interface Listener {
        fun colorBtnClicked(btnId: Int)
    }

    private var listener: Listener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_settings, container, false)

        val blueBtn = root.findViewById<MaterialButton>(R.id.blueBtn)
        val orangeBtn = root.findViewById<MaterialButton>(R.id.orangeBtn)
        blueBtn?.setOnClickListener { listener?.colorBtnClicked(R.id.blueBtn) }
        orangeBtn?.setOnClickListener { listener?.colorBtnClicked(R.id.orangeBtn) }

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }
}
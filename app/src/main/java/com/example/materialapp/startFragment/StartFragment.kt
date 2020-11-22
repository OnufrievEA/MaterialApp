package com.example.materialapp.startFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialapp.R
import com.google.android.material.button.MaterialButton

class StartFragment : Fragment() {

    companion object
    interface Listener {
        fun fragmentStartBackBtnClicked()
        fun fragmentStartNextBtnClicked()
    }

    private var listener: Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_start, container, false)
        val fragmentStartBackBtn = root.findViewById<MaterialButton>(R.id.fragmentStartBackBtn)
        val fragmentStartNextBtn = root.findViewById<MaterialButton>(R.id.fragmentStartNextBtn)
        fragmentStartBackBtn.setOnClickListener { listener?.fragmentStartBackBtnClicked() }
        fragmentStartNextBtn.setOnClickListener { listener?.fragmentStartNextBtnClicked() }

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.listener = context as Listener
    }
}
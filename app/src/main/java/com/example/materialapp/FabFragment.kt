package com.example.materialapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabFragment : Fragment() {

    companion object
    interface Listener {
        fun fabClicked()
    }

    private lateinit var listener: Listener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fab, container, false)
        val fab = view?.findViewById<FloatingActionButton>(R.id.fab)
        fab?.setOnClickListener { listener.fabClicked() }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }
}
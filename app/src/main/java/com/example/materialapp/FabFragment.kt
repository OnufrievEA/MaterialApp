package com.example.materialapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabFragment : Fragment() {

    companion object
    interface Listener {
        fun fabClicked()
    }

    private var listener: Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_fab, container, false)
        val fab = root?.findViewById<FloatingActionButton>(R.id.fab)
        fab?.setOnClickListener { listener?.fabClicked() }
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }
}
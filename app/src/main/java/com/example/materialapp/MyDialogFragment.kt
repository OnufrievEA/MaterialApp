package com.example.materialapp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Диалоговое окно")
                .setMessage("Текст для ознакомления")
                .setPositiveButton("Ок") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalArgumentException("Activity cannot be null")
    }
}
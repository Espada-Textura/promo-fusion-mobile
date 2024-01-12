package com.promofusion.modules.auth.context.models.api

import android.app.AlertDialog
import android.content.Context
import android.view.Gravity


class ApiErrorHandler {

    fun showAlert(context: Context?, errorMessage: String?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("Requesting Error")
            .setMessage(errorMessage)
            .setPositiveButton("Retry", null) // You can customize the button behavior if needed
        val alertDialog: AlertDialog = builder.create()

        // Set the position of the dialog
        alertDialog.window?.setGravity(Gravity.CENTER) // You can change the Gravity as needed
        alertDialog.show()
    }
}
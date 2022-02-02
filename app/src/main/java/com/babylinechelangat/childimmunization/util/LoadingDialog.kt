package com.babylinechelangat.childimmunization.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.babylinechelangat.childimmunization.R
import com.babylinechelangat.childimmunization.databinding.AlertDialogLayoutBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object LoadingDialog {

   fun createDialog(context: Context): AlertDialog {
      val builder = MaterialAlertDialogBuilder(context)
      builder.setView(R.layout.alert_dialog_layout)
      builder.setCancelable(false)
      val dialog = builder.create()
      dialog.setCanceledOnTouchOutside(false)
      return dialog
   }
}
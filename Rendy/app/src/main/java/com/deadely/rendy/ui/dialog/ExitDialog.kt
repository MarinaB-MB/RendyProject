package com.deadely.rendy.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.deadely.rendy.R
import kotlin.system.exitProcess

class ExitDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.exit_confirm))
            .setPositiveButton(getText(R.string.yes)) { _, _ ->
                exitProcess(0)
//                findNavController().popBackStack(R.id.choiceFragment, false)
            }
            .setNegativeButton(getText(R.string.no)) { _, _ ->
            }.create()
}

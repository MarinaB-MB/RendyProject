package com.deadely.rendy.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.deadely.rendy.R

class LogoutDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.logout_confirm))
            .setPositiveButton(getText(R.string.yes)) { _, _ ->
                findNavController().navigate(R.id.toChoiceFragment, bundleOf("sss" to "sss"))
            }
            .setNegativeButton(getText(R.string.no)) { _, _ ->
            }.create()
}

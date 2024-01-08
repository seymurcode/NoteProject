package com.homework.noteproject.features.fragments.addNoteDialog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.homework.noteproject.R
import com.homework.noteproject.databinding.FragmentAddNoteBinding
import com.homework.noteproject.databinding.FragmentAddNoteDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteDialogFragment : BottomSheetDialogFragment() {


    lateinit var binding: FragmentAddNoteDialogBinding
    val viewModel: AddNoteDialogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentAddNoteDialogBinding.inflate(inflater)

        return binding.root
    }



}
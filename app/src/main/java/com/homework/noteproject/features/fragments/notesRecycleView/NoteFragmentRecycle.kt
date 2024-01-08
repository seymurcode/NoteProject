package com.homework.noteproject.features.fragments.notesRecycleView

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.homework.noteproject.R
import com.homework.noteproject.databinding.FragmentAddNoteDialogBinding
import com.homework.noteproject.databinding.FragmentNoteFragmentRecycleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragmentRecycle : Fragment() {


    val viewModel: NoteFragmentRecycleViewModel by viewModels()

    lateinit var binding: FragmentNoteFragmentRecycleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNoteFragmentRecycleBinding.inflate(inflater)

        return binding.root
    }


}
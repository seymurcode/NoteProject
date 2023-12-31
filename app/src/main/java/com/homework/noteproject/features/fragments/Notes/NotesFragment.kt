package com.homework.noteproject.features.fragments.Notes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lesson2.features.adapters.NoteListAdapter
import com.homework.noteproject.R
import com.homework.noteproject.databinding.FragmentNotesBinding
import com.homework.noteproject.databinding.ListviewItemNoteBinding
import com.homework.noteproject.model.Note
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class NotesFragment : Fragment() {


    val viewModel: NotesViewModel by viewModels()

    lateinit var binding: FragmentNotesBinding
    var adapter : NoteListAdapter?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding= FragmentNotesBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        context?.let {

            runBlocking {
                launch {
                    viewModel.noteRepository.getAll().observe(this@NotesFragment.viewLifecycleOwner) { productList->

                        adapter=  NoteListAdapter(it, productList.toMutableList(),
                            onClickEdit = {
                                openEditPage(it)
                        },
                            onClickDelete = {

                        })
                        binding.listView.adapter=adapter
                    }
                }
                launch {

                }
            }
        }



        return binding.root

    }

    fun openEditPage(note: Note) {
        val action = NotesFragmentDirections.actionEdit(note)
        findNavController().navigate(action)
    }

    fun openAddPage(note: Note) {
        val action = NotesFragmentDirections.actionAdd()
        findNavController().navigate(action)
    }


}
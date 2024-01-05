package com.homework.noteproject.features.fragments.addNote

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.homework.noteproject.R
import com.homework.noteproject.databinding.FragmentAddNoteBinding
import com.homework.noteproject.databinding.FragmentNotesBinding
import com.homework.noteproject.model.Note
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment() {


    val viewModel: AddNoteViewModel by viewModels()
    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddNoteBinding.inflate(inflater)
        binding.viewModel=viewModel
        binding.lifecycleOwner=this


        return binding.root
    }

    fun observeAll(){
        viewModel.addNoteEvent.observe(this){
            if(it){
                val note : Note =viewModel.createNewNote()
                viewModel.insert(note)
                Toast.makeText(activity,"Başarıyla eklendi",Toast.LENGTH_SHORT).show()
            }
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.save -> {
                    viewModel.saveNoteClick()
                    true
                }
                else -> {
                    true
                }
            }
        }
        viewModel.errorObserver.observe(this){
            if(!it.isNullOrEmpty()){
                Toast.makeText(activity,it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun removeAllObservers(){
        viewModel.addNoteEvent.removeObservers(this)
        viewModel.addNoteEvent.postValue(false)

        viewModel.errorObserver.removeObservers(this)
        //viewModel.errorObserver.postValue(false)
    }

    override fun onResume() {
        super.onResume()
        observeAll()
    }

    override fun onPause() {
        super.onPause()
        removeAllObservers()
    }

}
package com.homework.noteproject.features.fragments.editNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.homework.noteproject.R
import com.homework.noteproject.databinding.FragmentAddNoteBinding
import com.homework.noteproject.databinding.FragmentEditNoteBinding
import com.homework.noteproject.model.Note
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class EditNoteFragment : Fragment() {

    val viewModel : EditNoteViewModel by viewModels()
    lateinit var binding: FragmentEditNoteBinding
    // TODO: Rename and change types of parameters
    val args : EditNoteFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentEditNoteBinding.inflate(inflater)
        binding.viewModel=viewModel
        binding.lifecycleOwner=this
        viewModel.setTexts(args.note)

        // Inflate the layout for this fragment
        return binding.root
    }


    fun observeAll(){
        viewModel.editNoteEvent.observe(this){
            if(it){
                val note : Note =viewModel.createUpdatedNote(args.note)
                viewModel.update(note)
                Toast.makeText(activity,"Başarıyla guncellendi", Toast.LENGTH_SHORT).show()
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
        viewModel.editNoteEvent.removeObservers(this)
        viewModel.editNoteEvent.postValue(false)
        viewModel.errorObserver.removeObservers(this)
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
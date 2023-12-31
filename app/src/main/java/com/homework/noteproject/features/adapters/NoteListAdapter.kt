package com.example.lesson2.features.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.homework.noteproject.R
import com.homework.noteproject.databinding.ListviewItemNoteBinding
import com.homework.noteproject.model.Note
import java.util.ListResourceBundle

class NoteListAdapter(val context: Context, private  var datalist: MutableList<Note>, var onClickEdit: (Note)->Unit, var onClickDelete: (Note)->Unit) : BaseAdapter() {

    fun addNewItem(note: Note){
        datalist.add(note)
        notifyDataSetChanged()
    }
    override fun getCount(): Int {
        return datalist.count()
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
        return datalist.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, contentView: View?, p2: ViewGroup?): View {

        var newContentView=contentView;
        var holder : ViewHolder
        if(contentView == null){
            var binding : ListviewItemNoteBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.listview_item_note, p2, false)

            newContentView=binding.root
            holder=ViewHolder(binding, onClickEdit, onClickDelete)
            holder.bind(datalist[position])
            newContentView?.tag=holder

            return binding.root

        }
        else{
            holder=contentView.tag as ViewHolder
            holder.bind(datalist[position])
        }

        return newContentView!!


    }

    private class ViewHolder(var binding : ListviewItemNoteBinding, var onClickEdit: (Note)->Unit, var onClickDelete: (Note)->Unit){

        fun bind(note: Note){
            binding.txtProductName.text=note.title
            binding.txtProductDescription.text=note.description
            binding.note=note
            binding.edit.setOnClickListener{
                onClickEdit(binding.note as Note)
            }
            binding.delete.setOnClickListener{
                onClickDelete(binding.note as Note)
            }
        }

    }
}
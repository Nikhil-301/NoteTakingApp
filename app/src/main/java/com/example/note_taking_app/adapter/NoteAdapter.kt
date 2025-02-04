package com.example.note_taking_app.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.note_taking_app.HomeFragmentDirections
import com.example.note_taking_app.databinding.NoteLayoutBinding
import com.example.note_taking_app.model.Note
import java.util.*

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder( val itemBonding: NoteLayoutBinding):
    RecyclerView.ViewHolder(itemBonding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Note>(){
        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteBody == newItem.noteBody &&
                    oldItem.noteTitle== newItem
                .noteTitle
        }

        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]
        holder.itemBonding.tvNoteTitle.text= currentNote.noteTitle
        holder.itemBonding.tvNoteBody.text= currentNote.noteBody

        val random= Random()
        val color = Color.argb(
            255,
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )

        holder.itemBonding.ibColor.setBackgroundColor(color)
        holder.itemView.setOnClickListener{
            val direction = HomeFragmentDirections.
            actionHomeFragmentToUpdateNoteFragment(currentNote)
            it.findNavController().navigate(direction)


        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }


}
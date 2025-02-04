package com.example.note_taking_app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_taking_app.model.Note
import com.example.note_taking_app.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application,
                    private val noteRepository: NoteRepository ):
                    AndroidViewModel(app) {

                        fun addNote(note: Note) =
                            viewModelScope.launch {
                                noteRepository.insertNode(note)

                            }

    fun deleteNote(note: Note ){
        viewModelScope.launch {
            noteRepository.deleteNode(note)
        }
    }

    fun updateNote(note: Note){
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

    fun getAllNotes() = noteRepository.getAllNotes()
    fun searchNotes(query : String?)=
        noteRepository.searchNote(query)



}
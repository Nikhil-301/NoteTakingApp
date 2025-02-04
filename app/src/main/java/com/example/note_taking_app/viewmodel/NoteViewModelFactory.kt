package com.example.note_taking_app.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.note_taking_app.repository.NoteRepository

//class NoteViewModelFactory(val application: Application,
//    val app: Application,
//    private val noteRepository: NoteRepository
//        ) : ViewModelProvider.Factory
//{
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return NoteViewModel(app, noteRepository) as T
//    }
//
//}
class NoteViewModelFactory(
    private val application: Application,
    private val noteRepository: NoteRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            NoteViewModel(application, noteRepository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

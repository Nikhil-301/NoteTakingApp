package com.example.note_taking_app.repository

import com.example.note_taking_app.database.NoteDatabase
import com.example.note_taking_app.model.Note


class NoteRepository(private val db:NoteDatabase) {

    suspend fun insertNode(note: Note)= db.getNoteDao().insertNote(note)
    suspend fun deleteNode( note : Note ) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote( note: Note) = db.getNoteDao().updateNote(note)

    fun getAllNotes()= db.getNoteDao().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)





}
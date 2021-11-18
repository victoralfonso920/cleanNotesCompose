package com.victordevs.composenotes.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.victordevs.composenotes.feature_notes.data.data_source.NoteDataBase
import com.victordevs.composenotes.feature_notes.data.repository.NoteRepositoryImpl
import com.victordevs.composenotes.feature_notes.domain.repository.NoteRepository
import com.victordevs.composenotes.feature_notes.domain.use_case.*
import com.victordevs.composenotes.feature_notes.presentation.util.ResourceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBase(app:Application):NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDataBase):NoteRepository{
        return  NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideResources(@ApplicationContext appContext: Context) : ResourceManager = ResourceManager(appContext)

    @Provides
    @Singleton
    fun provideNoteUsesCases(
        repository:NoteRepository,
        resourceManager: ResourceManager
    ):NoteUsesCases{
        return NoteUsesCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository,resourceManager),
            getNote = GetNote(repository)
        )
    }
}
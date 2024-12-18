package com.restapi.simple_notes_api.service;

import java.util.List;
import java.util.Optional;

import com.restapi.simple_notes_api.dto.NotesDTO;
import com.restapi.simple_notes_api.entity.Notes;

public interface NoteService {
    List<Notes> getAllNotes();
    Optional<Notes> getNotesById(Long id);
    Notes saveNotes(Notes notes);
    Notes updateNotes(Long id, Notes notes);
    boolean deleteNotes(Long id);
    Notes updateNotes(Long id, NotesDTO notesDTO); 
}

package com.restapi.simple_notes_api.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.simple_notes_api.dto.NotesDTO;
import com.restapi.simple_notes_api.entity.Notes;
import com.restapi.simple_notes_api.repository.NoteRepository;
import com.restapi.simple_notes_api.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Notes> getNotesById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Notes saveNotes(Notes notes) {
        return noteRepository.save(notes);
    }

    @Override
    public Notes updateNotes(Long id, Notes notes) {
        Optional<Notes> existingNoteOpt = noteRepository.findById(id);
        if (existingNoteOpt.isPresent()) {
            Notes existingNote = existingNoteOpt.get();
            notes.setId(id);
            return noteRepository.save(notes);
        }
        return null;
    }

    @Override
    public boolean deleteNotes(Long id) { 
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
		return false;
    }

	@Override
	public Notes updateNotes(Long id, NotesDTO notesDTO) {
		Optional<Notes> existingNoteOpt = noteRepository.findById(id);
	    if (existingNoteOpt.isPresent()) {
	        Notes existingNote = existingNoteOpt.get();
	        existingNote.setTitle(notesDTO.getTitle());
	        existingNote.setContent(notesDTO.getContent());
	        
	        return noteRepository.save(existingNote); 
	    }
	    return null; 
	}
}

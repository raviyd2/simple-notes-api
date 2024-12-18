package com.restapi.simple_notes_api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.simple_notes_api.dto.NotesDTO;
import com.restapi.simple_notes_api.entity.Notes;
import com.restapi.simple_notes_api.service.NoteService;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://127.0.0.1:5500")// Frontend API URL
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Create note
    @PostMapping
    public NotesDTO createNote(@RequestBody NotesDTO noteDTO) {
        Notes note = new Notes();
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());

        Notes savedNote = noteService.saveNotes(note);

        return new NotesDTO(savedNote.getId(), savedNote.getTitle(), savedNote.getContent());
    }

    // Get all notes
    @GetMapping
    public List<NotesDTO> getAllNotes() {
        List<Notes> notes = noteService.getAllNotes();
        return notes.stream()
                    .map(note -> new NotesDTO(note.getId(), note.getTitle(), note.getContent()))
                    .collect(Collectors.toList());
    }

    // Get note by ID
    @GetMapping("/{id}")
    public ResponseEntity<NotesDTO> getNoteById(@PathVariable Long id) {
        Optional<Notes> note = noteService.getNotesById(id);
        if (note.isPresent()) {
            NotesDTO noteDTO = new NotesDTO(note.get().getId(), note.get().getTitle(), note.get().getContent());
            return ResponseEntity.ok(noteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update note by ID
    @PutMapping("/{id}")
    public ResponseEntity<NotesDTO> updateNote(@PathVariable Long id, @RequestBody NotesDTO notesDTO) {
        Notes updatedNote = noteService.updateNotes(id, notesDTO);
        if (updatedNote != null) {
            NotesDTO updatedNoteDTO = new NotesDTO(updatedNote.getId(), updatedNote.getTitle(), updatedNote.getContent());
            return ResponseEntity.ok(updatedNoteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete note by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        boolean deleted = noteService.deleteNotes(id); 
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
}

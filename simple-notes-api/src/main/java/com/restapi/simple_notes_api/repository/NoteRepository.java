package com.restapi.simple_notes_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.simple_notes_api.entity.Notes;

public interface NoteRepository extends JpaRepository<Notes, Long> {

}

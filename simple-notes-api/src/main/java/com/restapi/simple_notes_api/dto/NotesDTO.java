package com.restapi.simple_notes_api.dto;

import lombok.Data;

@Data
public class NotesDTO {
    private Long id;
    private String title;
    private String content;

    
    public NotesDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

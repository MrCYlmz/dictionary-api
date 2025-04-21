package com.mrdew.dictionaryapi.daos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "words")
public class Word {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 255)
    @NotNull
    @Column(name = "term", nullable = false)
    private String term;

    @NotNull
    @Column(name = "definition", nullable = false, length = Integer.MAX_VALUE)
    private String definition;

    @Column(name = "partofspeech", length = Integer.MAX_VALUE)
    private String partofspeech;


    @Column(name = "synonyms")
    private List<String> synonyms;
}
package com.mrdew.dictionaryapi.daos;

import com.mrdew.dictionaryapi.openapi.model.WordApiDTO;

import java.util.UUID;

public class DaoMapper {
    public static WordApiDTO toDTO( Word word ) {
        return new WordApiDTO().id(word.getId())
                .definition(word.getDefinition())
                .synonyms(word.getSynonyms())
                .term(word.getTerm())
                .partOfSpeech(word.getPartofspeech());
    }
    public static Word toDAO( WordApiDTO wordApiDTO ) {
        Word word = new Word();
        word.setId(UUID.randomUUID());
        word.setDefinition(wordApiDTO.getDefinition());
        word.setTerm(wordApiDTO.getTerm());
        word.setSynonyms(wordApiDTO.getSynonyms().stream().toList());
        word.setPartofspeech(wordApiDTO.getPartOfSpeech());
        return word;
    }
}

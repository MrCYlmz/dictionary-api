package com.mrdew.dictionaryapi.controllers;

import com.mrdew.dictionaryapi.openapi.api.DefaultApi;
import com.mrdew.dictionaryapi.openapi.model.WordApiDTO;
import com.mrdew.dictionaryapi.service.WordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordsController implements DefaultApi{

    private final WordService wordService;

    public WordsController(WordService wordService) {
        this.wordService = wordService;
    }

    @Override
    public ResponseEntity<List<WordApiDTO>> wordsGet(@Valid Integer limit) {
        List<WordApiDTO> words = wordService.getWords();
        return ResponseEntity.ok(words);
    }

    @Override
    public ResponseEntity<WordApiDTO> wordsPost(@Valid WordApiDTO wordApiDTO) {
        WordApiDTO word = wordService.wordAdd(wordApiDTO);
        return ResponseEntity.ok(word);
    }

    @Override
    public ResponseEntity<WordApiDTO> wordsPut(@Valid WordApiDTO wordApiDTO) throws Exception {
        return DefaultApi.super.wordsPut(wordApiDTO);
    }
}

package com.mrdew.dictionaryapi.service;

import com.mrdew.dictionaryapi.daos.DaoMapper;
import com.mrdew.dictionaryapi.daos.Word;
import com.mrdew.dictionaryapi.openapi.model.WordApiDTO;
import com.mrdew.dictionaryapi.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordService {
    private final WordRepository wordRepository;
    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }
    public List<WordApiDTO> getWords() {
        List<Word> words = wordRepository.findAll();
        return words.stream()
                .map(DaoMapper::toDTO)
                .collect(Collectors.toList());
    }
    public WordApiDTO wordAdd(WordApiDTO wordApiDTO) {
        Word word = DaoMapper.toDAO(wordApiDTO);
        Word savedWord = wordRepository.save(word);
        return DaoMapper.toDTO(savedWord);
    }
}

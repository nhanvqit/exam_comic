package com.nhan.comic.service;

import com.nhan.comic.dao.ComicDAO;
import com.nhan.comic.entity.Comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ComicServiceImplement implements ComicService {
    private final ComicDAO comicDAO;

    @Autowired
    public ComicServiceImplement(ComicDAO comicDAO) {
        this.comicDAO = comicDAO;
    }

    @Override
    @Transactional
    public List<Comic> getAllComics() {
        return comicDAO.getAllComics();
    }

    @Override
    @Transactional
    public void saveComicData(Comic comicData) {
        comicDAO.saveComicData(comicData);
    }

    @Override
    @Transactional
    public Comic getComicById(int comicId) {
        return comicDAO.getComicById(comicId);
    }

    @Override
    @Transactional
    public void removeComicById(int comicId) {
        comicDAO.removeComicById(comicId);
    }

    @Override
    @Transactional
    public boolean checkComicIsExist(String comicName, int comicId, int categoryId) {
        return comicDAO.checkComicIsExist(comicName, comicId, categoryId);
    }
}

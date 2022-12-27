package com.nhan.comic.dao;

import com.nhan.comic.entity.Comic;

import java.util.List;

public interface ComicDAO {
    List<Comic> getAllComics();

    void saveComicData(Comic comicData);

    Comic getComicById(int comicId);

    void removeComicById(int comicId);

    boolean checkComicIsExist(String comicName, int comicId, int categoryId);
}

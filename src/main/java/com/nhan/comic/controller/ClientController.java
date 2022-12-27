package com.nhan.comic.controller;

import com.nhan.comic.service.ComicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {
    private final ComicService comicService;

    public ClientController(ComicService comicService) {
        this.comicService = comicService;
    }

    @GetMapping("/")
    public String showClientIndexPage(Model theModel) {
        theModel.addAttribute("comics", comicService.getAllComics());

        return "client/index";
    }

    @GetMapping("/comic-detail")
    public String showComicDetail(@RequestParam("comicId") int comicId, Model theModel) {
        theModel.addAttribute("comic", comicService.getComicById(comicId));

        return "client/comic-detail";
    }
}

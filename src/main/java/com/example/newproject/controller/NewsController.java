package com.example.newproject.controller;

import com.example.newproject.entity.News;
import com.example.newproject.model.NewsModel;
import com.example.newproject.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @PostMapping
    public NewsModel addOwner(@RequestBody News news) {
     return newsService.addNews(news);
    }

    @GetMapping("{id}")
    public ResponseEntity getNewsById(@PathVariable Long id) {
     NewsModel news = newsService.getNewsById(id);
     return ResponseEntity.ok(news);
    }

    @GetMapping
    public ResponseEntity getAllNews() {
        return ResponseEntity.ok(newsService.getAllNews());
    }
    @PutMapping("{id}")
    public ResponseEntity<NewsModel> updateNews(@PathVariable long id, @RequestBody NewsModel newsDetails) {
     NewsModel updateNews = newsService.updateNews(id,newsDetails);
             return ResponseEntity.ok(updateNews);
    }

    @PatchMapping("{id}")
    public ResponseEntity<NewsModel> updatePatchNews(@PathVariable long id, @RequestBody NewsModel newsDetails) {
        NewsModel updateNews = newsService.updatePartiallyNews(id,newsDetails);
        return ResponseEntity.ok(updateNews);
    }

    @DeleteMapping("{id}")
    public void deleteNews(@PathVariable Long id) {
     newsService.deleteNews(id);
    }
}

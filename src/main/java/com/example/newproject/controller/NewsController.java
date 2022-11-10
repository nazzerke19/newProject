package com.example.newproject.controller;

import com.example.newproject.entity.News;
import com.example.newproject.model.NewsModel;
import com.example.newproject.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
 @Autowired
    NewsService newsService;

 @PostMapping
    public News addOwner(@RequestBody News news){
     return newsService.addNews(news);
 }
@GetMapping("{id}")
public ResponseEntity getNewsById(@PathVariable Long id){
     News news = newsService.getNewsById(id);
     return ResponseEntity.ok(news);
}
 @GetMapping
    public List<NewsModel> getAllNews(){
     return newsService.getAllNews();
 }
 @PutMapping("{id}")
    public ResponseEntity<News> updateNews(@PathVariable long id, @RequestBody News newsDetails){
     News updateNews = newsService.updateNews(id,newsDetails);
             return ResponseEntity.ok(updateNews);
 }
    @PatchMapping("{id}")
    public ResponseEntity<News> updatePatchNews(@PathVariable long id, @RequestBody News newsDetails){
        News updateNews = newsService.updatePartiallyNews(id,newsDetails);
        return ResponseEntity.ok(updateNews);
    }

    @DeleteMapping("{id}")
    public void deleteNews(@PathVariable Long id){
     newsService.deleteNews(id);
    }
}

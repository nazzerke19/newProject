package com.example.newproject.service;

import com.example.newproject.entity.News;
import com.example.newproject.model.NewsModel;
import com.example.newproject.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    public News addNews(News news){

        return newsRepository.save(news);
    }

    public List<NewsModel> getAllNews(){
        Iterable<News> all = newsRepository.findAll();
        List<NewsModel> newsModelList = new ArrayList<>();
        for (News owner : all) {
            NewsModel newsModel = NewsModel.toModel(owner);
            newsModelList.add(newsModel);
        }
        return newsModelList;

    }

    public News getNewsById(Long id){
        return newsRepository.findById(id).get();
    }

    public News updateNews(Long id, News news){
        News news1 = newsRepository.findById(id).get();
        news1.setTitle(news.getTitle());
        news1.setBody(news.getBody());
        news1.setImage(news.getImage());

        return  newsRepository.save(news1);
    }
    public News updatePartiallyNews(Long id, News news){
        News news1 = newsRepository.findById(id).get();
        if (news.getTitle() != null) {    news1.setTitle(news.getTitle()); }
        if (news.getBody() != null) {  news1.setBody(news.getBody()); }
        if (news.getImage() != null) { news1.setImage(news.getImage()); }



        return  newsRepository.save(news1);
    }
    public void deleteNews(Long id){

        newsRepository.deleteById(id);
    }


}

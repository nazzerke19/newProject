package com.example.newproject.repository;

import com.example.newproject.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NewsRepository extends JpaRepository<News,Long> {
}

package com.bluecoding.shortener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByUrl(String url);
}

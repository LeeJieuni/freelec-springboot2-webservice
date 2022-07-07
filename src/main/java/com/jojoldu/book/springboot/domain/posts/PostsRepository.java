package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //MyBaits의 Dao역할의 DB Layer 접근자. JPA에서는 Repository라고 부르며 인터페이스로 생성
    // 인터페이스 생성후  JpaRepository<Entity클래스,pk 타입> 상속하면 기본적인 crud 메소드 자동 생성됨.
    // Entity 클래스와 기본 Entity Repository는 함께 위치해야 함.

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

package com.jojoldu.book.springboot.domain.posts;

import com.jayway.jsonpath.internal.function.text.Length;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 getter 메소드 자동생성
@NoArgsConstructor //기본생성자 자동추가 =  public Posts(){}
@Entity //테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어네이밍으로 테이블 이름 매칭함. SalesManager.java -> sales_manager table
public class Posts { //실제 DB 테이블과 매칭될 클래스
    //JPA를 사용하면 DB데이터에 작업할 경우 실제 쿼리를 날리기보다는 이 Entity 클래스 수정을 통해 작업.

    @Id //해당 테이블의 pk필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙. GenerationType.IDENTITY은 auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 컬럼을 나타냄. 굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 됨. 옵션이 필요한 경우 사용
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }



    //Entity 클래스에서는 절대 Setter 메소드 만들지 않음.
    //해당 필드의 값 변경 필요시 명확히 그 목적과 의도 나타낼 수 있는 메소드 추가함.
    //그럼 db에 삽입 방법? -> 생성자 통해 최종값 채운 후 db에 insert.
    //이 책에서는 생성자 대신 @Builder 통해 제공되는 빌더클래스 사용

}

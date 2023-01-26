package com.rest.api.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "posts")
@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @Size(min = 2, message = "Минимальная длина загаловка 2 символа")
    @Size(max = 64, message = "Максимальная длина загаловка 64 символа")
    private String title;

    @Column(name = "text")
    @Size(min = 2, message = "Минимальная длина текста 2 символа")
    @Size(max = 64, message = "Максимальная длина поста 256 символа")
    private String text;

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Post() {
    }
}

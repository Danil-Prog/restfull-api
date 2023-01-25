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
    @Size(min = 8, message = "Минимальная длина загаловка 8 символов")
    @Size(max = 64, message = "Максимальная длина загаловка 64 символа")
    private String title;

    @Column(name = "text")
    @Size(min = 8, message = "Минимальная длина текста 10 символов")
    @Size(max = 64, message = "Максимальная длина поста 256 символа")
    private String text;

}

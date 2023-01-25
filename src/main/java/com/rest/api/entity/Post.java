package com.rest.api.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Table(name = "posts")
@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @Min(value = 8, message = "Минимальная длина загаловка 8 символов")
    @Max(value = 64, message = "Максимальная длина загаловка 64 символа")
    private String title;

    @Column(name = "text")
    @Min(value = 8, message = "Минимальная длина текста 10 символов")
    @Max(value = 64, message = "Максимальная длина поста 256 символа")
    private String text;

}

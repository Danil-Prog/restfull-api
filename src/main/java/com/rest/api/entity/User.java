package com.rest.api.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    @NotEmpty
    @Size(min = 2, message = "Минимальная длина имени 2 символа")
    @Size(max = 30, message = "Максимальная длина имени 30 символов")
    private String firstname;

    @Column(name = "lastname")
    @NotEmpty
    @Size(min = 2, message = "Минимальная длина имени 2 символа")
    @Size(max = 30, message = "Максимальная длина имени 30 символов")
    private String lastname;

    @Column(name = "course")
    @Min(value = 1, message = "Минимальный курс: 1")
    @Max(value = 5, message = "Максимальный курс: 5")
    private int course;

}

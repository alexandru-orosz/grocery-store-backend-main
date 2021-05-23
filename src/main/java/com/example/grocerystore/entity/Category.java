package com.example.grocerystore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "name")
    private String name;

}

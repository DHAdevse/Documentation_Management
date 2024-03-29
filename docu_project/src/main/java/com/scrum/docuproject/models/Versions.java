package com.scrum.docuproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("versions")
public class Versions {

    @Id
    private String id;
    private String nameVer;
    private String link;
    private String date;
    private  String message;
    private double size;
}

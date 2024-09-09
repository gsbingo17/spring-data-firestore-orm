package com.example;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

@Document(collectionName = "myEntities")
public class MyEntity extends BaseEntity {

  @DocumentId
  private String id;
  private String data;

  public MyEntity() {
  }

  public MyEntity(String id, String data) {
    this.id = id;
    this.data = data;
  }

  // getters and setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}

package com.example;

import org.springframework.stereotype.Component;

@Component
public class MyEntityDaoImpl extends BaseFirestoreDaoImpl<MyEntity, String> {

  public MyEntityDaoImpl() {
    super(MyEntity.class);
  }
}

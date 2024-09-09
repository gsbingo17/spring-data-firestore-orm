package com.example;

import java.util.List;

public interface BaseDao<T extends BaseEntity, ID> {
  T save(T entity);
  List<T> findAll();
  T findById(ID id);
}
package com.example;

import com.google.cloud.spring.data.firestore.FirestoreTemplate;
import java.io.Serializable;
import com.google.cloud.firestore.Query;


public interface BaseFirestoreDao<T extends BaseEntity, ID extends Serializable> extends BaseDao<T, ID> {

  public T save(T entity);

  public T findById(ID id);

  public void deleteById(ID id);

}

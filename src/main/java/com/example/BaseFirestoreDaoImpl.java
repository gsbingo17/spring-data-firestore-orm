package com.example;

import com.google.cloud.spring.data.firestore.FirestoreTemplate;
import java.io.Serializable;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public abstract class BaseFirestoreDaoImpl<T extends BaseEntity, ID extends Serializable> implements BaseFirestoreDao<T, ID> {

  @Autowired
  private FirestoreTemplate firestoreTemplate;

  private Class<T> entityClass;

  public BaseFirestoreDaoImpl(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  @Override
  public T save(T entity) {
    return firestoreTemplate.save(entity).block();
  }

  @Override
  public List<T> findAll() {
    Flux<T> entities = firestoreTemplate.findAll(entityClass);
    return entities.toStream().collect(Collectors.toList());
  }

  public T findById(ID id) {
    String iDstring = id.toString();
    Publisher<String> stringPublisher = Flux.just(iDstring);
    return firestoreTemplate.findById(stringPublisher, entityClass).block();
  }

  @Override
  public void deleteById(ID id) {
    String iDstring = id.toString();
    Publisher<String> stringPublisher = Flux.just(iDstring);
    firestoreTemplate.deleteById(stringPublisher, entityClass);
  }
}
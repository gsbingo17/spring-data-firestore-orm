package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
  private final MyEntityDaoImpl myEntityDao;

  @Autowired
  public MyService(MyEntityDaoImpl myEntityDao) {
    this.myEntityDao = myEntityDao;
  }

  public MyEntity save(MyEntity entity) {
    return myEntityDao.save(entity);
  }

  public List<MyEntity> findAll() {
    return myEntityDao.findAll();
  }

  public MyEntity findById(String id) {
    return myEntityDao.findById(id);
  }

  public void deleteById(String id) {
    myEntityDao.deleteById(id);
  }
}

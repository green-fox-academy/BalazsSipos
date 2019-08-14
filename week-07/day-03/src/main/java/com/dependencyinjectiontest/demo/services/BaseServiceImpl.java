package com.dependencyinjectiontest.demo.services;

import com.dependencyinjectiontest.demo.models.MainModel;
import org.springframework.stereotype.Component;

//@Component
public class BaseServiceImpl implements BaseService {
  private MainModel model = new MainModel();

  @Override
  public int getCalledTimes() {
    model.incrementCount();
    return model.getCount();
  }
}
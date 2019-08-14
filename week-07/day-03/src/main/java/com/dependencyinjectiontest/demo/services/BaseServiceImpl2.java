package com.dependencyinjectiontest.demo.services;

import com.dependencyinjectiontest.demo.models.MainModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
public class BaseServiceImpl2 implements BaseService {
  private MainModel model = new MainModel();

  @Override
  public int getCalledTimes() {
    model.incrementCount();
    model.incrementCount();
    return model.getCount();
  }
}
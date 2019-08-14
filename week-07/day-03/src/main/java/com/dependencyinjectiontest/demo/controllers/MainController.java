package com.dependencyinjectiontest.demo.controllers;

import com.dependencyinjectiontest.demo.services.BaseService;
import com.dependencyinjectiontest.demo.services.BaseServiceImpl;
import com.dependencyinjectiontest.demo.services.BaseServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  BaseService baseServiceInstance;

//  @Autowired
//  MainController(BaseService instance){
//    this.baseServiceInstance = instance;
//  }

  MainController(){
    BaseService baseServiceImpl = new BaseServiceImpl();
    this.baseServiceInstance = baseServiceImpl;
  }

  @RequestMapping(value="/")
  @ResponseBody
  public String hw(){
    int count = this.baseServiceInstance.getCalledTimes();
    String returnValue ="Hello World! " + count;
    System.out.println(returnValue);
    return returnValue;
  }
}
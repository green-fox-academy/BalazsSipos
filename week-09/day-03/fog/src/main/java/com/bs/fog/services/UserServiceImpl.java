package com.bs.fog.services;

import com.bs.fog.models.entities.User;
import com.bs.fog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User saveNewUser(User user) {
    this.userRepository.save(user);
    return user;
  }
}

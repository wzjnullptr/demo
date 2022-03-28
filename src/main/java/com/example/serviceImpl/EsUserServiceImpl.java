package com.example.serviceImpl;

import com.example.model.EsUser;
import com.example.repository.UserRepository;
import com.example.service.EsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsUserServiceImpl implements EsUserService {

    @Autowired
    private UserRepository userRepository;

    //查询总数
    @Override
    public long count() {
        return userRepository.count();
    }

    //新增
    @Override
    public EsUser save(EsUser esUser) {
        return userRepository.save(esUser);
    }

    @Override
    public void delete(EsUser esUser) {
        userRepository.delete(esUser);
    }

    //查询全部列表
    @Override
    public Iterable<EsUser> getAll() {
        return userRepository.findAll();
    }
}

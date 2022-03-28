package com.example.service;

import com.example.model.EsUser;

public interface EsUserService {
    long count();

    EsUser save(EsUser esUser);

    void delete(EsUser esUser);

    Iterable<EsUser> getAll();
}

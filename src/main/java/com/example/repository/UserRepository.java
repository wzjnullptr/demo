package com.example.repository;

import com.example.model.EsUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 添加es的操作类
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<EsUser, String> {

}

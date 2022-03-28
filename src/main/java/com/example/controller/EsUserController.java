package com.example.controller;

import com.example.model.EsUser;
import com.example.service.EsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/esuser")
public class EsUserController {

    @Autowired
    private EsUserService esUserService;

    /**
     * 新增
     */
    @RequestMapping("/add")
    public void insert() {
        EsUser esUser = new EsUser();
        esUser.setId(2L);
        esUser.setUsername("李四");
        esUser.setPassword("222");
        esUserService.save(esUser);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void delete() {
        EsUser esUser = new EsUser();
        esUser.setId(1L);
        esUserService.delete(esUser);
    }

    /**
     * 查询所有
     */
    @RequestMapping("/findAll")
    public void findAll() {
        Iterable<EsUser> iterable = esUserService.getAll();
        iterable.forEach(e->System.out.println(e.toString()));
    }

    @RequestMapping("/getCount")
    public void count() {
        esUserService.count();
    }
}

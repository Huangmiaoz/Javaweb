package com.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.controller.utils.R;
import com.entity.Question;
import com.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public R getAll(){
        return new R(true, questionService.list());
    }

//    @PostMapping
//    public R save(@RequestBody Question question) throws IOException {
//        if (question.getName().equals("123") ) throw new IOException();
//        boolean flag = questionService.save(question);
//        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
//    }

    @PutMapping
    public R update(@RequestBody Question question) throws IOException {
        if (question.getQuestion().equals("123") ) throw new IOException();
        boolean flag = questionService.modify(question);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(questionService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, questionService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Question question){
////        System.out.println("参数==>"+book);
//
//        IPage<Question> page = questionService.getPage(currentPage, pageSize,question);
//        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if( currentPage > page.getPages()){
//            page = questionService.getPage((int)page.getPages(), pageSize,question);
//        }
//        return new R(true, page);
//    }

}


















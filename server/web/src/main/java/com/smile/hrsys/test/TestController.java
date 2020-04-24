package com.smile.hrsys.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    /////////////////////////// 测试方法 ////////////////////////////
    @GetMapping("/hello")
    public String hello() {
        return "Hello World.";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }

    @PostMapping("/addbook")
    public Integer addBook(@RequestBody Book book) {

        System.out.println("添加书籍---> " + book);
        return book.getId();
    }

    @PutMapping("/putbook")
    public Integer putBook(@RequestBody Book book) {
        System.out.println("修改书籍---> " + book);
        return book.getId();
    }

    @DeleteMapping("/delbook/{id}")
    public void delBook(@PathVariable Integer id) {
        System.out.println("删除书籍---> " + id);
    }

    /////////////////////////// 测试方法 End ////////////////////////////

}


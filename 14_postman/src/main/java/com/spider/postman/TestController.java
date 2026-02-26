package com.spider.postman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class TestController {
    @GetMapping("/show")
    public String show(@RequestParam  String name, int age) {
        System.out.println("Name: "+ name + " Age: "+ age);              //Name: viraj Age: 25
        return "Name: "+ name+ " Age: "+ age;
    }

    @PostMapping("/register")
    public String register(@RequestBody String obj) {
        System.out.println(obj);
        return obj;
    }
    @PutMapping("/update")
    public String update(@RequestHeader String name, @RequestHeader int age) {
        System.out.println(name + " "+ age);
        return "updation successful... "+ " Name: "+ name + " age: "+ age;
    }

    @DeleteMapping("/delete/{id}/name/{age}")
    public String delete(@PathVariable int id, @PathVariable int age) {
        System.out.println(id);
        System.out.println(age);
        return "deleted successfully, id: " + id + " Age "+ age;
    }
    @PatchMapping("/patch")
    public String patch(@RequestParam String name ,@RequestParam int age) {
        System.out.println(name+ " " + age);
        return "update successfully " +  name + " "+ age;
    }
}

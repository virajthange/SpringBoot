package com.spider.postman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class TestController {
    @GetMapping("/show")
    public String show(@RequestParam(name = "name")  String username, int age) {
        System.out.println("Name: "+ username + " Age: "+ age);              //Name: viraj Age: 25
        return "Name: "+ username+ " Age: "+ age;
    }

    @PostMapping("/register")
    public String register(@RequestBody String obj) {
        System.out.println(obj);
        return obj;
    }
    @PutMapping("/update")
//    We have to match the variable name with key which we pass , but if we don't want to match we can make use of name attribute in @RequestHeader
    public String update(@RequestHeader(name = "name") String myname, @RequestHeader int age) {
        System.out.println(myname + " "+ age);
        return "updation successful... "+ " Name: "+ myname + " age: "+ age;
    }

    @DeleteMapping("/delete/{id}/name/{age}")
    public String delete(@PathVariable int id, @PathVariable int age) {
        System.out.println(id);
        System.out.println(age);
        return "deleted successfully, id: " + id + " Age "+ age;
    }
    @PatchMapping("/patch")
    public String patch(@RequestParam String name ,@RequestParam(name = "age") int userage) {
        System.out.println(name+ " " + userage);
        return "update successfully " +  name + " "+ userage;
    }
}

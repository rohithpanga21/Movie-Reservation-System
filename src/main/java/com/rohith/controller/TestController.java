package com.rohith.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohith.exception.ResourceNotFoundException;

@RestController
public class TestController {
    @GetMapping("/test/notfound")
    public void test() { throw new ResourceNotFoundException("Movie 99 not found"); }
}
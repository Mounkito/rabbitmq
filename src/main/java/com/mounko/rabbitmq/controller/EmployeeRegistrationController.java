package com.mounko.rabbitmq.controller;

import com.mounko.rabbitmq.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableBinding(Source.class)
public class EmployeeRegistrationController {

    @Autowired
    Source source;

    @RequestMapping("/register")
    @ResponseBody
    public String registerEmployee(@RequestBody Employee employee) {
        source.output().send(MessageBuilder.withPayload(employee).build());
        System.out.println(employee.toString());
        return "Employee Registered";
    }

}

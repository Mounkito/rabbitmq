package com.mounko;

import com.mounko.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class RabbitmqConsumerApplication {


	@StreamListener(target = Sink.INPUT)
	public void processRegisterEmployees(Employee employee) {
		System.out.println("Employees Registered by Client " + employee);
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqConsumerApplication.class, args);
	}

}

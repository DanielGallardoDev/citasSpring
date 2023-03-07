package com.helloworld.citasSpring;

import com.helloworld.citasSpring.infra.console.ConsoleReader;
import com.helloworld.citasSpring.repository.Impl.CitaRepositoryMemory;
import com.helloworld.citasSpring.service.Impl.CitaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class CitasSpringApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(CitasSpringApplication.class, args);
		//ConsoleReader consoleReader = new ConsoleReader(new CitaServiceImpl(new CitaRepositoryMemory()));
		//consoleReader.init();
	}

}

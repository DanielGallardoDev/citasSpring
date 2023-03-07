package com.helloworld.citasSpring.infra.console;

import com.helloworld.citasSpring.domain.Cita;
import com.helloworld.citasSpring.service.CitaService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

@Component
public class ConsoleReader {
    CitaService citaService;
    SimpleDateFormat fechaFormateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.forLanguageTag("es_ES"));

    public ConsoleReader(CitaService citaService) {

        this.citaService = citaService;
    }
@PostConstruct
    public void init() throws ParseException {
        Scanner sc = new Scanner(System.in);
        String entradaConsola;
        int opcion = 1;

        while(opcion != 0){
            System.out.println("Menu por consola");
            System.out.println("1.- Registra nueva cita");
            System.out.println("2.- Modificar una cita");
            System.out.println("3.- Borrar una cita");
            System.out.println("4.- Listar todas las citas");
            System.out.println("0.- Salir");
            System.out.println("Ingresa la accion a realizar:");

            entradaConsola = sc.next();

            try{
                opcion= Integer.parseInt(entradaConsola);
            } catch (Exception e){
                System.out.println("OPcion no valida, ingresa un número");
            }

            switch (opcion){
                case 0:
                    System.out.println("Hasta luego!!");
                    break;
                case 1:
                    System.out.println("Ingresa nombre: ");
                    String nombre =  sc.next();;
                    System.out.println("Ingresa apellidos: ");
                    String apellidos =  sc.next();;
                    System.out.println("Ingresa fecha (dd/MM/YYYY hh:mm:ss): ");
                    String fecha =  sc.nextLine();;

                    Date fechaCita;
                    try{
                        fechaCita =fechaFormateador.parse(sc.nextLine());
                        citaService.alta(new Cita(nombre, apellidos, fechaCita));
                    } catch(ParseException e){
                        System.out.println("Formato de fecha no valido");
                    }
                    break;

                case 2:
                    //TODO Por desarrollar
                    break;

                case 3:
                    //TODO Por desarrolla
                    break;

                case 4:
                    List<Cita> citas = citaService.listar();
                    System.out.println("Lista de citas");
                    for (Cita cita: citas){
                        System.out.printf("Id: %s, nombre: %s, apellidos: %s, fecha: %s",
                                citas.indexOf(cita),
                                cita.getNombre(),
                                cita.getApellidos(),
                                fechaFormateador.format(cita.getFecha()));
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

}

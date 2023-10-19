package com.example.demo.prisons;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

@RestController
public class PrisonsController {

    private static ArrayList<Prison> loadAllFromFile() throws FileNotFoundException{
        try(Scanner sc = new Scanner(new File("prisons_Sweden_coordinates.csv"))){
            ArrayList<Prison> result = new ArrayList<>();

            sc.nextLine();

            while(sc.hasNextLine()){
                String line=sc.nextLine();
                String[]parts=line.split(";");
                Prison r =new Prison(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Double.parseDouble(parts[4]),
                        Double.parseDouble(parts[5]));

                result.add(r); }
            return result;
        }
    }



    @GetMapping("prisons")
    public ArrayList<Prison>getAll(
            @RequestParam(name="min-capacity", required=false) Integer minCapacity,
            @RequestParam(name="max-capacity", required=false) Integer maxCapacity
    )throws FileNotFoundException {

        ArrayList<Prison> result = new ArrayList<>();

        for(Prison  prison : loadAllFromFile()){

            if ((minCapacity == null || prison.getCapacity() >= minCapacity) && (maxCapacity == null || prison.getCapacity() <= maxCapacity)) {
                result.add(prison);
            }
        }
        return result;
    }


    @GetMapping("prisons/{id}")
    public Prison getById(
            @PathVariable int id
    ) throws FileNotFoundException {

        for (Prison prison : loadAllFromFile()) {
            if (id== prison.getId()) {
                return prison;
            }
        }
        return null;
    }





    }

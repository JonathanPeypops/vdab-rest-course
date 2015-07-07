package be.vdab.services;

import be.vdab.domain.Car;
import be.vdab.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/car")
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @RequestMapping("{carId}")
    public Car findById(@PathVariable("carId")Integer id)
    {return carRepository.findOne(id);}

    @RequestMapping(value = "/create/car", method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Car car) {
        carRepository.save(car);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location: ","http://localhost:8080/car/" + car.getId());
        return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
    }

    @RequestMapping(value = "{carId}", method = DELETE)
    public void deleteCar(@PathVariable("carId")Integer carId)
    {carRepository.delete(carId);}

    @RequestMapping(value = "update/car", method = PUT, consumes = APPLICATION_JSON_VALUE)
    public void edit(@RequestBody Car car){
        carRepository.save(car);
    }
}
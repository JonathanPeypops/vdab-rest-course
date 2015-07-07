package be.vdab.services;

import be.vdab.domain.Car;
import be.vdab.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @RequestMapping("{carId}")
    public Car findById(@PathVariable("carId")Integer id)
    {return carRepository.findOne(id);}

}

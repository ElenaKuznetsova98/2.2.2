package web.Dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDao {
    private List<Car> carList;

    public CarDao() {
        carList = new ArrayList<>();
        carList.add(new Car("Ford Focus", "black", 2000));
        carList.add(new Car("Ford", "white", 2005));
        carList.add(new Car("Audi", "blue", 2016));
        carList.add(new Car("BMW", "yellow", 2020));
        carList.add(new Car("Volvo", "grey", 2010));
    }

    public List<Car> getCars(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}

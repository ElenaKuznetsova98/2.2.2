package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.Dao.CarDao;
import web.model.Car;
import java.util.List;


@Component
public class CarService {
    @Autowired
    private CarDao carDao;

    public List<Car> getCars(int count) {
        return carDao.getCars(count);
    }
}

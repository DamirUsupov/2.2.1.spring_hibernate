package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private hiber.dao.CarDao CarDao;

    @Transactional
    @Override
    public void add(Car car) {
        CarDao.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return CarDao.listCars();
    }

    @Override
    public User getUserBySeries(int series, String number) {
        return CarDao.getUserBySeries(series, number);
    }


}

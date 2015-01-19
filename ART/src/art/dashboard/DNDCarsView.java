package art.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import art.datastructures.Car;

@ManagedBean(name = "dndCarsView")
@ViewScoped
public class DNDCarsView implements Serializable {
	@ManagedProperty("#{carService}")
 
    private List<Car> cars = new ArrayList<Car>();
     
    private List<Car> droppedCars;
     
    private Car selectedCar;
     
    @PostConstruct
    public void init() {
    	cars.add(new Car("Ford"));
    	cars.add(new Car("Lamborghini"));
    	cars.add(new Car("Maruthi"));
        droppedCars = new ArrayList<Car>();
    }
     
    public void onCarDrop(DragDropEvent ddEvent) {
        Car car = ((Car) ddEvent.getData());
  
        droppedCars.add(car);
        cars.remove(car);
    }
     
     public List<Car> getCars() {
        return cars;
    }
 
    public List<Car> getDroppedCars() {
        return droppedCars;
    }   
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}


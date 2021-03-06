package tests;

import models.Car;
import models.CarNew;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        //login
    }

    @Test
    public void addNewCarSuccess(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car = new Car()
                .withAddress("Tel Aviv, Israel")
                .withMake("BMW")
                .withModel("M5")
                .withYear("2020")
                .withEngine("2.3")
                .withFuel("Petrol")
                .withGear("MT")
                .withwD("AWD")
                .withDoors("5")
                .withSeats("4")
                .withClasS("C")
                .withFuelConsumption("6.5")
                .withCarRegNumber("100-66-"+i)
                .withPrice("65")
                .withDistanceIncluded("500")
                .withTypeFeature("type of")
                .withAbout(" Very good car");

        app.car().initAddingnewCar();
        app.car().fillCarForm(car);
        app.car().attachPhoto();
        app.car().clickButtonSubmit();

//        Assert.assertTrue(app.car().isCarAdded());

    }
    @Test
    public void addNewCarSuccessModelVarNew(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        CarNew car= CarNew.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.0")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("102-67-"+ i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("Very good car")
                .build();


        app.car().initAddingnewCar();
        app.car().fillCarForm(car);
        // app.car().attachPhoto();
        //app.car().clickButtonSubmit();

        //Assert.assertTrue(app.car().isCarAdded());
    }

}

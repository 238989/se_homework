package FactoryMethod;

public class ChongqingMaterial implements CityMaterial{
    @Override
    public void AddMaterial() {
        System.out.println("重庆火锅是香辣！");
    }
}

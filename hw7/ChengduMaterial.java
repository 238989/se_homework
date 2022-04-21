package FactoryMethod;

public class ChengduMaterial implements CityMaterial{
    @Override
    public void AddMaterial() {
        System.out.println("成都火锅是麻辣!");
    }
}

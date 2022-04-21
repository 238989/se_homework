package FactoryMethod;

public abstract class HotPot {

    public abstract CityMaterial AddMainMaterial();

    public void AddOtherMaterial(){
        System.out.println("添加水、蔬菜、荤菜");
    };
}

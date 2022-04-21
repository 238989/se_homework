package FactoryMethod;

public class ChongqingYuanyangHotPot extends HotPot{
    @Override
    public CityMaterial AddMainMaterial() {
        System.out.println("一半清汤，一半红汤！");
        return new ChongqingMaterial();
    }

    @Override
    public void AddOtherMaterial() {
        System.out.println("添加水、蔬菜、荤菜");
    }
}

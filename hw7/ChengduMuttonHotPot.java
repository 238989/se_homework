package FactoryMethod;

public class ChengduMuttonHotPot extends HotPot{

    @Override
    public CityMaterial AddMainMaterial() {
        System.out.println("麻辣口味！");
        return new ChengduMaterial();
    }

    @Override
    public void AddOtherMaterial() {
        super.AddOtherMaterial();
    }
}

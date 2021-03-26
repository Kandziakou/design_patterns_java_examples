package creationalPatterns;

public class FactoryMethodExample{
    private final CheeseFactory cheeseFactory = new CheeseFactory();
    private final SnackFactory snackFactory = new SnackFactory();
    private Cheese cheese;
    private Snacks snack;

    private void create(String cheeseName, String snackName){
        cheese = (Cheese) cheeseFactory.create(cheeseName);
        snack = (Snacks) snackFactory.create(snackName);
    }

    private void getFoodNames(){
        System.out.println(cheese.getFoodName());
        System.out.println(snack.getFoodName());
    }

    public void main(String[] args) {
        create("creamcheese", "loaf");
        getFoodNames();
    }
}

interface Food {
    String getFoodName();
}

class Cheese implements Food {
    String foodName = "";

    public Cheese(String name){
        this.foodName = name;
    }

    @Override
    public String getFoodName(){
        return foodName;
    }
}

class Snacks implements Food {
    String foodName = "";

    public Snacks(String name){
        this.foodName = name;
    }

    @Override
    public String getFoodName(){
        return foodName;
    }
}

interface Factory{
    Food create(String name);
    default String getName(Food food){
        return food.getFoodName();
    }
}

class CheeseFactory implements Factory{

    @Override
    public Food create(String name) {
        return new Cheese(name);
    }
}

class SnackFactory implements Factory{

    @Override
    public Food create(String name) {
        return new Snacks(name);
    }
}

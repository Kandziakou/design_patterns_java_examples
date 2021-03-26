package creationalPatterns;

public class AbstractFactoryExample {
    private final ConcreteFactory factory = new ConcreteFactory();
    private final ConcreteProduct product = new ConcreteProduct();

    public void main(String[] args) {
        product.init("name");
        factory.method(product.getName());
    }
}

interface AbstractFactory {
    void method(String product);
}

interface AbstractProduct {
    void init(String name);
    String getName();
}

class ConcreteFactory implements AbstractFactory {

    @Override
    public void method(String product){
        System.out.println(product);
    }
}

class ConcreteProduct implements AbstractProduct{
    private String name;

    @Override
    public void init(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
}

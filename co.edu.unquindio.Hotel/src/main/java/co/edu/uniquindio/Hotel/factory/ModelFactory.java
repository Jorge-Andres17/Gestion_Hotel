package co.edu.uniquindio.Hotel.factory;

public class ModelFactory {
    private ModelFactory instance;

    public ModelFactory(){}

    public ModelFactory getInstance(){
        if (instance == null){
            instance = new ModelFactory();
        }

        return instance;
    }


}

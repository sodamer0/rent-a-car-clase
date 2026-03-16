package repository;

import model.Model;

import java.util.ArrayList;

public class ModelRepository implements IModelRepository {

    private ArrayList<Model> models;
    private static ModelRepository modelRepository;

    private ModelRepository() {
        models = new ArrayList<>();
    }

    public static ModelRepository getModelRepository() {
        if(modelRepository == null){
            modelRepository = new ModelRepository();
        }
        return modelRepository;
    }

    public void add(Model model){
        model.setId(nextIdAvailable());
        models.add(model);
    }

    public void update(Model model){
        models.set(models.indexOf(findById(model.getId())), model);
    }

    public ArrayList findAll(){
        return models;
    }

    public void deleteById(Long id){
        for (Model model : models) {
            if (model.getId() == id) {
                models.remove(model);
                break;
            }
        }
    }

    public Long nextIdAvailable(){
        if(!models.isEmpty()){
            return models.get(models.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    public Model findById(Long id) {
        for (Model model : models) {
               if(model.getId() == id){
                   return model;
               }
        }
        return null;
    }


}

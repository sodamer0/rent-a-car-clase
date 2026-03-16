package repository;

import model.Model;

import java.util.ArrayList;

public interface IModelRepository {
    void add(Model model);
    void deleteById(Long id);
    ArrayList findAll();
    Model findById(Long id);
    void update(Model model);
}

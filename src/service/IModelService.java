package service;

import model.Model;

import java.util.ArrayList;

public interface IModelService {
    Model findById(Long id);
    void add(String name, int pricePerDay);
    void deleteById(Long id);
    ArrayList findAll();
    void update(Long id, String name, int pricePerDay);

}

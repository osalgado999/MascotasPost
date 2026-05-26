package com.example.MascotasPost.services;
import com.example.MascotasPost.dao.Pets;
import com.example.MascotasPost.dao.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private PetRepository productRepository;

    public List<Pets> findAll(){
        return productRepository.findAll();
    }

    public Optional<Pets> findById(Long id){
        return productRepository.findById(id);
    }

    public Pets add(Pets product){
        return this.productRepository.add(product);
    }

    public Pets update(Pets product){
        return this.productRepository.update(product);
    }

    public void delete(Pets product){
        this.productRepository.delete(product);
    }
}

package com.example.MascotasPost.dao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class PetRepository {
    private List<Pets> products;

    public PetRepository(){
        this.products = buildFakeProducts();
    }

    private List<Pets> buildFakeProducts(){
        Pets p1 = new Pets();
        p1.setId(1L);
        p1.setName("Rufo");
        p1.setStatus("Avaibable");
        Pets p2 = new Pets();
        p2.setId(2L);
        p2.setName("Luna");
        p2.setStatus("Avaibable");
        Pets p3 = new Pets();
        p3.setId(3L);
        p3.setName("Otto");
        p3.setStatus("Avaibable");
        Pets p4 = new Pets();
        p4.setId(5L);
        p4.setName("Saw");
        p4.setStatus("Avaibable");;
        Pets p5 = new Pets();
        p5.setId(6L);
        p5.setName("Lisa");
        p5.setStatus("Avaibable");;

        List<Pets> fakeProducts = new ArrayList<>();
        fakeProducts.add(p1);
        fakeProducts.add(p2);
        fakeProducts.add(p3);
        fakeProducts.add(p4);
        fakeProducts.add(p5);
        return fakeProducts;
    }
    public List<Pets> findAll(){
        return this.products;
    }

    public Optional<Pets> findById(Long id){
        Optional<Pets> ret = Optional.empty();
        List<Pets> filteredProducts = this.products.stream().filter(p -> Objects.equals(p.getId(), id)).collect(Collectors.toList());
        if(!filteredProducts.isEmpty()){
            ret = Optional.of(filteredProducts.get(0));
        }
        return ret;
    }

    public Pets add(Pets product){
        Long maxId = findMaxId();
        product.setId(maxId + 1);
        this.products.add(product);
        return product;
    }

    public Pets update(Pets product){
        int index = this.indexOf(product);
        this.products.set(index, product);
        return product;
    }

    public void delete(Pets product){
        int index = this.indexOf(product);
        this.products.remove(index);
    }
    private Long findMaxId() {
        return this.products.stream().map(Pets::getId).reduce(Long::max).orElse(0L);
    }
    private int indexOf(Pets product) {
        int index = 0;
        for (Pets p:this.products) {
            if(Objects.equals(product.getId(), p.getId()))
                return index;
            index++;
        }
        return -1;
    }
}
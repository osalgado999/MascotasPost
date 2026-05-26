package com.example.MascotasPost.dao;

public class Pets {
    private Long id;
    private String name;
    private String status;

    private String transaccion;

    private String dateCreated;



    public void setId(Long id) {

        this.id = id;
    }
    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public String getTransaccion() {
        return transaccion;
    }
}

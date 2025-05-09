package com.std.ec.controller;

import java.io.Serializable;

import org.primefaces.event.FlowEvent;

import com.std.ec.models.User;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class UserWizard implements Serializable {

    private User user = new User();

    private boolean skip;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void save() {

        System.out.println("User Name: " + user.getFirstname() + " " + user.getLastname());
        System.out.println("User Age: " + user.getAge());
        System.out.println("User Address: " + user.getStreet() + ", " + user.getCity() + ", " + user.getPostalCode());
        System.out.println("User Info: " + user.getInfo());
        System.out.println("User Email: " + user.getEmail());
        System.out.println("User Phone: " + user.getPhone());
        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}
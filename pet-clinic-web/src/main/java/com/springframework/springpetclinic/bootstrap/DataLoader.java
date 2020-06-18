package com.springframework.springpetclinic.bootstrap;

import com.springframework.springpetclinic.model.Owner;
import com.springframework.springpetclinic.model.PetType;
import com.springframework.springpetclinic.model.Vet;
import com.springframework.springpetclinic.services.OwnerService;
import com.springframework.springpetclinic.services.PetTypeService;
import com.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Rock");
        owner1.setLastName("West");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Water");
        owner2.setLastName("East");

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Samie");
        vet1.setLastName("Lake");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("James");
        vet2.setLastName("Layon");

        vetService.save(vet2);


        System.out.println("Loaded Vets...");
    }
}

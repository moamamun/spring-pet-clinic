package com.springframework.springpetclinic.bootstrap;

import com.springframework.springpetclinic.model.*;
import com.springframework.springpetclinic.services.OwnerService;
import com.springframework.springpetclinic.services.PetTypeService;
import com.springframework.springpetclinic.services.SpecialtyService;
import com.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.getDescription("Radiology");
        Speciality saveRadiology = specialitiesService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.getDescription("Dentistry");
        Speciality saveDentistry = specialitiesService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.getDescription("Surgery");
        Speciality saveSurgery = specialitiesService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Rock");
        owner1.setLastName("West");
        owner1.setAddress("123 Bekker");
        owner1.setCity("Fl");
        owner1.setTelephone("1231231234");

        Pet rocksPet = new Pet();
        rocksPet.setPetType(saveDogPetType);
        rocksPet.setOwner(owner1);
        rocksPet.setBirthDate(LocalDate.now());
        rocksPet.setName("Rolla");
        owner1.getPets().add(rocksPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Water");
        owner2.setLastName("East");
        owner2.setAddress("123 Bekker");
        owner2.setCity("Fl");
        owner2.setTelephone("1231231234");

        Pet waterCat = new Pet();
        waterCat.setName("Kitty");
        waterCat.setOwner(owner2);
        waterCat.setBirthDate(LocalDate.now());
        waterCat.setPetType(saveCatPetType);
        owner2.getPets().add(waterCat);
        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Samie");
        vet1.setLastName("Lake");
        vet1.getSpecialities().add(saveDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("James");
        vet2.setLastName("Layon");
        vet2.getSpecialities().add(saveRadiology);

        vetService.save(vet2);


        System.out.println("Loaded Vets...");
    }
}

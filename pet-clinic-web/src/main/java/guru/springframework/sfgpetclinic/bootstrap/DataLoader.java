package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
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
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("michael");
        owner1.setLastName("Watson");
        owner1.setAdress("123 miami");
        owner1.setCity("Miami");
        owner1.setTelephone("123 123 123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Adam");
        owner2.setLastName("Watson");
        owner2.setAdress("123 new york");
        owner2.setCity("MY");
        owner2.setTelephone("124 124 124");

        Pet adamsCat = new Pet();
        adamsCat.setPetType(cat);
        adamsCat.setName("max");
        adamsCat.setBirthDate(LocalDate.now());
        adamsCat.setOwner(owner2);
        owner1.getPets().add(adamsCat);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Peter");
        owner3.setLastName("Watson");

        ownerService.save(owner3);
        System.out.println("LOoaded owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("sam");
        vet1.setLastName("harr");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("andrew");
        vet2.setLastName("harr");
        vetService.save(vet2);
        vet2.getSpecialities().add(savedDentistry);

        System.out.println("LOoaded vets");
    }
}

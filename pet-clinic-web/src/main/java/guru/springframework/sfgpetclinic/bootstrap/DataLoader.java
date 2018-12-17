package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
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
        owner1.setFirstName("michael");
        owner1.setLastName("Watson");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Adam");
        owner2.setLastName("Watson");

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

        Vet vet2 = new Vet();
        vet2.setFirstName("andrew");
        vet2.setLastName("harr");
        vetService.save(vet2);

        System.out.println("LOoaded vets");


    }
}

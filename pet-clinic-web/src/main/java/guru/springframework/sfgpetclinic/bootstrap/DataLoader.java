package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("michael");
        owner1.setLastName("Watson");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Adam");
        owner2.setLastName("Watson");
        owner2.setId(2L);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Peter");
        owner3.setLastName("Watson");
        owner3.setId(3L);

        ownerService.save(owner3);
        System.out.println("LOoaded owners");


        Vet vet1 = new Vet();
        vet1.setFirstName("sam");
        vet1.setId(1L);
        vet1.setLastName("harr");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("andrew");
        vet2.setId(2L);
        vet2.setLastName("harr");
        vetService.save(vet2);

        System.out.println("LOoaded vets");
    }
}

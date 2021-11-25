package guru.springframework.sfgpetclinic.bootstrap;

import com.deniz.sfgpetclinic.model.Owner;
import com.deniz.sfgpetclinic.model.Vet;
import com.deniz.sfgpetclinic.services.OwnerService;
import com.deniz.sfgpetclinic.services.VetService;
import com.deniz.sfgpetclinic.services.map.OwnerServiceMap;
import com.deniz.sfgpetclinic.services.map.VetServiceMap;
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
    public void run(String... args) {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Deniz");
        owner1.setLastName("Salman");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Burcu");
        owner2.setLastName("Salman");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Memo");
        vet1.setLastName("Salman");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Bediha");
        vet2.setLastName("Salman");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}

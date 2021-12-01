package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Deniz");
        owner1.setLastName("Salman");
        owner1.setAddress("11 address");
        owner1.setCity("Ankara");
        owner1.setTelephone("4645656465");

        Pet denizsPet = new Pet();
        denizsPet.setPetType(savedDogPetType);
        denizsPet.setOwner(owner1);
        denizsPet.setBirthDate(LocalDate.now());
        denizsPet.setName("Lassie");
        owner1.getPets().add(denizsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Burcu");
        owner2.setLastName("Salman");
        owner2.setAddress("12 address");
        owner2.setCity("Ankara");
        owner2.setTelephone("5646545");

        Pet burcusCat = new Pet();
        burcusCat.setName("Just Cat");
        burcusCat.setOwner(owner2);
        burcusCat.setBirthDate(LocalDate.now());
        burcusCat.setPetType(savedCatPetType);
        owner2.getPets().add(burcusCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Memo");
        vet1.setLastName("Salman");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bediha");
        vet2.setLastName("Salman");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}

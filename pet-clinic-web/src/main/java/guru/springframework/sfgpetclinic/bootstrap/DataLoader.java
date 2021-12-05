package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(burcusCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Memo");
        vet1.setLastName("Salman");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bediha");
        vet2.setLastName("Salman");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}

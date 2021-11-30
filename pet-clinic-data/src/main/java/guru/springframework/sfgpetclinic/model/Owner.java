package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * @author deniz
 * 04/11/2021
 */
public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}

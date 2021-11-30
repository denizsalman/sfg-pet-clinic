package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * @author deniz
 * 04/11/2021
 */
public class Vet extends Person {

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}

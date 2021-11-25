package guru.springframework.sfgpetclinic.model;

/**
 * @author deniz
 * 04/11/2021
 */
public class PetType extends BaseEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

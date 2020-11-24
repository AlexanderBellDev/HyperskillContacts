package contacts;

import java.time.LocalDateTime;
import java.util.List;

public class PersonContact extends Contact {
    private String firstName;
    private String surname;
    private String gender;
    private String birthdate;

    public PersonContact(String phoneNumber, boolean isPerson, String firstName, String surname, String gender, String birthdate) {
        super(phoneNumber, isPerson, LocalDateTime.now().withSecond(0).withNano(0),LocalDateTime.now().withSecond(0).withNano(0));
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        if(firstName == null || firstName.isEmpty()){
            return "[no data]";
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        if(surname == null || surname.isEmpty()){
            return "[no data]";
        }
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        if(gender == null || gender.isEmpty()){
            return "[no data]";
        }
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        if(birthdate == null || birthdate.isEmpty()){
            return "[no data]";
        }
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public List<String> getListOfModifiableFields() {
        return List.of("name","surname","birth","gender","number");
    }

    @Override
    public String printListOfModifiableFields() {
        return "name, surname, birth, gender, number";
    }

    @Override
    public void modifyField(String fieldToChange, String newValue) {
        switch (fieldToChange){
            case "name":
                this.firstName = newValue;
                break;
            case "surname":
                this.surname = newValue;
                break;
            case "gender":
                this.gender = newValue;
                break;
            case "birth":
                this.birthdate = newValue;
        }
    }

    @Override
    public String getField(String fieldToGet) {
        switch (fieldToGet){
            case "name":
                return this.firstName;
            case "surname":
                return this.surname;
            case "gender":
                return this.gender;
            case "birth":
                return this.birthdate;
        }

        return "";
    }

    @Override
    public String getName() {
        return this.firstName + " " + this.surname;
    }

    @Override
    public String getDetails() {
        return "Name: " + this.getFirstName() + "\n" + "Surname: " + this.getSurname() + "\n" +
                "Birth date: " + this.getBirthdate() + "\n" + "Gender: " + this.getGender() + "\n" +
                "Number: " + this.getPhoneNumber() + "\n" + "Time created: " + this.getCreationTimestamp() + "\n" +
                "Time last edit: " + this.getLastEditTimestamp();
    }


}

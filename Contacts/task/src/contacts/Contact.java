package contacts;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static contacts.Util.isValid;


public abstract class Contact {
    private String phoneNumber;
    private boolean isPerson;
    private LocalDateTime creationTimestamp;
    private LocalDateTime lastEditTimestamp;

    public Contact(String phoneNumber, boolean isPerson, LocalDateTime creationTimestamp, LocalDateTime lastEditTimestamp) {
        this.phoneNumber = phoneNumber;
        this.isPerson = isPerson;
        this.creationTimestamp = creationTimestamp;
        this.lastEditTimestamp = lastEditTimestamp;
    }

    public abstract List<String> getListOfModifiableFields();

    public abstract String printListOfModifiableFields();

    public abstract void modifyField(String fieldToChange, String newValue);

    public abstract String getField(String fieldToGet);

    public abstract String getName();

    public abstract String getDetails();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        boolean valid = isValid(phoneNumber);
        if(!valid){
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }else {
            this.phoneNumber = phoneNumber;
        }
    }

    public boolean isPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public LocalDateTime getLastEditTimestamp() {
        return lastEditTimestamp;
    }

    public void setLastEditTimestamp(LocalDateTime lastEditTimestamp) {
        this.lastEditTimestamp = lastEditTimestamp;
    }

    public boolean hasNumber(){
        return !this.phoneNumber.isEmpty();
    }
}

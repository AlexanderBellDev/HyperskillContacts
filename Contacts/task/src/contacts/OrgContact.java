package contacts;

import java.time.LocalDateTime;
import java.util.List;

public class OrgContact extends Contact {
    String organizationName;
    String address;

    public OrgContact(String phoneNumber, boolean isPerson, String organizationName, String address) {
        super(phoneNumber, isPerson, LocalDateTime.now().withSecond(0).withNano(0), LocalDateTime.now().withSecond(0).withNano(0));
        this.organizationName = organizationName;
        this.address = address;
    }

    public String getOrganizationName() {
        if (organizationName == null || organizationName.isEmpty()) {
            return "[no data]";
        }
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        if (address == null || address.isEmpty()) {
            return "[no data]";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public List<String> getListOfModifiableFields() {
        return List.of("address", "name", "number");
    }

    @Override
    public String printListOfModifiableFields() {
        return "name, address, number";
    }

    @Override
    public void modifyField(String fieldToChange, String newValue) {
        switch (fieldToChange) {
            case "name":
                this.organizationName = newValue;
                break;
            case "address":
                this.address = newValue;
        }
    }

    @Override
    public String getField(String fieldToGet) {
        switch (fieldToGet) {
            case "name":
                return this.organizationName;
            case "address":
                return this.address;
        }

        return "";
    }

    @Override
    public String getName() {
        return this.organizationName;
    }

    @Override
    public String getDetails() {
        return "Organization name: " + this.getOrganizationName() + "\n" + "Address: " + this.getAddress() + "\n" +
                "Number: " + this.getPhoneNumber() + "\n" + "Time created: " + this.getCreationTimestamp() + "\n" +
                "Time last edit: " + this.getLastEditTimestamp();
    }
}

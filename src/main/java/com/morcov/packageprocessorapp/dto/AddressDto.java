package com.morcov.packageprocessorapp.dto;

public class AddressDto {

    private static final String v1 = "ATTN";
    private static final String v2 = "FAO";

    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private final String postcode;
    private final String country;

    public AddressDto(String addressLine1, String addressLine2, String addressLine3, String addressLine4, String addressLine5,
                      String postcode, String country) throws Exception {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.addressLine4 = addressLine4;
        this.addressLine5 = addressLine5;
        this.postcode = postcode;
        this.country = country;
        fixAddress();
        validateAddress();
    }

    private void validateAddress() throws Exception {
        if ((addressLine1 == null || addressLine1.isEmpty()) &&
                (addressLine2 == null || addressLine2.isEmpty()) &&
                (addressLine3 == null || addressLine3.isEmpty()) &&
                (addressLine4 == null || addressLine4.isEmpty()) &&
                (addressLine5 == null || addressLine5.isEmpty()) ||
                (postcode.isEmpty() || country.isEmpty())){
            throw new Exception("no values ");
        }
    }

    private void fixAddress() {
        String currentValue = addressLine1;
        if (!addressLine1.contains(v1) || !addressLine1.contains(v2)){
            if (addressLine2.contains(v1) || addressLine2.contains(v2)){
                addressLine1 = addressLine2;
                addressLine2 = currentValue;
            }
            else if (addressLine3.contains(v1) || addressLine3.contains(v2)){
                addressLine1 = addressLine3;
                addressLine3 = currentValue;
            }
            else if (addressLine4.contains(v1) || addressLine4.contains(v2)){
                addressLine1 = addressLine4;
                addressLine4 = currentValue;
            }
            else if (addressLine5.contains(v1) || addressLine5.contains(v2)){
                addressLine1 = addressLine5;
                addressLine5 = currentValue;
            }
        }


    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public String getAddressLine5() {
        return addressLine5;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

//    public class AddressBuilder build(String addressLine1, String addressLine2, String addressLine3, String addressLine4, String addressLine5, String postcode, String country){
//
//
//
//        if (addressLine1.contains(v1) || addressLine1.contains(v2)){
//            return
//        }
//
//    }


    @Override
    public String toString() {
        return "AddressDto{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                ", addressLine4='" + addressLine4 + '\'' +
                ", addressLine5='" + addressLine5 + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

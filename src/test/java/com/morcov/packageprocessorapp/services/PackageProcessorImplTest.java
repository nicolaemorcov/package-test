package com.morcov.packageprocessorapp.services;

import com.morcov.packageprocessorapp.dto.AddressDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PackageProcessorImplTest {

    @Autowired
    private PackageProcessorImpl packageProcessor;

    @Test
    void testPackageAddressIsValid() throws Exception {
        AddressDto addressDto = new AddressDto("Crossflight Limited", "ATTN: Guy Dawson", "Crossflight House",
                "Skyway 14", "Colnbrook", "SL3 0BQ",
                "United Kingdom");
        AddressDto updatedAddressDto = packageProcessor.processPackage(addressDto);
        assertTrue(updatedAddressDto.getAddressLine1().contains("ATTN") || updatedAddressDto.getAddressLine1().contains("FAO"));

    }


    @Test
    void testUpdatedPackageAddress() throws Exception {
        AddressDto addressDto = new AddressDto("Crossflight Limited", "ATTN: Guy Dawson", "Crossflight House",
                "Skyway 14", "Colnbrook", "SL3 0BQ",
                "United Kingdom");
        AddressDto updatedAddressDto = packageProcessor.processPackage(addressDto);
        assertTrue(updatedAddressDto.getAddressLine1().contains("ATTN") || updatedAddressDto.getAddressLine1().contains("FAO"));
    }

    @Test
    public void testWhenAddressNotValid() {
        assertThrows(Exception.class,
                () -> {
                    AddressDto addressDto2 = new AddressDto("Crossflight Limited", "Guy Dawson", "Crossflight House",
                            "Skyway 14", "Colnbrook", "SL3 0BQ",
                            "");
                    packageProcessor.processPackage(addressDto2);
                });
    }

}
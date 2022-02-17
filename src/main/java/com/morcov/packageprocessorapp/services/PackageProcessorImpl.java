package com.morcov.packageprocessorapp.services;

import com.morcov.packageprocessorapp.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class PackageProcessorImpl implements PackageProcessor {

    public AddressDto processPackage(AddressDto addressDto) {
            return addressDto;
    }


}

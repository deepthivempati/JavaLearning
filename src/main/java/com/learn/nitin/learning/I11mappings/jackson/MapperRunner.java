package com.learn.nitin.learning.I11mappings.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.nitin.learning.I11mappings.jackson.model.Address;
import com.learn.nitin.learning.I11mappings.jackson.model.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class MapperRunner {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        URL url = new URL("file:src/main/resources/mapper.json");
        Employee employee = mapper.readValue(url, Employee.class);

        List<Address> emptyFilteredAddresses = employee.getAddresses()
                .stream()
                .filter(singleAddress -> filterAddress(singleAddress))
                .collect(Collectors.toList());

        //employee.setAddresses(emptyFilteredAddresses);
        String convertedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

        System.out.println(convertedJson);
    }

    private static boolean filterAddress(Address singleAddress) {
        return (null != singleAddress.getAddressLine1() &&
                null != singleAddress.getAddressLine2() &&
                null != singleAddress.getCity() &&
                null != singleAddress.getState() &&
                null != singleAddress.getZip()
        );
    }
}

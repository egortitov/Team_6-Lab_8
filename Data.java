package com.company.hashtable;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Data {
    private final int city;
    private final String streetAddress;
    private final int phone;

    public Data(int city, String streetAddress, int phone) {
        this.city = city;
        this.streetAddress = streetAddress;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return city == data.city &&
                phone == data.phone &&
                Objects.equals(streetAddress, data.streetAddress);
    }

    @Override
    public int hashCode() {
        return 31 * city * phone + streetAddress.getBytes(StandardCharsets.UTF_8)[0];
    }
}

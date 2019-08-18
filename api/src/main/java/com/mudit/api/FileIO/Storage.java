package com.mudit.api.FileIO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Storage implements Serializable {

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Storage() {
        this.data = new ArrayList<>();
    }

    public Storage(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        private String serviceName;

        private String salting;

        private byte[] password;

        public Data(String serviceName, String salting, byte[] password) {
            this.serviceName = serviceName;
            this.salting = salting;
            this.password = password;
        }

        public Data() {
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getSalting() {
            return salting;
        }

        public void setSalting(String salting) {
            this.salting = salting;
        }

        public byte[] getPassword() {
            return password;
        }

        public void setPassword(byte[] password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Storage{" +
                    "serviceName='" + serviceName + '\'' +
                    ", salting='" + salting + '\'' +
                    ", password=" + Arrays.toString(password) +
                    '}';
        }
    }


}

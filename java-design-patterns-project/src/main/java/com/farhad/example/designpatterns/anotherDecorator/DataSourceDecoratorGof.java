package com.farhad.example.designpatterns.anotherDecorator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// compress and encrypt sensitive data independently from the code that actually uses this data.
// See https://refactoring.guru/design-patterns/decorator
public class DataSourceDecoratorGof {

    @RequiredArgsConstructor
    static class EncryptedData implements Data {
        private final Data data;
    }

    @RequiredArgsConstructor
    static class CompressedData implements Data {
        private final Data data;
    }

    @RequiredArgsConstructor
    static class RawData implements Data {
        private final Data data;
    }

    interface Data extends Serializable {
    }

    @NoArgsConstructor
    @lombok.Data
    @AllArgsConstructor
    static class Bill implements Serializable {
        private String billNo;
        private String buyerName;
    }
    interface   DataSource {
        void writeData(Data data);
        Data readData();
    }

    @RequiredArgsConstructor
    static  class FileDataSource implements DataSource {
        private final String filename;

        private Path file;
        
        private void openOrCreate(Path path) throws IOException {
            file = Paths.get(filename);
            if (Files.notExists(path)) {
                file = Files.createFile(path);
            }
        }
        @Override
        public void writeData(Data data) {
            // FileWriter writer = new FileWriter(file.toFile());
            // writer.
        }

        @Override
        public Data readData() {
            return null;
        }
    }
    
    @RequiredArgsConstructor
    static class DataSourceDecorator implements DataSource {
        private final DataSource dataSource;

        @Override
        public void writeData(Data data) {
            dataSource.writeData(data);
        }

        @Override
        public Data readData() {
            return dataSource.readData();
        }
    }

    static class CompressionDecorator extends DataSourceDecorator {

        public CompressionDecorator(DataSource dataSource) {
            super(dataSource);
        }

        @Override
        public Data readData() {
            Data data =  super.readData();
            data = deCompressData(data);
            return data;
        }

        private Data deCompressData(Data data) {
            return new RawData(data);
        }

        @Override
        public void writeData(Data data) {
            data = compressData(data);
            super.writeData(data);
        }

        private Data compressData(Data data) {
            return new CompressedData(data);
        }
    }

    static class EncryptionDecorator extends DataSourceDecorator {

        public EncryptionDecorator(DataSource dataSource) {
            super(dataSource);
        }

        @Override
        public Data readData() {
            Data data =  super.readData();
            data = decryptData(data);
            return data;
        }

        private Data decryptData(Data data) {
            return new RawData(data);
        }

        @Override
        public void writeData(Data data) {
            data = encryptData(data);
            super.writeData(data);
        }

        private Data encryptData(Data data) {
            return new EncryptedData(data);
        }
    }

    static class App {

        public void dump() {
            DataSource source = new FileDataSource("dump.dat");
            // Data data = new Ra
            source.writeData(null);
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            try {

                Path file = Paths.get("file.dat");
                Files.deleteIfExists(file);
                file = Files.createFile(file);
                try (
                    FileOutputStream f = new FileOutputStream(file.toFile());
                    GZIPOutputStream g = new GZIPOutputStream(f);
                    ObjectOutputStream o = new ObjectOutputStream(g);
                ) {
                    
                    Bill bill = new Bill("1234", "farhad");
                    o.writeObject(bill);
                    o.flush();
                } 

                try (
                    FileInputStream f = new FileInputStream(file.toFile());
                    GZIPInputStream g = new GZIPInputStream(f);
                    ObjectInputStream o = new ObjectInputStream(g);
                ) {
                    Bill bill = (Bill) o.readObject();
                    System.out.println(bill);
                }

                Files.deleteIfExists(file);
            } finally {

            }
        }
    }


}

package com.farhad.example.designpatterns.anotherspecification;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchProductService {
    
    private final ProductRepository repository;

    public List<Product> findBy(double maxPrice, float minScreenSize) {
        return findBy(repository.findAll(), maxPrice, minScreenSize);
    } 

    private List<Product> findBy(List<Product> products, double maxPrice, float minScreenSize) {
        return products.stream()
                    .filter(p -> p.getPrice() < maxPrice)
                    .filter(Television.class::isInstance)                           
                    .map( p -> (Television) p)
                    .filter(t -> t.getScreenSize() > minScreenSize)
                    .collect(toList());
    }

    public List<Product> findBy(Resolution resolution, int availableUnits ) {
        return findBy(repository.findAll(), resolution, availableUnits);
    }

    private List<Product> findBy(List<Product> products, Resolution resolution, int availableUnits ) {
        return products.stream()
                    .map(p -> (Television) p)
                    .filter(t -> t.getResolution() == resolution)
                    .filter(t -> t.getUnits() >= availableUnits)
                    .collect(toList());
    }

    public List<Product> findBy(Resolution resolution, int availableUnits, double maxPrice, float minScreenSize ) {
        return findBy(findBy(repository.findAll(), maxPrice, minScreenSize), resolution, availableUnits);
    }

    public static void main(String[] args) {
        
        List<Product> products = Arrays.asList(
            new Product(50.0, 8),
            new Television(60.0, 6, Resolution.R_1024, 14.1f)
        );

        ProductRepository repository = mock(ProductRepository.class);
        when(repository.findAll()).thenReturn(products);
        SearchProductService service = new SearchProductService(repository);
        System.out.println(service.findBy(100.0, 13.1f));
    }

}

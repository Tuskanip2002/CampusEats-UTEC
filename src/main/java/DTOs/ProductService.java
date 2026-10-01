package DTOs;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository,
                          ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public Page<ProductDto> getAllProducts(Pageable pageable) {
        Page<Product> productsPage = productRepository.findAll(pageable);

        // Transforma la Page de entidades a una Page de DTOs
        return productsPage.map(product -> modelMapper.map(product, ProductDto.class));
    }
}
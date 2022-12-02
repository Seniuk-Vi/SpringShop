package com.epam.springshop.service.impl;

import com.epam.springshop.dto.CategoryDto;
import com.epam.springshop.dto.ProductDto;
import com.epam.springshop.exceptions.EntityIllegalArgumentException;
import com.epam.springshop.exceptions.impl.ProductNotFoundException;
import com.epam.springshop.mapper.CategoryMapper;
import com.epam.springshop.mapper.ProductMapper;
import com.epam.springshop.model.Product;
import com.epam.springshop.repository.ProductRepoImpl;
import com.epam.springshop.service.CategoryService;
import com.epam.springshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepoImpl productRepo;
    private final CategoryService categoryService;

    @Override
    public ProductDto createProduct(ProductDto obj) {
        // todo check if category exists
        log.info(String.format("%s : method ==> createProduct(%s)", this.getClass().getName(), obj));
        Product product = ProductMapper.INSTANCE.mapProduct(obj);
        // check if category exists
        List<EntityIllegalArgumentException> exceptions = new ArrayList<>();
        CategoryDto categoryDto = categoryService.getCategory(obj.getCategory());
        // check date
        Date date = new Date();
        if (product.getPostDate().after(date)) {
            exceptions.add(new EntityIllegalArgumentException("Post date can't be in future"));
        }
        if (exceptions.size() > 0) {
            String messages = exceptions.toString();
            throw new EntityIllegalArgumentException(messages);
        }
        // save product
        product.setCategory(CategoryMapper.INSTANCE.mapCategory(categoryDto));
        product = productRepo.save(product);
        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public ProductDto getProduct(Long obj) {
        log.info(String.format("%s : method ==> getProduct(%s)", this.getClass().getName(), obj));
        Product product = productRepo.findById(obj).orElseThrow(ProductNotFoundException::new);
        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public List<ProductDto> getProducts(int page,int size) {
        log.info(String.format("%s : method ==> getProducts()", this.getClass().getName()));
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> pagProducts =  productRepo.findAll(pageable);
        List<Product> products = pagProducts.getContent();
        return ProductMapper.INSTANCE.mapProductDtos(products);
    }

    @Override
    @Transactional
    public ProductDto updateProduct(Long productId,ProductDto obj) {
        log.info(String.format("%s : method ==> updateProduct(%s)", this.getClass().getName(),obj));
        Product product = productRepo.findById(productId).orElseThrow(ProductNotFoundException::new);
        // todo: check field

        // update fields
        product.setTitle(obj.getTitle());
        product.setDescription(obj.getDescription());
        product.setPrice(obj.getPrice());
        product.setInStock(obj.getInStock());

        return ProductMapper.INSTANCE.mapProductDto(product);
    }

    @Override
    public void deleteProduct(Long obj) {
        log.info(String.format("%s : method ==> deleteProduct(%s)", this.getClass().getName(), obj));
        productRepo.deleteById(obj);
    }
}

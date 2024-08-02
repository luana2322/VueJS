package com.crudVuejs.service.serviceImpl;

import com.crudVuejs.dto.ProductDto;
import com.crudVuejs.exception.ResourceNotFoundException;
import com.crudVuejs.model.Category;
import com.crudVuejs.model.Product;
import com.crudVuejs.repository.CategoryRepository;
import com.crudVuejs.repository.ProductRepository;
import com.crudVuejs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FileStorageProductServiceImpl fileStorageProductService;
    @Override
    public List<Product> findAll() {
        List<Product> list1=new ArrayList<>();
list1=productRepository.findAll();
        return list1;
    }

    @Override
    public Product findbyId(Long productId) {
        Optional<Product> productfind=productRepository.findById(productId);
        if (!productfind.isPresent()){
            throw new ResourceNotFoundException("not found product ");
        }
        return productfind.get();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product insert(ProductDto product) {
        Product product1=convert(product);
        Product prosave=productRepository.save(product1);
        //Sửa tên file
        MultipartFile file=product.getImage();

        String input=file.getOriginalFilename();
        // Tìm vị trí của dấu chấm cuối cùng
        int lastDotIndex = input.lastIndexOf(".");

        // Kiểm tra xem có dấu chấm trong chuỗi hay không

        // Cắt lấy phần đuôi (extension) từ dấu chấm cuối cùng
        String extension = input.substring(lastDotIndex);

        // In ra phần đuôi (extension)
        System.out.println("Phần đuôi: " + extension);



        String filenamedatabase="image"+prosave.getProductId()+extension;
fileStorageProductService.save(file,filenamedatabase);

        String path="./../../../../image/product/"+filenamedatabase;

        prosave.setImage(path);
        return productRepository.save(prosave);
    }

    @Override
    public Product update(ProductDto product) {
        Product product1=convert(product);


        return productRepository.save(product1);
    }

    public Product convert (ProductDto prodto){
        Product pro=new Product();
        pro.setProductId(prodto.getProductId());
        pro.setProductName(prodto.getProductName());
        pro.setPrice(prodto.getPrice());
        pro.setDescription(prodto.getDescription());

        pro.setManufactureDate(prodto.getManufactureDate());
        Category category1=categoryRepository.findById(prodto.getCategoryId()).get();

        pro.setCategory(category1);
        return pro;
    }
}

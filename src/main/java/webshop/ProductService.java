package webshop;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount) {
        int stock = productRepository.findProductById(id).getStock();
        if (stock < amount) {
            throw new IllegalArgumentException("There are not enough stock!");
        }
        productRepository.updateProductStock(id, amount);
    }

}

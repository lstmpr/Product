package ru.domain.netology;

public class ProductManager {
    private ProductRepository repository;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        Product[] items = repository.findAll();
//        Product[] result = new Product[items.length];
//        for (int i = 0; i < result.length; i++) {
//            int index = items.length - 1 - i;
//            result[i] = items[index];
//        }
//        return result;
        return items;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] sought = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[sought.length + 1];
                System.arraycopy(sought, 0, tmp, 0, sought.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;
                sought = tmp;

            }
        }
        return sought;

    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains((search))) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getProducer().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false;

    }


}

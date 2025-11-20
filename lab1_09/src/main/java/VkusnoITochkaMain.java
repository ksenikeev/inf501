public class VkusnoITochkaMain {
    public static Product[] products;

    public static void main(String[] args) {
        createMenu();
        Order order1 = new Order();

        order1.changeProduct(products[2], 2);
        order1.changeProduct(products[0], 3);
        order1.changeProduct(products[1], 1);
        System.out.println(order1);
        order1.changeProduct(products[2], 0);
        System.out.println(order1);

        order1.payment();
        System.out.println(order1);

        order1.getOrder();
        System.out.println(order1);


    }
    public static void createMenu() {
        products = new Product[3];
        Category desert = new Category("десерт");
        Product cheesecake = new Product("чизкейк",desert,100);
        Product pirozhok = new Product("пирожок",desert,100);
        Category drinks = new Category("напитки");
        Product coke = new Product("кола", drinks, 80);
        products[0] = cheesecake;
        products[1] = pirozhok;
        products[2] = coke;
    }
}

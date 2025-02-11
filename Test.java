public class Test {
    public static void main(String[] args) {
        Supply supplies = new Supply("products.txt");
        for (Product supply:supplies.getProducts()){
            System.out.println (supply);

        }

    }
}

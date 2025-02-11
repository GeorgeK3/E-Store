public class Testing {
    public static void main(String[] args) {
        SaleList sales = new SaleList("sales.txt");
        for (Sale sale: sales.getSales()){
            System.out.println(sale);
            System.out.println(sale.get_product());
        }
    }
}

package org.example.coffeeshop;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class ProductReader {

    public List<Product> readProducts(){
        List<Product> products = new ArrayList<Product>();

        try{
            File file = new File("products.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //this will consume the header bc it is the first read in the file
            String line = bufferedReader.readLine();

            //this will read the first product
            line = bufferedReader.readLine();
            while(line!=null){
                Product p = parseProduct(line);
                products.add(p);
                line = bufferedReader.readLine();
            }
           // System.out.println(products.size());  //how many did we retrieve?

        }catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    private Product parseProduct(String line) {
        // pos 0     , 1, 2,  3
        //Chai Latte,2.99,10,true
        Product result = new Product();

        String[] columns = line.split(",");
        result.setName(columns[0]);
        result.setPrice(Double.parseDouble(columns[1])); //convert String to double
        result.setQuantityAvailable(Integer.parseInt(columns[2]));
        result.setBeverage(Boolean.parseBoolean(columns[3]));

        return result; //returns fully loaded Product object
    }
    //used this to build and test this functionality before "bigger picture"
//    public static void main(String[] args) {
//
//        //make ProductReader
//        ProductReader pr = new ProductReader();
//        pr.readProducts();
//    }
}

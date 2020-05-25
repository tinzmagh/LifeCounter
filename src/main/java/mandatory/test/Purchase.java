package mandatory.test;



import java.util.ArrayList;
import java.util.List;

public class Purchase {


    public boolean internetConnection;
    public int phoneLines;
    public ArrayList<String> cellPhones = new ArrayList<>();
    public int price = 0;

    public Purchase() {
    }

    public Purchase(boolean internetConnection, int phoneLines, ArrayList<String> cellPhones, int price) {
        this.internetConnection = internetConnection;
        this.phoneLines = phoneLines;
        this.cellPhones = cellPhones;
        this.price = price;
    }

    public void setInternetConnection(boolean internetConnection) {
        this.internetConnection = internetConnection;
    }

    public void setPhoneLines(int phoneLines) {
        this.phoneLines = phoneLines;
    }

    public void setPrice(int price) {
        this.price = price;
    }




    public int checkInternetConnection(boolean internetConnection) {

        if (internetConnection) {
            this.price = this.price + 200;
            System.out.println("Internet connection");
            setInternetConnection(true);

        } else {
            this.price = this.price - 200;
            System.out.println("Internet connection removed");
        }

        return this.price;
    }

    public int addPhoneLine() {

        if (phoneLines <= 8 && phoneLines >= 0) {
            phoneLines++;
            price = price + 150;
            System.out.println("phone line added");
        } else {
            IllegalArgumentException exception = new IllegalArgumentException("8 phone lines is the maximum");
            System.out.println("8 phone lines is the maximum");
            throw exception;
        }
        return price;
    }

    public int removePhoneLine() {

        if (phoneLines > 0) {
            phoneLines--;
            System.out.println("phone line removed");
            price = price - 150;
        } else {
            IllegalArgumentException exception = new IllegalArgumentException("0 phone lines is the minimum");
            System.out.println("0 phone lines is the minimum ");
            throw exception;
        }
        return price;
    }


    public int addCellPhone(String model) {

        cellPhones.add(model);

        switch (model) {
            case "Motorola G99":
                System.out.println("Motorola G99 added");
                price = price + 800;
                break;
            case "iPhone 99":
                System.out.println("iPhone 99 added");
                price = price + 6000;
                break;
            case "Samsung Galaxy 99":
                System.out.println("Samsung Galaxy 99 added");
                price = price + 1000;
                break;
            case "Sony Xperia 99":
                System.out.println("Sony Xperia 99 added");
                price = price + 900;
                break;
            case "Huawei 99":
                System.out.println("Huawei 99 added");
                price = price + 900;
                break;
        }

        return price;
    }



    public int removeCellPhone(String model) {
        // Find the first occurence of the string inside our cellPhones array
        int index = cellPhones.indexOf(model);
        /*if(index == -1){
            return price; }*/
        cellPhones.remove(index);
        switch (model) {
            case "Motorola G99":
                System.out.println("Motorola G99 removed");
                price = price - 800;
                break;
            case "iPhone 99":
                System.out.println("iPhone 99 removed");
                price = price - 6000;
                break;
            case "Samsung Galaxy 99":
                System.out.println("Samsung Galaxy 99 removed");
                price = price - 1000;
                break;
            case "Sony Xperia 99":
                System.out.println("Sony Xperia 99 removed");
                price = price - 900;
                break;
            case "Huawei 99":
                System.out.println("Huawei 99 removed");
                price = price - 900;
                break;
        }

        return price;

    }

    public String buy(){

        String purchase = "\nYour Cart: \n\n";
        int phoneLinePrice = 0;

        if(internetConnection){

            int internetPrice = 200;

            purchase = purchase + "Internet Connection: " + internetPrice + " DKK\n";
        }

        if(phoneLines <= 8 && phoneLines >= 0){

            phoneLinePrice = phoneLinePrice + (phoneLines * 150);
            purchase = purchase + String.valueOf(phoneLines) + " Phone lines: " + phoneLinePrice + "\n";
        }

        for (int i = 0; i < cellPhones.size(); i++) {

            switch (cellPhones.get(i)){

                case "iPhone 99":
                    purchase = purchase + "iPhone 99: 6000 DKK\n";
                    break;

                case "Sony Xperia 99":
                    purchase = purchase + "Sony Xperia 99: 900 DKK\n";
                    break;

                case "Motorola G99":
                    purchase = purchase + "Motorola G99: 800 DKK\n";
                    break;

                case "Samsung Galaxy 99":
                    purchase = purchase + "Samsunng Galaxy 99: 1000 DKK\n";
                    break;

                case "Huawei 99":
                    purchase = purchase + "Huawei 99: 900 DKK\n";
                    break;
            }

        }

        System.out.println(purchase + "\nTotal price: " + price + " DKK");

        purchase = purchase + "\nTotal price: " + price + "DKK";

        return purchase;

    }

    public String reset(){

        setInternetConnection(false);
        cellPhones.removeAll(cellPhones);
        setPhoneLines(0);
        setPrice(0);

        return "Shopping cart has been reset";

    }


}

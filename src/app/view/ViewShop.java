package app.view;

import app.products.models.Products;
import app.products.services.ProductsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ViewShop {
    private ProductsService productsService;
    private Scanner scanner;
    private List<Products>cartItems;
    private int pretCos;


    public ViewShop(){
        this.productsService=new ProductsService();
        cartItems=new ArrayList<>();
        pretCos=0;
        play();

    }
    public void meniuMagazin(){
        System.out.println("1->Afisare produse");
        System.out.println("2->Fa cumparaturi");
        System.out.println("3->Adauga un produs nou");
    }
    public void play(){
        boolean merge = true;
        while(merge){
            this.meniuMagazin();
            scanner=new Scanner(System.in);
            int alegere=scanner.nextInt();

            switch (alegere){
                case 1:
                    productsService.afisareProduse();
                    break;
                case 2:
                    Cart();
                    break;
                case 3:
                    afisareAdaugaProdus();
            }

        }
    }
    public void meniuCos(){
        System.out.println("--------CUMPARATURI--------");
        System.out.println("Apasa tasta 0 pentru a iesi din meniul cosului de cumparaturi");
        System.out.println("1->Adauga produs");
        System.out.println("2->Vizioneaza cosul");
        System.out.println("3->Vezi totalul cosului");
        System.out.println("4->Sterge din cos");
        System.out.println("0->Iesi din meniul cumparaturi");

    }
    public void Cart(){
        boolean run=true;
        while(run){
            this.meniuCos();
            int alegere=scanner.nextInt();
            scanner.nextLine();
            switch (alegere){
                case 1:
                    adaugaInCos();
                    break;
                case 2:
                    veziCosul();
                    break;
                case 3:
                    veziPretulCosului();
                    break;
                case 4:
                    stergeDinCos();
                    break;
                case 0:
                    run=false;
                    break;


            }
        }
    }
    public void adaugaInCos(){

        System.out.println("Ce produs vreti sa adaugati in cos?");
        String name = scanner.nextLine();
        System.out.println("Cate " + name + " vreti sa adaugati in cos?");
        int cantitate = scanner.nextInt();
        scanner.nextLine();
        Products products=productsService.getProductByName(name);
        if(products==null){
            System.out.println("Acest produs nu exista!");
        }
        else if(products.getStock()-cantitate<0&&products!=null){
            System.out.println("Stoc indisponibil");
        }
        else if (products!=null&&products.getStock()-cantitate>=0){
            products.setStock(products.getStock()-cantitate);
            System.out.println(name+" adaugat cu succes in cos");
            cartItems.addAll(Collections.nCopies(cantitate,products));
            pretCos+=products.getPrice()*cantitate;
        }

    }
    public void veziCosul(){
        if(cartItems==null){
            System.out.println("Cosul este gol!");
        }
        else{
            System.out.println("----------COSUL DUMNEAVOASTRA-------------");
            for(int i=0;i<cartItems.size();i++){
                System.out.println(cartItems.get(i).getName());
            }

        }

    }
    public void veziPretulCosului(){
        System.out.println("---------TOTALUL ESTE-------------");
        System.out.println(pretCos+" ron");
    }
    public void stergeDinCos() {
        if (cartItems.isEmpty()) {
            System.out.println("Nu pueti sterge, cosul este gol");
        } else {
            System.out.println("Ce produs vreti sa stergeti din cos?");
            String produsulSters = scanner.nextLine();
            Products deletedProtuct = productsService.getProductByName(produsulSters);
            if (cartItems.contains(deletedProtuct)) {
                System.out.println("Cate " + produsulSters + " vreti sa stergeti?");
                int cantitateaStearsa = scanner.nextInt();
                scanner.nextLine();
                int cantitateaPrezenta=Collections.frequency(cartItems, deletedProtuct);
                if (cantitateaStearsa>cantitateaPrezenta) {
                    System.out.println("Nu poti sterge mai multe produse decat ai deja in cos");
                } else {
                    for(int i=0;i<cantitateaStearsa;i++){
                        cartItems.remove(deletedProtuct);
                    }
                    System.out.println("Ati sters cu succes " + cantitateaStearsa + " " + deletedProtuct.getName());
                    pretCos -= deletedProtuct.getPrice()*cantitateaStearsa;

                }

            }
            else {
                System.out.println("Acest produs nu exista in cos");
            }

        }
    }
    public void afisareAdaugaProdus(){

        int id=productsService.randomId();
        System.out.println("Numele produsului");
        String name=scanner.next();
        System.out.println("Pretul");
        int price= scanner.nextInt();
        System.out.println("Descriere");
        String descriptions=scanner.next();
        System.out.println("DataCreari");
        String createDate=scanner.next();
        System.out.println("Stock");
        int stock=scanner.nextInt();

        String text=productsService.adaugaProdus(id,name,price,descriptions,createDate,stock);
        Products products=new Products(text);
        productsService.add(products);
        productsService.save();







    }




}

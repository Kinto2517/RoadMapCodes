import Enitity.Kullanıcı;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Optional;

public class KullanıcıPanel {

    private JSONArray customerList;
    private JSONParser jsonParser;

    public KullanıcıPanel() {
        customerList = new JSONArray();
        jsonParser = new JSONParser();
    }

    public void kayıtOl(String identityNumber, String password, double money){

        int count=0;
        for (int i = 0; i < password.length()-1; i++) {
            if(Character.isDigit(password.charAt(i))){
                count++;
            }else{
                count = 0;
            }
        }

        if(count>=4){
            System.out.println("Sifreniz Dogum Tarihi İceremez");
        }
        else{
            Kullanıcı kullanıcı= new Kullanıcı(identityNumber, password, money, 0,0);
            jsonYaz(kullanıcı);

        }


    }





    @SuppressWarnings("unchecked")
    public boolean login(String identityNumber, String password) {

        // Eðer kullanýcýnýn verileri json da varsa git onlarý doðrula
        // Read json
        boolean isLoginSuccess = true;

        JSONArray customerList = jsonOku();

        if (customerList.size() == 0) {
            System.out.println("Json datasında verileriniz bulunmuyor!");
            isLoginSuccess = false;
        } else {
            customerList.stream().forEach(customer -> {
                JSONObject c = (JSONObject) customer;
                if ( c.get("identityNumber").equals(identityNumber) && c.get("password").equals(password)) {

                    System.out.println("Giris Basarılı! Hoþgeldiniz.");

                }
                else
                    System.out.println("Şifrenizi kontrol edin");

            });

        }
        return isLoginSuccess;
    }

    @SuppressWarnings("unchecked")
    public void moneyTransfer(String fromAccount, String toAccount, double money) {
        JSONArray customerDb = jsonOku(); // Json dosyasýný oku

        if (customerDb.size() == 0) {
            System.out.println("Veritabanı boş!");
        } else {
            customerDb.stream().forEach(customer -> {
                JSONObject c = (JSONObject) customer;

                if (c.get("identityNumber").equals(fromAccount)) { //

                    System.out.println("işlem öncesi bakiye : " + c.get("money"));
                    System.out.println("işlem sonrası bakiye : " + ((double) c.get("money") - money));

                    Kullanıcı yeniKullanıcı = new Kullanıcı( // Kullanýcýnýn parasýný azaltýyoruz transferden dolayý
                            (String) c.get("identityNumber"),
                            (String) c.get("password"),
                            (double) ((double) c.get("money") - money),
                            (double) c.get("cardDebt"),
                            (double) c.get("creditDebt")
                    );

                    customerList.remove(customer); // Json dosyasýný güncellemek için kullanýcýyý siliyorum!

                    jsonYaz(yeniKullanıcı); // Parasýný güncel fiyat olarak oluþturduðum kullanýcýyý json a yazýyorum!

                }

            });

            Optional customerFromJson = customerDb.stream().filter(customer -> ((JSONObject) customer).get("identityNumber").equals(toAccount) ).findFirst();
            JSONObject obj = (JSONObject) customerFromJson.get();

        }
    }

    @SuppressWarnings("unchecked")
    public void payCardDebt(String identityNumber) {
        // Jsondan oku
        // Borç yoksa borç yok yaz
        // Borç var ise hesapta yeterli para varsa ödeyebilsin!

        JSONArray customerDb = jsonOku(); // Json dosyasýný oku

        if (customerDb.size() == 0) {
            System.out.println("Veritabaný boþ!");
        } else {
            customerDb.stream().forEach(customer -> {
                JSONObject c = (JSONObject) customer;

                if (c.get("identityNumber").equals(identityNumber)) { // Verilen identity number var ise devam et

                    if ((double) c.get("cardDebt") == 0) {
                        System.out.println("Kard borcunuz bulunmamaktadýr.");
                    } else {
                        if ( (double) c.get("money") >= (double) c.get("cardDebt")) {
                            // Ödeme iþlemini yap
                            System.out.println("Borcunuz ödendi!");
                            System.out.println("Eski bakiye : " + c.get("money"));
                            System.out.println("Yeni bakiye : " + ( (double) c.get("money") - (double) c.get("cardDebt")));

                            // Kullanýcýyý güncelleyelim !
                            Kullanıcı newCustomer = new Kullanıcı(
                                    (String) c.get("identityNumber"),
                                    (String) c.get("password"),
                                    (double) ((double) c.get("money") - (double) c.get("cardDebt")),
                                    (double) 0,
                                    (double) c.get("creditDebt")
                            );

                            customerList.remove(customer); // Json dosyasýný güncellemek için kullanýcýyý siliyorum!
                            jsonYaz(newCustomer); // Kart borcunu sildiðim kullanýcýyý json a yazýyorum!

                        } else {
                            System.out.println("Borcunuzu ödemek için yeterli paranýz bulunmamaktadýr.");
                        }
                    }

                }

            });

        }


    }

    @SuppressWarnings("unchecked")
    public void payDebt(String identityNumber) {
        JSONArray customerDb = jsonOku(); // Json dosyasýný oku

        if (customerDb.size() == 0) {
            System.out.println("Veritabaný boþ!");
        } else {
            customerDb.stream().forEach(customer -> {
                JSONObject c = (JSONObject) customer;

                if (c.get("identityNumber").equals(identityNumber)) {

                    if ((double) c.get("creditDebt") == 0) {
                        System.out.println("Kredi borcunuz bulunmamaktadýr.");
                    } else {
                        if ( (double) c.get("money") >= (double) c.get("creditDebt")) {
                            // Ödeme iþlemini yap
                            System.out.println("Borcunuz ödendi!");
                            System.out.println("Eski bakiye : " + c.get("money"));
                            System.out.println("Yeni bakiye : " + ( (double) c.get("money") - (double) c.get("creditDebt")));

                            // Kullanýcýyý güncelleyelim !
                            Kullanıcı newCustomer = new Kullanıcı(
                                    (String) c.get("identityNumber"),
                                    (String) c.get("password"),
                                    (double) ((double) c.get("money") - (double) c.get("cardDebt")),
                                    (double) c.get("cardDebt"),
                                    (double) 0
                            );

                            customerList.remove(customer); // Json dosyasýný güncellemek için kullanýcýyý siliyorum!
                            jsonYaz(newCustomer); // Kart borcunu sildiðim kullanýcýyý json a yazýyorum!

                        } else {
                            System.out.println("Borcunuzu ödemek için yeterli paranýz bulunmamaktadýr.");
                        }
                    }

                }

            });

        }

    }




    private void jsonYaz(Kullanıcı kullanıcı) {

        JSONObject jsonKullanıcı = new JSONObject();
        jsonKullanıcı.put("identityNumber", kullanıcı.getIdentityNumber());
        jsonKullanıcı.put("password", kullanıcı.getPassword());
        jsonKullanıcı.put("accountNumber", kullanıcı.getAccountNumber());
        jsonKullanıcı.put("money", kullanıcı.getMoney());
        jsonKullanıcı.put("cardDebt", kullanıcı.getCardDebt());
        jsonKullanıcı.put("creditDebt", kullanıcı.getCreditDebt());


        customerList.add(jsonKullanıcı);



        try (FileWriter file = new FileWriter("customers.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            BufferedWriter buffer = new BufferedWriter(file);
//        	customerList.toJSONString()
            buffer.write(customerList.toJSONString());
            buffer.close();

            //file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private JSONArray jsonOku() {

        JSONArray customerList = new JSONArray();

        try (FileReader reader = new FileReader("customers.json"))
        {
            //Read JSON file
            Object obj =  jsonParser.parse(reader);

            customerList = (JSONArray) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return customerList;
    }



}

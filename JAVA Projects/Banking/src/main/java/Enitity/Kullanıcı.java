package Enitity;

import lombok.*;

import java.util.Random;

@Getter
@Setter
@Data
@NoArgsConstructor
public class Kullanıcı {

    private String identityNumber;

    private String password;

    private String accountNumber;

    private double money;

    private double cardDebt;

    private double creditDebt;

    public Kullanıcı(String identityNumber, String password, double money, double cardDebt, double creditDebt) {
        this.identityNumber = identityNumber;
        this.password = password;
        this.accountNumber = getRandomAccountNumber();
        this.money = money;
        this.cardDebt = cardDebt;
        this.creditDebt = creditDebt;
    }

    String getRandomAccountNumber() {
        Random random = new Random();
        int number = random.nextInt(99999999);

        return String.format("%06d", number);
    }


}

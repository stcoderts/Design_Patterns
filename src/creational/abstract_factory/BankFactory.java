package creational.abstract_factory;

public class BankFactory extends AbstractFactory {
    public Bank getBank(String bankName){
        if (bankName == null){
            return null;
        }
        if (bankName.equalsIgnoreCase("HDFC BANK")) return new HDFC();
        if (bankName.equalsIgnoreCase("ICIC BANK")) return new ICIC();
        return null;
    }

    public Loan getLoan(String loan) {
        return null;
    }
}

interface Bank{
    String getBankName();
}

class HDFC implements Bank{

    private final String bName;

    public HDFC(){
        bName = "HDFC Bank";
    }
    @Override
    public String getBankName() {
        return bName;
    }
}

class ICIC implements Bank{
    private final String bName;

    public ICIC(){
        bName = "ICIC bank";
    }


    @Override
    public String getBankName() {
        return bName;
    }
}
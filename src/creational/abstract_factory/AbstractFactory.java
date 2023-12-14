package creational.abstract_factory;

abstract class AbstractFactory {
    abstract Bank getBank(String bankName);
    abstract Loan getLoan(String loanName);
}


class FactoryCreator{
    public static AbstractFactory getFactory(String factoryName){
        if(factoryName.equalsIgnoreCase("Bank")){
            return new BankFactory();
        } else if(factoryName.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }
}

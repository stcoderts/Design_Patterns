package creational.abstract_factory;

public class LoanFactory extends AbstractFactory {
    public Loan getLoan(String loanName){
        if (loanName == null) return null;
        if (loanName.equalsIgnoreCase("home loan")) return new HomeLoan();
        else if (loanName.equalsIgnoreCase("business loan")) return new BussinessLoan();
        return null;
    }

    public Bank getBank(String bankName){
        return null;
    }
}

abstract class Loan{
    protected double rate;
    abstract void getInterestRate(double rate);

    public void calculateLoanPayment(double loanAmount, int years){
        double EMI;
        int n;

        n=years*12;
        rate=rate/1200;
        EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanAmount;

        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanAmount+" you have borrowed");
    }
}

class HomeLoan extends Loan{
    public void getInterestRate(double r){
        rate = r;
    }
}

class BussinessLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }

}
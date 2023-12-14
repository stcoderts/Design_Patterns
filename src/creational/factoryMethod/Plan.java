package creational.factoryMethod;

public abstract class Plan {
    protected double rate;

    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}


class DomesticPlan extends Plan{
    public void getRate(){
        rate = 3.50;
    }
}

class CommercialPlan extends Plan{
    public void getRate(){
        rate = 7.50;
    }
}

class InstitutionalPlan extends Plan{
    public void getRate(){
        rate = 5.50;
    }
}
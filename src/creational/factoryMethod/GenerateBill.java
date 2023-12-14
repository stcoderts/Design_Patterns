package creational.factoryMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateBill {
    public static void main(String[] args) throws IOException {
        GetPlanFactory planFactory = new GetPlanFactory();
        System.out.print("Enter the name of plan you want: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String planName = br.readLine();

        System.out.print("Enter the unit you want: ");
        int units = Integer.parseInt(br.readLine());

        Plan p = planFactory.getPlan(planName);

        System.out.print("Your total expenses are: ");
        p.getRate();
        p.calculateBill(units);
    }
}

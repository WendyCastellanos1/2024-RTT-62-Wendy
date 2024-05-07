package org.example.PA_303_4_1;
import java.util.Scanner;

       /*  Create a program that lets the users input their filing status and
income. Display how much tax the user would have to pay
according to status and income.
❑ The U.S. federal personal income tax is calculated based
on the filing status and taxable income.
❑ There are four filing statuses: Single, Married Filing Jointly,
Married Filing Separately, and Head of Household. Tax rates are in a chart. */

public class NumberSeven {

    enum FilingStatus{
        SINGLE,
        MARRIED_FILING_JOINTLY_0R_QUALIFYING_WIDOWER,
        MARRIED_FILING_SEPARATELY,
        HEAD_OF_HOUSEHOLD;
    }

    public static void main(String[] args) {

        FilingStatus status = FilingStatus.SINGLE;
        int taxableIncome = 0;
        double taxRate = 0;

        Scanner scanner = new Scanner(System.in);

        //prompt for user's filing status using enum info, reset to correct one, overriding default
        System.out.println("What is your filing status?\n"
            + "0 for Single \n"
            + "1 for Married Filing Jointly or Qualifying Widower\n"
            + "2 for Married Filing Separately\n"
            + "3 for Head of Household\n");

        //capture user's response
        int tempStatus = scanner.nextInt();     //TODO validation

        //prompt for user's income          //store in taxableIncome variable
        System.out.println("What is your taxable income (as an integer)?");

        //capture user's response
        taxableIncome = scanner.nextInt();      //TODO validation

        //determine tax rate based on status and income (static methods were created for readability, not re-use)
        if (status == FilingStatus.SINGLE){
            taxRate = findTaxRate_single(taxableIncome);
        }else if (status == FilingStatus.MARRIED_FILING_JOINTLY_0R_QUALIFYING_WIDOWER){
            taxRate = findTaxRate_jointly(taxableIncome);
        }else if (status == FilingStatus.MARRIED_FILING_SEPARATELY){
            taxRate = findTaxRate_separately(taxableIncome);
        }else if (status == FilingStatus.HEAD_OF_HOUSEHOLD){
            taxRate = findTaxRate_head(taxableIncome);
        }else{
            System.out.println("Without an approved filing status, we cannot determine your taxes owed.");
        }

        //calculate and print the taxes owed
        double taxes = calculateTaxOwed(taxableIncome, taxRate);

        System.out.println("Your expected tax burden, before the standard deduction and other discounts, is " + taxes + ".");

        scanner.close();
    }

    static double findTaxRate_single (int income) {
        //return tax rate as a percentage for "Single tax filer person"

            if ((income >= 0) && (income <= 8350)){
                return .10;
            }else if ((income >= 8351) && (income <= 33950)){
                return .15;
            }else if  ((income >= 33951) && (income <= 82250)){
                return .25;
            }else if ((income >= 82251) && (income <= 171550)){
                return .28;
            }else if (income >= 171551 && income <= 372950){
                return .33;
            }else if (income >= 372951){
                return .35;
            }else{
                throw new IllegalStateException("Unexpected value: " + income);
            }
    }
    static double findTaxRate_jointly (int income) {
        //return tax rate as a percentage for "Married Filing Jointly or Qualifying Widower"

        if ((income >= 0) && (income <= 16700)){
            return .10;
        }else if ((income >= 16701) && (income <= 67900)){
            return .15;
        }else if  ((income >= 67901) && (income <= 137050)){
            return .25;
        }else if ((income >= 137051) && (income <= 208850)){
            return .28;
        }else if (income >= 208851 && income <= 372950){
            return .33;
        }else if (income >= 372951){
            return .35;
        }else{
            throw new IllegalStateException("Unexpected value: " + income);
        }
    }
    static double findTaxRate_separately (int income) {
        //return tax rate as a percentage for "Married Filing Separately tax filer person"

        if ((income >= 0) && (income <= 8350)){
            return .10;
        }else if ((income >= 8351) && (income <= 33950)){
            return .15;
        }else if  ((income >= 33951) && (income <= 68525)){
            return .25;
        }else if ((income >= 68526) && (income <= 104425)){
            return .28;
        }else if (income >= 104426 && income <= 186475){
            return .33;
        }else if (income >= 186476){
            return .35;
        }else{
            throw new IllegalStateException("Unexpected value: " + income);
        }
    }
    static double findTaxRate_head (int income) {
        //return tax rate as a percentage for "Head of Household tax filer person"

        if ((income >= 0) && (income <= 11950)){
            return .10;
        }else if ((income >= 11951) && (income <= 45500)){
            return .15;
        }else if  ((income >= 45501) && (income <= 117450)){
            return .25;
        }else if ((income >= 117451) && (income <= 190200)){
            return .28;
        }else if (income >= 190201 && income <= 372950){
            return .33;
        }else if (income >= 372951){
            return .35;
        }else{
            throw new IllegalStateException("Unexpected value: " + income);
        }
    }
    static double calculateTaxOwed(int income, double taxRate ){
        double taxOwed = (double)income * taxRate;
        return taxOwed;
    }
}
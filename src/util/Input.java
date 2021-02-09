package util;

import java.util.Scanner;

public class Input {

    private Scanner _input = new Scanner(System.in);

    public String getString(){
        return _input.nextLine();
    }

    public void close(){
        _input.close();
    }

    public Boolean yesNo(){
        String answer = _input.nextLine();
        if(answer.isBlank()){
            return yesNo();
        }else if(answer.toLowerCase().charAt(0) == 'n'){
            return false;
        }else{
            return true;
        }
    }

    public int getInt(){
        
        return _input.nextInt();

    }

    public int getInt(int min, int max){
        
        int n = _input.nextInt();

        if(n >= min && n <= max){
            return n;
        }else{
            return getInt(min,max);
        }
    }

    public double getDouble(double min, double max){
        double n = Double.parseDouble(_input.nextLine());

        if(n >= min && n <= max){
            return n;
        }else{
            return getDouble(min,max);
        }
    }

    public double getDouble(){
        return Double.parseDouble(_input.nextLine());
    }

    public String getPhoneNumber() {
        String phoneNumber = _input.nextLine();

        if (phoneNumber.length() == 7 || phoneNumber.length() == 10) {

        } else {
            getPhoneNumber(); //recurrsion if the phone number is the incorrect length
        }


        StringBuilder formatedNumber = new StringBuilder();

        if (phoneNumber.length() == 7) {

            for (int i = 0; i < phoneNumber.length() + 1; i++) {

                if (i == 3) {
                    formatedNumber.append('-'); //adds the dash if we are at the 3rd character
                    continue;
                } else if (i > 3) {
                    formatedNumber.append(phoneNumber.charAt(i - 1)); //this avoids arrayOutOfBounds
                    continue;
                }

                formatedNumber.append(phoneNumber.charAt(i));

            }

        } else {

            for (int i = 0; i < phoneNumber.length() + 2; i++) {

                if (i == 3 || i == 7) {
                    formatedNumber.append('-'); //adds the dash if we are at the 3rd character
                    continue;
                } else if (i > 7) {
                    formatedNumber.append(phoneNumber.charAt(i - 2)); //this avoids arrayOutOfBounds
                    continue;
                } else if (i > 3) {
                    formatedNumber.append(phoneNumber.charAt(i - 1)); //this avoids arrayOutOfBounds
                    continue;
                }
                formatedNumber.append(phoneNumber.charAt(i));

            }

        }

        return formatedNumber.toString();

    }

}

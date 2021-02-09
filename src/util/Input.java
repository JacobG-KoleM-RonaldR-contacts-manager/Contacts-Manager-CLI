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

}

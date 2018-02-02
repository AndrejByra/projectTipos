package sk.akademiasovy.tipos;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class Tipos {
    private int [] arr;

    public int[] getArr() {
        return arr;
    }

    public Tipos() {
        arr = new int[5];
        generate();
    }

    public void generate()
    {
        Random random=new Random();
        arr[0]=random.nextInt(35)+1;
        int k, i=1;
        boolean unique=true;
        while (i<5)
        {
            arr[i]=random.nextInt(35)+1;
            unique=true;

            for (k=0; k<i; k++)
            {
                if (arr[i]==arr[k])
                    unique=false;
            }

            if (unique==true)
                i++;
        }

        Arrays.sort(arr);
    }

    public void printArray()
    {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.arr[i]);
        }
    }
    public void printNewBets(List<Bet> list){
        if (list == null || list.size() == 0){
            System.out.println("No Bets in the database ! ");
        }
        else {
            for (Bet temp:list){
                System.out.println("Bet: "+temp.getId()+" "+temp.getDate()+" "+temp.getIduser());
                System.out.println(" > "+temp.getBet1()+ " "+temp.getBet2()+" "+temp.getBet3()+" "+temp.getBet4()+ " "+temp.getBet5()+" < ");
            }
        }

    }


}

package com.crm.qa.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class testExecution {
    public static void main(String[] args){
        //List<Integer> listElements = new ArrayList<>();
        List<Integer> listElements = Arrays.asList(1,2,1,2,1,6,7,8);
        //List<Integer> resultado = Arrays.asList();
        Set<Integer> resultado = new HashSet<Integer>();
        int count =0;
        for(Integer iterator : listElements){
            for(Integer iterator2 : listElements){
                if(iterator == iterator2){
                    count++;
                }
            }
            System.out.println("Numero: " + iterator);
            System.out.println("Count: " + count);
            System.out.println("---------------------------");
            if(count%2!=0){
                boolean var = false;
                for (Integer resultadoIterator : resultado){
                    if(resultadoIterator == iterator){
                        var = true;
                        break;
                    }
                }
                if (var == false){
                    resultado.add(iterator);
                }
            }
            count=0;
        }
        for (Integer resultadoIterator2 : resultado){
            System.out.println("Resultado: " + resultadoIterator2);
        }
    }
}

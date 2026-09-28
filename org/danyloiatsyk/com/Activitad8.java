package org.danyloiatsyk.com;

public class Activitad8 {
    public static void main(String[] args) {
        if (args.length>0)
            GestionArchivos.read(args[0]);
        else{
            System.out.println("U should pass the path of fur file");
            System.exit(1);
        }
    }
}

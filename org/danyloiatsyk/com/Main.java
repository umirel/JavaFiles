package org.danyloiatsyk.com;


import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File carpeta = new File("/home/numo/VS_code/Java/Tema01");
        if (carpeta.exists() && carpeta.isDirectory()){
            System.out.println("\nfile exists and it is directory\n");

            File[] elementos = carpeta.listFiles();
            if (elementos!=null && elementos.length>0){
                System.out.println("Directory has:");
                for (File elemento : elementos){
                    if (elemento.isDirectory())
                        System.out.println("Directory - "+elemento.getName());
                    else
                        System.out.println("File - "+elemento.getName());
                }
            }
            System.out.println();
            System.out.println("Name of directory is "+carpeta.getName());
            System.out.println("Path absolut to directory is "+carpeta.getAbsolutePath());
            if (carpeta.canRead())
                System.out.println("It is possible to read");
            else
                System.out.println("It is impossible to read");

            if (carpeta.canWrite())
                System.out.println("It is possible to write");
            else
                System.out.println("It is impossible to write");

            System.out.println();
            if (elementos!=null && elementos.length>0) {
                System.out.println("Name of file is " + elementos[0].getName());
                System.out.println("Path absolut to directory is " + elementos[0].getAbsolutePath());
                if (elementos[0].isHidden())
                    System.out.println("File is hiden");
                else
                    System.out.println("File isnt hiden");

                if (elementos[0].canRead())
                    System.out.println("It is possible to read");
                else
                    System.out.println("It is impossible to read");

                if (elementos[0].canWrite())
                    System.out.println("It is possible to write");
                else
                    System.out.println("It is impossible to write");

                LocalDate localDate = LocalDate.ofEpochDay(elementos[0].lastModified() / 86400000L);
                DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Last modification was: "+localDate.format(formateador));

                System.out.println("Size in bytes: "+elementos[0].length());
                System.out.printf("Size in KB: %.3f\n",elementos[0].length()/1024.0);
                System.out.printf("Size in MB %.3f\n: ",elementos[0].length()/1024.0/1024);
            }

        }
        else if (!carpeta.exists())
            System.out.println("file doesnt exists");
        else
            System.out.println("it isnt directory");

        System.out.println();

        GestionArchivos.listarDirectorio("/home/numo/VS_code/Java/Tema01");
        System.out.println();
        GestionArchivos.verInfo("/home/numo/VS_code/Java/Tema01","tsts.txt");
        System.out.println();
        GestionArchivos.read("/home/numo/VS_code/Java/Tema01/tsts.txt");
        System.out.println();
        GestionArchivos.readBinary("/home/numo/VS_code/Java/Tema01/tsts.txt");
        System.out.println();
        System.out.println();
        GestionArchivos.compare("/home/numo/VS_code/Java/Tema01/tsts.txt","/home/numo/VS_code/Java/Tema01/shuegc.txt");
        GestionArchivos.compare("/home/numo/VS_code/Java/Tema01/tsts.txt","/home/numo/VS_code/Java/Tema01/rr.txt");
        System.out.println();
        GestionArchivos.concat("/home/numo/VS_code/Java/Tema01/tsts.txt","/home/numo/VS_code/Java/Tema01/shuegc.txt");
        System.out.println();
        GestionArchivos.concatLine("/home/numo/VS_code/Java/Tema01/tsts.txt","/home/numo/VS_code/Java/Tema01/shuegc.txt");
    }
}

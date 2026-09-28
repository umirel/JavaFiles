package org.danyloiatsyk.com;

import java.io.*;

public class GestionArchivos {

    public static boolean crearArchivo(String directorio, String archivo) throws IOException {

        File file = new File(directorio,archivo);

        if (file.exists()){
            System.out.println("File already exists");
            return false;
        }

        return file.createNewFile();
    }

    public static void listarDirectorio(String directorio){
        File file = new File(directorio);

        if (file.exists()  && file.isDirectory()){
            File[] elementos = file.listFiles();
            if (elementos!=null && elementos.length>0){
                for (File elemento : elementos){
                    char writable = elemento.canWrite() ? 'w' : '_';
                    char readable = elemento.canRead() ? 'r' : '_';
                    char type = elemento.isDirectory() ? 'd' : 'f';
                    System.out.printf("%s %c %d bytes %c%c\n",elemento.getName(), type, elemento.length(), readable, writable);
                }
            }

        } else if (!file.exists())
            throw new NullPointerException("It doesnt exists");
        else if (!file.isDirectory())
            System.out.println("It is a directory");
        else
            System.out.println("smth went wrong");
    }


    public static void verInfo(String directorio, String archivo){
        File file = new File(directorio, archivo);
            if (file.exists()){
                System.out.println("Name: "+file.getName());
                System.out.println("Path absolute: "+file.getAbsolutePath());
                char writable = file.canWrite() ? 'w' : '_';
                char readable = file.canRead() ? 'r' : '_';
                System.out.printf("Permisos: %c%c\n",readable,writable);
                System.out.println("Size: "+file.length()+" bytes");
                String type = file.isDirectory() ? "directory" : "file";
                System.out.printf("This is %s\n",type);
            }else if(!file.exists())
                throw new NullPointerException("File doesnt exists");
            else if(!file.canRead())
                System.out.println("It is impossible to read");
            else
                System.out.println("smth went wrong");
    }

    public static void read(String path) {
        if (path==null)
            throw new IllegalArgumentException("Path cant be null");

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readBinary(String path){
        if (path==null)
            throw new IllegalArgumentException("Path cant be null");

        try (FileInputStream reader = new FileInputStream(path)){
            int date;
            while((date=reader.read()) != -1){
                System.out.printf("%X ",date);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void compare(String file1, String file2){
        if (file1==null || file2==null)
            throw new IllegalArgumentException("U have to pass 2 files, argument cant be empty");

        try(FileInputStream reader1 = new FileInputStream(file1);
            FileInputStream reader2 = new FileInputStream(file2)){

            int date1;
            int date2;

            while ((date1 = reader1.read()) != -1 | (date2 = reader2.read()) != -1){
                if(date1!=date2) {
                    System.out.println("They are not equals");
                    return;
                }
            }
            System.out.println("They are equals");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void concat(String file1, String file2){
        if (file1==null || file2==null)
            throw new IllegalArgumentException("U have to pass 2 files, argument cant be empty");

        try (FileInputStream reader1 = new FileInputStream(file1);
             FileInputStream reader2 = new FileInputStream(file2);
             FileOutputStream writer = new FileOutputStream("/home/numo/IdeaProjects/tema1/src/main/java/org/danyloiatsyk/com/output.txt")){

            int date;

            while ((date=reader1.read()) != -1){
                writer.write(date);
            }

            writer.write('\n');

            while ((date=reader2.read()) != -1){
                writer.write(date);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void concatLine(String file1, String file2){
        if (file1==null || file2==null)
            throw new IllegalArgumentException("U have to pass 2 files, argument cant be empty");

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/numo/IdeaProjects/tema1/src/main/java/org/danyloiatsyk/com/outputLine.txt"))){

            String date1;
            String date2;

            while ((date1 = reader1.readLine()) != null | (date2 = reader2.readLine()) != null) {
                if (date1 != null){
                    writer.write(date1);
                    writer.write(' ');
                }
                if (date2 != null)
                    writer.write(date2);

                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

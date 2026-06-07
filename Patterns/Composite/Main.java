package Patterns.Composite;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("File 1", 1);
        File file2 = new File("File 2", 2);
        File file3 = new File("File 3", 3);
        
        
        Folder folder1 = new Folder("Folder 1");
        Folder folder2 = new Folder("Folder 2");
        Folder folder3 = new Folder("Folder 3");

        
        folder2.add(file2);
        folder2.add(file3);
        
        folder1.add(file1);
        folder1.add(folder2);
        folder1.add(folder3);

        folder1.getHirarchy("");
/**
+ Folder 1
  . File 1
  + Folder 2
    . File 2
    . File 3
  + Folder 3
 */
        // folder1.open();
        // System.out.println(file1.getSize());
        // System.out.println(folder1.getSize());
    }

}

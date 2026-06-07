package Patterns.Composite;

public class File implements FileSystemComponent{
    private String name;
    private int size;
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void open() {
        System.out.println("cat " + this.name);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void getHirarchy(String prefix) {
        System.out.println(prefix + ". " + this.getName());
    }
}

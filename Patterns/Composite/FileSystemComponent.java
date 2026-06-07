package Patterns.Composite;

public interface FileSystemComponent {
    void open();
    int getSize();
    String getName();
    void getHirarchy(String prefix);
}

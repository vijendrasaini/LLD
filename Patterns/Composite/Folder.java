package Patterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{
    private String name;
    private int size;
    private List<FileSystemComponent> children;
    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public void getHirarchy(String prefix) {
        System.out.println(prefix + "+ " + this.getName());
        for (FileSystemComponent fileSystemComponent : children) {
            fileSystemComponent.getHirarchy("  " + prefix);
        }
    }

    @Override
    public int getSize() {
        int size = 0;
        for (FileSystemComponent fileSystemComponent : children) {
            size += fileSystemComponent.getSize();
        }

        return size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void add(FileSystemComponent fileSystemComponent) {
        this.children.add(fileSystemComponent);
    }

    @Override
    public void open() {
        for (FileSystemComponent fileSystemComponent : children) {
            System.out.println(fileSystemComponent.getName());
        }
    }
}

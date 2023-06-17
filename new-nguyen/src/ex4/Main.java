package ex4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Nguyen\\IdeaProjects\\new-nguyen\\src\\ex4\\FileResource";
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get(path);
        dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
        System.out.println("Watch service registered for dir: " + dir.getFileName());
        WatchKey key = null;
        while(true)
        {
            try
            {
                key = watcher.take();
            }catch (InterruptedException e)
            {
                System.out.println("Interruption: " + e.getMessage());
                return;
            }
            for(WatchEvent<?> event: key.pollEvents())
            {
                WatchEvent.Kind<?> kind = event.kind();
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();
                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.printf("A new file %s was created.%n", filename.getFileName());
                } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.printf("A file %s was modified.%n", filename.getFileName());
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.printf("A file %s was deleted.%n", filename.getFileName());
                }
            }
            boolean  valid = key.reset();
            if(!valid) break;
        }
    }
}
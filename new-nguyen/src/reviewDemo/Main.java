package reviewDemo;

import reviewDemo.core.ProcessTask;
import reviewDemo.core.ReadAreaTask;
import reviewDemo.core.ReadPositionTask;
import reviewDemo.core.WriteTask;
import reviewDemo.model.Alert;
import reviewDemo.model.Area;
import reviewDemo.model.Position;

import java.io.File;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        final File positionFile = new File("C:\\Users\\Nguyen\\Downloads\\B3\\B3\\resource\\positions.txt");
        final File areaFile = new File("C:\\Users\\Nguyen\\Downloads\\B3\\B3\\resource\\area.txt");
        final File alertFile = new File("C:\\Users\\Nguyen\\Downloads\\B3\\B3\\output\\alert.txt");
        final BlockingQueue<Position> positionQueue = new ArrayBlockingQueue<>(1024);
        final BlockingQueue<Alert> alertQueue = new ArrayBlockingQueue<>(1024);
        
        ReadAreaTask readAreaTask = new ReadAreaTask(areaFile);
        ExecutorService executor = Executors.newCachedThreadPool();
        
        ReadPositionTask readPositiontask = new ReadPositionTask(positionFile, positionQueue);
        executor.execute(readPositiontask);
        Future<List<Area>> future = executor.submit(readAreaTask);
        
        List<Area> areaList = future.get();
        ProcessTask processTask = new ProcessTask(positionQueue, areaList, alertQueue);
        WriteTask writeTask = new WriteTask(alertQueue, alertFile);
        executor.execute(processTask);
        executor.execute(writeTask);
    }
}

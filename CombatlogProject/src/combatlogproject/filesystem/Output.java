package combatlogproject.filesystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Domenik Irrgang
 */
public abstract class Output {

    public Output() {
    }

    protected boolean saveToFile(String path, String content) {
        File file = new File(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] contentInBytes = content.getBytes();
            fileOutputStream.write(contentInBytes);
            fileOutputStream.flush();
            fileOutputStream.close();

            return true;
        } catch (IOException ex) {
        }
        return false;
    }

    public abstract void outputModule(Module module);
}

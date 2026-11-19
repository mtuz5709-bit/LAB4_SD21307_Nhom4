package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {
    private static final String FOLDER = "/uploads/";

    // Upload file vào /uploads
    public static String upload(HttpServletRequest request, String name) throws IOException {
        try {
            Part part = request.getPart(name);
            String fileName = part.getSubmittedFileName();
            if (fileName == null || fileName.isEmpty()) return null;
            String ext = fileName.substring(fileName.lastIndexOf("."));
            String uniqueName = System.currentTimeMillis() + ext;
            String realPath = request.getServletContext().getRealPath(FOLDER + uniqueName);
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectories(Path.of(realPath));
            }
            part.write(realPath);
            return uniqueName;
        } catch (Exception e) {
            return "";
        }
    }

    // Xóa file trong /uploads
    public static boolean delete(HttpServletRequest request, String fileName) {
        try {
            if (fileName == null || fileName.isEmpty()) return false;
            String realPath = request.getServletContext().getRealPath(FOLDER);
            File file = new File(realPath, fileName);
            return file.exists() && file.isFile() && file.delete();
        } catch (Exception e) {
            return false;
        }
    }
}

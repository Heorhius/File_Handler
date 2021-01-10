package util;

import java.io.*;
import java.nio.file.Path;
import java.util.Date;
import java.util.Objects;

public class FileHandler {
    public static final String FILE_IS_DELETED = "File is deleted.";
    public static final String FILE_WASNT_DELETED = "File wasn't deleted.";
    public static final String FILE_WASNT_CREATED = "File wasn't created.";
    public static final String FILE_ALREADY_EXISTS = "File already exists.";
    public static final String FILE_DOESNT_EXIST = "File doesn't exist.";
    public static final String FILE_CREATED = " is created";
    public static final String FILE_HANDLER_TO_STRING = "FileHandler: fileSize=";

    private double fileSize;
    private String fileAuthor;
    private Date creatingDate;

    public FileHandler() {
    }

    public FileHandler(double fileSize, String fileAuthor, Date creatingDate) {
        this.fileSize = fileSize;
        this.fileAuthor = fileAuthor;
        this.creatingDate = creatingDate;
    }

    public static boolean createFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println(file.getName() + FILE_CREATED);
                    return true;
                } else {
                    System.out.println(FILE_WASNT_CREATED);
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(FILE_ALREADY_EXISTS);
        return false;
    }

    public static boolean createFile(Path path) {
        return createFile(path.toString());
    }

    public static boolean deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(FILE_IS_DELETED);
                return true;
            } else {
                System.out.println(FILE_WASNT_DELETED);
                return false;
            }
        }
        System.out.println(FILE_DOESNT_EXIST);
        return false;
    }

    public static boolean deleteFile(Path path) {
        return deleteFile(path.toString());
    }

    public String read(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();

    }

    public void write(String path, String value) {
        try (Writer writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(value);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileAuthor() {
        return fileAuthor;
    }

    public void setFileAuthor(String fileAuthor) {
        this.fileAuthor = fileAuthor;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileHandler)) return false;
        FileHandler that = (FileHandler) o;
        return Double.compare(that.getFileSize(), getFileSize()) == 0 &&
                Objects.equals(getFileAuthor(), that.getFileAuthor()) &&
                Objects.equals(getCreatingDate(), that.getCreatingDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFileSize(), getFileAuthor(), getCreatingDate());
    }

    @Override
    public String toString() {
        return FILE_HANDLER_TO_STRING + fileSize + ", fileAuthor='" + fileAuthor + ", creatingDate=" + creatingDate;
    }
}

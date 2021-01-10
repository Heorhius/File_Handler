package util;

import java.util.Date;
import java.util.Objects;

public class PDFFileHandler extends FileHandler {
    public static final String READ_FROM_PDF_FILE = "Read from pdf file\n";
    public static final String WRITE_TO_PDF_FILE = "Write to pdf file";
    public static final String PDFFILE_HANDLER_TO_STRING = " PDFFileHandler: securityLevel=";
    private String securityLevel;

    public PDFFileHandler() {
        super();
    }

    public PDFFileHandler(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public PDFFileHandler(double fileSize, String fileAuthor, Date creatingDate, String securityLevel) {
        super(fileSize, fileAuthor, creatingDate);
        this.securityLevel = securityLevel;
    }

    @Override
    public String read(String path) {
        System.out.println(READ_FROM_PDF_FILE);
        return super.read(path);
    }

    @Override
    public void write(String path, String value) {
        System.out.println(WRITE_TO_PDF_FILE);
        super.write(path, value);
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PDFFileHandler)) return false;
        if (!super.equals(o)) return false;
        PDFFileHandler that = (PDFFileHandler) o;
        return Objects.equals(getSecurityLevel(), that.getSecurityLevel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSecurityLevel());
    }

    @Override
    public String toString() {
        return super.toString() + PDFFILE_HANDLER_TO_STRING + securityLevel;
    }
}

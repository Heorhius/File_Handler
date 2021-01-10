package util;

import java.util.Date;
import java.util.Objects;

public class TXTFileHandler extends FileHandler {
    public static final String READ_FROM_TXT_FILE = "Read from txt file\n";
    public static final String WRITE_TO_TXT_FILE = "Write to txt file";
    public static final String TXTFILE_HANDLER_TO_STRING = " TXTFileHandler:  utfCode=";

    private String utfCode;

    public TXTFileHandler() {
        super();
    }

    public TXTFileHandler(String utfCode) {
        this.utfCode = utfCode;
    }

    public TXTFileHandler(double fileSize, String fileAuthor, Date creatingDate, String utfCode) {
        super(fileSize, fileAuthor, creatingDate);
        this.utfCode = utfCode;
    }

    @Override
    public String read(String path) {
        System.out.println(READ_FROM_TXT_FILE);
        return super.read(path);
    }

    @Override
    public void write(String path, String value) {
        System.out.println(WRITE_TO_TXT_FILE);
        super.write(path, value);
    }

    public String getUtfCode() {
        return utfCode;
    }

    public void setUtfCode(String utfCode) {
        this.utfCode = utfCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TXTFileHandler)) return false;
        if (!super.equals(o)) return false;
        TXTFileHandler that = (TXTFileHandler) o;
        return Objects.equals(getUtfCode(), that.getUtfCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUtfCode());
    }

    @Override
    public String toString() {
        return super.toString() + TXTFILE_HANDLER_TO_STRING + utfCode;
    }
}

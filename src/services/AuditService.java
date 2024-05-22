
package services;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService
{
    private static AuditService auditService;

    FileWriter writer;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private AuditService()
    {
        try
        {
            this.writer = new FileWriter("C:\\Users\\ingeaua\\Desktop\\AN 2\\SEM 2\\PAO\\Proiect\\Proiect-PAO-Final\\audit.csv");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static AuditService getInstance()
    {
        if (auditService == null) auditService = new AuditService();

        return auditService;
    }

    public void logAction(String action)
    {
        try {
            writer.append(action);
            writer.append(",");
            writer.append(formatter.format(LocalDateTime.now()));
            writer.append("\n");
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
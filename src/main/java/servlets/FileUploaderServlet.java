package servlets;

import configuration.Configuration;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.format.DateTimeFormatter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brian on 7/13/15.
 */
public class FileUploaderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subject user = SecurityUtils.getSubject();
        if (!user.isAuthenticated()) {
            resp.sendError(403);
            return;
        }
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        DiskFileItemFactory factory = new DiskFileItemFactory(25*1024*1024, new File(Configuration.UPLOADS));

        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List fileItems = upload.parseRequest(req);

            Iterator i = fileItems.iterator();
            while (i.hasNext()) {
                FileItem item = (FileItem) i.next();
                String fileName = item.getName();
                if (!fileName.toLowerCase().endsWith(".gcode") || (fileName.startsWith("/") || fileName.startsWith("."))) {
                    throw new RuntimeException("Invalid file");
                }
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String path = Configuration.UPLOADS + "/%s/%s/%s";
                File dir = new File(String.format(path, user.getPrincipal(), format.format(cal.getTime()), ""));
                dir.mkdirs();
                File file;
                if (fileName.lastIndexOf('/') >= 0) {
                    file = new File(String.format(path, user.getPrincipal(), format.format(cal.getTime()), fileName.substring(fileName.lastIndexOf('/'))));
                } else {
                    file = new File(String.format(path, user.getPrincipal(), format.format(cal.getTime()), fileName));
                }

                item.write(file);
            }
        } catch (Exception e) {
            resp.sendError(500);
        }
    }
}

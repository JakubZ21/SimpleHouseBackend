
package pl.jakubz.simplehouse.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import pl.jakubz.simplehouse.exception.CategoryNotFoundException;
import pl.jakubz.simplehouse.exception.FileTooBigException;
import pl.jakubz.simplehouse.exception.MealNotFoundException;

@Controller
@ControllerAdvice
public class ExceptionController implements ErrorController {
    Logger logger = Logger.getLogger(this.getClass().getName());

    public ExceptionController() {
    }

    @ExceptionHandler({Exception.class})
    public String handleException(Exception exc, Model model) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        String httpCode = "" + httpStatus.value();
        String message = exc.getMessage();
        this.logger.info(exc.toString());
        this.logger.info("Saving to file");
        File file = new File("exceptionLogs.txt");
        FileWriter fr = null;

        try {
            fr = new FileWriter(file, true);
            fr.write("\n Exception message: " + exc);
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            String excStackTrace = stringWriter.toString();
            fr.write("\t Exception Stack Trace: " + excStackTrace);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        model.addAttribute("httpStatus", httpStatus);
        model.addAttribute("httpCode", httpCode);
        model.addAttribute("message", message);
        exc.printStackTrace();
        return "error";
    }

    @ExceptionHandler({MaxUploadSizeExceededException.class})
    public String handleException(MaxUploadSizeExceededException exc, Model model) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String httpCode = "" + httpStatus.value();
        String message = "File cannot be bigger than 64KB";
        this.logger.info(exc.toString());
        model.addAttribute("httpStatus", httpStatus);
        model.addAttribute("httpCode", httpCode);
        model.addAttribute("message", message);
        return "error";
    }

    @ExceptionHandler({MealNotFoundException.class})
    public String handleException(MealNotFoundException exc, Model model) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String httpCode = "" + httpStatus.value();
        String message = exc.toString();
        this.logger.info(exc.toString());
        model.addAttribute("httpStatus", httpStatus);
        model.addAttribute("httpCode", httpCode);
        model.addAttribute("message", message);
        return "error";
    }

    @ExceptionHandler({IOException.class})
    public String handleException(IOException exc, Model model) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String httpCode = "" + httpStatus.value();
        String message = "File not found";
        this.logger.info(exc.toString());
        model.addAttribute("httpStatus", httpStatus);
        model.addAttribute("httpCode", httpCode);
        model.addAttribute("message", message);
        return "error";
    }

    @ExceptionHandler({FileTooBigException.class})
    public String handleException(FileTooBigException exc, Model model) {
        HttpStatus httpStatus = HttpStatus.PAYLOAD_TOO_LARGE;
        String httpCode = "" + httpStatus.value();
        String message = exc.toString();
        this.logger.info(exc.toString());
        model.addAttribute("httpStatus", httpStatus);
        model.addAttribute("httpCode", httpCode);
        model.addAttribute("message", message);
        return "error";
    }

    @ExceptionHandler({CategoryNotFoundException.class})
    public String handleException(CategoryNotFoundException exc, Model model) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String httpCode = "" + httpStatus.value();
        String message = exc.toString();
        this.logger.info(exc.toString());
        model.addAttribute("httpStatus", httpStatus);
        model.addAttribute("httpCode", httpCode);
        model.addAttribute("message", message);
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}

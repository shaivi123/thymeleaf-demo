package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.dto.TemplateToHtmlDto;
import com.example.thymeleafdemo.model.Book;
import com.example.thymeleafdemo.service.TemplateToHtmlRenderer;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import java.util.Scanner;

@RestController
//@RequestMapping("/convert")
public class TemplateToHtmlController {

    private final TemplateToHtmlRenderer renderer;

    public TemplateToHtmlController(TemplateToHtmlRenderer renderer) {
        this.renderer = renderer;
    }

//    @PostMapping
//    public String renderAndSendHtml(@RequestBody TemplateToHtmlDto dto) {
//        String render= renderer.renderHtml(dto.getTemplateName(), dto.getData());
//        return render;
//    }

    @PostMapping("/downloadingPDFOnLocal")
    public ResponseEntity<?> addPDF(@RequestBody String content){
        Document document=new Document();
        try{
            document.open();
            HtmlConverter.convertToPdf(content, new FileOutputStream("/home/shaivi/Downloads/Test.pdf/"));
            document.close();
            return (ResponseEntity<?>) ResponseEntity.ok("SUCCESS");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/convert")
    public void renderAndSendAndConvertToPdf(@RequestBody TemplateToHtmlDto dto,String filename) {
        String render= renderer.renderHtml(dto.getTemplateName(), dto.getData());
        Document document=new Document();
        document.open();
        try {
           // Document document = new Document();

//            InputStream is = getClass().getClassLoader().getResourceAsStream("shaivi.html");
//            File file = new File("/src/main/resources/templates/myfile.ext");
//            OutputStream out = new FileOutputStream(file);
//            out.write(render.getBytes());
          // document.add(render);


            HtmlConverter.convertToPdf(render,
                    new FileOutputStream("/home/shaivi/Downloads/Test.pdf/"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        document.close();
       // return render;
    }

}

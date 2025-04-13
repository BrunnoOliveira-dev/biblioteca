package com.example.biblioteca.method;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;

public class GerarCodigoDeBarras {
    public static String gerarCodigoBarrasBase64(String texto) {
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(texto, BarcodeFormat.CODE_128, 300, 100);
            BufferedImage imagem = MatrixToImageWriter.toBufferedImage(bitMatrix);

            // Converter a imagem em bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(imagem, "png", outputStream);
            byte[] imagemBytes = outputStream.toByteArray();

            // Retornar a string base64
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(imagemBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        gerarCodigoBarras("978859431876-003", "codigo_barras.png");
//    }
}

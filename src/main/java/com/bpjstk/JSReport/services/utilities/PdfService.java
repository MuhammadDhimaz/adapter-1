package com.bpjstk.JSReport.services.utilities;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfService {

    public byte[] mergePdfs(List<byte[]> pdfByteArrays) throws IOException {
        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        for (byte[] pdfBytes : pdfByteArrays) {
            RandomAccessRead randomAccessRead = new RandomAccessReadBuffer(pdfBytes);
            pdfMerger.addSource(randomAccessRead);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        pdfMerger.setDestinationStream(outputStream);
        pdfMerger.mergeDocuments(null);
        return outputStream.toByteArray();
    }

}

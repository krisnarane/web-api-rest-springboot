package br.com.krisnarane.webApi.handler;

import java.time.LocalDateTime;

public class ResponseError {
    private LocalDateTime timestamp = LocalDateTime.now(); // momento da geracao da excecao
    private String status = "error"; // campo customizado
    private int statusCode = 400; // dicionario de erro
    private String error; // mensagem apresentada ao usuario


    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    
     
}

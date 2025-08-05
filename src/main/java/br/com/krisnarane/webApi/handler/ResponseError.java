package br.com.krisnarane.webApi.handler;

import java.sql.Date;

public class ResponseError {
    private Date timestamp = new Date(0); // momento da geracao da excecao
    private String status = "error"; // campo customizado
    private int statusCode = 400; // dicionario de erro
    private String error; // mensagem apresentada ao usuario


    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
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

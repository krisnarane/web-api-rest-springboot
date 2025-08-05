package br.com.krisnarane.webApi.handler;

public class BusinessException extends RuntimeException {
    public BusinessException(String mensagem){
        super(mensagem);
    }

    public BusinessException(String mensagem, Object ... params){
        super(String.format(mensagem, params));
    }
}

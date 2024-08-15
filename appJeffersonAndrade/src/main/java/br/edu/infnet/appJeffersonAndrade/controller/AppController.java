package br.edu.infnet.appJeffersonAndrade.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    public String  exibirMensagemAlow(){
        return "Aplication On";
    }
}

package com.todo.todo.common;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GeradorData {
    public LocalDateTime gerarLocalDataAtual(){
        return LocalDateTime.now();
    }
}
